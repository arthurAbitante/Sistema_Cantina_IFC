/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arthur
 */
public class ClienteTableModel extends AbstractTableModel{
    
     private final String[] colunas = {"Matrícula", "CPF", "RG", "Nome", "Curso", "Idade", "Endereço"};
    private List<Cliente> clientes;

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getMatricula();
            case 1: return c.getCpf();
            case 2: return c.getRg();
            case 3: return c.getNomeCompleto();
            case 4: return c.getCurso();
            case 5: return c.getIdade();
            case 6: return c.getEndereco();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        fireTableDataChanged();
    }
    
}
