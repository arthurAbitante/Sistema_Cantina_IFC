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
    private JComboBox<String> comboProduto;
    private JTextField txtQuantidade, txtPreco;
    private JButton btnCadastrar, btnListar, btnRecarregar;
    private CompraController compraController;
    private ProdutoController produtoController;

    public TelaCompras() {
        setTitle("Gestão de Compras");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        compraController = new CompraController();
        produtoController = new ProdutoController();

        // Painel de formulário
        JPanel painelForm = new JPanel(new GridLayout(2, 3, 10, 10));
        comboProduto = new JComboBox<>();
        txtQuantidade = new JTextField();
        txtPreco = new JTextField();
        
        btnCadastrar = new JButton("🛒 Cadastrar Compra");

        painelForm.add(new JLabel("Produto:"));
        painelForm.add(comboProduto);
        painelForm.add(new JLabel());
        painelForm.add(new JLabel("Quantidade:"));
        painelForm.add(txtQuantidade);
        painelForm.add(new JLabel());

        painelForm.add(new JLabel("Preço:"));
        painelForm.add(txtPreco);
        
        painelForm.add(btnCadastrar);

        // Painel de botões da tabela
        btnListar = new JButton("📋 Listar");
        btnRecarregar = new JButton("🔄 Recarregar");
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRecarregar);

        // Tabela
        tabelaCompras = new JTable();
        JScrollPane scroll = new JScrollPane(tabelaCompras);

        add(painelForm, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Carrega produtos no combo e tabela
        carregarProdutos();
        carregarTabela();

        // Ações
        btnCadastrar.addActionListener((ActionEvent e) -> cadastrarCompra());
        btnListar.addActionListener((ActionEvent e) -> listarCompras());
        btnRecarregar.addActionListener((ActionEvent e) -> carregarTabela());
    }

    private void carregarProdutos() {
        comboProduto.removeAllItems();
        List<Produto> produtos = produtoController.listar();
        for (Produto p : produtos) {
            comboProduto.addItem("Nome: "+ p.getNome()+ "Descrição: " + p.getDescricao());
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
