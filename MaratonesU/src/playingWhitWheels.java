import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class playingWhitWheels 
{
	private static boolean test = true;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/playingWhitWheelsTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema();
	}

	private static void solucionarProblema() throws IOException 
	{
		ArrayList<Integer>[]grafo=preprocesarGrafo();

		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion pertinente

			int initial=Integer.parseInt((br.readLine().replace(" ", "")));
			int target=Integer.parseInt((br.readLine().replace(" ", "")));

			Set<Integer> prohibidas=new HashSet<Integer>();
			int numProhibidas=Integer.parseInt(br.readLine());
			for (int j = 0; j < numProhibidas; j++)
			{
				int aux = Integer.parseInt((br.readLine().replace(" ", "")));
				prohibidas.add(aux);
			}

			String rta = solucionarCaso(initial,target,prohibidas,grafo);

			if(!(i==casos-1))br.readLine();

			//---------------------------------------------

			rta=(i==casos-1)?rta:rta+"\n";
			System.out.print(rta);
		}
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Integer>[] preprocesarGrafo()
	{
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[10000];
		for (int i = 0; i < adj.length; i++) adj[i]=new ArrayList<Integer>();

		for (int actual=0; actual<10000; actual++)
		{
			String num=actual+"";
			for (int j = num.length(); j < 4; j++)num="0"+num;
			char[] aux=num.toCharArray();
			for (int k = 0; k < 4; k++)
			{
				char temp=aux[k];
				for (int j = 0; j < 10; j++)
				{
					aux[k]=(j+"").toCharArray()[0];
					int variacion=Integer.parseInt(new String(aux));
					if(actual!=variacion)
					{
						adj[actual].add(variacion);
						adj[variacion].add(actual);
					}
				}
				aux[k]=temp;
			}
		}
		return adj;
	}

	/**Dijkstra */
	private static String solucionarCaso(int initial, int target, Set<Integer> prohibidas, ArrayList<Integer>[] grafo) 
	{
		double[] distTo = new double[10000];
        int[] edgeTo = new int[10000];
        
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        Arrays.fill(edgeTo, -1);
        
        PriorityQueue<E>
		return "XX";
	}
}