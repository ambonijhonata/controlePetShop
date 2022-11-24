/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Atendimento;
import com.brasil.petshop.model.AtendimentoServico;
import com.brasil.petshop.model.Funcionario;
import com.brasil.petshop.model.Servico;
import com.brasil.petshop.model.Situacao;
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
public class AtendimentoServicoDAO {

    private Connection connection;
    private String selectAtendimentoServico = "SELECT atendimentos_servicos.id_atendimento AS codAtendimento, animais.codigo AS codAnimal, "
            + "animais.nome AS nomeAnimal, atendimentos.dia_semana AS diaSemana, funcionarios.codigo AS codFunc, "
            + "funcionarios.nome AS nomeFunc, situacoes.codigo AS codSituacao, "
            + "situacoes.descricao AS situacao, atendimentos_servicos.id_servico AS codServico, servicos.nome AS nomeServico "
            + "FROM atendimentos_servicos "
            + " INNER JOIN atendimentos ON atendimentos_servicos.id_atendimento = atendimentos.codigo "
            + " INNER JOIN servicos ON atendimentos_servicos.id_servico = servicos.codigo "
            + " INNER JOIN animais ON atendimentos.id_animal = animais.codigo "
            + " INNER JOIN funcionarios ON atendimentos.id_funcionario = funcionarios.codigo "
            + " INNER JOIN situacoes ON atendimentos.id_situacao = situacoes.codigo "
            + " WHERE atendimentos_servicos.id_atendimento = ? "
            + " ORDER BY atendimentos_servicos.id_atendimento ASC";
    private String updateServicosByAtendimento = "UPDATE atendimentos_servicos "
            + "SET id_servico = ? "
            + "WHERE id_atendimento = ?";
    private String deleteServicosByAtendimento = "DELETE FROM atendimentos_servicos WHERE id_atendimento = ? ";
    private String insertAtendimentoServico = "INSERT INTO atendimentos_servicos(id_atendimento, id_servico) VALUES(?, ?)";

    private PreparedStatement pstSelect;
    private PreparedStatement pstUpdateServicosByAtendimento;
    private PreparedStatement pstDeleteServicosByAtendimento;
    private PreparedStatement pstInsertAtendimentoServico;

    public AtendimentoServicoDAO(Connection connection) {
        try {
            this.connection = connection;
            pstSelect = this.connection.prepareStatement(selectAtendimentoServico);
            pstUpdateServicosByAtendimento = this.connection.prepareStatement(updateServicosByAtendimento);
            pstDeleteServicosByAtendimento = this.connection.prepareStatement(deleteServicosByAtendimento);
            pstInsertAtendimentoServico = this.connection.prepareStatement(insertAtendimentoServico);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean atualizaServicos(int idAtendimento, int idServico) {
        int qtdeRowsAffected = 0;
        try {
            pstUpdateServicosByAtendimento.setInt(1, idServico);
            pstUpdateServicosByAtendimento.setInt(2, idAtendimento);
            pstUpdateServicosByAtendimento.execute();
            qtdeRowsAffected = pstUpdateServicosByAtendimento.getUpdateCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return qtdeRowsAffected > 0;
    }

    public List<AtendimentoServico> buscarAtendimentosServicosByIdAtendimento(int idAtendimento) {
        List<AtendimentoServico> list = new ArrayList<>();

        try {
            pstSelect.setInt(1, idAtendimento);
            ResultSet rs = pstSelect.executeQuery();

            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setCodigo(rs.getInt(("codAtendimento")));

                Animal animal = new Animal();
                animal.setCodigo(rs.getInt("codAnimal"));
                animal.setNome(rs.getString("nomeAnimal"));
                atendimento.setAnimal(animal);

                atendimento.setDiaSemana(rs.getString("diaSemana"));

                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("codFunc"));
                funcionario.setNome(rs.getString("nomeFunc"));
                atendimento.setFuncionario(funcionario);

                Situacao situacao = new Situacao();
                situacao.setCodigo(rs.getInt("codServico"));
                situacao.setDescricao(rs.getString("situacao"));
                atendimento.setSituacao(situacao);

                Servico servico = new Servico();
                servico.setCodigo(rs.getInt("codServico"));
                servico.setNome(rs.getString("nomeServico"));

                AtendimentoServico as = new AtendimentoServico();
                as.setAtendimento(atendimento);
                as.setServico(servico);
                list.add(as);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void deleteServicosByAtendimento(int codAtendimento) {
        try {
            pstDeleteServicosByAtendimento.setInt(1, codAtendimento);
            pstDeleteServicosByAtendimento.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertAtendimentoServico(int codigoAtendimento, int codigoServico) {
        try {
            pstInsertAtendimentoServico.setInt(1, codigoAtendimento);
            pstInsertAtendimentoServico.setInt(2, codigoServico);
            pstInsertAtendimentoServico.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
