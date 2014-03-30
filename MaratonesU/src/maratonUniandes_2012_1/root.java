package maratonUniandes_2012_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class root 
{

	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/maratonUniandes_2012_1/root/root.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema();
		br.close();
	}

	private static void solucionarProblema() throws IOException 
	{
		String linea=br.readLine();
		while(!linea.equals("0 0"))
		{
			String[] param=linea.split(" ");
			int b=Integer.parseInt(param[0]);
			int n=Integer.parseInt(param[1]);
			
			int rta=soucionarCaso(b,n);
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int soucionarCaso(int b, double n)
	{
		double auxA = Math.pow(b,1.0/n);
		double aMenor=Math.floor(auxA);
		double aMayor=Math.ceil(auxA);
		return (int) ((Math.abs((Math.pow(aMenor, n)-b))<=Math.abs((Math.pow(aMayor, n)-b)))?aMenor:aMayor);
	}

}