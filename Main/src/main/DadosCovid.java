/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Felipe
 */
public class DadosCovid {

    protected ArrayList<Entrada> entradas;
    String dataset;

    public static class Entrada {

        private String cidade;
        private String estado;
        private int cod_cidade;
        private int numeroObitos;
        private int numeroCasos;
        private int numeroCasosDiario;
        private Date dt_confirmacao;

        public int getNumeroCasosDiario() {
            return numeroCasosDiario;
        }

        public void setNumeroCasosDiario(int numeroCasosDiario) {
            this.numeroCasosDiario = numeroCasosDiario;
        }

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

        public Date getDtConfirmacao() {
            return dt_confirmacao;
        }

        public void setDtConfirmacao(Date data) {
            this.dt_confirmacao = data;
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

        public int getCodCidade() {
            return cod_cidade;
        }

        public void setCodCidade(int cod_cidade) {
            this.cod_cidade = cod_cidade;
        }
    }

    public DadosCovid(String dataset) throws IOException {
        this.dataset = dataset;
        this.entradas = new ArrayList<>();
        Carregamento();
        PreProcessamento();
        Save(this.dataset.split("\\.")[0] + "_processado.csv");

    }

    private void Carregamento() throws IOException {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(this.dataset))) {
            String row;
            br.readLine();
            while ((row = br.readLine()) != null) {
                Entrada entrada = new Entrada();
                String[] dados = row.split(",");
                entrada.setDtConfirmacao(new SimpleDateFormat("yyyy-MM-dd").parse(dados[0]));
                entrada.setEstado(dados[1]);
                entrada.setCidade(dados[2]);
                entrada.setCodCidade((int) Float.parseFloat(dados[3]));
                entrada.setNumeroCasos(Integer.parseInt(dados[4]));
                entrada.setNumeroObitos(Integer.parseInt(dados[5]));
                this.entradas.add(entrada);
                i++;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void PreProcessamento() {
        System.out.println("Pré-processamento dos dados...");

        long tempoInicial = System.currentTimeMillis();

        CompareEstado compara_estado = new CompareEstado();
        CompareCidade compara_cidade = new CompareCidade();
        CompareDatas compara_dt_confirmacao = new CompareDatas();

        Collections.shuffle(this.entradas);
        System.out.println("Embaralhando Entradas.");
        System.out.println("Ordenando por par Estado-Cidade");

        MergeSort MS = new MergeSort();

        MS.sort(this.entradas, compara_estado);
        for (int i = 0; i < this.entradas.size(); i++) {
            int j = i + 1;
            while ((j < this.entradas.size()) && this.entradas.get(j).getEstado().equals(this.entradas.get(i).getEstado())) {
                j++;
            }
            if (j <= this.entradas.size()) {
                MS.sort(this.entradas, i, j - 1, compara_cidade);
            }
            i = j;
        }
        System.out.println("Dados ordenados por par Estado-Cidade");

        System.out.println("Ordenando por data de confirmação");
        for (int i = 0; i < this.entradas.size(); i++) {
            int j = i + 1;

            while ((j < this.entradas.size()) && this.entradas.get(j).getCidade().equals(this.entradas.get(i).getCidade())) {
                j++;
            }
            if (j <= this.entradas.size()) {
                MS.sort(this.entradas, i, j - 1, compara_dt_confirmacao);
            }
            i = j - 1;
        }
        System.out.println("Dados ordenados por data de confirmação");

        System.out.println("Calculando casos Diários");
        for (int i = 0; i < this.entradas.size(); i++) {
            int j = i + 1;

            while ((j < this.entradas.size()) && this.entradas.get(j).getCidade().equals(this.entradas.get(i).getCidade())) {
                if (j - 1 == i) {
                    this.entradas.get(j - 1).setNumeroCasosDiario(this.entradas.get(j - 1).getNumeroCasos());
                } else {
                    this.entradas.get(j - 1).setNumeroCasosDiario(this.entradas.get(j - 1).getNumeroCasos() - this.entradas.get(j - 2).getNumeroCasos());
                }
                j++;
            }
            i = j;
        }
        System.out.println("Dados ordenados por data de confirmação");

        long tempoFinal = System.currentTimeMillis() - tempoInicial;

        System.out.println("Dados Processados.");
        System.out.println("Tempo total: " + tempoFinal + "s\n");
    }

    public void Save(String file_name) throws IOException {
        File file = new File(file_name);
        file.createNewFile();

        FileWriter fw = new FileWriter(file);

        fw.write("date,state,name,code,cases,dailyCases,deaths\n");
        for (Entrada entrada : entradas) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String row = df.format(
                    entrada.getDtConfirmacao()) + ","
                    + entrada.getEstado() + ","
                    + entrada.getCidade() + ","
                    + entrada.getCodCidade() + ","
                    + entrada.getNumeroCasos() + ","
                    + entrada.getNumeroCasosDiario() + ","
                    + entrada.getNumeroObitos() + "\n";
            fw.write(row);
        }
        fw.flush();
        fw.close();
    }

    public void setEntradas(ArrayList<Entrada> entradas) {
        this.entradas = entradas;

    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }
}
