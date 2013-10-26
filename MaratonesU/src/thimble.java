import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thimble 
{
	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(!test) br=new BufferedReader(new FileReader(new File("./data/thimbleTest.in")));
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

			String[] swaps=line.split(" ");
			String rta=solucionarCaso(swaps);

			//--------------------------------
			rta=(primero)?rta:"\n"+rta;
			if(primero)primero=false;
			System.out.print(rta);

			line=br.readLine();
		}
	}
	private static String solucionarCaso(String[] swaps)
	{
		boolean[] thimbles={true,false,false};
		for (String swap : swaps)
		{
			String[] aux=swap.split("-");
			int x=Integer.parseInt(aux[0])-1;
			int y=Integer.parseInt(aux[1])-1;

			boolean temp=thimbles[x];
			thimbles[x]=thimbles[y];
			thimbles[y]=temp;
		}
		for (int i = 0; i < thimbles.length; i++) if(thimbles[i])return (i+1)+"";
		return "Nunca llega a este punto.";
	}

}