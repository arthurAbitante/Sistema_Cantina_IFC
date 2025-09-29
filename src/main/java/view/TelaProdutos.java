/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.ClienteTableModel;
import model.Produto;
import model.ProdutoTableModel;
import controller.ClienteController;
import controller.ProdutoController;
import view.TelaClientes;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author arthur
 */
public class TelaProdutos extends javax.swing.JFrame {
    
    
    
    private JTable tabela;
    private ProdutoTableModel modelo;
    private ProdutoController dao;

    // Campos de texto
    private JTextField txtCodigo, txtNome, txtDescricao, txtQuantidade;
    
    
    
    public TelaProdutos(){
        dao = new ProdutoController();
        
        modelo = new ProdutoTableModel(dao.listar());
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Dados do produto"));
        
        txtCodigo = new JTextField();
        txtNome = new JTextField();
        txtDescricao = new JTextField();
        txtQuantidade = new JTextField();
        
        formPanel.add(new JLabel("Código: "));
        formPanel.add(txtCodigo);
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(txtNome);
        formPanel.add(new JLabel("Descrição:"));
        formPanel.add(txtDescricao);
        formPanel.add(new JLabel("Quantidade:"));
        formPanel.add(txtQuantidade);
        
        JPanel buttonPanel = new JPanel();
        JButton btnInserir = new JButton("Inserir");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnDeletar = new JButton("Deletar");
        JButton btnRecarregar = new JButton("Recarregar");
        
        buttonPanel.add(btnInserir);
        buttonPanel.add(btnAtualizar);
        buttonPanel.add(btnDeletar);
        buttonPanel.add(btnRecarregar);
        
        btnInserir.addActionListener(e -> inserirProduto());
        btnAtualizar.addActionListener(e -> atualizarProduto());
        btnDeletar.addActionListener(e -> deletarProduto());
        btnRecarregar.addActionListener(e -> atualizarTabela());
        
        tabela.getSelectionModel().addListSelectionListener(e -> preencherCampos());
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setTitle("CRUD Produtos");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inserirProduto(){
        try{
            Produto p = new Produto(
                    txtCodigo.getText(),
                    txtNome.getText(),
                    txtDescricao.getText(),
                    Integer.parseInt(txtQuantidade.getText())
            );
            dao.inserir(p);
            atualizarTabela();
            limparCampos();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage());
        }
    }
    
    private void atualizarProduto(){
                try {
            Produto p = new Produto(
                    txtCodigo.getText(),
                    txtNome.getText(),
                    txtDescricao.getText(),
                    Integer.parseInt(txtQuantidade.getText())
            );
            dao.atualizar(p);
            atualizarTabela();
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }
    }
    
    private void deletarProduto(){
        String codigo = txtCodigo.getText();
        if (!codigo.isEmpty()) {
            dao.deletar(codigo);
            atualizarTabela();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para deletar.");
        }
    }
    
    private void atualizarTabela(){
        List<Produto> produtos = dao.listar();
        modelo.setProdutos(produtos);
    }
    
    private void preencherCampos(){
        int row = tabela.getSelectedRow();
        if (row >= 0) {
            txtCodigo.setText((String) tabela.getValueAt(row, 0));
            txtNome.setText((String) tabela.getValueAt(row, 1));
            txtDescricao.setText((String) tabela.getValueAt(row, 2));
            txtQuantidade.setText(tabela.getValueAt(row, 3).toString());
        }
        
    }
    
    private void limparCampos(){
        txtCodigo.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtQuantidade.setText("");
    }    
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaClientes.class.getName());

    

       
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> new TelaProdutos().setVisible(true));
    }
}
