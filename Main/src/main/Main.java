/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date dt_a = dt.parse("2021-04-07");
        Date dt_b = dt.parse("2021-05-06");

        int int_a = 1;
        int int_b = 2;

        String str_a = "ab";
        String str_b = "bc";

        Comparador comparador = new Comparador();
        System.out.println(comparador.comparar(dt_a, dt_b, ">"));
        System.out.println(comparador.comparar(int_a, int_b, "<"));
        System.out.println(comparador.comparar(str_a, str_b, "<="));

//        String caminhoCSV = "./brazil_covid19_cities.csv";
//
//        DadosCovid dados = new DadosCovid(caminhoCSV);
//        MergeSort MS = new MergeSort();
//        MS.sort(dados.getEntradas());
//        int quantidade = 100;
//        int[] vetor = new int[quantidade];
//
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = (int) (Math.random() * quantidade);
////            System.out.println(i + " - " +vetor[i]);
//        }
//
//        long tempoInicial = System.currentTimeMillis();
//
//        Quicksort.quickSort(vetor, 0, vetor.length - 1);
//
//        long tempoFinal = System.currentTimeMillis();
////
//        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
//
//        for (int i = 0; i < vetor.length; i++) {
//            System.out.println(i + " - " +vetor[i]);
//        }
        // TODO code application logic here
//        List<Entradas> listEntradas = new ArrayList<>();
//        BufferedReader br; 
//        String caminhoCSV = "./brazil_covid19_cities.csv";
//        //Mergesort merge = new Mergesort();
//        boolean primeiraLinha = true;
//   
//        try  {
//                br = new BufferedReader(new FileReader(caminhoCSV));
//                String line;           
//                String divisor = ",";               
//                while ((line = br.readLine()) != null) { 
//                    if (primeiraLinha) {
//		        primeiraLinha = false;
//			continue;
//		    }
//                    String[] coluna = line.split(divisor);
//                    int numeroCasos = Integer.parseInt(coluna[coluna.length-2]);
//                    int numeroObitos = Integer.parseInt(coluna[coluna.length-1]);
//                    listEntradas.add(new Entradas (coluna[coluna.length-4], coluna[coluna.length-5], coluna[coluna.length-6],
//                            numeroCasos, numeroObitos));                   
//                    //System.out.println("Cidade: " + listEntradas.get(listEntradas.size()-1).getCidade()+ " Estado: " + listEntradas.get(listEntradas.size()-1).getEstado()
//                     //       + " Data: " + listEntradas.get(listEntradas.size()-1).getData() + " Número de Casos: " + listEntradas.get(listEntradas.size()-1).getNumeroCasos()
//                     //       + " Número de Óbitos: " + listEntradas.get(listEntradas.size()-1).getNumeroObitos() );  //Felipe e Fael
//                    //merge.ordenaMergeSort(listEntradas);
//                    System.out.println("Cidade: " + listEntradas.get(listEntradas.size()-1).getCidade()+ " Estado: " + listEntradas.get(listEntradas.size()-1).getEstado()
//                           + " Data: " + listEntradas.get(listEntradas.size()-1).getData() + " Número de Casos: " + listEntradas.get(listEntradas.size()-1).getNumeroCasos()
//                           + " Número de Óbitos: " + listEntradas.get(listEntradas.size()-1).getNumeroObitos() );
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
//proximo a fazer: algoritmos ordenaçao
//proximo a fazer: ordenar por cidade/estado > ordenar por data > aplicar formula dos totais de casos
