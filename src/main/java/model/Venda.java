/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arthur
 */
public class Venda {
    private int id;
    private int idCompra;
    private int quantidade;
    private double preco;
    
    
    public Venda(){
    }
    
    public Venda(int id, int idCompra, int quantidade, double preco){
        this.id = id;
        this.idCompra = idCompra;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }
    
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    
}
