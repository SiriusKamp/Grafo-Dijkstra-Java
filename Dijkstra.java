import java.io.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    Map<String, Integer> distancias = new HashMap<>();
        Map<String, No> predecessores = new HashMap<>();
        private No destino;
        private No inicial;

        public void DiksFunc (No inicial, List<No> nos) {
         distancias.put(inicial.getNome(), 0); // Distância para o nó inicial é 0
         // fila que ao receber um nó na hora de adicionar antes de adicionar compara com a função distancias.get no.nome para definir em qual parte estará o nó

         PriorityQueue<No> fila = new PriorityQueue<>(Comparator.comparingInt(no -> distancias.get(no.getNome())));

         for (No no : nos) {
            if (!no.equals(inicial)) {
                distancias.put(no.getNome(), Integer.MAX_VALUE);
            }
            fila.add(no);
        }

        while (!fila.isEmpty()) {
            //Pega o nó com a menor distância
            No noAtual = fila.poll();
            //adiciona a nova distancia caso seja menor que a distancia atual
            for (Map.Entry<No, Integer> vizinho : noAtual.getVizinhos().entrySet()) {
                int novaDistancia = distancias.get(noAtual.getNome()) + vizinho.getValue();
                if (novaDistancia < distancias.get(vizinho.getKey().getNome())) {
                    distancias.put(vizinho.getKey().getNome(), novaDistancia);
                    predecessores.put(vizinho.getKey().getNome(), noAtual); // Marca que para chegar neste vizinho foi utilizado o nó atual
                    // Reordenar a fila é necessário para refletir a nova prioridade de vizinhos
                    fila.remove(vizinho.getKey());
                    fila.add(vizinho.getKey());
                }
            }
        }
            //Imprime as distancias da cidade inicial para as outras cidades
            for (Map.Entry<String, Integer> distancia : distancias.entrySet()) {
                System.out.println("\nDistância de " + inicial.getNome() + " para " + distancia.getKey() + " é " + distancia.getValue());
            }
    }

    public void Buscarcaminho(String cidadedestino, String cidadeinicial, List<No> lista){
        if( cidadedestino.equals(cidadeinicial)){
            System.out.println("Os nós de destino e inicial são iguais");
            return;
        }
        List<No> nos = ProcuararNos(cidadedestino, cidadeinicial, lista);

        if(nos == null ||nos.size() < 2)
        {
            System.out.println("Nós não encontrados");
            return;
        }

        //salva na variavel de classe 
        for (No no : nos) {
            if(no.getNome().equals(cidadedestino)){
                this.destino = no;
            }
            else if(no.getNome().equals(cidadeinicial)){
                this.inicial = no;
            }
        }

        //faz o algoritimo de dijkstra com as variaveis achadas
        DiksFunc(this.inicial, lista);
        List<String> caminho = new ArrayList<String>();
        No no = this.destino;

        if(no.getNome().equals(this.inicial.getNome())){
            System.out.println("O nó de destino é o mesmo que o nó inicial");
            return;
        }
        else if (!predecessores.containsKey(no.getNome()))
        {
            System.out.println("Não há caminho entre o nó inicial e o nó de destino");
            return;
        }
        else{  
            while (no != null) {
            caminho.add(0, no.getNome());
            no = predecessores.get(no.getNome()); 
        }
    }
    //Retorna os caminhos no log
    System.out.println("Caminho mais curto de " + inicial.getNome() + " para " + destino.getNome() +" Custando : "+distancias.get(this.destino.getNome())+ " é: ");
    for (String cidade : caminho) {
        System.out.println("Vá para : " + cidade);
    }
}

    //função para retornar uma lista de nós com o nó destino e o nó inicial
    public List<No> ProcuararNos(String destino, String inicial, List<No> lista){
        List<No> nos = new ArrayList<No>();

        for (No no : lista) {
            if(no.getNome().equals(destino) || no.getNome().equals(inicial)){
                nos.add(no);
            }
        }
        if(nos.size() != 2){
            return null;
        }
        return nos; 
    }
}