import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Esqueleto
{
	private static boolean test=true;
	
	private static BufferedReader br;
	private static PrintWriter pw;

	public static void main(String[] args) throws Exception 
	{
		String pathname="./data/Esqueleto/Esqueleto";//TODO Nombre del problema

		if(test)
		{
			br = new BufferedReader(new FileReader(new File(pathname+".in")));
			pw = new PrintWriter(new File(pathname+".out"));
		}
		else br = new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		if(test)
		{
			pw.close();
			Desktop.getDesktop().open(new File(pathname+".out"));
		}
	}

	private static void solucionarProblema() throws IOException 
	{
		String line=br.readLine();
		while(!"0 0".endsWith(line))
		{
			//Separar informacion pertinente(Usar line)
			
			String rta=solucionarCaso();
			
			//---------------------------------------------

			line=br.readLine();
			rta=("0 0".equals(line))?rta:rta+"\n";
			imprimirSolucion(rta);
		}
	}
	
	@SuppressWarnings("unused")
	private static void solucionarProblema2() throws IOException 
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion pertinente

			String rta = solucionarCaso();

			//---------------------------------------------

			rta=(i==casos-1)?rta:rta+"\n";
			imprimirSolucion(rta);
		}
	}
		
	private static String solucionarCaso() 
	{
		return null;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(!test)System.out.print(solucion);
		else pw.print(solucion);
	}
}
