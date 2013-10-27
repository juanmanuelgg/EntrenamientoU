package entrenamientoNacho2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cards 
{
	private static boolean test = false;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/cardsTest.in")));
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

			String rta = solucionarCaso(linea) + "";
			
			//---------------------------------------------

			rta = (primero) ? rta : "\n" + rta;
			if(primero)primero = false;
			System.out.print(rta);
			linea=br.readLine();
		}

	}

	private static char solucionarCaso(String linea) 
	{
		int[] cartas = { 0, 1, 0 };
		char[] swaps = linea.toCharArray();
		for (char c : swaps) 
		{
			if(c == 'L') 
			{
				int temp = cartas[0];
				cartas[0] = cartas[1];
				cartas[1] = temp;
			}
			if(c == 'R')
			{
				int temp = cartas[2];
				cartas[2] = cartas[1];
				cartas[1] = temp;
			}
			if(c == 'E')
			{
				int temp = cartas[0];
				cartas[0] = cartas[2];
				cartas[2] = temp;
			}
		}
		if (cartas[0] == 1)return 'L';
		if (cartas[1] == 1)return 'M';
		return 'R';
	}
}