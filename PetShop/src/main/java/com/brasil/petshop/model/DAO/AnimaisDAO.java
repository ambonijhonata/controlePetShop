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

/**
 *
 * @author User
 */
public class AnimaisDAO {

    private Connection connection;
    private String selectAnimais = "SELECT animais.codigo AS codAnimal, animais.nome AS nomeAnimal, "
            + "racas.codigo AS codRaca, racas.nome AS nomeRaca, clientes.codigo AS codCliente, "
            + "clientes.nome AS nomeCliente "
            + "FROM petshop.animais "
            + "INNER JOIN racas ON animais.id_racas = racas.codigo "
            + "INNER JOIN clientes ON animais.id_dono = clientes.codigo "
            + "ORDER BY animais.codigo ASC;";
    private PreparedStatement pstSelectAnimais;

    public AnimaisDAO(Connection connection) {
        this.connection = connection;
        try {
            pstSelectAnimais = this.connection.prepareStatement(selectAnimais);
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
                cliente.setNome("nomeCliente");

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
}
