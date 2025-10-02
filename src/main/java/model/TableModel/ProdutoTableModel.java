/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author arthur
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    private final String[] colunas = {"Código","Nome","Descrição"};
    private List<Produto> produtos;
    
    public ProdutoTableModel(List<Produto> produtos){
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto p = produtos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getCodigo();
            case 1:
                return p.getNome();
            case 2:
                return p.getDescricao();
            default: 
                return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
        fireTableDataChanged();
    }
    
    
}
