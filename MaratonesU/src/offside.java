import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class offside
{
	private static BufferedReader br;

	private static final String LINEA_FINAL = "0 0";	
	private static boolean test=true;

	public static void main(String[] args) throws IOException 
	{
		String pathname="./data/offside/Test.in";
		if(test) br=new BufferedReader(new FileReader(new File(pathname)));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema();
	}

	private static void solucionarProblema() throws IOException 
	{
		String line=br.readLine();
		while(!LINEA_FINAL.endsWith(line))
		{
			//Separar informacion & Procesar caso

			String[] jugadoresEq1=br.readLine().split(" ");
			int[] posAtacantes=new int[jugadoresEq1.length];
			for (int i = 0; i < posAtacantes.length; i++)
				posAtacantes[i]=Integer.parseInt(jugadoresEq1[i]);
			Arrays.sort(posAtacantes);
			
			String[] jugadoresEq2=br.readLine().split(" ");
			int[] posDefensores=new int[jugadoresEq2.length];
			for (int i = 0; i < posDefensores.length; i++)
				posDefensores[i]=Integer.parseInt(jugadoresEq2[i]);
			Arrays.sort(posDefensores);
			
			String rta=(posAtacantes[0]<posDefensores[1])?"Y":"N";
			
			//---------------------------------------------
			
			line=br.readLine();
			rta=(LINEA_FINAL.equals(line))?rta:rta+"\n";
			System.out.print(rta);
		}
	}
}