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
    }
}
