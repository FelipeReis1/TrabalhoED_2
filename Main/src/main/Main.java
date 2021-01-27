/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Entradas> listEntradas = new ArrayList<>();
        BufferedReader br; 
        String caminhoCSV = "./brazil_covid19_cities.csv";
        //Mergesort merge = new Mergesort();
        boolean primeiraLinha = true;
   
        try  {
                br = new BufferedReader(new FileReader(caminhoCSV));
                String line;           
                String divisor = ",";               
                while ((line = br.readLine()) != null) { 
                    if (primeiraLinha) {
		        primeiraLinha = false;
			continue;
		    }
                    String[] coluna = line.split(divisor);
                    int numeroCasos = Integer.parseInt(coluna[coluna.length-2]);
                    int numeroObitos = Integer.parseInt(coluna[coluna.length-1]);
                    listEntradas.add(new Entradas (coluna[coluna.length-4], coluna[coluna.length-5], coluna[coluna.length-6],
                            numeroCasos, numeroObitos));                   
                    //System.out.println("Cidade: " + listEntradas.get(listEntradas.size()-1).getCidade()+ " Estado: " + listEntradas.get(listEntradas.size()-1).getEstado()
                     //       + " Data: " + listEntradas.get(listEntradas.size()-1).getData() + " Número de Casos: " + listEntradas.get(listEntradas.size()-1).getNumeroCasos()
                     //       + " Número de Óbitos: " + listEntradas.get(listEntradas.size()-1).getNumeroObitos() );  //Felipe e Fael
                    //merge.ordenaMergeSort(listEntradas);
                    System.out.println("Cidade: " + listEntradas.get(listEntradas.size()-1).getCidade()+ " Estado: " + listEntradas.get(listEntradas.size()-1).getEstado()
                           + " Data: " + listEntradas.get(listEntradas.size()-1).getData() + " Número de Casos: " + listEntradas.get(listEntradas.size()-1).getNumeroCasos()
                           + " Número de Óbitos: " + listEntradas.get(listEntradas.size()-1).getNumeroObitos() );
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
//proximo a fazer: algoritmos ordenaçaooo
//proximo a fazer: ordenar por cidade/estado > ordenar por data > aplicar formula dos totais de casos
