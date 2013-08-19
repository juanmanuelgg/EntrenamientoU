package auxiliar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Esqueleto
{
	private static BufferedReader br;
	
	private static final String LINEAFINAL = "0 0";//TODO SP1
	private static boolean primero = true;//TODO SP3
	
	private static boolean test = true;//TODO Cambiar
	
	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/Esqueleto/Test.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema3();
	}

	@SuppressWarnings("unused")
	private static void solucionarProblema1() throws IOException 
	{
		String line=br.readLine();
		while(!LINEAFINAL.equals(line))
		{
			//Separar informacion pertinente(Usando line)
			
			String rta=solucionarCaso();
			
			//---------------------------------------------

			line=br.readLine();
			rta=(LINEAFINAL.equals(line))?rta:rta+"\n";
			System.out.print(rta);
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
			System.out.print(rta);
		}
	}
	
	private static void solucionarProblema3() throws IOException 
	{
		String line=br.readLine();
		while(line!=null)
		{
			//Separar informacion pertinente(Usando line)

			String rta = solucionarCaso();

			//---------------------------------------------
			
			rta=(primero)?rta:"\n"+rta;
			if(primero) primero=false;
			System.out.print(rta);
			line=br.readLine();
		}
	}
		
	private static String solucionarCaso() 
	{
		return "XX";
	}
}