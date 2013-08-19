package auxiliar;

import java.util.ArrayList;
import java.util.Arrays;

public class Teoria_De_Numeros
{
	//---------------------------------------------
	//	NUMEROS PRIMOS
	//---------------------------------------------

	/** Checkeo sencillo.*/
	public static boolean esPrimo(int n)
	{
		if(n<=1) return false;
		if(n==2) return true;
		if(n%2==0) return false;

		int m=(int)Math.sqrt(n);
		for (int i = 3; i <= m; i+=2) if(n%i==0)return false;
		return true;
	}

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
	public static ArrayList<Integer> darPrimos(int inicio, int fin)
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
	
	//---------------------------------------------
	//	XXXXXXXXXXXXXX
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

	public static ArrayList<Long> factoresPrimos(long n)
	{
		ArrayList<Long> rta=new ArrayList<Long>();
		
		for (long i = 2; i*i <= n;)
		{
            while (n%i==0) 
            {
                rta.add(i); 
                n = n/i;
            }
            i+=(i==2)?1:2;
        }

        if (n > 1) rta.add(n);
		return rta;
	}

	//---------------------------------------------
	//	VECTORES
	//---------------------------------------------


	//---------------------------------------------
	//	MATRICES
	//---------------------------------------------


	public static void main(String[] args) 
	{
		System.out.println(factoresPrimos(Long.MAX_VALUE));
	}
}