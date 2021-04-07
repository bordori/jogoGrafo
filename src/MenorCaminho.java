import java.util.List; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator; 
 
public class MenorCaminho extends Grafo{ 
     
    private boolean nodosVisitados[]; 
    private int distancias[]; 
    public int father[]; 
    private List filaDePrioridade = new ArrayList<Integer>(); 
    private int origem; 
    public List<Integer> caminho = new ArrayList<Integer>();
     
    /* 
     * Construtor : recebe o numero de nodos do grafo 
     */ 
    public MenorCaminho(int numeroDeNodos) throws Exception{ 
        super(numeroDeNodos); 
        //como sera considerado de 1- n entao e acrescentado + 1 
        nodosVisitados = new boolean[numeroDeNodos]; 
        //como sera considerado de 1- n entao e acrescentado + 1 
        distancias = new int[numeroDeNodos]; 
        //antecesor do vertice 
        father = new int[numeroDeNodos]; 
    } 
     
    public int dijkistra(int origem, int destino)throws Exception{ 
 
        if(origem < 0 || origem > getNUMERO_DE_NODOS()) 
            throw new Exception("origem eh menor que 0 ou destino nao existe"); 
                 
        try{ 
            iniciaMenorCaminho(origem); 
        }catch(Exception ex){ 
            System.out.println("Erro ao iniciar os dados "+ex); 
        } 
         
                 
        while(!filaDePrioridade.isEmpty()){             
            Integer verticeMenorPeso = extraiMenor();     
             
             
            for(int i = 0 ; i < getNUMERO_DE_NODOS() ; i++){ 
                 
                if(getMatrizDePesos()[verticeMenorPeso][i] > 0)                     
                    relaxa(verticeMenorPeso,i);                 
            } 
             
        } 
        getCaminho(origem, destino);
        //printDistancias(); 
        return distancias[destino];                           
    } 
    /* 
     * Inicia dados do algoritmo 
     */ 
    private void iniciaMenorCaminho(int origem){ 
        for(int i = 0 ; i < getNUMERO_DE_NODOS(); i++){ 
            distancias[i] = OO; 
            nodosVisitados[i] = false;     
            father[i] = OO; 
            filaDePrioridade.add(new Integer(i));//adiciona a aresta na fila 
        } 
        distancias[origem] = 0;//inicia o vetor de distancias 
         
    } 
   
    /* 
     * Relaxa arestas no grafo 
     */ 
    private void relaxa(int u, int v){ 
         
            if (distancias[v] > distancias[u]+getMatrizDePesos()[u][v]){                 
                distancias[v] = distancias[u]+getMatrizDePesos()[u][v]; 
                father[v] = u;                         
            } 
    } 
     
    private int extraiMenor(){ 
        int menorValor = OO;    
        int verticeDeMenorPeso=0; 
         
        Iterator<Integer>it = filaDePrioridade.iterator(); 
        while(it.hasNext()){ 
            int verticeAtual = it.next();             
            if(distancias[verticeAtual] < menorValor){                 
                menorValor = distancias[verticeAtual]; 
                verticeDeMenorPeso = verticeAtual; 
            } 
        } 
         
      //  System.out.println("Remove o vertice "+verticeDeMenorPeso+" da fila " 
         //                  +" de peso "+menorValor); 
        //remove o vertice com menor distancia do grafo 
        filaDePrioridade.remove(new Integer(verticeDeMenorPeso));         
       // System.out.println("-------------------------------------------------"); 
         
        return verticeDeMenorPeso; 
    } 
     
    public int getOrigem() { 
        return origem; 
    } 
 
    public void setOrigem(int origem) { 
        this.origem = origem; 
    } 
     
    public List getFilaDePrioridade() { 
        return filaDePrioridade; 
    } 
 
    public void setFilaDePrioridade(List filaDePrioridade) { 
        this.filaDePrioridade = filaDePrioridade; 
    } 
    
    private void getCaminho(int origem,int destino) {
    	
    	int i = destino ;
    	List<Integer> temp = new ArrayList<Integer>();
    	temp.add(destino);
    	while(i != origem) {
    		
    		temp.add(father[i]);
    		i= father[i];
    	}
    	Collections.reverse(temp);
    	caminho = temp;
    }
     
    public List<Integer> getCaminho() {
		return caminho;
	}

	public void setCaminho(List<Integer> caminho) {
		this.caminho = caminho;
	}

	private void printDistancias(){ 
        for(int i = 0 ; i < getNUMERO_DE_NODOS(); i++) 
            System.out.print("["+distancias[i]+"] "); 
        System.out.println(); 
        
    } 
    /*public static void main(String args[]){ 
         
         
        try{ 
            MenorCaminho dij = new MenorCaminho(5); 
            dij.insertArc(0, 1, 10); 
            dij.insertArc(0, 2, 5); 
            dij.insertArc(1, 2, 2); 
            dij.insertArc(1, 3, 1); 
            dij.insertArc(2, 1, 3); 
            dij.insertArc(2, 3, 9); 
            dij.insertArc(2, 4, 2); 
            dij.insertArc(3, 4, 4);         
            dij.insertArc(4, 3, 6); 
            dij.insertArc(4, 0, 7);             
            System.out.println("Menor caminho entre 0 e 4 "+dij.dijkistra(0,4 ));             
            dij.printMatriz(dij.getMatrizDePesos()); 
        }catch(Exception ex){ 
            if(ex.getMessage() == null) 
                  System.out.println("Ocorreu um erro de "+ex+" no main"); 
            else  
                System.out.println(ex.getMessage()+"XXX"); 
        } 
         
    } */
} 