/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Compra;

/**
 *
 * @author arthur
 */
public class CompraTableModel extends AbstractTableModel{

    private final String[] colunas = {"Produto", "Descrição", "Quantidade", "Preço"};
    private List<Compra> compras;

    public CompraTableModel(List<Compra> compras){
        this.compras = compras;
    }
    
    @Override
    public int getRowCount() {
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra c = compras.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getProduto().getNome();
            case 1: return c.getProduto().getDescricao();
            case 2: return c.getQuantidade();
            case 3: return c.getPreco();
  
            default: return null;
        }

    }
    
        @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void setClientes(List<Compra> compras) {
        this.compras = compras;
        fireTableDataChanged();
    }
    
}
