/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CompraController;
import controller.ProdutoController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import model.Compra;
import model.CompraDetalhada;
import model.Produto;
import model.TableModel.CompraTableModel;

/**
 *
 * @author arthur
 */
public class TelaCompras  extends JFrame {
 
    private JTable tabelaCompras;
    private JComboBox<Produto> comboProduto;
    private JTextField txtQuantidade, txtPreco;
    private JButton btnCadastrar, btnListar, btnRecarregar;
    private CompraController compraController;
    private ProdutoController produtoController;
    private CompraTableModel modelo;

    public TelaCompras() {
        compraController = new CompraController();
        produtoController = new ProdutoController();
        
        
              // Tabela
        modelo = new CompraTableModel(compraController.listarDetalhadas());
        tabelaCompras = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabelaCompras);
        
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Dados da Compra"));
    /*    
        setTitle("Gestão de Compras");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());*/



        // Painel de formulário
//        JPanel painelForm = new JPanel(new GridLayout(2, 3, 10, 10));
        comboProduto = new JComboBox<>();
        txtQuantidade = new JTextField();
        txtPreco = new JTextField();
        

        formPanel.add(new JLabel("Produto:"));
        formPanel.add(comboProduto);
        formPanel.add(new JLabel("Quantidade:"));
        formPanel.add(txtQuantidade);
        formPanel.add(new JLabel("Preço:"));
        formPanel.add(txtPreco);
        
                // Carrega produtos no combo e tabela
        carregarProdutos();
        carregarTabela();
        
        //formPanel.add(btnCadastrar);

        // Painel de botões da tabela
        JPanel painelBotoes = new JPanel();

        btnCadastrar = new JButton("🛒 Cadastrar Compra");
        btnListar = new JButton("Listar");
        btnRecarregar = new JButton("🔄 Recarregar");
        
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRecarregar);
        painelBotoes.add(btnCadastrar);

//fazer o atualizar
  
        add(scroll, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações
        btnCadastrar.addActionListener((ActionEvent e) -> cadastrarCompra());
        btnListar.addActionListener((ActionEvent e) -> listarCompras());
        btnRecarregar.addActionListener((ActionEvent e) -> carregarTabela());
        
        setTitle("CRUD Compras");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void carregarProdutos() {
        comboProduto.removeAllItems();
        List<Produto> produtos = produtoController.listar();
        for (Produto p : produtos) {
            comboProduto.addItem(p);
        }
    }

    private void carregarTabela() {
        List<CompraDetalhada> lista = compraController.listarDetalhadas();
        tabelaCompras.setModel(new CompraTableModel(lista));
    }

    private void listarCompras() {
        carregarTabela();
        JOptionPane.showMessageDialog(this, "Compras listadas com sucesso!");
    }

    private void cadastrarCompra() {
        try {
            
            Produto produtoSelecionado = (Produto) comboProduto.getSelectedItem();
            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            double preco = Double.parseDouble(txtPreco.getText().trim());

            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione um produto.");
                return;
            }

            Compra compra = new Compra();
            compra.setCodigoProduto(produtoSelecionado.getCodigo());
            compra.setQuantidade(quantidade);
            compra.setPreco(preco);
            compraController.inserir(compra);

            JOptionPane.showMessageDialog(this, "Compra cadastrada com sucesso!");
            carregarTabela();
            txtQuantidade.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite uma quantidade válida.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCompras().setVisible(true));
    }
    
}
