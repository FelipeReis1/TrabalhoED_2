/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Augusto
 */
class Experimentos {

    private int N;
    private ArrayList<DadosCovid.Entrada> amostras;
    private long comparacoes, movimentacoes;
    private long tempoFinal;

    public Experimentos(DadosCovid dados, int N) {
        ArrayList<DadosCovid.Entrada> temp = dados.getEntradas();
        Collections.shuffle(temp);
        this.amostras = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            this.amostras.add(temp.get(i));
        }
        this.N = N;
    }

    public void executeQuickSort() {
        Quicksort QS = new Quicksort();
        comparacoes = 0;
        movimentacoes = 0;
        long startTime = System.currentTimeMillis();
        CompareNumeroCasos compara_numero_casos = new CompareNumeroCasos();
        QS.sort(this.amostras, compara_numero_casos);
        comparacoes = QS.getComparacao();
        movimentacoes = QS.getMovimentacao();
        System.out.println("Comparações: " + this.comparacoes);
        System.out.println("Movimentações: " + this.movimentacoes);
        tempoFinal = System.currentTimeMillis() - startTime;
        System.out.println("Tempo: " + (float) (this.tempoFinal) / 1000.0 + " segundos");
    }

    public void executeHeapSort() {
        comparacoes = 0;
        movimentacoes = 0;
        long startTime = System.currentTimeMillis();
        // heapsort aqui
        tempoFinal = System.currentTimeMillis() - startTime;
    }

    public void executeMergeSort() {
        MergeSort MSE = new MergeSort();
        comparacoes = 0;
        movimentacoes = 0;
        long startTime = System.currentTimeMillis();
        CompareNumeroCasos compara_numero_casos = new CompareNumeroCasos();

        System.out.println("Experimenting merge sort for N=" + this.N);

        MSE.sort(this.amostras, compara_numero_casos);
        comparacoes = MSE.getComparacao();
        movimentacoes = MSE.getMovimentacao();
        System.out.println("Comparações: " + this.comparacoes);
        System.out.println("Movimentações: " + this.movimentacoes);
        tempoFinal = System.currentTimeMillis() - startTime;
        System.out.println("Tempo: " + (float) (this.tempoFinal) / 1000.0 + " segundos");
    }

    public void setN(int N) {
        this.N = N;
    }

    public void setAmostras(ArrayList<DadosCovid.Entrada> amostras) {
        this.amostras = amostras;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }

    public void setMovimentacoes(int movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public void setTempoFinal(long tempoFinal) {
        this.tempoFinal = tempoFinal;
    }

    public int getN() {
        return N;
    }

    public List<DadosCovid.Entrada> getamostras() {
        return amostras;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public long getTempo() {
        return tempoFinal;
    }

}
