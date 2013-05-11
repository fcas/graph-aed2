import java.util.ArrayList;
import java.util.List;


public class Vertice {
	
	 private String conteudo;
	 private String id; 
     private int distancia;
     private boolean visitado;
     private Vertice pai;
     private List<Aresta> arestas;
     private List<Vertice> vizinhos;
     
     public Vertice(String conteudo, String id) { 
    	 this.conteudo = conteudo; 
    	 this.id = id; 
    	 this.visitado = false; 
    	 this.arestas = new ArrayList<Aresta>();
    	 this.vizinhos = new ArrayList<Vertice>();	 
     }
     
     public void setConteudo(String conteudo){
             
             this.conteudo = conteudo;
     }
     
     public String getConteudo(){
             
             return conteudo;
             
     }
     
     public void visitar (){
             
             this.visitado = true;
     }
     
     public boolean verificarVisita(){
             
             return visitado;
     }
     
     public void setDistancia(int distancia){
             
             this.distancia = distancia;
     }
     
     public int getDistancia(){
             
             return this.distancia;
     }
     
     public void setPai(Vertice pai){
             
             this.pai = pai;
     }
     
     public Vertice getPai(){
             
             return this.pai;
     }

     public void setVizinhos(List<Vertice> vizinhos) {
             
             this.vizinhos.addAll(vizinhos);
                             
     }
     
     public List<Vertice> getVizinhos(){
             
             return this.vizinhos;
     }
     
     public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setArestas(List <Aresta> arestas){
             this.arestas.addAll(arestas);
             
     }
     
     public List<Aresta> getArestas() {
             return arestas;
     }
     
}
