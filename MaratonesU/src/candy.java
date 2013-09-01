import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class candy 
{
	private static boolean test=true;
	private static BufferedReader br;

	private static candy yo;

	public static void main(String[] args) throws Exception
	{
		yo=new candy();

		if(test)br=new BufferedReader(new FileReader(new File("./data/candyTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		
		solucionarProblema();
		
		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		boolean primero=true;
		String linea=br.readLine();
		while(linea!=null)
		{
			//Separar informacion pertinente(Usando line)
			
			String[] paramLol=linea.split(" ");
			int sx=Integer.parseInt(paramLol[0]);
			int sy=Integer.parseInt(paramLol[1]); 
			int tx=Integer.parseInt(paramLol[2]);
			int ty=Integer.parseInt(paramLol[3]);
			
			String[] posxs=br.readLine().split(" ");
			String[] posys=br.readLine().split(" ");
			String[] radios=br.readLine().split(" ");
			
			String rta=solucionarCaso(sx,sy,tx,ty,posxs,posys,radios);
			
			//---------------------------------------------
			
			rta=(primero)?rta:"\n"+rta;
			if(primero)primero=false;
			System.out.print(rta);
			linea=br.readLine();
		}
	}

	private static String solucionarCaso(int sx, int sy, int tx, int ty, String[] posxs, String[] posys, String[] radios)
	{
		// TODO Auto-generated method stub
		return null;
	}

}