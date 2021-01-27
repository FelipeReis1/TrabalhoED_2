/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Felipe
 */
public class Entradas {
    private String cidade;
    private String estado;
    private String data;
    private int numeroObitos;
    private int numeroCasos;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Entradas(String cidade, String estado, String data, int numeroCasos, int numeroObitos) {
        this.cidade = cidade;
        this.estado = estado;
        this.data = data;
        this.numeroCasos = numeroCasos;
        this.numeroObitos = numeroObitos;
    }

    public int getNumeroObitos() {
        return numeroObitos;
    }

    public void setNumeroObitos(int numeroObitos) {
        this.numeroObitos = numeroObitos;
    }

    public int getNumeroCasos() {
        return numeroCasos;
    }

    public void setNumeroCasos(int numeroCasos) {
        this.numeroCasos = numeroCasos;
    }
}
