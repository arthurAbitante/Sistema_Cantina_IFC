/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Produto;
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
public class ProdutoController {
    
    public void inserir(Produto produto){
        String sql = "INSERT INTO Produto (Codigo, Nome, Descricao, Quantidade) VALUES (?, ?, ?, ?)";
        try(Connection conn = Conexao.getConexao()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getQuantidade());

            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        
        try(Connection conn = Conexao.getConexao()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Produto p = new Produto(
                        rs.getString("Codigo"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getInt("Quantidade")
                );
                produtos.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return produtos;
    }
    
    public Produto buscarPorCodigo(String codigo){
        String sql = "SELECT * FROM Produto WHERE Codigo = ?";
        
        try(Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return new Produto(
                        rs.getString("Codigo"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getInt("Quantidade")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    public void atualizar(Produto produto){
           String sql = "UPDATE Produto SET Nome=?, Descricao=?, Quantidade=? WHERE Codigo=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCodigo());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletar(String codigo){
        String sql = "DELETE FROM Produto WHERE Codigo=?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);
            stmt.executeUpdate();
            System.out.println("Produto removido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
