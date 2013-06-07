package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import menorcaminho.BellmanFord;
import menorcaminho.MenorCaminhoInfo;

import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;

public class MainBellmanFord {
	
	private static final String caminhoArquivo = System.getProperty("user.dir") + "/src/testes/bellmanford/";
	private static List<String> arquivos = new ArrayList<String>();
	static BufferedReader in;
	
	protected BellmanFord bellmanford;
	
	public MainBellmanFord(GrafoComoListaAdjacencia grafo) throws FileNotFoundException {
		
		bellmanford = new BellmanFord(grafo);
		
	}
	
	public void leArquivo() throws IOException{
		String linha = in.readLine();
		while (linha != null) {
			String palavras[] = linha.split(" ");
			
			switch(palavras[0]){
			case "edge":
				bellmanford.grafo.adicionarVertice(palavras[1], Integer.parseInt(palavras[1]));
				bellmanford.grafo.adicionarVertice(palavras[2], Integer.parseInt(palavras[2]));
				bellmanford.grafo.adicionarAresta(Integer.parseInt(palavras[1]), Integer.parseInt(palavras[2]), Double.parseDouble(palavras[3]));
				System.out.println("-");
				break;
				
			case "shortest":
				Stack<Vertice> pilha = new Stack<Vertice>();
				bellmanford.calculaMenorCaminho(bellmanford.grafo.getVertice(Integer.parseInt(palavras[1])));
				MenorCaminhoInfo destino = bellmanford.getMenorCaminho(bellmanford.grafo.getVertice(Integer.parseInt(palavras[2])));
				double tamanho = destino.getMenorCaminho();
				Vertice aux = bellmanford.grafo.getVertice(Integer.parseInt(palavras[2])) ;
				
				do {
					pilha.push(aux);
					aux = destino.getPredecessor();
					if (aux != null){
						destino = bellmanford.getMenorCaminho(aux);
					}
				} while(aux != null);
				
				for (int i=0; i<pilha.size(); i++){
					System.out.print(pilha.pop().getIndice() + " ");
				}
				System.out.println(tamanho);
				break;
				
			case "hasNegativeCicle":
				bellmanford.calculaMenorCaminho(bellmanford.grafo.getListaAdjacencia()[0].esteVertice);
				System.out.println(!bellmanford.naoExisteCicloNegativo());
				break;
			}
			linha = in.readLine();
		}
	}
	
	public static void main(String[] args) throws IOException {
		arquivos.add(caminhoArquivo + "bellmanford1.in");
		arquivos.add(caminhoArquivo + "bellmanford2.in");
		arquivos.add(caminhoArquivo + "bellmanford3.in");
		in = new BufferedReader(new FileReader(arquivos.get(0)));
		String card = in.readLine();
		GrafoComoListaAdjacencia grafo = new GrafoComoListaAdjacencia(Integer.parseInt(card), false);
		MainBellmanFord a = new MainBellmanFord(grafo);
		a.leArquivo();
	}
	
	
	

}
