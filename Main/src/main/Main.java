/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

        StringBuilder arquivo_saida = new StringBuilder();

        ArrayList<Long> comparacoes = new ArrayList<>();
        ArrayList<Long> movimentacoes = new ArrayList<>();
        ArrayList<Long> tempos = new ArrayList<>();

        long tempo_inicial = System.currentTimeMillis();

        String caminhoCSV = "brazil_covid19_cities.csv";
        DadosCovid dados = new DadosCovid(caminhoCSV);

        //ver se da pra melhorar
        int[] tamanhos = new int[5];
        tamanhos[0] = 10000;
        tamanhos[1] = 50000;
        tamanhos[2] = 100000;
        tamanhos[3] = 500000;
        tamanhos[4] = 1000000;

        arquivo_saida.append("Resultados MergeSort:\n\n");
        for (int tamanho : tamanhos) {
            Experimentos exp = new Experimentos(dados, tamanho);
            exp.executeMergeSort();

            comparacoes.add(exp.getComparacoes());
            movimentacoes.add(exp.getMovimentacoes());
            tempos.add(exp.getTempo());

            arquivo_saida.append("Tamanho: ").append(tamanho).append("\n");
            arquivo_saida.append("Comparações: ").append(exp.getComparacoes()).append("\n");
            arquivo_saida.append("Movimentações: ").append(exp.getMovimentacoes()).append("\n");
            arquivo_saida.append("Tempo de Execução: ").append((float)exp.getTempo()/1000).append(" s\n\n");
        }
        float media_comparacoes = 0, media_movimentacoes = 0, media_tempo = 0;
        int tam = 0;

        for (int i = 0; i < tamanhos.length; i++) {
            media_comparacoes += comparacoes.get(i);
            media_movimentacoes += movimentacoes.get(i);
            media_tempo += tempos.get(i);
            tam += tamanhos[i];
        }
        arquivo_saida.append("Totais MergeSort:\n\n");
        arquivo_saida.append("Tamanho: ").append(tam).append("\n");
        arquivo_saida.append("Comparações: ").append(media_comparacoes).append("\n");
        arquivo_saida.append("Movimentações: ").append(media_movimentacoes).append("\n");
        arquivo_saida.append("Tempos: ").append((float)media_tempo/1000).append(" s").append("\n\n");

        arquivo_saida.append("Médias MergeSort:\n\n");
        arquivo_saida.append("Comparações: ").append(media_comparacoes/tam).append("\n");
        arquivo_saida.append("Movimentações: ").append(media_movimentacoes/tam).append("\n");
        arquivo_saida.append("Tempos: ").append(media_tempo/tam).append("\n\n");

        comparacoes.clear();
        movimentacoes.clear();
        tempos.clear();

        //quickSort
        //heapSort
        
        save("saida", arquivo_saida);
        long tempo_final = System.currentTimeMillis() - tempo_inicial;
        arquivo_saida.append("Tempo Total: ").append((float)tempo_final/1000).append("s\n\n");
        System.out.println("Time elapsed: " + tempo_final/1000 + " seconds");
    }

    public static void save(String nome_arquivo, StringBuilder arquivo) throws IOException {
        File file = new File(nome_arquivo + ".txt");
        file.createNewFile();
        FileWriter txtWriter = new FileWriter(file);
        txtWriter.write(arquivo.toString());
        txtWriter.flush();
        txtWriter.close();
    }

}
// Teste futuross
//        String str_a = "ab";
//        String str_b = "ab";
//        String str_c = "z";
//        String str_d = "f";
//
//        Comparador comparador = new Comparador();
//        System.out.println(comparador.comparar(str_a+str_c, str_b+str_d, "<"));

//        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
//        Date dt_a = dt.parse("2021-04-07");
//        Date dt_b = dt.parse("2021-05-06");
//
//        int int_a = 1;
//        int int_b = 2;
//
//        String str_a = "ab";
//        String str_b = "bc";
//
//        Comparador comparador = new Comparador();
//        System.out.println(comparador.comparar(dt_a, dt_b, ">"));
//        System.out.println(comparador.comparar(int_a, int_b, "<"));
//        System.out.println(comparador.comparar(str_a, str_b, "<="));
