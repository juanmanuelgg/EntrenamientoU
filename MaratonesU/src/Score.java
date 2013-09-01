import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Score
{
	private static boolean test = false;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/scoreTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		
		solucionarProblem();
	
		br.close();
	}

	private static void solucionarProblem() throws IOException 
	{
		boolean primero = true;
		String line=br.readLine();
		while(line!=null)
		{
			//Separar informacion pertinente(Usando line)

			String[] paramScore=line.split(" ");
			int newScore=Integer.parseInt(paramScore[0]);
			int places=Integer.parseInt(paramScore[1]);

			int[] scores = new int[places];
			String aux=br.readLine();
			if(aux.equals("")) scores=new int[]{};
			else
			{
				String[] scoresAux=aux.split(" ");
				for (int i = 0; i < scoresAux.length; i++) 
					scores[i]=Integer.parseInt(scoresAux[i]);
			}

			String rta = solucionarCaso(newScore,places,scores);

			//---------------------------------------------

			rta=(primero)?rta:"\n"+rta;
			if(primero) primero=false;
			System.out.print(rta);
			line=br.readLine();
		}
	}

	private static String solucionarCaso(int newScore, int places, int[] scores) 
	{
		int lugar=1;
		for (int score : scores) if(newScore<score)lugar++;
		if(lugar>places || (scores.length==places && scores[places-1]==newScore))lugar=-1;
		return lugar+"";
	}
}