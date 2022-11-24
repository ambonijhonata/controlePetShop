/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.controller;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.DAO.AnimalDAO;
import com.brasil.petshop.model.DAO.AtendimentoDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author User
 */
public class DadosAnimaisViewController {
    private Connection connection;        
    
    public DadosAnimaisViewController(Connection connection) {
        this.connection = connection;
    }
    
    public List<Animal> buscarAnimais(){
        AnimalDAO dao = new AnimalDAO(connection);
        return dao.buscarTodosAnimais();
    }
    
    public boolean verificarVinculoAnimalAtendimentos(int idAnimal){
        AtendimentoDAO dao = new AtendimentoDAO(connection);
        return dao.verificarVinculoAnimalAtendimento(idAnimal);
    }
    
    public void deletarAnimal(int codAnimal){
        AnimalDAO dao = new AnimalDAO(connection);
        dao.deletarAnimal(codAnimal);
    }
}
