/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Cliente;
import com.brasil.petshop.model.Raca;
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
public class AnimalDAO {

    private Connection connection;
    private String selectAnimais = "SELECT animais.codigo AS codAnimal, animais.nome AS nomeAnimal, "
            + "racas.codigo AS codRaca, racas.nome AS nomeRaca, clientes.codigo AS codCliente, "
            + "clientes.nome AS nomeCliente "
            + "FROM petshop.animais "
            + "INNER JOIN racas ON animais.id_racas = racas.codigo "
            + "INNER JOIN clientes ON animais.id_dono = clientes.codigo "
            + "ORDER BY animais.codigo ASC;";

    private String insertAnimal = "INSERT INTO animais(nome, id_racas, id_dono) VALUES(?, ?, ?)";
    private String updateAnimal = "UPDATE animais "
            + "SET nome = ?, "
            + "id_racas = ?, "
            + "id_dono = ? "
            + "WHERE codigo = ?";
    private String deleteAnimal = "DELETE FROM animais WHERE codigo = ?";
    
    private PreparedStatement pstSelectAnimais;
    private PreparedStatement pstInsertAnimal;
    private PreparedStatement pstUpdateAnimal;
    private PreparedStatement pstDeleteAnimal;
    
    public AnimalDAO(Connection connection) {
        this.connection = connection;
        try {
            pstSelectAnimais = this.connection.prepareStatement(selectAnimais);
            pstInsertAnimal = this.connection.prepareStatement(insertAnimal);
            pstUpdateAnimal = this.connection.prepareStatement(updateAnimal);
            pstDeleteAnimal = this.connection.prepareStatement(deleteAnimal);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Animal> buscarTodosAnimais() {
        List<Animal> animais = new ArrayList<>();
        try {
            ResultSet rs = pstSelectAnimais.executeQuery();

            while (rs.next()) {
                Raca raca = new Raca();
                raca.setCodigo(rs.getInt("codRaca"));
                raca.setNome(rs.getString("nomeRaca"));

                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codCliente"));
                cliente.setNome(rs.getString("nomeCliente"));

                Animal animal = new Animal();
                animal.setCodigo(rs.getInt("codAnimal"));
                animal.setNome(rs.getString("nomeAnimal"));
                animal.setRaca(raca);
                animal.setDono(cliente);

                animais.add(animal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return animais;
    }

    public void inserirAnimal(Animal animal) {
        try {
            pstInsertAnimal.setString(1, animal.getNome());
            pstInsertAnimal.setInt(2, animal.getRaca().getCodigo());
            pstInsertAnimal.setInt(3, animal.getDono().getCodigo());

            pstInsertAnimal.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void atualizarAnimal(Animal animal) {
        try {
            pstUpdateAnimal.setString(1, animal.getNome());
            pstUpdateAnimal.setInt(2, animal.getRaca().getCodigo());
            pstUpdateAnimal.setInt(3, animal.getDono().getCodigo());
            pstUpdateAnimal.setInt(4, animal.getCodigo());
            pstUpdateAnimal.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void deletarAnimal(int codAnimal){
        try {
            pstDeleteAnimal.setInt(1, codAnimal);
            pstDeleteAnimal.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
