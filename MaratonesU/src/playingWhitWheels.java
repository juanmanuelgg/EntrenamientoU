import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
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
	
		br.close();
	}

	private static void solucionarProblema() throws IOException 
	{
		LinkedHashSet<Integer>[]grfAdj=preprocesarGrafo();
		for (int i = 0; i < grfAdj.length; i++) System.out.println(i+" "+grfAdj[i]);

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

			String rta = solucionarCaso(initial,target,prohibidas,grfAdj);

			if(!(i==casos-1))br.readLine();

			//---------------------------------------------

			rta=(i==casos-1)?rta:rta+"\n";
			System.out.print(rta);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static LinkedHashSet<Integer>[] preprocesarGrafo()
	{
		LinkedHashSet<Integer>[] adj = (LinkedHashSet<Integer>[])new LinkedHashSet[10000];
		for (int i = 0; i < adj.length; i++) adj[i]=new LinkedHashSet<Integer>();

		for (int actual=0; actual<10000; actual++)
		{
			String num=actual+"";
			for (int j = num.length(); j < 4; j++)num="0"+num;
			char[] aux=num.toCharArray();
			for (int k = 0; k < 4; k++)
			{
				char temp=aux[k];

				int izq=(temp=='0')?9:(temp-'0')-1;
				int der=(temp=='9')?0:(temp-'0')+1;

				aux[k]=(izq+"").toCharArray()[0];
				int variacion=Integer.parseInt(new String(aux));
				adj[actual].add(variacion);
				
				aux[k]=(der+"").toCharArray()[0];
				variacion=Integer.parseInt(new String(aux));
				adj[actual].add(variacion);
				
				aux[k]=temp;
			}
		}
		return adj;
	}

	/**DFS */
	private static String solucionarCaso(int initial, int target, Set<Integer> prohibidas, HashSet<Integer>[] grfAdj) 
	{
		double[] distTo = new double[10000];
		Arrays.fill(distTo, -1);

		distTo[initial]=0;
		Queue<Integer> q=new PriorityQueue<Integer>();
		q.add(initial);

		while (!q.isEmpty())
		{
			int v=q.poll();
			for (int w: grfAdj[v])
			{
				if(!prohibidas.contains(w) && distTo[w]==-1)
				{
					distTo[w]=distTo[v]+1;
					q.add(w);
				}
			}
		}
		return (int)distTo[target]+"";
	}
}