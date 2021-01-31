/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Augusto
 */
public class MergeSort {

    private long comparacao = 0;
    private long movimentacao = 0;

    Comparador comparador = new Comparador();

    protected void sort(ArrayList<DadosCovid.Entrada> entradas, Comparadores sortBy) {
        sort(entradas, 0, entradas.size() - 1, sortBy);
    }

    protected void sort(ArrayList<DadosCovid.Entrada> entradas, int esq, int dir, Comparadores sortBy) {
        comparacao++;
        if (esq >= dir) {
            return;
        } else {
            movimentacao++;
            int meio = (esq + dir) / 2;
            sort(entradas, esq, meio, sortBy);
            sort(entradas, meio + 1, dir, sortBy);

            merge(entradas, esq, meio, dir, sortBy);
        }
    }

    public void merge(ArrayList<DadosCovid.Entrada> entradas, int esq, int meio, int dir, Comparadores sortBy) {
        // Seta tamanho dos subarrays 
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        // Instancia arrays temporários
        DadosCovid.Entrada E[] = new DadosCovid.Entrada[n1];
        DadosCovid.Entrada D[] = new DadosCovid.Entrada[n2];

        //Preenche os arrays temporários
        comparacao++;
        for (int i = 0; i < n1; i++) {
            comparacao++;
            movimentacao++;
            E[i] = entradas.get(esq + i);
        }
        comparacao++;
        for (int j = 0; j < n2; j++) {
            comparacao++;
            movimentacao++;
            D[j] = entradas.get(meio + 1 + j);
        }

        // Faz Merge nos Arrays temporários
        // Indices iniciais dos subarrays
        int i = 0, j = 0;

        // Índice inicial do array mesclado 
        int k = esq;
        comparacao += 2;
        while (i < n1 && j < n2) {
            comparacao++;
            if (sortBy.comparar(E[i], D[j])) {
                movimentacao++;
                entradas.set(k, E[i]);
                i++;
            } else {
                movimentacao++;
                entradas.set(k, D[j]);
                j++;
            }
            k++;
        }

        // Copia elementos restantes do subarray da Esquerda
        comparacao++;
        while (i < n1) {
            movimentacao++;
            entradas.set(k, E[i]);
            i++;
            k++;
        }

        // Copia elementos restantes do subarray da Direita
        comparacao++;
        while (j < n2) {
            movimentacao++;
            entradas.set(k, D[j]);
            j++;
            k++;
        }
    }

    public long getComparacao() {
        return comparacao;
    }

    public void setComparacao(int comparacao) {
        this.comparacao = comparacao;
    }

    public long getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }

}
