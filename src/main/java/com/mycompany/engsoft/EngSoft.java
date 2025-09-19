/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.engsoft;

import com.bd.Beans.Cliente;
import com.bd.DAOs.ClienteDAO;

/**
 *
 * @author arthur
 */
public class EngSoft {

    public static void main(String[] args) {
         ClienteDAO dao = new ClienteDAO();

        // Inserir cliente
        Cliente c1 = new Cliente("123", "111.222.333-44", "55.666.777-8", "Maria Silva", "Engenharia", 21, "Rua A, 123");
        dao.inserir(c1);

        // Listar clientes
        System.out.println("Lista de clientes:");
        dao.listar().forEach(c -> System.out.println(c.getNomeCompleto()));

        // Buscar por matrícula
        Cliente encontrado = dao.buscarPorMatricula("123");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNomeCompleto());
        }

        // Atualizar cliente
        c1.setCurso("Ciência da Computação");
        dao.atualizar(c1);

        // Deletar cliente
        dao.deletar("123");
    }
}
