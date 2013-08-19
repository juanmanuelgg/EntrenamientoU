import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
	private static BufferedReader br;

	private static boolean primero = true;
	private static boolean test = true;//TODO Cambiar

	public static void main(String[] args) throws Exception 
	{
		String pathname="./data/Solution/Test.in";
		if(test) br = new BufferedReader(new FileReader(new File(pathname)));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema3();
	}

	private static void solucionarProblema3() throws IOException 
	{
		String line=br.readLine();
		while(line!=null)
		{
			//Separar informacion pertinente(Usando line)

			String[] eq=line.split(" ");
			int a = Integer.parseInt(eq[0].split("\\*")[0].replace("(","").replace(")",""));
			int b = Integer.parseInt(eq[2].split("\\*")[0].replace("(","").replace(")",""));
			int c = Integer.parseInt(eq[4].replace("(","").replace(")",""));

			eq=br.readLine().split(" ");
			int d = Integer.parseInt(eq[0].split("\\*")[0].replace("(","").replace(")",""));
			int e = Integer.parseInt(eq[2].split("\\*")[0].replace("(","").replace(")",""));
			int f = Integer.parseInt(eq[4].replace("(","").replace(")",""));

			String rta = solucionarCaso(a,b,c,d,e,f);

			//---------------------------------------------

			rta=(primero)?rta:"\n"+rta;
			if(primero) primero=false;
			System.out.print(rta);
			line=br.readLine();
		}
	}

	private static String solucionarCaso(int a, int b, int c, int d, int e, int f) 
	{
		int deltr = (a*e)-(d*b);
		if (deltr==0) 
		{
			return "XX";
		}
		else 
		{
			int deltx = (e*c)-(f*b);
			int delty = (a*f)-(c*d);
			
			int nx = deltx;
			int dx = deltr;
			if (deltx != 0)
			{
				int gcd = gcd(Math.abs(nx),Math.abs(deltr));
				nx = nx/gcd;
				dx = dx/gcd;
			}

			int ny = delty;
			int dy = deltr;
			if (delty != 0) 
			{
				int gcd = gcd(Math.abs(ny),Math.abs(deltr));
				ny = ny/gcd;
				dy = dy/gcd;
			}

			String X = "";
			if (((double)nx)/((double)dx) > 0) 	X = Math.abs(nx)+"/"+Math.abs(dx);
			else X = "(-"+Math.abs(nx)+")/"+Math.abs(dx);

			String Y = "";
			if (((double)ny)/((double)dy) > 0) Y = Math.abs(ny)+"/"+Math.abs(dy);
			else Y = "(-"+Math.abs(ny)+")/"+Math.abs(dy);

			return ("X="+X+" Y="+Y);
		}
	}

	private static int gcd(int x, int y)
	{
		while(y!=0)
		{
			int temp=y;
			y=x%y;
			x=temp;
		}
		return x;
	}
}