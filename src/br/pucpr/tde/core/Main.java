package br.pucpr.tde.core;

import br.pucpr.tde.data.Vetor;

/**
 * Classe principal que executa os testes e mede o tempo.
 */
public class Main {

    // Define o caminho base e os 9 arquivos
    private static final String PATH_DADOS = "dados/";
    private static final String[] ARQUIVOS = {
        "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
        "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
        "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
    };

    public static void main(String[] args) {
        System.out.println("Iniciando medição de tempo dos algoritmos...");
        System.out.println("--------------------------------------------------------------------------");

        // Loop para testar todos os 9 arquivos
        // (Usamos um loop 'for' padrão, pois não podemos usar 'for-each' em arrays nativos)
        for (int i = 0; i < ARQUIVOS.length; i++) {
            String nomeArquivo = ARQUIVOS[i];
            String caminhoCompleto = PATH_DADOS + nomeArquivo;

            // 1. Lê o arquivo CSV para o nosso Vetor
            Vetor dadosOriginais = LeitorCSV.lerArquivo(caminhoCompleto);
            if (dadosOriginais.size() == 0) {
                System.err.println("Falha ao ler o arquivo: " + nomeArquivo);
                continue; // Pula para o próximo arquivo
            }

            // --- Teste do Bubble Sort (Trabalho do Integrante 1) ---

            // 2. Faz uma CÓPIA dos dados para não estragar o original
            Vetor copiaBubble = dadosOriginais.copy();

            // 3. Mede o tempo
            long inicio = System.nanoTime();
            Algoritmos.bubbleSort(copiaBubble); // Executa o algoritmo
            long fim = System.nanoTime();
            long duracaoNs = fim - inicio; // Tempo em nanosegundos

            // 4. Imprime o resultado
            System.out.printf("Arquivo: %-22s | Algoritmo: Bubble Sort   | Tempo (ns): %d\n", nomeArquivo, duracaoNs);

            // --- ESPAÇO PARA OS OUTROS ALGORITMOS ---
            // O Integrante 3 vai adicionar os testes do Insertion e Quick Sort aqui
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Medição finalizada.");
    }
}