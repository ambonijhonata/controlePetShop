/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model;

/**
 *
 * @author User
 */
public class Animal {
    private int codigo;
    private String nome;            
    private Raca raca;
    private Cliente dono;

    public Animal() {
    }

    public Animal(int codigo, String nome, Raca raca, Cliente dono) {
        this.codigo = codigo;
        this.nome = nome;
        this.raca = raca;
        this.dono = dono;
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

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
