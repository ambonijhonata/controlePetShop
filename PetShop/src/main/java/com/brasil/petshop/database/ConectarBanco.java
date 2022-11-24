/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConectarBanco {

    private String DRIVER = "com.mysql.jdbc.Driver";
    private String BD = "jdbc:mysql://localhost:3306/petshop";
    private String USUARIO = "root";
    private String SENHA = "";

    public Connection getConnection() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(BD, USUARIO, SENHA);
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
}
