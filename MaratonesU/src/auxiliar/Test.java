package auxiliar;

public class Test
{
	public static void main(String[] args) 
	{
		double lat1=Math.toRadians(0);
		double lat2=Math.toRadians(70);
		double lon1=Math.toRadians(90);
		double lon2=Math.toRadians(45);
		
		double aux1=Math.sin(lat1);
		double aux2=Math.sin(lat2);
		double aux3=Math.cos(lat1);
		double aux4=Math.cos(lat2);
		double aux5=Math.cos((lon1-lon2));
		double peso=4000*Math.acos((aux1*aux2)+(aux3*aux4*aux5));
		System.out.println(peso);
	}
}