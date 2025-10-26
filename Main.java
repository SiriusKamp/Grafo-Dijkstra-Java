import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, No> grafo = LeitorGrafo.carregarDeArquivo("./USA-road-d.NY.gr");

        System.out.println("Nós totais: " + grafo.size());

        // Pegando um nó qualquer e vendo seus vizinhos
        No exemplo = grafo.get("1");
        if (exemplo != null) {
            System.out.println("Vizinhos do nó 1:");
            exemplo.getVizinhos().forEach((vizinho, peso) ->
                System.out.println(" -> " + vizinho.getNome() + " (peso: " + peso + ")")
            );
        }

        DijkstraMap dijkstra = new DijkstraMap();

Runtime runtime = Runtime.getRuntime();
runtime.gc(); // força o garbage collector pra limpar antes da medição

long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

long inicio = System.nanoTime();
dijkstra.buscarCaminho("100", "1", grafo);
long fim = System.nanoTime();

long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
long memoriaUsada = (memoriaDepois - memoriaAntes) / (1024 * 1024); // em MB

double tempoSegundos = (fim - inicio) / 1_000_000_000.0;

System.out.printf("⏱️ Tempo: %.6f segundos%n", tempoSegundos);
System.out.printf("💾 Memória usada: %d MB%n", memoriaUsada);


    }
}
