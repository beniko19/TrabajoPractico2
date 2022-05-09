package grafos;

public class AristaVecina implements Comparable<AristaVecina>{
	
	private Integer verticeVecino;
	private Double pesoArista;

	
	public AristaVecina()
	{
		this.pesoArista=null;
		this.verticeVecino=null;
	}
	
	public AristaVecina(Integer vertice,double peso)
	{
		this.pesoArista=peso;
		this.verticeVecino=vertice;
	}

	public Integer getVertice() {
		return verticeVecino;
	}

	public void setVerticeVecino(Integer verticeVecino) {
		this.verticeVecino = verticeVecino;
	}

	public double getPesoArista() {
		return pesoArista;
	}

	public void setPesoArista(double pesoArista) {
		this.pesoArista = pesoArista;
	}
	
	public int compareTo(AristaVecina arista)
	{
		if(this.pesoArista<arista.pesoArista) return -1;
		else if(this.pesoArista>arista.pesoArista) return 1;
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return "{["+this.verticeVecino+"] Peso: "+this.pesoArista+" }";
		
	}
	
	public boolean equals(Object obj) 
	{
		AristaVecina arista = (AristaVecina) obj;
		
		if(this.verticeVecino==arista.verticeVecino)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
