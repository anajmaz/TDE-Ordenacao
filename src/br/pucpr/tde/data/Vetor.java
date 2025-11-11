package br.pucpr.tde.data;

/**
 * Nossa implementação de um vetor dinâmico para armazenar inteiros.
 * Baseado no ArrayList.java do projeto anterior.
 */
public class Vetor {
    private int[] data;
    private int size; // Quantidade de elementos realmente no vetor
    private int capacity; // Tamanho total do array 'data'

    public Vetor() {
        this.capacity = 10; // Capacidade inicial padrão
        this.data = new int[this.capacity];
        this.size = 0;
    }

    public Vetor(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new int[this.capacity];
        this.size = 0;
    }

    public void add(int value) {
        if (size == capacity) {
            resize(); // Dobra a capacidade se estiver cheio
        }
        data[size] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + index);
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + index);
        }
        data[index] = value;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int[] newData = new int[this.capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public int size() {
        return this.size;
    }

    public Vetor copy() {
        Vetor newVetor = new Vetor(this.capacity);
        for (int i = 0; i < this.size; i++) {
            newVetor.add(this.data[i]); // Adiciona copiando os elementos
        }
        return newVetor;
    }
}