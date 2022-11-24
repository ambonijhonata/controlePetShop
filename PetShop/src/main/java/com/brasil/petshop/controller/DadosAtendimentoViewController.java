/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.controller;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.DAO.AnimaisDAO;
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
    
    public List<Animal> buscarAnimais(){
        AnimaisDAO animaisDAO = new AnimaisDAO(connection);        
        return animaisDAO.buscarTodosAnimais();                
    }
}
