/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arthur
 */
public class Compra {
    private int id;
    private String codigoProduto;
    private int quantidade;
    private double preco;
    
    public Compra(){}
    
    public Compra(int id, String codigoProduto, int quantidade, double preco){
        this.id = id;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getCodigoProduto() { return codigoProduto; }
    public void setCodigoProduto(String codigoProduto) { this.codigoProduto = codigoProduto; }
    
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    
}
