import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//------------------------------------------------------------
//            NO SIRVE POR COMPLEJIDAD TEMPORAL
//------------------------------------------------------------

public class soldiers 
{
	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(test) br=new BufferedReader(new FileReader(new File("./data/soildersTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		boolean primero=true;
		String line=br.readLine();

		while (line!=null)
		{
			//Partir info usando line

			String[] soldados=line.split(" ");
			String rta=solucionarCaso(soldados);

			//--------------------------------
			rta=(primero)?rta:"\n"+rta;
			if(primero)primero=false;
			System.out.print(rta);

			line=br.readLine();
		}
	}

	@SuppressWarnings("unchecked")
	private static String solucionarCaso(String[] soldados) 
	{
		String formacion="";
		Set<String> configs=new HashSet<String>();
		for (int i = 0; i < soldados.length; i++)
		{
			int reps=Integer.parseInt(soldados[i]);
			for (int j = 0; j < reps; j++)formacion+=i;
		}
		ArrayList<Character> lol=new ArrayList<Character>();
		for (int i = 0; i < formacion.length(); i++)lol.add(formacion.charAt(i));

		for (int j = 0; j < lol.size(); j++)
		{
			char x=lol.get(j);
			ArrayList<Character> lol2 = (ArrayList<Character>) lol.clone();
			lol2.remove(j);
			resolver(configs, lol2,""+x,lol.size());
		}

		return configs.size()+"";

	}

	@SuppressWarnings("unchecked")
	private static void resolver(Set<String> configs, ArrayList<Character> lol, String cadena, int length)
	{
		if(cadena.length()==length)
		{
			String inversa="";
			for (int i =cadena.length()-1; i >=0; i--) inversa+=cadena.charAt(i);	
			if(!configs.contains(inversa)) 
				configs.add(cadena);
		}
		else
		{
			for (int j = 0; j < lol.size(); j++)
			{
				char x=lol.get(j);
				ArrayList<Character> lol2 = (ArrayList<Character>) lol.clone();
				lol2.remove(j);
				String cad2=(cadena+x);
				resolver(configs, lol2, cad2, length);				
			}
		}
	}
}