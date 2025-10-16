/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CompraDetalhada;

/**
 *
 * @author arthur
 */
public class CompraTableModel extends AbstractTableModel{
    private final String[] colunas = {"ID", "Nome do Produto", "Descrição", "Quantidade", "Preço Unitário", "Valor Total"};
    private List<CompraDetalhada> compras;
    
    public CompraTableModel(List<CompraDetalhada> compras) {
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
        CompraDetalhada c = compras.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getNomeProduto();
            case 2:
                return c.getDescricaoProduto();
            case 3:
                return c.getQuantidade();
            case 4:
                return String.format("R$ %.2f", c.getPreco());
            case 5:
                return String.format("R$ %.2f", c.getValorTotal());
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void setCompras(List<CompraDetalhada> compras) {
        this.compras = compras;
        fireTableDataChanged();
    }
    
}
