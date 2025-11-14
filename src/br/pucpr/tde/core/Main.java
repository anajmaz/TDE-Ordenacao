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

        for (int i = 0; i < ARQUIVOS.length; i++) {
            String nomeArquivo = ARQUIVOS[i];
            String caminhoCompleto = PATH_DADOS + nomeArquivo;

            // 1. Lê o arquivo CSV para o nosso Vetor
            Vetor dadosOriginais = LeitorCSV.lerArquivo(caminhoCompleto);
            if (dadosOriginais.size() == 0) {
                System.err.println("Falha ao ler o arquivo: " + nomeArquivo);
                continue;
            }

            /* ============================================================
               BUBBLE SORT (Integrante 1)
               ============================================================ */
            Vetor copiaBubble = dadosOriginais.copy();

            long inicioBubble = System.nanoTime();
            Algoritmos.bubbleSort(copiaBubble);
            long fimBubble = System.nanoTime();

            long duracaoBubble = fimBubble - inicioBubble;
            System.out.printf("Arquivo: %-22s | Algoritmo: Bubble Sort   | Tempo (ns): %d\n",
                    nomeArquivo, duracaoBubble);


            /* ============================================================
               INSERTION SORT (Integrante 2)
               ============================================================ */
            Vetor copiaInsertion = dadosOriginais.copy();

            long inicioInsertion = System.nanoTime();
            Algoritmos.insertionSort(copiaInsertion);
            long fimInsertion = System.nanoTime();

            long duracaoInsertion = fimInsertion - inicioInsertion;
            System.out.printf("Arquivo: %-22s | Algoritmo: Insertion Sort | Tempo (ns): %d\n",
                    nomeArquivo, duracaoInsertion);


            /* ============================================================
               QUICK SORT (Integrante 2)
               ============================================================ */
            Vetor copiaQuick = dadosOriginais.copy();

            long inicioQuick = System.nanoTime();
            Algoritmos.quickSort(copiaQuick);
            long fimQuick = System.nanoTime();

            long duracaoQuick = fimQuick - inicioQuick;
            System.out.printf("Arquivo: %-22s | Algoritmo: Quick Sort     | Tempo (ns): %d\n",
                    nomeArquivo, duracaoQuick);

            System.out.println("--------------------------------------------------------------------------");
        }

        System.out.println("Medição finalizada.");
    }
}
