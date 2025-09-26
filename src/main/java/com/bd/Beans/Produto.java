/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.Beans;

/**
 *
 * @author arthur
 */
public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    
    public Produto(){}
    
        
    public Produto( String nome, String descricao, int quantidade){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public Produto(String codigo, String nome, String descricao, int quantidade){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}
