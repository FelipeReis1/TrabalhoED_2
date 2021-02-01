/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Augusto
 */
public class Heapsort {

    private static long comparacao = 0;
    private static long movimentacao = 0;

    protected void sort(ArrayList<DadosCovid.Entrada> entradas, Comparadores sortBy) {
        int raiz = 0;
        int n = entradas.size();
        sort(entradas, raiz, n, sortBy);
    }

    protected void sort(ArrayList<DadosCovid.Entrada> entradas, int raiz, int n, Comparadores sortBy) {
        
        for (int i = raiz; i < n / 2 - 1; i++) {
            heapfy(entradas, i, entradas.size(), sortBy);
        }
        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(entradas, 0, i);
            heapfy(entradas, 0, i, sortBy);
        }
    }

    private void heapfy(ArrayList<DadosCovid.Entrada> entradas, int raiz, int n, Comparadores sortBy) {
        int max = raiz;
        int esq = 2 * raiz + 1;
        int dir = 2 * raiz + 2;

        comparacao++;
        if ((esq < n) && !sortBy.comparar(entradas.get(esq), entradas.get(raiz))) {
            max = esq;
        }
        comparacao++;
        if ((dir < n) && !sortBy.comparar(entradas.get(dir), entradas.get(raiz))) {
            max = dir;
        }
        if (max != raiz) {
            movimentacao++;
            Collections.swap(entradas, max, raiz);
            heapfy(entradas, max, n, sortBy);
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
