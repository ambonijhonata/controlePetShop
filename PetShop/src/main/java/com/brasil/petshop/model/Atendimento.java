/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.petshop.model;

/**
 *
 * @author User
 */
public class Atendimento {
    private int codigo;
    private Animal animal;
    private String diaSemana;
    private Funcionario funcionario;
    private Situacao situacao;

    public Atendimento(int codigo, Animal animal, String diaSemana, Situacao situacao, Funcionario funcionario) {
        this.codigo = codigo;
        this.animal = animal;
        this.diaSemana = diaSemana;
        this.situacao = situacao;
        this.funcionario = funcionario;
    }

    public Atendimento() {        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    
}
