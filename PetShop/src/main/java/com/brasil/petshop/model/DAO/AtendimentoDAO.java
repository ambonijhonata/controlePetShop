/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Atendimento;
import com.brasil.petshop.model.Funcionario;
import com.brasil.petshop.model.Situacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AtendimentoDAO {

    private Connection connection;

    private String selectAtendimentos = "SELECT atendimentos.codigo AS codAtendimento, animais.nome AS nomeAnimal, funcionarios.nome AS nomeFunc, "
            + "situacoes.descricao AS situacao FROM petshop.atendimentos "
            + "INNER JOIN animais ON atendimentos.id_animal = animais.codigo "
            + "INNER JOIN funcionarios ON atendimentos.id_funcionario = funcionarios.codigo "
            + "INNER JOIN situacoes ON atendimentos.id_situacao = situacoes.codigo "
            + "WHERE dia_semana = ? "
            + "AND situacoes.descricao = ?"
            + "ORDER BY atendimentos.codigo ASC;";

    private String updateSituacaoAtendimento = "UPDATE atendimentos "
            + "SET id_situacao = (SELECT codigo FROM situacoes WHERE descricao = ?)"
            + "WHERE codigo = ?";

    private String updateAtendimento = "UPDATE atendimentos "
            + "SET id_animal = ?, "
            + "dia_semana = ?, "
            + "id_funcionario = ? "
            + "WHERE codigo = ?";

    private String insertAtendimento = "INSERT INTO atendimentos(id_animal, dia_semana, id_situacao, id_funcionario) "
            + "VALUES(?, ?, ?, ?)";
    private String verificarVinculoAnimalAtendimento = "SELECT count(codigo) FROM atendimentos WHERE id_animal = ?";

    private PreparedStatement pstSelectAtendimentos;
    private PreparedStatement pstUpdateSituacaoAtendimento;
    private PreparedStatement pstUpdateAtendimento;
    private PreparedStatement pstInsertAtendimento;
    private PreparedStatement pstVerificarVinculoAnimalAtendimento;

    public AtendimentoDAO(Connection connection) {
        this.connection = connection;
        try {
            pstSelectAtendimentos = this.connection.prepareStatement(selectAtendimentos);
            pstUpdateSituacaoAtendimento = this.connection.prepareStatement(updateSituacaoAtendimento);
            pstUpdateAtendimento = this.connection.prepareStatement(updateAtendimento);
            pstInsertAtendimento = this.connection.prepareStatement(insertAtendimento, Statement.RETURN_GENERATED_KEYS);
            pstVerificarVinculoAnimalAtendimento = this.connection.prepareStatement(verificarVinculoAnimalAtendimento);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Atendimento> buscarAtendimentoByDiaDaSemana(String diaSemana, String situacao) {
        List<Atendimento> atendimentos = new ArrayList<>();

        try {
            pstSelectAtendimentos.setString(1, diaSemana);
            pstSelectAtendimentos.setString(2, situacao);
            ResultSet rs = pstSelectAtendimentos.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setNome(rs.getString("nomeAnimal"));

                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nomeFunc"));

                Situacao s = new Situacao();
                s.setDescricao(rs.getString("situacao"));

                Atendimento atendimento = new Atendimento();
                atendimento.setCodigo(rs.getInt("codAtendimento"));
                atendimento.setAnimal(animal);
                atendimento.setFuncionario(funcionario);
                atendimento.setSituacao(s);

                atendimentos.add(atendimento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return atendimentos;
    }

    public void atualizaSituacaoAtendimento(int codigoAtendimento, String situacao) {
        try {
            pstUpdateSituacaoAtendimento.setString(1, situacao);
            pstUpdateSituacaoAtendimento.setInt(2, codigoAtendimento);
            pstUpdateSituacaoAtendimento.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean atualizaAtendimento(Atendimento a) {
        int qtdRowsAffected = 0;

        try {
            pstUpdateAtendimento.setInt(1, a.getAnimal().getCodigo());
            pstUpdateAtendimento.setString(2, a.getDiaSemana());
            pstUpdateAtendimento.setInt(3, a.getFuncionario().getCodigo());
            pstUpdateAtendimento.setInt(4, a.getCodigo());

            pstUpdateAtendimento.execute();
            qtdRowsAffected = pstUpdateAtendimento.getUpdateCount();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return qtdRowsAffected > 0;
    }

    public int insertAtendimento(Atendimento atendimento) {
        int codigo = 0;
        try {
            pstInsertAtendimento.setInt(1, atendimento.getAnimal().getCodigo());
            pstInsertAtendimento.setString(2, atendimento.getDiaSemana());
            pstInsertAtendimento.setInt(3, 4);
            pstInsertAtendimento.setInt(4, atendimento.getFuncionario().getCodigo());

            pstInsertAtendimento.executeUpdate();

            ResultSet rs = pstInsertAtendimento.getGeneratedKeys();
            rs.next();
            codigo = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return codigo;
    }

    public boolean verificarVinculoAnimalAtendimento(int idAnimal) {
        int retorno = 0;

        try {
            pstVerificarVinculoAnimalAtendimento.setInt(1, idAnimal);
            ResultSet rs = pstVerificarVinculoAnimalAtendimento.executeQuery();
            if (rs.next()) {
                retorno = rs.getInt("count(codigo)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno > 0;
    }
}
