import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class C 
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
		// Preparar la Matriz de posibles
		Set<Character> aparecen=new LinkedHashSet<Character>();
		for (char letra : linea.toCharArray()) if(letra>='A' && letra <='Z') aparecen.add(letra);

		Object[] ap=aparecen.toArray();

		char[][] matriz=new char[10][ap.length];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < ap.length; j++) 
				matriz[i][j]=(char) ap[j];

		// Quitar de la matriz las que no pueden corresponder al numero 0
		Set<Character> lasQNoSon0=new LinkedHashSet<Character>();

		String[] ladosEquacion=linea.split("=");
		String[] palLado1=ladosEquacion[0].split("\\+|-");
		for (String pal : palLado1)lasQNoSon0.add(pal.trim().charAt(0));

		String[] palLado2=ladosEquacion[1].split("\\+|-");
		for (String pal : palLado2)lasQNoSon0.add(pal.trim().charAt(0));

		for (int i = 0; i < matriz[0].length; i++)
		{
			for (Character esta : lasQNoSon0) 
				if(esta==matriz[0][i]) matriz[0][i]+=('a'-'A');
		}

		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < ap.length; j++) 
				System.out.print(matriz[i][j]);
			System.out.println();
		}

		return null;
	}
}