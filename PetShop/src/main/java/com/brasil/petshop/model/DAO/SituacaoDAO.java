/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class SituacaoDAO {
    private Connection connection;
    private String selectSituacoes = "SELECT * FROM situacoes ORDER BY codigo ASC";
    private PreparedStatement pst;
}
