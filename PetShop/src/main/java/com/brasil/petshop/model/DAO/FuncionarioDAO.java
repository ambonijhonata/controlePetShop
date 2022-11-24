/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Funcao;
import com.brasil.petshop.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FuncionarioDAO {

    private Connection connection;
    private String selectFuncionarios = "SELECT funcionarios.codigo AS codFuncionario, funcionarios.nome AS nomeFuncionario, "
            + "funcoes.codigo AS codFuncao, funcoes.nome AS nomeFuncao FROM funcionarios "
            + "INNER JOIN funcoes ON funcionarios.id_funcao = funcoes.codigo;";
    private PreparedStatement pstSelectFuncionarios;

    public FuncionarioDAO(Connection connection) {
        try {
            this.connection = connection;
            pstSelectFuncionarios = this.connection.prepareStatement(selectFuncionarios);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Funcionario> buscarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            ResultSet rs = pstSelectFuncionarios.executeQuery();

            while (rs.next()) {
                Funcao funcao = new Funcao();
                funcao.setCodigo(rs.getInt("codFuncao"));
                funcao.setNome(rs.getString("nomeFuncao"));

                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("codFuncionario"));
                funcionario.setNome(rs.getString("nomeFuncionario"));
                funcionario.setFuncao(funcao);

                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionarios;
    }
}
