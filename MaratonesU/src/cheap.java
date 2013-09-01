import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class cheap 
{
	private static boolean test = true;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/cheapTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException 
	{
		boolean primero = true;
		String linea = br.readLine();
		while (linea != null)
		{
			//Separar informacion pertinente(Usando line)
			
			String rta = solucionarCaso(linea)+"";

			//---------------------------------------------

			rta=(primero)?rta:"\n"+rta;
			if (primero)primero = false;
			System.out.print(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(String linea) 
	{
		String[] aux = linea.split(" ");
		SortedSet<Integer> valores=new TreeSet<Integer>();
		for (String valor : aux) valores.add(Integer.parseInt(valor));

		if(valores.size()>2)
		{
			Object[] x = valores.toArray();
			return (Integer) x[2];
		}
		else return -1;
	}
}