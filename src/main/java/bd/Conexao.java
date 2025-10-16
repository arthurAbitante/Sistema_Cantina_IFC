/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arthur
 */
public class Conexao {
    
        
    
        private static final String URL = "jdbc:mysql://localhost:3306/Cantina";
        private static final String USUARIO = "root";
        private static final String SENHA = "ifc";
    
       public static Connection getConexao() throws SQLException {
        try {
            // Registrar o driver do MySQL (opcional nas versões mais novas do JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna a conexão
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        return null;
    }
       
        public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
