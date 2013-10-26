package auxiliar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ancheta
{
	//---------------------------------------------
	//	NUMEROS PRIMOS
	//---------------------------------------------

	/** Checkeo sencillo.*/
	public static boolean esPrimo(long n)
	{
		if(n<=1) return false;
		if(n==2) return true;
		if(n%2==0) return false;

		for (long i = 3; i*i <= n; i+=2) if(n%i==0)return false;
		return true;
	}

	/** Criba de Eratóstenes.
	 * @return */
	public static ArrayList<Integer> darPrimos(int	inicio, int fin)
	{
		boolean[] isPrime = new boolean[fin+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;

		for (int i = 2; i*i <= fin; i++) 
			if (isPrime[i]) for (int j = i; i*j <= fin; j++) isPrime[i*j]=false;

		ArrayList<Integer> primos=new ArrayList<Integer>();
		for (int i = inicio; i <= fin; i++) if(isPrime[i])primos.add(i);	

		return primos;
	}

	public static ArrayList<Integer> factoresPrimos(int n)
	{
		ArrayList<Integer> rta=new ArrayList<Integer>();

		int m = (int) Math.sqrt(n);
		ArrayList<Integer> primos = darPrimos(0, m);
		for (Integer primo : primos) 
		{
			while (n%primo==0)
			{
				rta.add(primo);
				n=(n/primo);
			}
		}

		if (n > 1) rta.add(n);
		return rta;
	}

	//---------------------------------------------
	//	Teoria de Enteros
	//---------------------------------------------

	/** Algoritmo de Euclides.*/
	public static int gcd(int a, int b)
	{
		while(b!=0)
		{
			int temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}

	public static int lcm(int a, int b)
	{
		return Math.abs(a*b)/gcd(a,b);
	}

	//---------------------------------------------
	//	SISTEMAS NUMERICOS
	//---------------------------------------------

	// Integer.parseInt("31",8) == 25
	public static long baseN_a_Base10(char[] numero, int base)
	{
		long rta=0;
		for (int i = 0; i <numero.length; i++) rta+=(numero[i]-'0')*Math.pow(base,numero.length-i-1);
		return rta;
	}

	// Integer.toString(10, 2) == "1010";
	public static String base10_a_BaseN(long numero, int base)
	{
		ArrayList<Long> aux = new ArrayList<Long>();
		if(numero==0)aux.add((long) 0);
		while (numero > 0) 
		{
			long residuo = numero % base;
			aux.add(residuo);
			numero /= base;
		}

		String rta="";
		for (int i = aux.size()-1; i >= 0; i--) rta+=aux.get(i);
		return rta;
	}

	public static String transformacion_General(char[] numero, char[] lOrigen, char[] lDestino)
	{
		Map<Character, Integer>mOrigen=new HashMap<Character, Integer>();
		int baseOrigen=lOrigen.length;
		for (int i = 0; i < baseOrigen; i++) mOrigen.put(lOrigen[i],i);

		long numBase10=0;
		for (int i = 0; i <numero.length; i++) numBase10+=mOrigen.get(numero[i])*Math.pow(baseOrigen,numero.length-i-1);

		Map<Long, Character>mDestino=new HashMap<Long, Character>();
		int baseDestino=lDestino.length;
		for (long i = 0; i < baseDestino; i++) mDestino.put(i,lDestino[(int) i]);

		ArrayList<Long> aux = new ArrayList<Long>();
		if(numBase10==0)aux.add((long) 0);
		while (numBase10 > 0) 
		{
			long residuo = numBase10 % baseDestino;
			aux.add(residuo);
			numBase10 /= baseDestino;
		}

		String rta="";
		for (int i = aux.size()-1; i >= 0; i--) rta+=mDestino.get(aux.get(i));
		return rta;
	}

	public static String binario_a_Gray(char[] binario)
	{
		String gray="";
		for (int i = 0; i < binario.length; i++)
		{
			if(i==0)gray+=binario[i];
			else
			{
				if(binario[i-1]!=binario[i]) gray+='1';
				else gray+='0';
			}
		}
		return gray;
	}

	public static String gray_a_Bianrio(char[] gray)
	{
		String binario="";
		for (int i = 0; i < gray.length; i++)
		{
			if(i==0)binario+=gray[i];
			else
			{
				if(gray[i]=='0')binario+=binario.charAt(i-1);
				else binario+=(binario.charAt(i-1)=='0')?'1':'0';
			}
		}
		return binario;
	}

	//---------------------------------------------
	//	VECTORES
	//---------------------------------------------

	//---------------------------------------------
	//	MATRICES
	//---------------------------------------------

	//---------------------------------------------
	//	BASICOS
	//---------------------------------------------
	
	public static int busquedaBinaria(int[] arreglo, int valor)
	{
		int index=-1;
		int inicio=0;
		int fin=arreglo.length-1;
		
		busqueda: while (inicio<=fin)
		{
			int medio=(inicio+fin)/2;
			
			if(arreglo[medio]==valor)
			{
				index=medio;
				break busqueda;
			}
			else if(arreglo[medio]>valor) fin=medio-1;
			else inicio=medio+1;
		}
		
		return index;
	}

	//---------------------------------------------
	//	USANDO LAS IMPLEMENTACIONES JAVA
	//---------------------------------------------
	
	// ORDENAR
	/*
	 * Opcion 1: Collections.sort(list);
	 * Opcion 2: Arrays.Sort(array);
	 */
	
	// BUSQUEDA
	
	/*
	 * int pos = Collections.binarySearch(list, key);
	 * if (pos < 0) list.add(-pos-1, key);
	 */
	
	// USO COTIDIANO
	
	/*
	 * reverse — reverses the order of the elements in a List.
	 * fill — overwrites every element in a List with the specified value. This operation is useful for reinitializing a List.
	 * copy — takes two arguments, a destination List and a source List, and copies the elements of the source into the destination, overwriting its contents. The destination List must be at least as long as the source. If it is longer, the remaining elements in the destination List are unaffected.
	 * swap — swaps the elements at the specified positions in a List.
	 * addAll — adds all the specified elements to a Collection. The elements to be added may be specified individually or as an array.
	 */
	
	//COMPOSICION
	
	/*
	 * frequency — counts the number of times the specified element occurs in the specified collection
	 * disjoint — determines whether two Collections are disjoint; that is, whether they contain no elements in common
	 */
	
	/*
	 * Contar repeticiones de un elemento:
	 * 
	 *Map<String, Integer> m = new HashMap<String, Integer>();
	 *for (String a : args)
	 *{
	 *	Integer freq = m.get(a);
	 *	m.put(a, (freq == null) ? 1 : freq + 1);
	 *}
	 */
}