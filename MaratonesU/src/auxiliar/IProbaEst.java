package auxiliar;

public interface IProbaEst 
{

	//--------------------------------------------
	// ESTADISTICA
	//--------------------------------------------

	double media(double[] datos);

	double mediana(double[] datos);

	double moda(double[] datos);

	double varianza(double[] datos);

	double desvEstandar(double[] datos);

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

	double probUnifDiscreta(double[] datos);

	double esperadoUnifeDiscreta(double[] datos);

	double varianzaUnifDiscreta(double[] datos);

	//2. Hipergeometrica.
	
	double probHiperGeom(double[] datos);

	double esperadoHiperGeom(double[] datos);

	double varianzaHiperGeom(double[] datos);
	
	//3. Bernoulli.
	//4. Binomial.
	
	double probBinomial(double[] datos);

	double esperadoBinomial(double p);

	double varianzaBinomial(double p);
	
	//5. Geometrica.
	//6. Binomial Negativa.
	//7. POISSON.
}
