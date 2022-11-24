/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

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
public class RacaDAO {

    private Connection connection;

    private String selectRacas = "SELECT * FROM racas ORDER BY codigo ASC";
    private PreparedStatement pstSelectRacas;

    public RacaDAO(Connection connection) {
        try {
            this.connection = connection;
            pstSelectRacas = this.connection.prepareStatement(selectRacas);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Raca> listarRacas() {
        List<Raca> racas = new ArrayList<>();
        try {
            ResultSet rs = pstSelectRacas.executeQuery();
            while (rs.next()) {
                Raca r = new Raca();
                r.setCodigo(rs.getInt("codigo"));
                r.setNome(rs.getString("nome"));

                racas.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return racas;
    }
}
