/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arthur
 */
public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    
    public Produto(){}
    
    public Produto(String codigo){
        this.codigo = codigo;
    }
        
    public Produto( String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public Produto(String codigo, String nome, String descricao){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
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
    
    @Override
    public String toString(){
        return nome+ " - " + descricao;
    }
}
