import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Test 
{
	private static char[] noSon0={'1','2'};
	//	private static char[] noSon0={'S','M'};

	public static void main(String[] args)
	{
		long t=System.currentTimeMillis();
		System.out.println(evaluarLinea("SENDMORY**","SEND + MORE = MONEY"));//OMY**ENDRS
		long t2=System.currentTimeMillis();
		double tiempo=(t2-t)/1000.0;
		System.out.println(tiempo +" Segundos");

		t=System.currentTimeMillis();
		permutation("SENDMORY**");
		t2=System.currentTimeMillis();
		tiempo=(t2-t)/1000.0;
		System.out.println(tiempo +" Segundos");
	}
	
	private static boolean evaluarLinea(String prefix, String linea)
	{
		Map<Character, Integer> map=new HashMap<Character, Integer>(10);
		for (int i = 0; i < prefix.length(); i++)map.put(prefix.charAt(i), i);

		String[] ladosEquacion=linea.split("=");
		
		String[] primerLado=ladosEquacion[0].trim().split(" ");
		int numLado1=0;
		boolean ultimaFueSuma=true;
		for (int i = 0; i < primerLado.length; i++) 
		{
			if(i%2==0)
			{
				String ultimaTransformacion="";
				String pal=primerLado[i];
				for (int j = 0; j < pal.length(); j++)
					ultimaTransformacion+=map.get(pal.charAt(j));
				
				int num=Integer.parseInt(ultimaTransformacion);
				if(ultimaFueSuma)numLado1+=num;
				else numLado1-=num;
			}
			else
			{
				if(primerLado[i].equals("+"))ultimaFueSuma=true;
				else ultimaFueSuma=false;
			}
		}

		String[] segundoLado=ladosEquacion[1].trim().split(" ");
		int numLado2=0;
		for (int i = 0; i < segundoLado.length; i++) 
		{
			if(i%2==0)
			{
				String ultimaTransformacion="";
				String pal=segundoLado[i];
				for (int j = 0; j < pal.length(); j++)
					ultimaTransformacion+=map.get(pal.charAt(j));
				
				int num=Integer.parseInt(ultimaTransformacion);
				if(ultimaFueSuma)numLado2+=num;
				else numLado2-=num;
			}
			else
			{
				if(segundoLado[i].equals("+"))ultimaFueSuma=true;
				else ultimaFueSuma=false;
			}
		}
		return numLado1==numLado2;
	}
	
	public static void permutation(String str) { 
		ArrayList<String> rtas=new ArrayList<String>();
		permutation("", str, rtas);
		System.out.println("---------------------------");
		for (String string : rtas) {
			System.out.println(string);
		}
	}

	private static void permutation(String prefix, String str, ArrayList<String> rtas)
	{
		int n = str.length();
		if (n == 0 && evaluarLinea(prefix,str))rtas.add(prefix);
		else if(n != 0)
		{
			boolean avanzar=true;
			for (char este : noSon0)if(prefix.startsWith(este+""))avanzar=false;

			if(avanzar)
			{
				for (int i = 0; i < n; i++)
					permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), rtas);
			}
		}
	}

}