/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model.DAO;

import com.brasil.petshop.model.Situacao;
import com.mysql.cj.protocol.Resultset;
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
public class SituacaoDAO {

    private Connection connection;
    private String selectSituacoes = "SELECT * FROM situacoes ORDER BY codigo ASC";
    private PreparedStatement pstSelectSituacoes;

    public SituacaoDAO(Connection connection) {
        try {
            this.connection = connection;
            pstSelectSituacoes = this.connection.prepareStatement(selectSituacoes);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Situacao> buscarSituacoes(){
        List<Situacao> situacoes = new ArrayList<>();
        try {
            ResultSet rs = pstSelectSituacoes.executeQuery();
            
            while(rs.next()){
                Situacao situacao = new Situacao();
                situacao.setCodigo(rs.getInt("codigo"));
                situacao.setDescricao(rs.getString("descricao"));
                
                situacoes.add(situacao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return situacoes;
    }
}
