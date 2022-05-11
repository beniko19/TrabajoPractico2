package generadorMinimo;

import grafos.AristaVecina;
import grafos.GrafoLV;
import grafos.GrafoVecinos;

import java.util.*;

public class GrafoPrim {
	
	private ArrayList<Integer> verticesAmarillos;
	private GrafoLV grafoNegro;
	private GrafoLV grafoAmarillo;
	double startTime;
	double endTime;
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
		this.startTime = System.currentTimeMillis();
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
		this.endTime = System.currentTimeMillis();
		return grafoPrim;
	}
	
	public GrafoLV getGrafoPrim()
	{
		return this.grafoAmarillo;
	}

	public GrafoVecinos toGrafoVecinos()
	{
		GrafoVecinos grafoVecinos=new GrafoVecinos(this.grafoAmarillo.getTotalVertices());
		AristaVecina aristaAux=new AristaVecina();

		for (Map.Entry<Integer,TreeSet<AristaVecina>> verticeConLV : this.grafoAmarillo.getGrafo().entrySet())
		{
			Iterator<AristaVecina> iterator = verticeConLV.getValue().iterator();
			while(iterator.hasNext())
			{
				aristaAux=iterator.next();
				grafoVecinos.agregarVecino(verticeConLV.getKey(), aristaAux.getVertice(),(int) aristaAux.getPesoArista());
			}
		}

		return grafoVecinos;

	}

	public double tiempoQueTardo(){
		return this.endTime-this.startTime;
	}
}
