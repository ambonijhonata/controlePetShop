/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model;

/**
 *
 * @author User
 */
public class Estado {

    private int codigo;
    private String nome;
    private String UF;
    private Pais pais;

    public Estado(int codigo, String nome, String UF, Pais pais) {
        this.codigo = codigo;
        this.nome = nome;
        this.UF = UF;
        this.pais = pais;
    }

    public Estado() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nome;
    }

}
