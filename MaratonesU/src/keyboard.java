import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class keyboard 
{
	private static BufferedReader br;
	private static boolean test=true;
	
	public static void main(String[] args) throws IOException 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/keyboardTest.in")));
		else br= new BufferedReader(new InputStreamReader(System.in));
		
		solucionarProblema();
		
		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		boolean primero=true;
		
		String linea=br.readLine();
		while (linea!=null) 
		{
			// Separar  informacion usando line
			String[] auxLol=linea.split(" ");
			
			HashMap<Character, Integer> teclado=new HashMap<Character, Integer>();
			char[] teclas=auxLol[0].toCharArray();
			char[] palabra=auxLol[1].toCharArray();
			for (int i = 0; i < teclas.length; i++) teclado.put(teclas[i], i);
			
			String rta=solucionarCaso(teclado,palabra)+"";
			
			//-------------------------------
			
			rta=(primero)?rta:"\n"+rta;
			if(primero)primero=false;
			System.out.print(rta);
			linea=br.readLine();
		}
		
	}

	private static int solucionarCaso(HashMap<Character, Integer> teclado, char[] palabra) 
	{
		int suma=0;
		for (int i = 0; i < palabra.length-1; i++)
		{
			int indiceActual = teclado.get(palabra[i]);
			int indiceOtro = teclado.get(palabra[i+1]);
			suma+=Math.abs(indiceActual-indiceOtro);
		}
		return suma;
	}
}
