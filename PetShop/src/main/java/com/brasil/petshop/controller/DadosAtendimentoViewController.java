/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.controller;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Atendimento;
import com.brasil.petshop.model.AtendimentoServico;
import com.brasil.petshop.model.DAO.AnimalDAO;
import com.brasil.petshop.model.DAO.AtendimentoDAO;
import com.brasil.petshop.model.DAO.AtendimentoServicoDAO;
import com.brasil.petshop.model.DAO.FuncionarioDAO;
import com.brasil.petshop.model.DAO.ServicoDAO;
import com.brasil.petshop.model.DAO.SituacaoDAO;
import com.brasil.petshop.model.Funcionario;
import com.brasil.petshop.model.Servico;
import com.brasil.petshop.model.Situacao;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author User
 */
public class DadosAtendimentoViewController {

    private Connection connection;

    public DadosAtendimentoViewController(Connection connection) {
        this.connection = connection;
    }

    public List<Animal> buscarAnimais() {
        AnimalDAO animaisDAO = new AnimalDAO(connection);
        return animaisDAO.buscarTodosAnimais();
    }

    public List<Situacao> buscarSituacoes() {
        SituacaoDAO situacaoDAO = new SituacaoDAO(connection);
        return situacaoDAO.buscarSituacoes();
    }

    public List<Funcionario> buscarFuncionarios() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
        return funcionarioDAO.buscarFuncionarios();
    }

    public List<Servico> buscarServicos() {
        ServicoDAO servicoDAO = new ServicoDAO(connection);
        return servicoDAO.buscarServicos();
    }

    public List<AtendimentoServico> buscarAtendimentoById(int idAtendimento) {
        AtendimentoServicoDAO dao = new AtendimentoServicoDAO(connection);
        return dao.buscarAtendimentosServicosByIdAtendimento(idAtendimento);
    }

    public void inicarAtendimento(int codigoAtendimento, String situacao) {
        AtendimentoDAO dao = new AtendimentoDAO(connection);
        dao.atualizaSituacaoAtendimento(codigoAtendimento, situacao);
    }

    public boolean atualizaDadosAtendimento(Atendimento atendimento) {
        AtendimentoDAO dao = new AtendimentoDAO(connection);
        return dao.atualizaAtendimento(atendimento);
    }

    public void deleteServicosByAtendimento(int codigoAtendimento){
        AtendimentoServicoDAO dao = new AtendimentoServicoDAO(connection);
        dao.deleteServicosByAtendimento(codigoAtendimento);
    }
    
    public void inserirServico(int codigoAtendimento, int codigoServico){
        AtendimentoServicoDAO dao = new AtendimentoServicoDAO(connection);
        dao.insertAtendimentoServico(codigoAtendimento, codigoServico);
    }
    
    public int inserirAtendimento(Atendimento atendimento){
        AtendimentoDAO dao = new AtendimentoDAO(connection);
        return dao.insertAtendimento(atendimento);
    }
}
