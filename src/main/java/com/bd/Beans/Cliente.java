/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.Beans;

/**
 *
 * @author arthur
 */
public class Cliente {
    private String matricula;
    private String cpf;
    private String rg;
    private String nomeCompleto;
    private String curso;
    private int idade;
    private String endereco;

    // Construtores
    public Cliente() {}

    public Cliente(String matricula, String cpf, String rg, String nomeCompleto, String curso, int idade, String endereco) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.rg = rg;
        this.nomeCompleto = nomeCompleto;
        this.curso = curso;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}

