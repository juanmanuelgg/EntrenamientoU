import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//------------------------------------------------------------
//      NO SIRVE POR COMPLEJIDAD TEMPORAL & ESPACIAL
//------------------------------------------------------------

public class cycles 
{
	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(test) br=new BufferedReader(new FileReader(new File("./data/cyclesTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	@SuppressWarnings("unchecked")
	private static void solucionarProblema() throws IOException
	{
		boolean primero=true;
		String line=br.readLine();

		while (line!=null)
		{
			//Partir info usando line

			int  numVertices=line.length();

			//Armar Grafo.
			ArrayList<Integer>[] grfAdj=(ArrayList<Integer>[])new ArrayList[numVertices];
			for (int i = 0; i < grfAdj.length; i++)grfAdj[i]=new ArrayList<Integer>();

			//Armar relaciones Grafo.
			for (int i = 0; i < line.length(); i++) if(line.charAt(i)=='Y')grfAdj[0].add(i);
			for (int i = 0; i < numVertices-1; i++)
			{
				line=br.readLine();
				for (int j = 0; j < line.length(); j++) if(line.charAt(j)=='Y')grfAdj[i+1].add(j);
			}

			String[] paramGraf=br.readLine().split(" ");
			int k=Integer.parseInt(paramGraf[0]);
			int m=Integer.parseInt(paramGraf[1]);

			int rta=solucionarCaso(grfAdj,k,m);

			//--------------------------------
			String rtaReal=(primero)?""+rta:"\n"+rta;
			if(primero)primero=false;
			System.out.print(rtaReal);

			line=br.readLine();
		}
	}

	private static int solucionarCaso(ArrayList<Integer>[] grfAdj, int k, int m)
	{
		Set<String> ciclos=new HashSet<String>();
		Set<String> quitar=new HashSet<String>();
		for (int i = 0; i < grfAdj.length; i++)
		{
			boolean[] marcados=new boolean[grfAdj.length];
			String elCamino=i+"";
			dfs(ciclos,i,k,grfAdj,marcados, elCamino, i);
			quitar.add(i+"");
		}
		ciclos.removeAll(quitar);
		return ciclos.size()%m;
	}

	private static void dfs(Set<String> ciclos, int vertice, int k, ArrayList<Integer>[] grfAdj, boolean[] marcados, String elCamino, int original)
	{
		if(k!=0)
		{
			if(vertice==original)ciclos.add(elCamino);
			marcados[vertice] = true;
			for (int w : grfAdj[vertice])
			{
				String auxCamino=(elCamino+w);
				dfs(ciclos,w,k-1, grfAdj,marcados, auxCamino, original);
			}
		}
	}
}