/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telas.produtos;

import com.bd.Beans.ClienteTableModel;
import com.bd.Beans.ProdutoTableModel;
import com.bd.DAOs.ClienteDAO;
import com.bd.DAOs.ProdutoDAO;
import com.telas.clientes.TelaClientes;
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
    private ProdutoDAO dao;

    // Campos de texto
    private JTextField txtNome, txtDescricao, txtQuantidade;
    
    
    
    public TelaProdutos(){
        
    }
    
    private void inserirProduto(){
        
    }
    
    private void atualizarProduto(){
        
    }
    
    private void deletarProduto(){
        
    }
    
    private void atualizarTabela(){
        
    }
    
    private void preencherCampos(){
        
    }
    
    private void limparCampos(){
        
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
