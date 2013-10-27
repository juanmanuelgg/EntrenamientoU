package entrenamientoNacho3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class transport
{
	private static BufferedReader br;
	private static boolean test = true;

	public static void main(String[] args) throws Exception 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/entrenamientoNacho3/transportTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while(linea!=null)
		{
			String[] paramYo=linea.split(" ");
			int Vyo=Integer.parseInt(paramYo[0]);
			int t=Integer.parseInt(paramYo[1]);

			String lineaPos=br.readLine();
			String lineaVel=br.readLine();
			int rta=0;
			if((lineaPos!=null && !lineaPos.equals(""))&&(lineaVel!=null&&!lineaVel.equals("")))
			{
				String[] pos=lineaPos.split(" ");
				String[] Vel=lineaVel.split(" ");
				rta= (int)solucionarCaso(Vyo,t,pos,Vel);
			}

			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(double Vyo, int t, String[] pos, String[] vel)
	{
		double Xfinal=Vyo*t;
		int cont=0;
		for (int i = 0; i < pos.length; i++)
		{			
			int xFinalBus=Integer.parseInt(pos[i])+(Integer.parseInt(vel[i])*t);
			if(Xfinal >= xFinalBus || Integer.parseInt(pos[i]) == 0)cont++;
		}
		return cont;
	}
}