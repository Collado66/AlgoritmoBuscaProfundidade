/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmobuscaprofundidade;

/**
 *
 * @author marce
 */


import java.util.*;

class Grafo {
    private int numVertices; // Número de vértices
    private LinkedList<Integer> adjList[]; // Lista de adjacência

    // Construtor
    Grafo(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Adiciona uma aresta ao grafo
    void adicionarAresta(int v, int w) {
        adjList[v].add(w);
    }

    // Realiza a busca em profundidade a partir de um vértice fonte
    void DFS(int inicio) {
        // Marca todos os vértices como não visitados (false)
        boolean visitado[] = new boolean[numVertices];

        // Chama o método recursivo para realizar DFS
        DFSUtil(inicio, visitado);
    }

    // Método utilitário recursivo para DFS
    private void DFSUtil(int v, boolean visitado[]) {
        // Marca o nó atual como visitado e o imprime
        visitado[v] = true;
        System.out.print(v + " ");

        // Recorre a todos os vértices adjacentes ao vértice atual
        for (int n : adjList[v]) {
            if (!visitado[n]) {
                DFSUtil(n, visitado);
            }
        }
    }
}

public class AlgoritmoBuscaProfundidade {
    public static void main(String args[]) {
        Grafo g = new Grafo(4);

        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(2, 0);
        g.adicionarAresta(2, 3);
        g.adicionarAresta(3, 3);

        System.out.println("Busca em Profundidade (DFS) a partir do vértice 2:");

        g.DFS(2);
    }
}
