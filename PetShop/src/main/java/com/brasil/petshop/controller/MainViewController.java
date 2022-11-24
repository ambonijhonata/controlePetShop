/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.controller;

import com.brasil.petshop.model.Atendimento;
import com.brasil.petshop.model.DAO.AtendimentoDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author User
 */
public class MainViewController {

    private Connection connection;

    public MainViewController(Connection connection) {
        this.connection = connection;
    }

    public List<Atendimento> buscarAtendimentos(String diaSemana) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connection);
        List<Atendimento> atendimentos = atendimentoDAO.buscarAtendimentoByDiaDaSemana(diaSemana);

        return atendimentos;
    }
}
