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
import model.CompraDetalhada;
import model.Produto;
/**
 *
 * @author arthur
 */
public class CompraController {
    
    public void inserir(Compra compra) {
        String sql = "INSERT INTO Compra (CodigoProduto, Quantidade, Preco) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compra.getCodigoProduto());
            stmt.setInt(2, compra.getQuantidade());
            stmt.setDouble(3, compra.getPreco());

            stmt.executeUpdate();
            System.out.println("Compra inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: "+ e);
           // e.printStackTrace();
        }
    }

    // READ (buscar todas as compras)
    public List<Compra> listar() {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compra";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Compra compra = new Compra(
                        rs.getInt("Id"),
                        rs.getString("CodigoProduto"),
                        rs.getInt("Quantidade"),
                        rs.getDouble("Preco")
                );
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }

    // READ (buscar por ID)
    public Compra buscarPorId(int id) {
        String sql = "SELECT * FROM Compra WHERE Id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Compra(
                        rs.getInt("Id"),
                        rs.getString("CodigoProduto"),
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
        String sql = "UPDATE Compra SET CodigoProduto=?, Quantidade=?, Preco=? WHERE Id=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compra.getCodigoProduto());
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
        String sql = "DELETE FROM Compra WHERE Id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Compra removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
    public List<String> listarComProduto() {
        List<String> compras = new ArrayList<>();
        String sql = """
            SELECT c.Id, p.Nome, p.Descricao, c.Quantidade, c.Preco
            FROM Compra c
            INNER JOIN Produto p ON c.CodigoProduto = p.Codigo
            """;

        try (Connection conn = Conexao.getConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String nomeProduto = rs.getString("Nome");
                String descricao = rs.getString("Descricao");
                int quantidade = rs.getInt("Quantidade");
                double preco = rs.getDouble("Preco");
                double total = quantidade * preco;

                String linha = String.format(
                    "Compra ID: %d | Produto: %s - %s | Qtd: %d | Preço: %.2f | Total: %.2f",
                    id, nomeProduto, descricao, quantidade, preco, total
                );

                compras.add(linha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compras;
    }
    
    public List<CompraDetalhada> listarDetalhadas() {
        List<CompraDetalhada> lista = new ArrayList<>();
        String sql = """
            SELECT c.Id, p.Nome, p.Descricao, c.Quantidade, c.Preco
            FROM Compra c
            INNER JOIN Produto p ON c.CodigoProduto = p.Codigo
        """;

        try (Connection conn = Conexao.getConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CompraDetalhada cd = new CompraDetalhada(
                    rs.getInt("Id"),
                    rs.getString("Nome"),
                    rs.getString("Descricao"),
                    rs.getInt("Quantidade"),
                    rs.getDouble("Preco")
                );
                lista.add(cd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


}
