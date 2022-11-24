/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Cliente;
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
public class ClienteDAO {

    private Connection connection;

    private String selectClientes = "SELECT clientes.codigo, clientes.nome FROM clientes ORDER BY codigo ASC";
    private PreparedStatement pstSelectClientes;

    public ClienteDAO(Connection connection) {
        try {
            this.connection = connection;
            pstSelectClientes = this.connection.prepareStatement(selectClientes);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Cliente> buscarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {

            ResultSet rs = pstSelectClientes.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));

                clientes.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }
}
