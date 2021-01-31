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
public class Quicksort {

    private static long comparacao = 0;
    private static long movimentacao = 0;

    protected void sort(ArrayList<DadosCovid.Entrada> vetor, Comparadores sortBy) {
        sort(vetor, 0, vetor.size() - 1, sortBy);
    }

    protected void sort(ArrayList<DadosCovid.Entrada> vetor, int inicio, int fim, Comparadores sortBy) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim, sortBy);
            sort(vetor, inicio, posicaoPivo - 1, sortBy);
            sort(vetor, posicaoPivo + 1, fim, sortBy);
        }
    }

    private static int separar(ArrayList<DadosCovid.Entrada> vetor, int inicio, int fim, Comparadores sortBy) {
        DadosCovid.Entrada pivo = vetor.get(inicio);
        int i = inicio + 1, f = fim;
        while (i <= f) {
            comparacao++;
            if (sortBy.comparar(vetor.get(i), pivo)) {
                i++;
            } else if (sortBy.comparar(pivo, vetor.get(f))) {
                f--;
                comparacao++;
            } else {
                movimentacao++;
                comparacao++;
                Collections.swap(vetor, i, f);
                i++;
                f--;
            }
        }
        vetor.set(inicio, vetor.get(f));
        vetor.set(f, pivo);
        return f;

//        int pivo = vetor[inicio];
//        int i = inicio + 1, f = fim;
//        while (i <= f) {
//            if (vetor[i] <= pivo) {
//                i++;
//            } else if (pivo < vetor[f]) {
//                f--;
//            } else {
//                int troca = vetor[i];
//                vetor[i] = vetor[f];
//                vetor[f] = troca;
//                i++;
//                f--;
//            }
//        }
//        vetor[inicio] = vetor[f];
//        vetor[f] = pivo;
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
