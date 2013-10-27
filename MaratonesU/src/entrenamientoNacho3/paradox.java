package entrenamientoNacho3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class paradox
{
	private static BufferedReader br;
	private static boolean test = true;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/entrenamientoNacho3/paradoxTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while(linea!=null)
		{
			String[] paramSet1=linea.split(" ");
			String[] paramSet2=br.readLine().split(" ");
			
			int[] set1=new int[paramSet1.length];
			double promSet1 = 0;
			for (int i = 0; i < paramSet1.length; i++)
			{
				set1[i]=Integer.parseInt(paramSet1[i]);
				promSet1+=set1[i];
			}
			promSet1/=set1.length;
			
			int[] set2=new int[paramSet2.length];
			double promSet2 = 0;
			for (int i = 0; i < paramSet2.length; i++)
			{
				set2[i]=Integer.parseInt(paramSet2[i]);
				promSet2+=set2[i];
			}
			promSet2/=set2.length;

			int rta= (int)solucionarCaso(set1,set2, promSet1,promSet2);

			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(int[] set1, int[] set2, double promSet1, double promSet2)
	{
		if(set1.length < 2 && set2.length < 2) return 0;
		int cont = 0;
		for (int i = 0; i < set1.length; i++)
		{
			double nuevoPromSet2=(promSet2*set2.length + set1[i])/(set2.length + 1);
			double nuevoPromSet1=(promSet1*set1.length - set1[i])/(set1.length - 1);
			if( nuevoPromSet2 > promSet2 && nuevoPromSet1 > promSet1) cont++;
		}
		for (int i = 0; i < set2.length; i++)
		{
			double nuevoPromSet1=((promSet1*set1.length) + set2[i])/(set1.length + 1);
			double nuevoPromSet2=((promSet2*set2.length) - set2[i])/(set2.length - 1);
			if(nuevoPromSet1 > promSet1 && nuevoPromSet2 > promSet2) cont++;
		}
		return cont;
	}

}