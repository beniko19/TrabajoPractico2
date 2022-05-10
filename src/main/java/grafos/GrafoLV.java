package grafos;

import java.util.*;

public class GrafoLV {
	
	// vertice -> conjunto de aristas vecinas con sus pesos.
	private HashMap<Integer,TreeSet<AristaVecina>> grafo;
	private StringBuilder stringGrafo;
	
	
	public GrafoLV()
	{
		this.grafo=new HashMap<Integer,TreeSet<AristaVecina>>();
		this.grafo.put(0,new TreeSet<AristaVecina>());
		
	}
	
	public GrafoLV(GrafoLV grafo)
	{
	}
	
	public GrafoLV(int vertices)
	{
		this.grafo=new HashMap<Integer,TreeSet<AristaVecina>>();	
		for(int i=0; i<vertices; ++i) this.grafo.put(i,new TreeSet<AristaVecina>());  
	}

	
	
	public void agregarArista(Integer vertice1,Integer vertice2, double peso)
	{
		
		TreeSet<AristaVecina> aristasVertice1= this.grafo.get(vertice1);
		AristaVecina vertice1al2=new AristaVecina(vertice2,peso);
		aristasVertice1.add(vertice1al2);
		this.grafo.put(vertice1, aristasVertice1);
		
		
		TreeSet<AristaVecina> aristasVertice2= this.grafo.get(vertice2);		
		AristaVecina vertice2al1=new AristaVecina(vertice1,peso);
		aristasVertice2.add(vertice2al1);
		this.grafo.put(vertice2,aristasVertice2);	
	}
	
	public void agregarVertice(Integer vertice)
	{
		this.grafo.put(vertice,new TreeSet<AristaVecina>());
	}
	
	
	public void agregarArista(Integer vertice, AristaVecina arista)
	{
		this.agregarArista(vertice, arista.getVertice(),arista.getPesoArista());
	}
	
	
	public int getTotalVertices()
	{
		return this.grafo.size();
	}
	

	
	public TreeSet<AristaVecina> getVecinos(int vertice)
	{
		return this.grafo.get(vertice);
	}
	
	public HashMap<Integer,TreeSet<AristaVecina>> getGrafo()
	{
		return this.grafo;
	}
	
	
	public String toString()
	{
		stringGrafo= new StringBuilder();
		for (Map.Entry<Integer,TreeSet<AristaVecina>> verticeConLV : this.grafo.entrySet())
		{
			stringGrafo.append("Vertice Nro ").append(verticeConLV.getKey()).append(" Tiene de vecinos: \n");
			Iterator<AristaVecina> iterator = verticeConLV.getValue().iterator();
			while(iterator.hasNext())
			{
				stringGrafo.append(iterator.next().toString());		
			}
			stringGrafo.append("\n");
		}
		return stringGrafo.toString();	
	}
}
