package com.example.av1_parte2.model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private int id;
    private String ra;
    private String nome;
    private String curso;
    private Double nota_1;
    private Double nota_2;
    private Double nota_3;
    private Double nota_4;

    public int getId() { return  this.id; }

    public void setId(int id) { this.id = id; }

    public String getRa() { return this.ra; }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getNota_1() {
        return this.nota_1;
    }

    public void setNota_1(Double nota_1) {
        this.nota_1 = nota_1;
    }

    public Double getNota_2() {
        return this.nota_2;
    }

    public void setNota_2(Double nota_2) {
        this.nota_2 = nota_2;
    }

    public Double getNota_3() {
        return this.nota_3;
    }

    public void setNota_3(Double nota_3) {
        this.nota_3 = nota_3;
    }

    public Double getNota_4() { return this.nota_4; }

    public void setNota_4(Double nota_4) {
        this.nota_4 = nota_4;
    }

    public double getMedia() {
        return (this.nota_1 + this.nota_2 + this.nota_3 + this.nota_4) / 4;
    }

    @Override
    public String toString() {
        return getRa() + "-" + getNome();
    }
}
