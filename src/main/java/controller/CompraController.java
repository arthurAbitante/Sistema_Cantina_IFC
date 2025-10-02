/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Compra;
import model.Produto;
/**
 *
 * @author arthur
 */
public class CompraController {
    
       // CREATE
    public void inserir(Compra compra) {
        String sql = "INSERT INTO Compra (Id, IdProduto, Quantidade, Preco) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, compra.getId());
            stmt.setString(2, compra.getProduto().getCodigo());
            stmt.setInt(3, compra.getQuantidade());
            stmt.setDouble(4, compra.getPreco());

            stmt.executeUpdate();
            System.out.println("Compra inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (buscar todos)
    public List<Compra> listar() {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compra";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto(rs.getString("IdProduto"));
                Compra c = new Compra(
                        rs.getInt("Id"),
                        p,
                        rs.getInt("Quantidade"),
                        rs.getDouble("Preco")
                );
                compras.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }

    // READ (buscar por matrícula)
    public Compra buscarPorId(int id) {
        String sql = "SELECT * FROM Compra WHERE Id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Produto p = new Produto(rs.getString("IdProduto"));

            if (rs.next()) {
                return new Compra(
                        rs.getInt("Id"),
                        p,
                        rs.getInt("Quantidade"),
                        rs.getDouble("Preco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public void atualizar(Compra compra) {
        String sql = "UPDATE Compra SET IdProduto=?, Quantidade=?, Preco=?, WHERE Id=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compra.getProduto().getCodigo());
            stmt.setInt(2, compra.getQuantidade());
            stmt.setDouble(3, compra.getPreco());
            stmt.setInt(4, compra.getId());


            stmt.executeUpdate();
            System.out.println("Compra atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM Compra WHERE Id=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Compra removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
