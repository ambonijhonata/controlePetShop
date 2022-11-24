/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Atendimento;
import com.brasil.petshop.model.Situacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AtendimentoDAO {

    private Connection connection;

    private String selectAtendimentos = "SELECT atendimentos.codigo AS codAtendimento, animais.nome AS nomeAnimal, "
            + "situacoes.descricao AS situacao FROM petshop.atendimentos "
            + "INNER JOIN animais ON atendimentos.id_animal = animais.codigo "
            + "INNER JOIN situacoes ON atendimentos.id_situacao = situacoes.codigo "
            + "WHERE dia_semana = ? "
            + "ORDER BY atendimentos.codigo ASC;";

    private PreparedStatement pstSelectAtendimentos;

    public AtendimentoDAO(Connection connection) {
        this.connection = connection;
        try {
            this.pstSelectAtendimentos = this.connection.prepareStatement(selectAtendimentos);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Atendimento> buscarAtendimentoByDiaDaSemana(String diaSemana) {
        List<Atendimento> atendimentos = new ArrayList<>();

        try {
            pstSelectAtendimentos.setString(1, diaSemana);
            ResultSet rs = pstSelectAtendimentos.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setNome(rs.getString("nomeAnimal"));

                Situacao situacao = new Situacao();
                situacao.setDescricao(rs.getString("situacao"));

                Atendimento atendimento = new Atendimento();
                atendimento.setCodigo(rs.getInt("codAtendimento"));
                atendimento.setAnimal(animal);
                atendimento.setSituacao(situacao);

                atendimentos.add(atendimento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return atendimentos;
    }
}
