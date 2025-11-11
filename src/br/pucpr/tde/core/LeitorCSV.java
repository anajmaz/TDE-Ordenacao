package br.pucpr.tde.core;

import br.pucpr.tde.data.Vetor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lê os arquivos CSV e os coloca no nosso Vetor.
 */
public class LeitorCSV {

    public static Vetor lerArquivo(String caminhoArquivo) {
        Vetor dados = new Vetor();
        String linha = "";
        boolean isPrimeiraLinha = true; // Flag para pular o cabeçalho "Value"

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            while ((linha = br.readLine()) != null) {
                if (isPrimeiraLinha) {
                    isPrimeiraLinha = false; // Marca que já pulou a primeira linha
                    continue; // Pula a linha atual (o cabeçalho)
                }

                if (!linha.isEmpty()) {
                    int valor = Integer.parseInt(linha.trim());
                    dados.add(valor);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + caminhoArquivo);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número no arquivo: " + caminhoArquivo);
        }

        return dados;
    }
}