package entrenamientoNacho3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class waiter
{
	private static BufferedReader br;
	private static boolean test = true;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/entrenamientoNacho3/waiterTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while(linea!=null)
		{
			String[] paramProb=linea.split(" ");
			double total=Integer.parseInt(paramProb[0]);
			double tax=Integer.parseInt(paramProb[1]);
			double money=Integer.parseInt(paramProb[2]);

			int rta= (int)solucionarCaso(total,tax,money);

			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static double solucionarCaso(double total, double tax, double money)
	{
		int tip = -1;

		int inicio=0;
		int fin=(int)money;
		while(inicio<=fin)
		{
			int medio=(inicio+fin)/2;
			
			if ((total + Math.floor(total*tax/100)+Math.floor(total*medio/100)) < money) inicio=medio+1;
			else if((total + Math.floor(total*tax/100)+Math.floor(total*medio/100)) > money) fin =medio-1;
			else
			{
				tip=medio;
				break;
			}
			tip=fin;
		}
		return tip;
	}
}