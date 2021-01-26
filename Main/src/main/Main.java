/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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
   
        try  {
                br = new BufferedReader(new FileReader(caminhoCSV));
                String line;           
                String divisor = ",";
                while ((line = br.readLine()) != null) {
                    String[] coluna = line.split(divisor);
                    listEntradas.add(new Entradas (coluna[coluna.length-4], coluna[coluna.length-5], coluna[coluna.length-6]));                   
                    System.out.println("Cidade: " + listEntradas.get(listEntradas.size()-1).getCidade()+ " Estado: " + listEntradas.get(listEntradas.size()-1).getEstado()
                            + " Data: " + listEntradas.get(listEntradas.size()-1).getData());  //Felipe e Fael
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
//proximo a fazer: algoritmos ordenaçaoo
//proximo a fazer: ordenar por cidade/estado > ordenar por data > aplicar formula dos totais de casos
