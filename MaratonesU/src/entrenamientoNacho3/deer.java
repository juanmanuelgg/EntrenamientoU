package entrenamientoNacho3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class deer
{
	private static BufferedReader br;
    private static boolean test = true;
    
    public static void main(String[] args) throws Exception 
    {
            if(test)br=new BufferedReader(new FileReader(new File("./data/entrenamientoNacho3/deerTest.in")));
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
			int vTipo=Integer.parseInt(paramProb[0]);
			int vVenado=Integer.parseInt(paramProb[1]);
			int distanciaSep=Integer.parseInt(paramProb[2]);
			
			int rta= (int)solucionarCaso(vTipo,vVenado,distanciaSep);
			
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static double solucionarCaso(double A, double B, double C)
	{
		if(A*45 < (B*30) || A*45 == (B*30) && C > 0) return -1;
		
		int cont = 0;
		double dist = C;
		for(int i=1;dist>0;i++)
		{
			double tiempo = dist/(A-B);
			if(tiempo > 30 || tiempo<0)
			{
				cont += 30;
				dist = B*(30*i) + C - A*cont;
				double tAux = dist/A;
				if(tAux > 15)
				{
					cont += 15;
					dist = B*(30*i) + C - A*cont;
				}
				else
				{
					cont += Math.ceil(tAux);
					dist = 0;
				}
			}
			else
			{
				cont += Math.ceil(tiempo);
				dist = 0;
			}
		}
		return cont;
	}
}