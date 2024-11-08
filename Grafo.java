import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Grafo extends JPanel {

    private List<No> nos;
    private List<Aresta> arestas;

    public Grafo() {
        nos = new ArrayList<>();
        arestas = new ArrayList<>();



        No acre = new No("Acre", 90, 300);
nos.add(acre);

No amazonas = new No("Amazonas", 180, 210);
nos.add(amazonas);

No roraima = new No("Roraima", 270, 120);
nos.add(roraima);

No para = new No("Pará", 330, 180);
nos.add(para);

No amapa = new No("Amapá", 390, 120);
nos.add(amapa);

No MG = new No("Mato Grosso", 270, 360);
nos.add(MG);

No rondonia = new No("Rondônia", 180, 330);
nos.add(rondonia);

No maranhao = new No("Maranhão", 420, 240);
nos.add(maranhao);

No piaui = new No("Piauí", 450, 300);
nos.add(piaui);

No ceara = new No("Ceará", 480, 270);
nos.add(ceara);

No rioGrandeDoNorte = new No("Rio Grande do Norte", 540, 240);
nos.add(rioGrandeDoNorte);

No paraiba = new No("Paraíba", 528, 270);
nos.add(paraiba);

No pernambuco = new No("Pernambuco", 510, 300);
nos.add(pernambuco);

No alagoas = new No("Alagoas", 492, 330);
nos.add(alagoas);

No sergipe = new No("Sergipe", 486, 360);
nos.add(sergipe);

No bahia = new No("Bahia", 450, 390);
nos.add(bahia);

No tocantins = new No("Tocantins", 360, 330);
nos.add(tocantins);

No goias = new No("Goiás", 330, 420);
nos.add(goias);

No distritoFederal = new No("Distrito Federal", 360, 450);
nos.add(distritoFederal);

No matoGrossoDoSul = new No("Mato Grosso do Sul", 300, 480);
nos.add(matoGrossoDoSul);

No minasGerais = new No("Minas Gerais", 420, 480);
nos.add(minasGerais);

No espiritoSanto = new No("Espírito Santo", 468, 528);
nos.add(espiritoSanto);

No rioDeJaneiro = new No("Rio de Janeiro", 450, 558);
nos.add(rioDeJaneiro);

No saoPaulo = new No("São Paulo", 420, 600);
nos.add(saoPaulo);

No parana = new No("Paraná", 390, 648);
nos.add(parana);

No santaCatarina = new No("Santa Catarina", 384, 690);
nos.add(santaCatarina);

No rioGrandeDoSul = new No("Rio Grande do Sul", 378, 732);
nos.add(rioGrandeDoSul);


                arestas.add(new Aresta(acre, amazonas, 2));
                arestas.add(new Aresta(amazonas, roraima, 2));
                arestas.add(new Aresta(roraima, para, 3));
                arestas.add(new Aresta(amazonas, rondonia, 2));
                arestas.add(new Aresta(para, amapa, 2));
                arestas.add(new Aresta(para, MG, 3));
                arestas.add(new Aresta(amazonas, MG, 4));
                arestas.add(new Aresta(para, maranhao, 2));
                arestas.add(new Aresta(maranhao, piaui, 1));
                arestas.add(new Aresta(piaui, ceara, 1));
                arestas.add(new Aresta(ceara, rioGrandeDoNorte, 1));
                arestas.add(new Aresta(ceara, paraiba, 1));
                arestas.add(new Aresta(paraiba, pernambuco, 1));
                arestas.add(new Aresta(pernambuco, alagoas, 1));
                arestas.add(new Aresta(alagoas, sergipe, 1));
                arestas.add(new Aresta(sergipe, bahia, 1));
                arestas.add(new Aresta(bahia, minasGerais, 2));
                arestas.add(new Aresta(bahia, goias, 3));
                arestas.add(new Aresta(goias, tocantins, 2));
                arestas.add(new Aresta(tocantins, para, 3));
                arestas.add(new Aresta(goias, MG, 2));
                arestas.add(new Aresta(MG, matoGrossoDoSul, 2));
                arestas.add(new Aresta(matoGrossoDoSul, saoPaulo, 3));
                arestas.add(new Aresta(saoPaulo, minasGerais, 2));
                arestas.add(new Aresta(saoPaulo, rioDeJaneiro, 1));
                arestas.add(new Aresta(minasGerais, espiritoSanto, 1));
                arestas.add(new Aresta(parana, saoPaulo, 2));
                arestas.add(new Aresta(santaCatarina, parana, 1));
                arestas.add(new Aresta(rioGrandeDoSul, santaCatarina, 1));
                arestas.add(new Aresta(acre, rondonia, 2));
                arestas.add(new Aresta(rondonia, MG, 2));
                arestas.add(new Aresta(tocantins, maranhao, 2));
                arestas.add(new Aresta(bahia, espiritoSanto, 2));
                arestas.add(new Aresta(saoPaulo, rioDeJaneiro, 3));
                arestas.add(new Aresta(rioGrandeDoNorte, paraiba, 1));
                arestas.add(new Aresta(rioDeJaneiro, espiritoSanto, 1));
                arestas.add(new Aresta(distritoFederal, goias, 1));
                arestas.add(new Aresta(distritoFederal, minasGerais, 2));
                arestas.add(new Aresta(distritoFederal, bahia, 2));
                arestas.add(new Aresta(distritoFederal, tocantins, 1));
                arestas.add(new Aresta(distritoFederal, MG,4));
                
                for (No no : nos) {
                for (Aresta aresta : arestas) {
                    if(no.getNome().equals(aresta.getNo1().getNome())){
                        no.addVizinho(aresta.getNo2(), (int)aresta.getPeso());
                    }  
                    else if(no.getNome().equals(aresta.getNo2().getNome()) ){
                        no.addVizinho(aresta.getNo1(), (int)aresta.getPeso());
                    }
                }
           }


}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Aresta aresta : arestas) { 
            No no1 = aresta.getNo1();
            No no2 = aresta.getNo2();
            g2d.drawLine(no1.getX(), no1.getY(), no2.getX(), no2.getY());
            float posX = (no2.getX() + no1.getX()) / 2;
            float posY = (no2.getY() + no2.getY()) / 2;
            g2d.drawString(String.valueOf(aresta.getPeso()), posX - 15, posY - 25);
        }

        for (No no : nos) {
            g2d.drawOval(no.getX(), no.getY(), 10, 10);
            g2d.drawString(no.getNome(), no.getX() - 10, no.getY() - 15);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grafo grafo = new Grafo();
        //minha parte
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.Buscarcaminho("Amapá", "Acre", grafo.nos);
        //visualização
        frame.add(grafo);
        frame.setSize(2000,  2000);
        frame.setVisible(true);
    }
}