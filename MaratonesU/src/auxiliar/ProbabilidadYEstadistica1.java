package auxiliar;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProbabilidadYEstadistica1 implements IProbaEst 
{
	public static String[] factoriales={"1","1","2","6","24","120","720","5040","40320","362880","3628800","39916800","479001600","6227020800","87178291200","1307674368000","20922789888000","355687428096000","6402373705728000","121645100408832000","2432902008176640000"};

	//--------------------------------------------
	// ESTADISTICA
	//--------------------------------------------

	@Override
	public double media(double[] datos)
	{
		double suma=0;
		for (double dato : datos)suma+=dato;
		return suma/datos.length;
	}
	
	@Override
	public double mediana(double[] datos)
	{
		Arrays.sort(datos);
		int n=datos.length;
		if(n%2==1)return datos[n/2];
		else 
		{
			double v1=datos[(n/2)-1];
			double v2=datos[n/2];
			return (v1+v2)/2;
		}
	}

	@Override
	public double moda(double[] datos)
	{
		Map<Double, Integer> m = new LinkedHashMap<Double, Integer>();
		for (Double a : datos) 
		{
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}

		int masRepite=0;
		double rta=Double.POSITIVE_INFINITY;
		for (Map.Entry<Double, Integer> e : m.entrySet())
		{
			int reps=e.getValue();
			double dato=e.getKey();
			if(reps>masRepite)
			{
				masRepite=reps;
				rta=dato;
			}
		}
		return rta;
	}

	@Override
	public double varianza(double[] datos)
	{
		double xBarra = media(datos);
		double rta=0;
		for (double dato : datos)
		{
			double aux = dato-xBarra;
			rta+=(aux*aux);
		}
		return rta/(datos.length-1);
	}

	@Override
	public double desvEstandar(double[] datos)
	{
		return Math.sqrt(varianza(datos));
	}

	//--------------------------------------------
	// METODOS DE CONTEO
	//--------------------------------------------
	
	// Regla de multiplicacion.
	// Arreglo ordinario.
	// Permutaciones Ordinarias.
	// Permutaciones Ordinarios.
	// Permutaciones.
	// Combinaciones.
	// Particiones ordenadas.

	//--------------------------------------------
	// DISTRIBUCIONES TIPICAS VARIABLES DISCRETAS
	//--------------------------------------------

	//1. Uniforme Discreta.
	@Override
	public double probUnifDiscreta(double[] X)
	{
		return 1/X.length;
	}
	
	@Override
	public double esperadoUnifeDiscreta(double[] X)
	{
		// 
		double k=X.length;
		
		double suma=0;
		for (double dato : X) suma+=dato;
		return suma/k;
	}
	
	@Override
	public double varianzaUnifDiscreta(double[] X)
	{
		double xBarra = media(X);
		// 
		double k=X.length;

		double rta=0;
		for (double dato : X)
		{
			double aux = dato*xBarra;
			rta+=(aux*aux);
		}
		return rta/k;
	}

	//2. Hipergeometrica.
	@Override
	public double probHiperGeom(double[] datos)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double esperadoHiperGeom(double[] datos)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double varianzaHiperGeom(double[] datos)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	//3. Bernoulli.
	public double probBernoulli(double p, int x)
	{
		return Math.pow(p, x)*Math.pow((1-p),(1-x));
	}
	
	public double varianzaBernoulli(double p)
	{
		return p*(1-p);
	}
	
	public double esperadoBernoulli(double p)
	{
		return p;
	}
	//4. Binomial.
	@Override
	public double probBinomial(int x, int n, double p)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double esperadoBinomial(double p, int n) 
	{
		return n*p;
	}

	@Override
	public double varianzaBinomial(double p, int n)
	{
		return (n*p)*(1-p);
	}

	@Override
	public double varianzaBinomial(double p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//5. Geometrica.
	//6. Binomial Negativa.
	//7. POISSON.
}