package generadorMinimo;

import grafos.AristaVecina;
import grafos.GrafoLV;

import java.util.*;

public class GrafoPrim {
	
	private ArrayList<Integer> verticesAmarillos;
	private GrafoLV grafoNegro;
	private GrafoLV grafoAmarillo;
	
	public GrafoPrim(GrafoLV grafoOriginal)
	{
		this.grafoNegro=grafoOriginal;
		this.grafoAmarillo=algoritmoPrim(grafoOriginal);
	}
	private GrafoLV algoritmoPrim(GrafoLV grafoNegro)
	{
		GrafoLV grafoPrim=new GrafoLV();
		
		AristaVecina aristaMenorPeso=new AristaVecina();
		AristaVecina aristaAux=new AristaVecina();
		boolean primerVecino;
		Integer verticeAmarilloMPeso=0;
		
		for(int x=0;x< grafoNegro.getTotalVertices()-1 ;x++)
		{	
			primerVecino=true;		
			for (Map.Entry<Integer,TreeSet<AristaVecina>> grafoAmarillo : grafoPrim.getGrafo().entrySet())
			{	
				if(grafoNegro.getVecinos(grafoAmarillo.getKey()).size()!=0 )
				{		
					
					if(grafoPrim.getGrafo().keySet().contains( grafoNegro.getVecinos(grafoAmarillo.getKey()).first().getVertice() ))
					{
						grafoNegro.getVecinos(grafoAmarillo.getKey()).pollFirst();
					}
					else 
					{
						if(primerVecino)
						{				
							aristaMenorPeso=grafoNegro.getVecinos(grafoAmarillo.getKey()).first();
							primerVecino=false;			
						}
						
						aristaAux=grafoNegro.getVecinos(grafoAmarillo.getKey()).first();
	
						if(aristaMenorPeso.compareTo(aristaAux)>=0)
						{
							aristaMenorPeso=aristaAux;
							verticeAmarilloMPeso=grafoAmarillo.getKey();		
						}	
					}
				}			
			}		
			
			grafoPrim.agregarVertice(aristaMenorPeso.getVertice());	
			grafoPrim.agregarArista(verticeAmarilloMPeso, grafoNegro.getVecinos(verticeAmarilloMPeso).pollFirst());		
			AristaVecina aristaInversa=new AristaVecina(verticeAmarilloMPeso,aristaMenorPeso.getPesoArista());
			grafoNegro.getGrafo().get(aristaMenorPeso.getVertice()).remove(aristaInversa);
					
		}
		return grafoPrim;
	}
	
	public GrafoLV getGrafoPrim()
	{
		return this.grafoAmarillo;
	}

	public String[][] toArray2D()
	{
		//ACA LO INICIAMOS CON [NUMERO DE VERTICES]  [3 FIJO: ESPIA/ESPIA/PESO]
		String[][] grafo=new String[this.grafoAmarillo.getTotalVertices()][3];
		int x=0;
		//INICIAMOS UN FOR QUE RECORRA LOS VERTICES DEL GRAFO.
		for (Map.Entry<Integer,TreeSet<AristaVecina>> verticeConLV : this.grafoAmarillo.getGrafo().entrySet())
		{

			Iterator<AristaVecina> iterator = verticeConLV.getValue().iterator();
			while(iterator.hasNext())
			{
				AristaVecina next = iterator.next();
				//DE CADA UNO SACAMOS EL VERTICE, CON EL QUE SE COMUNICA, Y EL PESO.
				grafo[x][0]=String.valueOf(verticeConLV.getKey());
				//grafo[x][1]= String.valueOf(iterator.next().getVertice());
				//grafo[x][2]=  String.valueOf(iterator.next().getPesoArista());
				grafo[x][1]= String.valueOf(next.getVertice());
				grafo[x][2]= String.valueOf(next.getVertice());

			}
		x++;
		}
		return grafo;
	}
}
