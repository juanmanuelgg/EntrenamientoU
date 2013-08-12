import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class offside
{
	private static boolean test=true;
	
	private static BufferedReader br;
	private static PrintWriter pw;

	public static void main(String[] args) throws IOException 
	{
		String pathname="./data/offside/offside";

		if(test)
		{
			br = new BufferedReader(new FileReader(new File(pathname+".in")));
			pw = new PrintWriter(new File(pathname+".out"));
		}
		else br = new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		if(test)
		{
			pw.close();
			Desktop.getDesktop().open(new File(pathname+".out"));
		}
	}

	private static void solucionarProblema() throws IOException 
	{
		String line=br.readLine();
		while(!"0 0".endsWith(line))
		{
			//Separar informacion & Procesar caso

			String[] jugadoresEq1=br.readLine().split(" ");
			String[] jugadoresEq2=br.readLine().split(" ");
			
			int masAdelantadoEq1=0;
			for (String jugador : jugadoresEq1)
			{
				int pos=Integer.parseInt(jugador);
				if(pos>masAdelantadoEq1)masAdelantadoEq1=pos;
			}
			
			int masAdelantadoEq2=0;
			for (String jugador : jugadoresEq2)
			{
				int pos=Integer.parseInt(jugador);
				if(pos>masAdelantadoEq2)masAdelantadoEq2=pos;
			}
			
			String rta=(masAdelantadoEq1<masAdelantadoEq2)?"Y":"N";
			
			//---------------------------------------------
			
			line=br.readLine();
			rta=("0 0".equals(line))?rta:rta+"\n";
			imprimirSolucion(rta);
		}
	}
	
	private static void imprimirSolucion(String solucion)
	{
		if(!test)System.out.print(solucion);
		else pw.print(solucion);
	}
}