/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arthur
 */
public class VendaDetalhada {
    private int id;
    private int idCompra;
    private String nomeProdutoVendido;
    private String descricaoProduto;
    private int quantidadeComprada;
    private int quantidadeVendida;
    private double precoVendido;
    private double precoComprado;
    
    public VendaDetalhada(){}
    
    public VendaDetalhada(int id, int idCompra, String nomeProdutoVendido, String descricaoProduto, int quantidadeComprada, int quantidadeVendida, double precoVendido, double precoComprado){
        this.id = id;
        this.idCompra = idCompra;
        this.nomeProdutoVendido = nomeProdutoVendido;
        this.descricaoProduto = descricaoProduto;
        this.quantidadeComprada = quantidadeComprada;
        this.quantidadeVendida = quantidadeVendida;
        this.precoVendido = precoVendido;
        this.precoComprado = precoComprado;
    }
    
    
    public int getId() {
        return id;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public String getNomeProdutoVendido(){
        return nomeProdutoVendido;
    }
    
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
    
    public int getQuantidadeVendida(){
        return quantidadeVendida;
    }

    public double getPrecoVendido() {
        return precoVendido;
    }
    
    public double getPrecoComprado(){
        return precoComprado;
    }

    public double getValorTotalVendido() {
        return precoVendido * quantidadeVendida;
    }
    
    
}
