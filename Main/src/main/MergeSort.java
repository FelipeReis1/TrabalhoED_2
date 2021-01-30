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

    protected void sort(ArrayList<DadosCovid.Entrada> entradas) {
        sort(entradas, 0, entradas.size() - 1);
    }

    private void sort(ArrayList<DadosCovid.Entrada> entradas, int esq, int dir) {
        if (esq >= dir) {
            return;
        } else {
            int meio = (esq + dir) / 2;
            sort(entradas, esq, meio);
            sort(entradas, meio + 1, dir);

            merge(entradas, esq, meio, dir);

        }
    }

    public void merge(ArrayList<DadosCovid.Entrada> entradas, int esq, int meio, int dir) {
        List<DadosCovid.Entrada> helper = entradas;

        int i = esq;
        int j = meio + 1;
        int k = esq;

        while (i < meio && j < dir) {
            if (helper.get(i).getCidade().compareTo(helper.get(j).getCidade()) < 0) {
                entradas.set(k, helper.get(i));
                i++;

            } else {
                entradas.set(k, helper.get(j));
                j++;
            }
            k++;
        }
        while (j != dir) {
            entradas.set(k, helper.get(j));
            k++;
            j++;
        }
        while (i != meio) {
            entradas.set(k, helper.get(i));
            k++;
            i++;
        }
    }

}
