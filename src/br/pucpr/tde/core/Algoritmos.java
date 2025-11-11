package br.pucpr.tde.core;

import br.pucpr.tde.data.Vetor;

/**
 * Classe onde ficarão os 3 algoritmos.
 * Integrante 1: Implementa o bubbleSort.
 */
public class Algoritmos {

    public static void bubbleSort(Vetor vetor) {
        int n = vetor.size();
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Usa get() para comparar
                if (vetor.get(j) > vetor.get(j + 1)) {
                    // Troca usando get() e set()
                    int temp = vetor.get(j);
                    vetor.set(j, vetor.get(j + 1));
                    vetor.set(j + 1, temp);
                    trocou = true;
                }
            }
            // Otimização: Se não houve trocas, o vetor está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    // Integrante 2 vai adicionar os outros métodos aqui:
    // public static void insertionSort(Vetor vetor) { ... }
    // public static void quickSort(Vetor vetor) { ... }
}