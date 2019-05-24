package com.senai.wsquickfood.dao;

import com.senai.wsquickfood.controller.Utils;
import com.senai.wsquickfood.model.Tbusuario;
import com.senai.wsquickfood.repository.Repository;
import java.sql.SQLException;

public class UsuarioDAO {

    String SELECT_RECUPERA_SENHA = "SELECT BDID, BDEMAIL, BDLOGIN FROM TBUSUARIO WHERE BDLOGIN = ";
    String ID = "bdID";
    String EMAIL = "bdEmail";
    String LOGIN = "bdLogin";
    String SENHA = "bdSenha";

    public Tbusuario recuperaSenhaDAO(String login) {

        Repository conexao = Repository.getInstace();
        Tbusuario usuario = null;

        try {
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery(SELECT_RECUPERA_SENHA + login);

            while (conexao.resultSet.next()) {
                usuario.setBdID(conexao.resultSet.getInt(ID));
                usuario.setBdEmail(conexao.resultSet.getString(EMAIL));
                usuario.setBdLogin(conexao.resultSet.getString(LOGIN));
            }

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.recuperaSenhaDAO - " + e.toString());
        } finally {
            conexao.close();
        }

        return usuario;
    }

    public Tbusuario validaLoginDAO(String login, String senha) {

        Repository conexao = Repository.getInstace();
        String senhaCriptografada = Utils.criptografarSHA256(senha);
        Tbusuario usuario = null;

        try {
            conexao.open();

            conexao.statement = conexao.conection.createStatement();
            conexao.resultSet = conexao.statement.executeQuery("SELECT * FROM TBUSUARIO WHERE LOGIN = " + login + " AND SENHA = " + senhaCriptografada);

            while (conexao.resultSet.next()) {
                usuario.setBdID(conexao.resultSet.getInt(ID));
                usuario.setBdEmail(conexao.resultSet.getString(EMAIL));
                usuario.setBdLogin(conexao.resultSet.getString(LOGIN));
            }

        } catch (SQLException e) {
            System.err.println("Erro na execução SQL: UsuarioDAO.validaLoginDAO - " + e.toString());
        } finally {
            conexao.close();
        }
        
        return usuario;
    }
}
