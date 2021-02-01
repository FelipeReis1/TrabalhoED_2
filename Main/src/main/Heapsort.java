/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Augusto
 */
public class Heapsort {

    public ArrayList<DadosCovid.Entrada> resultados = new ArrayList<DadosCovid.Entrada>();
    private static long comparacao = 0;
    private static long movimentacao = 0;

    public void sort(ArrayList<DadosCovid.Entrada> arr, Comparadores sortBy) {
        int n = arr.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, sortBy);
        }

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(arr, 0, i);
            heapify(arr, i, 0, sortBy);
        }
    }

    void heapify(ArrayList<DadosCovid.Entrada> arr, int n, int i, Comparadores sortBy) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        comparacao++;
        if (l < n && sortBy.comparar(arr.get(l), arr.get(largest))) {
            largest = l;
        }

        comparacao++;
        if (r < n && sortBy.comparar(arr.get(r), arr.get(largest))) {

            largest = r;
        }

        comparacao++;
        if (largest != i) {
            movimentacao++;
            Collections.swap(arr, i, largest);

            heapify(arr, n, largest, sortBy);
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
