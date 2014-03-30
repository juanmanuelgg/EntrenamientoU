package maratonUniandes_2012_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quicksum 
{

	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/maratonUniandes_2012_1/quicksum.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema();
		br.close();
	}

	private static void solucionarProblema() throws IOException 
	{
		String linea=br.readLine();
		while(!linea.equals("#"))
		{
			int rta=soucionarCaso(linea.toCharArray());
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int soucionarCaso(char[] word)
	{
		int quicksum=0;
		for (int i = 0; i < word.length; i++) if(word[i]!=' ') quicksum+=(i+1)*((word[i]-'A')+1);
		return quicksum;
	}

}