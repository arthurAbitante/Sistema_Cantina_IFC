/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthur
 */
public class ClienteController {

    // CREATE
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO ClienteCantina (Matricula, CPF, RG, NomeCompleto, Curso, Idade, Endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getMatricula());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getNomeCompleto());
            stmt.setString(5, cliente.getCurso());
            stmt.setInt(6, cliente.getIdade());
            stmt.setString(7, cliente.getEndereco());

            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (buscar todos)
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM ClienteCantina";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getString("Matricula"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("NomeCompleto"),
                        rs.getString("Curso"),
                        rs.getInt("Idade"),
                        rs.getString("Endereco")
                );
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // READ (buscar por matrícula)
    public Cliente buscarPorMatricula(String matricula) {
        String sql = "SELECT * FROM ClienteCantina WHERE Matricula = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getString("Matricula"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("NomeCompleto"),
                        rs.getString("Curso"),
                        rs.getInt("Idade"),
                        rs.getString("Endereco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE ClienteCantina SET CPF=?, RG=?, NomeCompleto=?, Curso=?, Idade=?, Endereco=? WHERE Matricula=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getRg());
            stmt.setString(3, cliente.getNomeCompleto());
            stmt.setString(4, cliente.getCurso());
            stmt.setInt(5, cliente.getIdade());
            stmt.setString(6, cliente.getEndereco());
            stmt.setString(7, cliente.getMatricula());

            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(String matricula) {
        String sql = "DELETE FROM ClienteCantina WHERE Matricula=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            stmt.executeUpdate();
            System.out.println("Cliente removido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
