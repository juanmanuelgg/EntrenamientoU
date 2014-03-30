import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class C_0 
{

	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/testC.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solve();
		br.close();
	}

	private static void solve() throws IOException 
	{
		String linea=br.readLine();
		while(linea!=null)
		{
			String rta=solucionarCaso(linea);
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static String solucionarCaso(String linea)
	{
		//
		String alfabeto="";
		for (char letra : linea.toCharArray()) if(letra>='A' && letra <='Z') alfabeto+=letra;

		// Quitar de la matriz las que no pueden corresponder al numero 0
		Set<Character> lasQNoSon0=new LinkedHashSet<Character>();

		String[] ladosEquacion=linea.split("=");
		String[] palLado1=ladosEquacion[0].split("\\+|-");
		for (String pal : palLado1)lasQNoSon0.add(pal.trim().charAt(0));

		String[] palLado2=ladosEquacion[1].split("\\+|-");
		for (String pal : palLado2)lasQNoSon0.add(pal.trim().charAt(0));

		//
		ArrayList<String>soluciones=crearYProbarPermutaciones(linea,lasQNoSon0,alfabeto);

		return (soluciones.size()==1)?soluciones.get(0):"**********";
	}

	private static ArrayList<String> crearYProbarPermutaciones(String linea,Set<Character> noSon0, String alfabeto)
	{
		ArrayList<String> rtas=new ArrayList<>();
		permutation("", alfabeto,rtas,linea,noSon0); 
		return rtas;
	}

	private static void permutation(String prefix, String alfabeto, ArrayList<String> rtas, String linea, Set<Character> noSon0)
	{
		int n = alfabeto.length();
		if (n==0 || n == 0 && evaluarLinea(prefix,linea))rtas.add(prefix);
		else 
		{
			boolean avanzar=true;
			for (char este : noSon0)if(prefix.startsWith(este+""))avanzar=false;

			if(avanzar)
			{
				for (int i = 0; i < n; i++)
					permutation(prefix + alfabeto.charAt(i), alfabeto.substring(0, i) + alfabeto.substring(i+1, n), rtas, linea, noSon0);
			}
		}
	}

	private static boolean evaluarLinea(String prefix, String linea)
	{
		Map<Character, Integer> map=new HashMap<Character, Integer>(10);
		for (int i = 0; i < prefix.length(); i++)map.put(prefix.charAt(i), i);

		String[] ladosEquacion=linea.split("=");
		
		String[] primerLado=ladosEquacion[0].trim().split(" ");
		int numLado1=0;
		boolean ultimaFueSuma=true;
		for (int i = 0; i < primerLado.length; i++) 
		{
			if(i%2==0)
			{
				String ultimaTransformacion="";
				String pal=primerLado[i];
				for (int j = 0; j < pal.length(); j++)
					ultimaTransformacion+=map.get(pal.charAt(j));
				
				int num=Integer.parseInt(ultimaTransformacion);
				if(ultimaFueSuma)numLado1+=num;
				else numLado1-=num;
			}
			else
			{
				if(primerLado[i].equals("+"))ultimaFueSuma=true;
				else ultimaFueSuma=false;
			}
		}

		String[] segundoLado=ladosEquacion[1].trim().split(" ");
		int numLado2=0;
		ultimaFueSuma=true;
		for (int i = 0; i < segundoLado.length; i++) 
		{
			if(i%2==0)
			{
				String ultimaTransformacion="";
				String pal=segundoLado[i];
				for (int j = 0; j < pal.length(); j++)
					ultimaTransformacion+=map.get(pal.charAt(j));
				
				int num=Integer.parseInt(ultimaTransformacion);
				if(ultimaFueSuma)numLado2+=num;
				else numLado2-=num;
			}
			else
			{
				if(primerLado[i].equals("+"))ultimaFueSuma=true;
				else ultimaFueSuma=false;
			}
		}
		return numLado1==numLado2;
	}
}