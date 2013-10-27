package entrenamientoNacho2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

public class travel 
{
	private static boolean test=true;
	private static BufferedReader br;

	private static travel yo;

	public static void main(String[] args) throws Exception 
	{
		yo=new travel();
		if(test) br=new BufferedReader(new FileReader(new File("./data/travelTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws Exception 
	{
		boolean primero = true;
		String linea = br.readLine();
		while (linea != null) 
		{
			//Separar informacion pertinente(Usando line)

			String[] auxpuntosRuta=linea.split(" ");
			int origen=Integer.parseInt(auxpuntosRuta[0]);
			int destino=Integer.parseInt(auxpuntosRuta[1]);

			String[] latitudes = br.readLine().split(" ");
			String[] longitudes = br.readLine().split(" ");

			int numeroAeropuertos=Integer.parseInt(br.readLine());
			String[] adjacentes=new String[numeroAeropuertos];
			for (int i = 0; i < adjacentes.length; i++)adjacentes[i]=br.readLine();

			GrafoDirigConPeso grafo = armarGrafo(numeroAeropuertos,adjacentes,latitudes,longitudes);

			String rta = solucionarCaso(origen,destino,grafo);

			//---------------------------------------------

			rta=(primero)?rta:"\n"+rta;
			System.out.print(rta);
			linea = br.readLine();
			if (primero)primero=false;
		}
	}

	private static GrafoDirigConPeso armarGrafo(int numeroAeropuertos,String[] adjacentes, String[] latitudes, String[] longitudes)
	{
		ArrayList<String> arcos = new ArrayList<String>();
		for (int i = 0; i < numeroAeropuertos; i++) 
		{
			String[] vertAdjacentes=adjacentes[i].split(" ");
			for (int j = 0; j < vertAdjacentes.length; j++) 
			{
				int otroPunto=Integer.parseInt(vertAdjacentes[j]);
				double lat1=Math.toRadians(Integer.parseInt(latitudes[i]));
				double lat2=Math.toRadians(Integer.parseInt(latitudes[otroPunto]));
				double lon1=Math.toRadians(Integer.parseInt(longitudes[i]));
				double lon2=Math.toRadians(Integer.parseInt(longitudes[otroPunto]));

				double aux1=Math.sin(lat1);
				double aux2=Math.sin(lat2);
				double aux3=Math.cos(lat1);
				double aux4=Math.cos(lat2);
				double aux5=Math.cos((lon1-lon2));
				double peso=4000*Math.acos((aux1*aux2)+(aux3*aux4*aux5));
				String arcoNuevo=i+":"+vertAdjacentes[j]+":"+peso;
				arcos.add(arcoNuevo);
			}
		}
		return yo.new GrafoDirigConPeso(numeroAeropuertos, arcos);
	}

	/**Dijkstra*/
	private static String solucionarCaso(int origen, int destino,GrafoDirigConPeso grafo)
	{
		double[] distTo = new double[grafo.V()];
		ArcoDirigido[] edgeTo= new ArcoDirigido[grafo.V()];

		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		distTo[origen]=0;

		PriorityQueue<NodoDijkstra> pq = new PriorityQueue<NodoDijkstra>(grafo.V());
		NodoDijkstra fuente=yo.new NodoDijkstra(origen,0.0);
		pq.add(fuente);
		while (!pq.isEmpty()) relaxArcos(pq,distTo,edgeTo,pq.poll(),grafo.adj());

		Double distancia = distTo[destino];
		if(distancia==Double.POSITIVE_INFINITY) return "-1.00000";
		else
		{
			String[] aux=(distancia+"").split("\\.");
			char[] numDescimales=aux[1].toCharArray();
			String decimales="";
			for (int i = 0; i < 5; i++)
			{
				if(i<numDescimales.length)decimales+=numDescimales[i];
				else decimales+='0';
			}
			return aux[0]+'.'+decimales;
		}
	}

	private static void relaxArcos(PriorityQueue<NodoDijkstra> pq, double[] distTo, ArcoDirigido[] edgeTo, NodoDijkstra nodo, ArrayList<ArcoDirigido>[] adj)
	{
		for(ArcoDirigido arco : adj[nodo.s()])
		{
			int w = arco.to();
			Double nuevaDist=distTo[nodo.s()] + arco.weight();
			if (distTo[w] > nuevaDist)
			{
				distTo[w]=nuevaDist;
				edgeTo[w]=arco;
				if (pq.contains(w))
				{
					pq.remove(w);
					NodoDijkstra remplazo=yo.new NodoDijkstra(w,distTo[w]);
					pq.add(remplazo);
				}
				else 
				{
					NodoDijkstra nuevo=yo.new NodoDijkstra(w,distTo[w]);
					pq.add(nuevo);
				}
			}
		}
	}
	
	//-----------------------------------------------
	// Estructura de Datos (Grafo Dirigido con peso)
	//-----------------------------------------------
	
	private class GrafoDirigConPeso 
	{
		protected final int V;
		protected ArrayList<ArcoDirigido>[] adj;

		@SuppressWarnings("unchecked")
		public GrafoDirigConPeso(int numV, Collection<String> arcos) 
		{
			adj=(ArrayList<ArcoDirigido>[])new ArrayList[numV];
			for (int i=0; i < adj.length; i++)adj[i]=new ArrayList<ArcoDirigido>();

			V=numV;

			for (String esteA : arcos) 
			{
				String[] paramArco=esteA.split(":");
				int v = Integer.parseInt(paramArco[0]);
				int w = Integer.parseInt(paramArco[1]);
				double weight = Double.parseDouble(paramArco[2]);
				ArcoDirigido e = new ArcoDirigido(v, w, weight);
				addEdge(e);
			}
		}

		public int V() {return V;}
		public ArrayList<ArcoDirigido>[] adj(){return adj;}

		public void addEdge(ArcoDirigido e) 
		{
			int v = e.from();
			adj[v].add(e);
		}

	}

	private class ArcoDirigido implements Comparable<ArcoDirigido> 
	{ 
		protected final int v;
		protected final int w;
		protected final double weight;

		public ArcoDirigido(int verV, int verW, double peso) 
		{
			v = verV;
			w = verW;
			weight = peso;
		}

		public double weight() {return weight;}

		public int from() {return v;}

		public int to()	{return w;}

		@Override
		public int compareTo(ArcoDirigido that) 
		{return  Double.compare(weight, that.weight());}
	}

	private class NodoDijkstra implements Comparable<NodoDijkstra> 
	{
		protected int s;
		protected double d;

		public NodoDijkstra(int s, double d) 
		{
			this.s=s;
			this.d=d;
		}

		public int s() {return s;}

		private double d() {return d;}

		@Override
		public int compareTo(NodoDijkstra that)
		{return Double.compare(d, that.d());}
	}
}