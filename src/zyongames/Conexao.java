/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play;

/**
 *
 * @author Aluno
 */// Bibliotecas:

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexao {
    
    private ResultSet rs = null;
    private Connection conexao = null;
    private Statement stmt = null;
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    public static String usuario = "postgres";
    public static String senha = "admin";
    
    // Método para testar a conexão com o Banco de Dados
    boolean teste_conexao()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            // stmt = conexao.createStatement();
            conexao.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para criar a tabela CLIENTE
    boolean cria_db()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS CLIENTE(NOME VARCHAR(50), USUARIO VARCHAR(50) PRIMARY KEY, SENHA VARCHAR(20), EMAIL VARCHAR(90))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para inserir na tabela CLIENTE
    boolean insere(String NOME, String USUARIO, String SENHA, String EMAIL)
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO CLIENTE VALUES('"
                         +NOME+ "','"
                         +USUARIO+ "','"
                         +SENHA+ "','"
                         +EMAIL+ "'"
                         + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro! Nome de usuário já existente!", "Cadastro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }
    
    // Método para implementar Query Busca na tabela CLIENTE
    public boolean busca(String NOME, String SENHA)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "SELECT * FROM CLIENTE WHERE USUARIO LIKE '"
                        + NOME + "' AND SENHA LIKE '" + SENHA + "';";
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!");
            
            return false;
        }
    }
    
    // Método para implementar Query Atualizar na tabela CLIENTE
    boolean atualizar (String NOME, String USUARIO, String SENHA, String EMAIL)
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "UPDATE CLIENTE SET NOME = '"
                         +NOME+ "', SENHA = '"
                         +SENHA+ "', EMAIL = '"
                         +EMAIL+ "' WHERE USUARIO = '"
                         +USUARIO+ "';";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para implementar Query Deletar na tabela CLIENTE
    boolean deletar (String USUARIO)
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "DELETE  FROM CARRINHO WHERE USUARIO = '" + USUARIO + "'; DELETE  FROM COMPRADOS WHERE USUARIO = '" + USUARIO + "'; DELETE  FROM CLIENTE WHERE USUARIO = '" + USUARIO + "';";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para mostrar NOME da tabela CLIENTE
    public ResultSet mostra_nome(String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String nome = "SELECT NOME FROM CLIENTE WHERE USUARIO LIKE '" + USUARIO + "';";
            
            stmt.executeQuery(nome);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para mostrar USUARIO da tabela CLIENTE
    public ResultSet mostra_usuario(String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String usuario_user = "SELECT USUARIO FROM CLIENTE WHERE USUARIO LIKE '" + USUARIO + "';";
            
            stmt.executeQuery(usuario_user);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para mostrar SENHA da tabela CLIENTE
    public ResultSet mostra_senha(String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String senha_user = "SELECT SENHA FROM CLIENTE WHERE USUARIO LIKE '" + USUARIO + "';";
            
            stmt.executeQuery(senha_user);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para mostrar E-MAIL da tabela CLIENTE
    public ResultSet mostra_email(String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String email = "SELECT EMAIL FROM CLIENTE WHERE USUARIO LIKE '" + USUARIO + "';";
            
            stmt.executeQuery(email);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para criar tabela CARRINHO
    boolean criaCarrinho() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS CARRINHO(USUARIO VARCHAR(50), ID INTEGER, PRIMARY KEY(USUARIO, ID), FOREIGN KEY(USUARIO) REFERENCES CLIENTE(USUARIO))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para inserir na tabela CARRINHO
    boolean insereCarrinho(String USUARIO, int ID)
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO CARRINHO VALUES('"
                        + USUARIO + "', "
                        + ID + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para implementar Query Deletar na tabela CARRINHO
    boolean deletarCarrinho(String USUARIO, int ID) {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            stmt = conexao.createStatement();
            String sql = "DELETE  FROM CARRINHO WHERE ID = " + ID + "AND USUARIO = '" + USUARIO + "';";

            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para Buscar na tabela CARRINHO
    public ResultSet busca_carrinho(String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "SELECT ID, NOME, PRECO FROM CARRINHO JOIN JOGOS USING(ID) WHERE USUARIO LIKE '"
                        + USUARIO + "';";
            
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para criar tabela COMPRADOS
    boolean criaComprados() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS COMPRADOS(USUARIO VARCHAR(50), ID INTEGER, PRIMARY KEY(USUARIO, ID), FOREIGN KEY(USUARIO) REFERENCES CLIENTE(USUARIO))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para inserir na tabela COMPRADOS
    boolean insereComprados(String USUARIO, int ID)
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO COMPRADOS VALUES('"
                        + USUARIO + "', "
                        + ID + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para implementar Query Deletar na tabela COMPRADOS
    boolean deletarComprados(String USUARIO, int ID) {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            stmt = conexao.createStatement();
            
            String sql = "DELETE  FROM COMPRADOS WHERE ID = " + ID + "AND USUARIO = '" + USUARIO + "';";

            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para Buscar na tabela COMPRADOS
    public ResultSet busca_comprados(String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "SELECT ID, NOME, PRECO FROM COMPRADOS JOIN JOGOS USING(ID) WHERE USUARIO LIKE '"
                        + USUARIO + "';";
            
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para Buscar na tabela COMPRADOS por ID
    public ResultSet busca_comprados_por_ID(int ID, String USUARIO)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "(SELECT JOGOS.ID, NOME, Categoria, Fornecedor, Preco FROM  JOGOS, comprados,Acao_E_Aventura  WHERE  JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Acao_e_Aventura.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS,COMPRADOS, Arcade  WHERE  JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Arcade.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS,COMPRADOS,Casual  WHERE  JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Casual.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, Classicos  WHERE  JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Classicos.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, Luta  WHERE  JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Luta.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, Corrida  WHERE  JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Corrida.ID)"+
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, RPG WHERE JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = RPG.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, Esportes  WHERE JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Esportes.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, Terror   WHERE JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Terror.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, Estrategia  WHERE JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = Estrategia.ID)" +
                          "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS, COMPRADOS, MOBA  WHERE JOGOS.ID = " + ID + " AND usuario LIKE '" + USUARIO + "' and Jogos.ID = COMPRADOS.ID and JOGOS.id = MOBA.ID)";
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para criar tabela com JOGOS / CATEGORIA
    boolean criaJogos() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS JOGOS(ID INTEGER PRIMARY KEY, NOME VARCHAR(50), PRECO DECIMAL(6,2))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para inserir na tabela com JOGOS / CATEGORIA
    boolean insereJogos()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO JOGOS VALUES (1, 'Tomb Raider', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (2, 'Devil May Cry', 119.90);\n" +
                         "INSERT INTO JOGOS VALUES (3, 'The Walking Dead', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (4, 'Middle Earth Shadow Of War', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (5, 'Uncharted', 69.90);\n" +
                         "INSERT INTO JOGOS VALUES (6, 'Marvel Vs Capcom', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (7, 'Captain Commando', 49.90);\n" +
                         "INSERT INTO JOGOS VALUES (8, 'Mortal Kombat', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (9, 'Street Fighter', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (10, 'Metal Slug', 49.90);\n" +
                         "INSERT INTO JOGOS VALUES (11, 'Bubble Legend', 14.90);\n" +
                         "INSERT INTO JOGOS VALUES (12, 'Candy Crush', 9.90);\n" +
                         "INSERT INTO JOGOS VALUES (13, 'Angry Birds', 19.90);\n" +
                         "INSERT INTO JOGOS VALUES (14, 'UNO', 4.90);\n" +
                         "INSERT INTO JOGOS VALUES (15, 'Boku no Pico Simulator', 999.90);\n" +
                         "INSERT INTO JOGOS VALUES (16, 'Tetris', 9.90);\n" +
                         "INSERT INTO JOGOS VALUES (17, 'Donkey Kong', 14.90);\n" +
                         "INSERT INTO JOGOS VALUES (18, 'Super Mario Bros', 19.90);\n" +
                         "INSERT INTO JOGOS VALUES (19, 'PAC MAN', 9.90);\n" +
                         "INSERT INTO JOGOS VALUES (20, 'Sonic', 19.90);\n" +
                         "INSERT INTO JOGOS VALUES (21, 'BlazBlue', 29.90);\n" +
                         "INSERT INTO JOGOS VALUES (22, 'Killer Instinct', 39.90);\n" +
                         "INSERT INTO JOGOS VALUES (23, 'Tekken', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (24, 'Injustice', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (25, 'Dragon Ball Z', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (26, 'The Crew', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (27, 'Need For Speed', 119.90);\n" +
                         "INSERT INTO JOGOS VALUES (28, 'Gran Turismo', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (29, 'Forza', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (30, 'Dirt', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (31, 'Fallout', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (32, 'The Elder Scrolls V Skyrim', 199.90);\n" +
                         "INSERT INTO JOGOS VALUES (33, 'The Witcher', 169.90);\n" +
                         "INSERT INTO JOGOS VALUES (34, 'Baldurs Gate', 119.90);\n" +
                         "INSERT INTO JOGOS VALUES (35, 'Dark Souls', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (36, 'NBA', 119.90);\n" +
                         "INSERT INTO JOGOS VALUES (37, 'STEEP', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (38, 'Madden', 119.90);\n" +
                         "INSERT INTO JOGOS VALUES (39, 'PES', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (40, 'FIFA', 149.90);\n" +
                         "INSERT INTO JOGOS VALUES (41, 'Outlast Trinity', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (42, 'Resident Evil', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (43, 'Silent Hill', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (44, 'Amnesia', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (45, 'Dead Space', 69.90);\n" +
                         "INSERT INTO JOGOS VALUES (46, 'Hearts of Iron', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (47, 'XCOM', 119.90);\n" +
                         "INSERT INTO JOGOS VALUES (48, 'Warcraft', 129.90);\n" +
                         "INSERT INTO JOGOS VALUES (49, 'Civilization', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (50, 'Age Of Empires', 129.90);\n" +
                         "INSERT INTO JOGOS VALUES (51, 'DOTA', 99.90);\n" +
                         "INSERT INTO JOGOS VALUES (52, 'SMITE', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (53, 'VAINGLORY', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (54, 'AWESOMENAUTS', 59.90);\n" +
                         "INSERT INTO JOGOS VALUES (55, 'League Of Legends', 99.90);";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Método para buscar todos os IDs
    public ResultSet buscaIDJogos()
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "SELECT ID FROM JOGOS";
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para buscar na tabela com JOGOS
    public ResultSet buscaJogosNome(String NOME)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Acao_E_Aventura USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Arcade USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Casual USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Classicos USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Luta USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Corrida USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN RPG USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Esportes USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Terror USING (ID)  WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN Estrategia USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "UNION" +
                         "(SELECT JOGOS.ID, Nome, Categoria, Fornecedor, Preco FROM JOGOS JOIN MOBA USING (ID) WHERE Nome LIKE '%" + NOME + "%')" +
                         "ORDER BY (NOME);";
            
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // Método para buscar na tabela com CATEGORIA
    public ResultSet buscaJogosCategoria(String CATEGORIA)
    {
        ResultSet rs = null;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "";
            
            if(CATEGORIA.equals("Ação e Aventura"))
            {
                sql = "SELECT * FROM JOGOS JOIN Acao_E_Aventura USING (ID);";
            } else if(CATEGORIA.equals("Arcade"))
            {
                sql = "SELECT * FROM JOGOS JOIN Arcade USING (ID);";
            } else if(CATEGORIA.equals("Casual"))
            {
                sql = "SELECT * FROM JOGOS JOIN Casual USING (ID);";
            } else if(CATEGORIA.equals("Clássicos"))
            {
                sql = "SELECT * FROM JOGOS JOIN Classicos USING (ID);";
            } else if(CATEGORIA.equals("Luta"))
            {
                sql = "SELECT * FROM JOGOS JOIN Luta USING (ID);";
            } else if(CATEGORIA.equals("Corrida"))
            {
                sql = "SELECT * FROM JOGOS JOIN Corrida USING (ID);";
            } else if(CATEGORIA.equals("RPG"))
            {
                sql = "SELECT * FROM JOGOS JOIN RPG USING (ID);";
            } else if(CATEGORIA.equals("Esportes"))
            {
                sql = "SELECT * FROM JOGOS JOIN Esportes USING (ID);";
            } else if(CATEGORIA.equals("Terror"))
            {
                sql = "SELECT * FROM JOGOS JOIN Terror USING (ID);";
            } else if(CATEGORIA.equals("Estratégia"))
            {
                sql = "SELECT * FROM JOGOS JOIN Estrategia USING (ID);";
            } else if(CATEGORIA.equals("MOBA"))
            {
                sql = "SELECT * FROM JOGOS JOIN MOBA USING (ID);";
            } else
            {
                JOptionPane.showMessageDialog(null, "Insira o Nome da Categoria Corretamente!");
            }
            
            stmt.executeQuery(sql);
            
            // Recebendo os dados do Banco
            rs = stmt.getResultSet();
            conexao.close();
            
            return rs;
        } catch (SQLException e) {
            // JOptionPane.showMessageDialog(null, "Erro ao realizar a Busca!" + e);
            
            return rs;
        }
    }
    
    // 1
    // Método Criar Ação e Aventura
    boolean Acao_E_Aventura() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Acao_E_Aventura(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Ação e Aventura
    boolean insere_Acao_E_Aventura()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO Acao_E_Aventura VALUES (1, 'Ação e Aventura', 'Square Enix');"+
                         "INSERT INTO Acao_E_Aventura VALUES (2, 'Ação e Aventura', 'Capcom');"+
                         "INSERT INTO Acao_E_Aventura VALUES (3, 'Ação e Aventura', 'Telltale Games');"+
                         "INSERT INTO Acao_E_Aventura VALUES (4, 'Ação e Aventura', 'Warner Bros. Interactive Entertainment');"+
                         "INSERT INTO Acao_E_Aventura VALUES (5, 'Ação e Aventura', 'Naughty Dog');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Ação e Aventura
    
    // 2
    // Método Criar Arcade
    boolean Arcade() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Arcade(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Arcade
    boolean insere_Arcade()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO ARCADE VALUES (6, 'Arcade', 'Capcom');"+
                         "INSERT INTO ARCADE VALUES (7, 'Arcade', 'Capcom');"+
                         "INSERT INTO ARCADE VALUES (8, 'Arcade', 'Warner Bros. Interactive Entertainment');"+
                         "INSERT INTO ARCADE VALUES (9, 'Arcade', 'Capcom');"+
                         "INSERT INTO ARCADE VALUES (10, 'Arcade', 'SNK');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Arcade
    
    // 3
    // Método Criar Casual
    boolean Casual() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Casual(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Casual
    boolean insere_Casual()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO CASUAL VALUES (11, 'Casual', 'Blast 2 Fun Games');"+
                        "INSERT INTO CASUAL VALUES (12, 'Casual', 'King');"+
                        "INSERT INTO CASUAL VALUES (13, 'Casual', 'Rovio Entertainment');"+
                        "INSERT INTO CASUAL VALUES (14, 'Casual', 'Ubisoft');"+
                        "INSERT INTO CASUAL VALUES (15, 'Casual', 'Natural High');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Casual
    
    // 4
    // Método Criar Clássicos
    boolean Classicos() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Classicos(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Clássicos
    boolean insere_Classicos()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO CLASSICOS VALUES (16, 'Clássicos', 'The Tetris Company');\n" +
                         "INSERT INTO CLASSICOS VALUES (17, 'Clássicos', 'Nintendo');\n" +
                         "INSERT INTO CLASSICOS VALUES (18, 'Clássicos', 'Nintendo');\n" +
                         "INSERT INTO CLASSICOS VALUES (19, 'Clássicos', 'Namco');\n" +
                         "INSERT INTO CLASSICOS VALUES (20, 'Clássicos', 'SEGA');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Clássicos
    
    // 5
    // Método Criar Luta
    boolean Luta() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Luta(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Luta
    boolean insere_Luta()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO LUTA VALUES (21, 'Luta', 'Arc System Works');\n" +
                         "INSERT INTO LUTA VALUES (22, 'Luta', 'Nintendo');\n" +
                         "INSERT INTO LUTA VALUES (23, 'Luta', 'Namco');\n" +
                         "INSERT INTO LUTA VALUES (24, 'Luta', 'Warner Bros. Interactive Entertainment');\n" +
                         "INSERT INTO LUTA VALUES (25, 'Luta', 'Arc System Works');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Luta
    
    // 6
    // Método Criar Corrida
    boolean Corrida() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Corrida(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Corrida
    boolean insere_Corrida()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO CORRIDA VALUES (26, 'Corrida', 'Ubisoft');\n" +
                         "INSERT INTO CORRIDA VALUES (27, 'Corrida', 'Electronic Arts');\n" +
                         "INSERT INTO CORRIDA VALUES (28, 'Corrida', 'Polyphony Digital');\n" +
                         "INSERT INTO CORRIDA VALUES (29, 'Corrida', 'Microsoft');\n" +
                         "INSERT INTO CORRIDA VALUES (30, 'Corrida', 'Codemasters');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Corrida
    
    // 7
    // Método Criar RPG
    boolean RPG() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS RPG(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir RPG
    boolean insere_RPG()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO RPG VALUES (31, 'RPG', 'Bethesda Game Studios');\n" +
                         "INSERT INTO RPG VALUES (32, 'RPG', 'Bethesda Game Studios');\n" +
                         "INSERT INTO RPG VALUES (33, 'RPG', 'CD Projekt RED');\n" +
                         "INSERT INTO RPG VALUES (34, 'RPG', 'SnowBlind Studios');\n" +
                         "INSERT INTO RPG VALUES (35, 'RPG', 'Bandai Namco Entertainment Inc.');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar RPG
    
    // 8
    // Método Criar Esportes
    boolean Esportes() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Esportes(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Esportes
    boolean insere_Esportes()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO ESPORTES VALUES (36, 'Esportes', 'Electronic Arts');\n" +
                         "INSERT INTO ESPORTES VALUES (37, 'Esportes', 'Ubisoft');\n" +
                         "INSERT INTO ESPORTES VALUES (38, 'Esportes', 'Electronic Arts');\n" +
                         "INSERT INTO ESPORTES VALUES (39, 'Esportes', 'Konami');\n" +
                         "INSERT INTO ESPORTES VALUES (40, 'Esportes', 'Electronic Arts');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Esportes
    
    // 9
    // Método Criar Terror
    boolean Terror() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Terror(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Terror
    boolean insere_Terror()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO TERROR VALUES (41, 'Terror', 'Red Barrels Inc.');\n" +
                         "INSERT INTO TERROR VALUES (42, 'Terror', 'Capcom');\n" +
                         "INSERT INTO TERROR VALUES (43, 'Terror', 'Konami');\n" +
                         "INSERT INTO TERROR VALUES (44, 'Terror', 'Frictional Games');\n" +
                         "INSERT INTO TERROR VALUES (45, 'Terror', 'Electronic Arts');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Terror
    
    // 10
    // Método Criar Estratégia
    boolean Estrategia() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Estrategia(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir Estratégia
    boolean insere_Estrategia()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO ESTRATEGIA VALUES (46, 'Estratégia', 'Paradox Interactive');\n" +
                         "INSERT INTO ESTRATEGIA VALUES (47, 'Estratégia', 'MicroProse');\n" +
                         "INSERT INTO ESTRATEGIA VALUES (48, 'Estratégia', 'Blizzard Entertainment');\n" +
                         "INSERT INTO ESTRATEGIA VALUES (49, 'Estratégia', 'MicroProse');\n" +
                         "INSERT INTO ESTRATEGIA VALUES (50, 'Estratégia', 'Ensemble Studios');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar Estratégia
    
    // 11
    // Método Criar MOBA
    boolean MOBA() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS MOBA(ID INTEGER PRIMARY KEY, CATEGORIA VARCHAR(50), FORNECEDOR VARCHAR(50), FOREIGN KEY(ID) REFERENCES JOGOS(ID))";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Inserir MOBA
    boolean insere_MOBA()
    {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            // System.out.println("Conectado!");
            stmt = conexao.createStatement();
            
            String sql = "INSERT INTO MOBA VALUES (51, 'MOBA', 'Valve Corporation');\n" +
                         "INSERT INTO MOBA VALUES (52, 'MOBA', 'Hi-Rez Studios');\n" +
                         "INSERT INTO MOBA VALUES (53, 'MOBA', 'Super Evil Megacorp');\n" +
                         "INSERT INTO MOBA VALUES (54, 'MOBA', 'Ronimo Games');\n" +
                         "INSERT INTO MOBA VALUES (55, 'MOBA', 'Riot Games');";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conexao.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    // Método Buscar MOBA
}
