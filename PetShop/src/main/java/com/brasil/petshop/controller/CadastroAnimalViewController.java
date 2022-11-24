/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.controller;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Cliente;
import com.brasil.petshop.model.DAO.AnimalDAO;
import com.brasil.petshop.model.DAO.ClienteDAO;
import com.brasil.petshop.model.DAO.RacaDAO;
import com.brasil.petshop.model.Raca;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author User
 */
public class CadastroAnimalViewController {

    private Connection connection;

    public CadastroAnimalViewController(Connection connection) {
        this.connection = connection;
    }
    
    public List<Raca> buscarRacas(){
        RacaDAO dao = new RacaDAO(connection);
        return dao.listarRacas();
    }
    
    public List<Cliente> buscarClientes(){
        ClienteDAO dao = new ClienteDAO(connection);
        return dao.buscarClientes();
    }
    
    public void inserirAnimal(Animal animal){
        AnimalDAO dao = new AnimalDAO(connection);
        dao.inserirAnimal(animal);
    }
    
    public void atualizarAnimal(Animal animal){
        AnimalDAO dao = new AnimalDAO(connection);
        dao.atualizarAnimal(animal);
    }
}
