
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class kripton
{
	private static BufferedReader br;
	
	private static final String LINEAFINAL = "0 0";
	private static final char[] aux = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static boolean test = true;//TODO Cambiar
	
	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/kripton/Test.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema();
	}

	private static void solucionarProblema() throws IOException 
	{
		String line=br.readLine();
		while(!LINEAFINAL.equals(line))
		{
			//Separar informacion pertinente(Usando line)
			String[]paramKripton=line.split(" ");
			int n=Integer.parseInt(paramKripton[0]);
			int l=Integer.parseInt(paramKripton[1]);

			String rta=solucionarCaso(n,l);
			
			//---------------------------------------------

			line=br.readLine();
			rta=(LINEAFINAL.equals(line))?rta:rta+"\n";
			System.out.print(rta);
		}
	}
		
	private static String solucionarCaso(int n, int l) 
	{
		Map<Integer, Character>mDestino=new HashMap<Integer, Character>();
		for (int i = 0; i < l; i++) mDestino.put(i,aux[i]);
		
		String rta="";
		for (int i=0, j=0; i <n; j++)
		{
			String secuencia=unaSecuencia(j, mDestino, l)+"";
			if(esDificil(secuencia))
			{
				i++;
				rta+=(i<n)?secuencia+" ":secuencia;
			}
		}
		return rta;
	}
	
	private static boolean esDificil(String lol)
	{
		return true;
	}
	
	private static String unaSecuencia(int numBase10,Map<Integer, Character> mDestino, int baseDestino)
	{
		ArrayList<Integer> aux = new ArrayList<Integer>();
		if(numBase10==0)aux.add(0);
		while (numBase10 > 0) 
		{
			int residuo = numBase10 % baseDestino;
			aux.add(residuo);
			numBase10 /= baseDestino;
		}

		String rta="";
		for (int i = aux.size()-1; i >= 0; i--) rta+=mDestino.get(aux.get(i));
		return rta;
	}
}