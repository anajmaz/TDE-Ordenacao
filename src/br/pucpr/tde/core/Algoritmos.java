package br.pucpr.tde.core;

import br.pucpr.tde.data.Vetor;

/**
 * Classe onde ficarão os 3 algoritmos de ordenação.
 * Integrante 1: bubbleSort
 * Integrante 2: insertionSort e quickSort
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
            if (!trocou) break;
        }
    }


    /* ---------------------------------------------------
       INSERTION SORT  (Integrante 2)
    --------------------------------------------------- */
    public static void insertionSort(Vetor vetor) {
        int n = vetor.size();

        for (int i = 1; i < n; i++) {
            int chave = vetor.get(i);
            int j = i - 1;

            // Move elementos maiores para frente
            while (j >= 0 && vetor.get(j) > chave) {
                vetor.set(j + 1, vetor.get(j));  
                j--;
            }

            vetor.set(j + 1, chave);
        }
    }



    // Método público chamado pelo Main
    public static void quickSort(Vetor vetor) {
        if (vetor.size() > 1) {
            quickSortRecursive(vetor, 0, vetor.size() - 1);
        }
    }

    // Método recursivo
    private static void quickSortRecursive(Vetor vetor, int inicio, int fim) {
        if (inicio < fim) {
            int p = partition(vetor, inicio, fim);
            quickSortRecursive(vetor, inicio, p - 1);
            quickSortRecursive(vetor, p + 1, fim);
        }
    }

    // Particiona o vetor escolhendo o pivô (último elemento)
    private static int partition(Vetor vetor, int inicio, int fim) {
        int pivot = vetor.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor.get(j) <= pivot) {
                i++;

                // swap(i, j)
                int temp = vetor.get(i);
                vetor.set(i, vetor.get(j));
                vetor.set(j, temp);
            }
        }

        // Coloca o pivô na posição correta
        int temp = vetor.get(i + 1);
        vetor.set(i + 1, vetor.get(fim));
        vetor.set(fim, temp);

        return i + 1;
    }
}
