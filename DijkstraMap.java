import java.util.*;

public class DijkstraMap {
    private Map<String, Integer> distancias = new HashMap<>();
    private Map<String, No> predecessores = new HashMap<>();
    private No destino;
    private No inicial;

    public void calcular(No inicial, Map<String, No> grafo) {
        // Inicializa distâncias
        distancias.put(inicial.getNome(), 0);

        PriorityQueue<No> fila = new PriorityQueue<>(
            Comparator.comparingInt(no -> distancias.getOrDefault(no.getNome(), Integer.MAX_VALUE))
        );

        // Inicializa todos os nós
        for (No no : grafo.values()) {
            if (!no.equals(inicial)) {
                distancias.put(no.getNome(), Integer.MAX_VALUE);
            }
            fila.add(no);
        }

        // Processa Dijkstra
        while (!fila.isEmpty()) {
            No noAtual = fila.poll();

            // Relaxamento das arestas
            for (Map.Entry<No, Integer> vizinho : noAtual.getVizinhos().entrySet()) {
                int novaDistancia = distancias.get(noAtual.getNome()) + vizinho.getValue();

                if (novaDistancia < distancias.get(vizinho.getKey().getNome())) {
                    distancias.put(vizinho.getKey().getNome(), novaDistancia);
                    predecessores.put(vizinho.getKey().getNome(), noAtual);

                    // Atualiza prioridade na fila
                    fila.remove(vizinho.getKey());
                    fila.add(vizinho.getKey());
                }
            }
        }

        // // Exibe as distâncias encontradas
        // for (Map.Entry<String, Integer> d : distancias.entrySet()) {
        //     System.out.println("Distância de " + inicial.getNome() + " até " + d.getKey() + " = " + d.getValue());
        // }
    }

    public void buscarCaminho(String nomeDestino, String nomeInicial, Map<String, No> grafo) {
        if (nomeDestino.equals(nomeInicial)) {
            System.out.println("⚠️ Os nós de destino e inicial são iguais: " + nomeDestino);
            return;
        }

        No noInicial = grafo.get(nomeInicial);
        No noDestino = grafo.get(nomeDestino);

        // Valida nós
        if (noInicial == null) {
            System.out.println("❌ Nó inicial '" + nomeInicial + "' não encontrado no grafo!");
            return;
        }
        if (noDestino == null) {
            System.out.println("❌ Nó de destino '" + nomeDestino + "' não encontrado no grafo!");
            return;
        }

        this.inicial = noInicial;
        this.destino = noDestino;

        // Executa Dijkstra
        calcular(inicial, grafo);

        if (!predecessores.containsKey(destino.getNome()) && !destino.equals(inicial)) {
            System.out.println("🚫 Não há caminho entre " + inicial.getNome() + " e " + destino.getNome());
            return;
        }

        // Reconstrói o caminho
        List<String> caminho = new ArrayList<>();
        No atual = destino;
        while (atual != null) {
            caminho.add(0, atual.getNome());
            atual = predecessores.get(atual.getNome());
        }

        // Exibe o resultado
        int custoTotal = distancias.get(destino.getNome());
        System.out.println("\n✅ Caminho mais curto de " + inicial.getNome() + " até " + destino.getNome());
        System.out.println("   → Custo total: " + custoTotal);
        System.out.println("   → Caminho:");
        for (String nome : caminho) {
            System.out.println("->      " + nome);
        }
    }
}
