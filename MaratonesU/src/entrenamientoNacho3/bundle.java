package entrenamientoNacho3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bundle
{
	private static BufferedReader br;
	private static boolean test = true;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/entrenamientoNacho3/bundleTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while(linea!=null)
		{
			String[] paramProb=linea.split(" ");
			int productos=Integer.parseInt(paramProb[0]);
			int clientes=Integer.parseInt(paramProb[1]);
			
			char[][] matriz= new char[productos][clientes];
			for (int i = 0; i < productos; i++) matriz[i]=br.readLine().toCharArray();
			
			int rta= solucionarCaso(matriz,clientes,productos);

			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(char[][] matriz, int clientes, int productos) 
	{
		Set<String> combinaciones=new HashSet<String>();
		for (int j = 0; j < clientes; j++)
		{
			String compra="";
			for (int i = 0; i < productos; i++) compra+=matriz[i][j];
			combinaciones.add(compra);
		}
		return combinaciones.size();
	}
}