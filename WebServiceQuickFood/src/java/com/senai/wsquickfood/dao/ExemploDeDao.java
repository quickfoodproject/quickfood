package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.repository.Repository;
import com.senai.wsquickfood.model.ExemploDeModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExemploDeDao {
    
    String INSERT = "INSERT INTO USUARIO (ID, LOGIN, PASSWORD, NOME, TELEFONE, EMAIL, REPOSTASEGURANCA, IEPERMISSAO) VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "UPDATE USUARIO SET LOGIN = ?, PASSWORD = ?, NOME = ?, TELEFONE = ?, EMAIL = ?, REPOSTASEGURANCA = ?, IEPERMISSAO = ? WHERE ID = ?";
    String DELETE = "DELETE FROM USUARIO WHERE ID = ?";
    String SELECTALL = "SELECT * FROM USUARIO";
    String SELECTBYID = "SELECT * FROM USUARIO WHERE ID = ";

    public void save(ExemploDeModel usuario) {
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(INSERT);
            conexao.preparedStatement.setString(1, usuario.getLogin());
            conexao.preparedStatement.setString(2, usuario.getPassword());
            conexao.preparedStatement.setString(3, usuario.getNome());
            conexao.preparedStatement.setString(4, usuario.getTelefone());
            conexao.preparedStatement.setString(5, usuario.getEmail());
            conexao.preparedStatement.setString(6, usuario.getRepostaSeguranca());
            conexao.preparedStatement.setString(7, usuario.getIePermissao());

            conexao.preparedStatement.execute();
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de INSERT: " + e.toString());
        }
    }

    public void update(ExemploDeModel usuario) {
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(UPDATE);
            conexao.preparedStatement.setString(1, usuario.getLogin());
            conexao.preparedStatement.setString(2, usuario.getPassword());
            conexao.preparedStatement.setString(3, usuario.getNome());
            conexao.preparedStatement.setString(4, usuario.getTelefone());
            conexao.preparedStatement.setString(5, usuario.getEmail());
            conexao.preparedStatement.setString(6, usuario.getRepostaSeguranca());
            conexao.preparedStatement.setString(7, usuario.getIePermissao());
            conexao.preparedStatement.setInt(7, usuario.getId());

            conexao.preparedStatement.execute();
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de UPDATE: " + e.toString());
        }
    }

    public void delete(ExemploDeModel usuario) {
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.preparedStatement = conexao.conection.prepareStatement(DELETE);
            conexao.preparedStatement.setString(1, usuario.getId() + "");
            conexao.preparedStatement.execute();
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de DELETE: " + e.toString());
        }
    }

    public List<ExemploDeModel> getAll() {
        List<ExemploDeModel> usuarios = new ArrayList();
        ExemploDeModel usuario = null;

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECTALL);

            while (conexao.resultSet.next()) {
                usuario = new ExemploDeModel();
                
                usuario.setId(conexao.resultSet.getInt("id"));
                usuario.setLogin(conexao.resultSet.getString("login"));
                usuario.setPassword(conexao.resultSet.getString("password"));
                usuario.setNome(conexao.resultSet.getString("nome"));
                usuario.setTelefone(conexao.resultSet.getString("telefone"));
                usuario.setEmail(conexao.resultSet.getString("email"));
                usuario.setRepostaSeguranca(conexao.resultSet.getString("repostaSeguranca"));
                usuario.setIePermissao(conexao.resultSet.getString("iePermissao"));                
                
                usuarios.add(usuario);
            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT ALL: " + e.toString());
        }
        return usuarios;
    }
    
    public ExemploDeModel getById(int id) {
       ExemploDeModel usuario = null;

        try {
            Repository conexao = Repository.getInstance();
            conexao.open();
           
            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECTBYID + id);

            while (conexao.resultSet.next()) {
                usuario = new ExemploDeModel();
                
                usuario.setId(conexao.resultSet.getInt("id"));
                usuario.setLogin(conexao.resultSet.getString("login"));
                usuario.setPassword(conexao.resultSet.getString("password"));
                usuario.setNome(conexao.resultSet.getString("nome"));
                usuario.setTelefone(conexao.resultSet.getString("telefone"));
                usuario.setEmail(conexao.resultSet.getString("email"));
                usuario.setRepostaSeguranca(conexao.resultSet.getString("repostaSeguranca"));
                usuario.setIePermissao(conexao.resultSet.getString("iePermissao"));                                    
            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT por ID: " + e.toString());
        }
        return usuario;
    }
    
    public ExemploDeModel logar(String usuario, String password) {        
        ExemploDeModel user = null;
        
        try {
            Repository conexao = Repository.getInstance();
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = '" + usuario + "' AND PASSWORD = '" + password + "'");

            while (conexao.resultSet.next()) {
                user = new ExemploDeModel();
                
                user.setId(conexao.resultSet.getInt("id"));
                user.setLogin(conexao.resultSet.getString("login"));
                user.setPassword(conexao.resultSet.getString("password"));
                user.setNome(conexao.resultSet.getString("nome"));
                user.setTelefone(conexao.resultSet.getString("telefone"));
                user.setEmail(conexao.resultSet.getString("email"));
                user.setRepostaSeguranca(conexao.resultSet.getString("repostaSeguranca"));
                user.setIePermissao(conexao.resultSet.getString("iePermissao"));                                    
            }

            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL de SELECT por ID: " + e.toString());
        }
        return user;
    }
}
