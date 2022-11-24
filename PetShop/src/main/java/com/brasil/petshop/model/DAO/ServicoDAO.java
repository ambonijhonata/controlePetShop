/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Servico;
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
public class ServicoDAO {

    private Connection connection;
    private String selectServicos = "SELECT * FROM servicos "
            + "ORDER BY codigo ASC";
    private PreparedStatement pstSelectServicos;

    public ServicoDAO(Connection connection) {
        try {
            this.connection = connection;
            pstSelectServicos = this.connection.prepareStatement(selectServicos);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Servico> buscarServicos() {
        List<Servico> servicos = new ArrayList<>();

        try {
            ResultSet rs = pstSelectServicos.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setCodigo(rs.getInt("codigo"));
                servico.setNome(rs.getString("nome"));

                servicos.add(servico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return servicos;
    }

}
