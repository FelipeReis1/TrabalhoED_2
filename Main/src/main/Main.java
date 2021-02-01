/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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

        String caminhoCSV = "../brazil_covid19_cities.csv";
        DadosCovid dados = new DadosCovid(caminhoCSV);

        //ver se da pra melhorar
        int[] tamanhos = new int[5];
        tamanhos[0] = 10000;
        tamanhos[1] = 50000;
        tamanhos[2] = 100000;
        tamanhos[3] = 500000;
        tamanhos[4] = 1000000;

        //merge Sort
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
            arquivo_saida.append("Tempo de Execução: ").append((float) exp.getTempo() / 1000).append(" s\n\n");
        }
        long media_comparacoes = 0, media_movimentacoes = 0, media_tempo = 0;
        int tam = 0;

        for (int i = 0; i < tamanhos.length; i++) {
            media_comparacoes += comparacoes.get(i);
            media_movimentacoes += movimentacoes.get(i);
            media_tempo += tempos.get(i);
            tam += tamanhos[i];
        }
        arquivo_saida.append("Totais MergeSort:\n\n");
        arquivo_saida.append("Tamanho: ").append(tam).append("\n");
        arquivo_saida.append("Comparações: ").append((float) media_comparacoes).append("\n");
        arquivo_saida.append("Movimentações: ").append((float) media_movimentacoes).append("\n");
        arquivo_saida.append("Tempos: ").append((float) media_tempo / 1000).append(" s").append("\n\n");

        arquivo_saida.append("Médias MergeSort por Registro:\n\n");
        arquivo_saida.append("Média de Comparações: ").append((float) media_comparacoes / tam).append("\n");
        arquivo_saida.append("Média de Movimentações: ").append((float) media_movimentacoes / tam).append("\n");
        arquivo_saida.append("Média de tempo: ").append((float) media_tempo / tam).append(" s\n\n");

        comparacoes.clear();
        movimentacoes.clear();
        tempos.clear();

        //quickSort
        arquivo_saida.append("Resultados QuickSort:\n\n");
        for (int tamanho : tamanhos) {
            Experimentos exp = new Experimentos(dados, tamanho);
            exp.executeQuickSort();

            comparacoes.add(exp.getComparacoes());
            movimentacoes.add(exp.getMovimentacoes());
            tempos.add(exp.getTempo());

            arquivo_saida.append("Tamanho: ").append(tamanho).append("\n");
            arquivo_saida.append("Comparações: ").append(exp.getComparacoes()).append("\n");
            arquivo_saida.append("Movimentações: ").append(exp.getMovimentacoes()).append("\n");
            arquivo_saida.append("Tempo de Execução: ").append((float) exp.getTempo() / 1000).append(" s\n\n");
        }
        media_comparacoes = 0;
        media_movimentacoes = 0;
        media_tempo = 0;
        tam = 0;

        for (int i = 0; i < tamanhos.length; i++) {
            media_comparacoes += comparacoes.get(i);
            media_movimentacoes += movimentacoes.get(i);
            media_tempo += tempos.get(i);
            tam += tamanhos[i];
        }
        arquivo_saida.append("Totais QuickSort:\n\n");
        arquivo_saida.append("Tamanho: ").append(tam).append("\n");
        arquivo_saida.append("Comparações: ").append((float) media_comparacoes).append("\n");
        arquivo_saida.append("Movimentações: ").append((float) media_movimentacoes).append("\n");
        arquivo_saida.append("Tempos: ").append((float) media_tempo / 1000).append(" s").append("\n\n");

        arquivo_saida.append("Médias QuickSort por Registro:\n\n");
        arquivo_saida.append("Média de Comparações: ").append((float) media_comparacoes / tam).append("\n");
        arquivo_saida.append("Média de Movimentações: ").append((float) media_movimentacoes / tam).append("\n");
        arquivo_saida.append("Média de tempo: ").append((float) media_tempo / tam).append(" s\n\n");

        comparacoes.clear();
        movimentacoes.clear();
        tempos.clear();

        //heapSort
        arquivo_saida.append("Resultados HeapSort:\n\n");
        for (int tamanho : tamanhos) {
            Experimentos exp = new Experimentos(dados, tamanho);
            exp.executeHeapSort();

            comparacoes.add(exp.getComparacoes());
            movimentacoes.add(exp.getMovimentacoes());
            tempos.add(exp.getTempo());

            arquivo_saida.append("Tamanho: ").append(tamanho).append("\n");
            arquivo_saida.append("Comparações: ").append(exp.getComparacoes()).append("\n");
            arquivo_saida.append("Movimentações: ").append(exp.getMovimentacoes()).append("\n");
            arquivo_saida.append("Tempo de Execução: ").append((float) exp.getTempo() / 1000).append(" s\n\n");
        }
        media_comparacoes = 0;
        media_movimentacoes = 0;
        media_tempo = 0;
        tam = 0;

        for (int i = 0; i < tamanhos.length; i++) {
            media_comparacoes += comparacoes.get(i);
            media_movimentacoes += movimentacoes.get(i);
            media_tempo += tempos.get(i);
            tam += tamanhos[i];
        }
        arquivo_saida.append("Totais HeapSort:\n\n");
        arquivo_saida.append("Tamanho: ").append(tam).append("\n");
        arquivo_saida.append("Comparações: ").append((float) media_comparacoes).append("\n");
        arquivo_saida.append("Movimentações: ").append((float) media_movimentacoes).append("\n");
        arquivo_saida.append("Tempos: ").append((float) media_tempo / 1000).append(" s").append("\n\n");

        arquivo_saida.append("Médias HeapSort por Registro:\n\n");
        arquivo_saida.append("Média de Comparações: ").append((float) media_comparacoes / tam).append("\n");
        arquivo_saida.append("Média de Movimentações: ").append((float) media_movimentacoes / tam).append("\n");
        arquivo_saida.append("Média de tempo: ").append((float) media_tempo / tam).append(" s\n\n");

        comparacoes.clear();
        movimentacoes.clear();
        tempos.clear();

        long tempo_final = System.currentTimeMillis() - tempo_inicial;
        arquivo_saida.append("Tempo Total: ").append((float) tempo_final / 1000).append("s\n\n");

        save("saida", arquivo_saida);

        System.out.println("Tempo Total: " + tempo_final / 1000 + " s\n");
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
