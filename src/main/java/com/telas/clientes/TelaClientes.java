/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.telas.clientes;

import com.bd.Beans.Cliente;
import com.bd.Beans.ClienteTableModel;
import com.bd.DAOs.ClienteDAO;
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
public class TelaClientes extends javax.swing.JFrame {
    
    private JTable tabela;
    private ClienteTableModel modelo;
    private ClienteDAO dao;

    // Campos de texto
    private JTextField txtMatricula, txtCpf, txtRg, txtNome, txtCurso, txtIdade, txtEndereco;

    public TelaClientes() {
        dao = new ClienteDAO();

        // Criar tabela
        modelo = new ClienteTableModel(dao.listar());
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        // Criar painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));

        txtMatricula = new JTextField();
        txtCpf = new JTextField();
        txtRg = new JTextField();
        txtNome = new JTextField();
        txtCurso = new JTextField();
        txtIdade = new JTextField();
        txtEndereco = new JTextField();

        formPanel.add(new JLabel("Matrícula:"));
        formPanel.add(txtMatricula);
        formPanel.add(new JLabel("CPF:"));
        formPanel.add(txtCpf);
        formPanel.add(new JLabel("RG:"));
        formPanel.add(txtRg);
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(txtNome);
        formPanel.add(new JLabel("Curso:"));
        formPanel.add(txtCurso);
        formPanel.add(new JLabel("Idade:"));
        formPanel.add(txtIdade);
        formPanel.add(new JLabel("Endereço:"));
        formPanel.add(txtEndereco);

        // Criar painel de botões
        JPanel buttonPanel = new JPanel();
        JButton btnInserir = new JButton("Inserir");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnDeletar = new JButton("Deletar");
        JButton btnRecarregar = new JButton("Recarregar");

        buttonPanel.add(btnInserir);
        buttonPanel.add(btnAtualizar);
        buttonPanel.add(btnDeletar);
        buttonPanel.add(btnRecarregar);

        // Ações dos botões
        btnInserir.addActionListener(e -> inserirCliente());
        btnAtualizar.addActionListener(e -> atualizarCliente());
        btnDeletar.addActionListener(e -> deletarCliente());
        btnRecarregar.addActionListener(e -> atualizarTabela());

        // Preencher campos ao clicar na tabela
        tabela.getSelectionModel().addListSelectionListener(e -> preencherCampos());

        // Layout principal
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurações da janela
        setTitle("CRUD Clientes da Cantina");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inserirCliente() {
        try {
            Cliente c = new Cliente(
                    txtMatricula.getText(),
                    txtCpf.getText(),
                    txtRg.getText(),
                    txtNome.getText(),
                    txtCurso.getText(),
                    Integer.parseInt(txtIdade.getText()),
                    txtEndereco.getText()
            );
            dao.inserir(c);
            atualizarTabela();
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage());
        }
    }

    private void atualizarCliente() {
        try {
            Cliente c = new Cliente(
                    txtMatricula.getText(),
                    txtCpf.getText(),
                    txtRg.getText(),
                    txtNome.getText(),
                    txtCurso.getText(),
                    Integer.parseInt(txtIdade.getText()),
                    txtEndereco.getText()
            );
            dao.atualizar(c);
            atualizarTabela();
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }
    }

    private void deletarCliente() {
        String matricula = txtMatricula.getText();
        if (!matricula.isEmpty()) {
            dao.deletar(matricula);
            atualizarTabela();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para deletar.");
        }
    }

    private void atualizarTabela() {
        List<Cliente> clientes = dao.listar();
        modelo.setClientes(clientes);
    }

    private void preencherCampos() {
        int row = tabela.getSelectedRow();
        if (row >= 0) {
            txtMatricula.setText((String) tabela.getValueAt(row, 0));
            txtCpf.setText((String) tabela.getValueAt(row, 1));
            txtRg.setText((String) tabela.getValueAt(row, 2));
            txtNome.setText((String) tabela.getValueAt(row, 3));
            txtCurso.setText((String) tabela.getValueAt(row, 4));
            txtIdade.setText(tabela.getValueAt(row, 5).toString());
            txtEndereco.setText((String) tabela.getValueAt(row, 6));
        }
    }

    private void limparCampos() {
        txtMatricula.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNome.setText("");
        txtCurso.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");
    }
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaClientes.class.getName());

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        SwingUtilities.invokeLater(() -> new TelaClientes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
