import java.io.*;
import java.util.*;

public class LeitorGrafo {
    public static Map<String, No> carregarDeArquivo(String caminho) throws IOException {
        //LEITOR DE ARQUIVOS DE TEXTO 
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        Map<String, No> mapaNos = new HashMap<>();

        String linha;
        int totalNos = 0, totalArestas = 0;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("c")) continue; // comentário
            if (linha.startsWith("p")) {
                String[] partes = linha.split("\\s+");
                totalNos = Integer.parseInt(partes[2]);
                totalArestas = Integer.parseInt(partes[3]);
                System.out.println("Grafo com " + totalNos + " nós e " + totalArestas + " arestas");
            } else if (linha.startsWith("a")) {
                String[] partes = linha.split("\\s+");
                String id1 = partes[1];
                String id2 = partes[2];
                int peso = Integer.parseInt(partes[3]);

                // Cria nós se ainda não existirem na lista
                No no1 = mapaNos.computeIfAbsent(id1, k -> new No(k, 0, 0));
                No no2 = mapaNos.computeIfAbsent(id2, k -> new No(k, 0, 0));

                // Adiciona o vizinho no nó 1 da linha
                no1.addVizinho(no2, peso);

                // Se o grafo não tiver uma segunda linha com a mesma aresta no sentido contrário:
                // no2.addVizinho(no1, peso);
            }
        }
        br.close();

        System.out.println("Total de nós lidos: " + mapaNos.size());
        return mapaNos;
    }
}
