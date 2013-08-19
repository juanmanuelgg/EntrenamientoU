package auxiliar;
public class Test
{
	public static void main(String[] args) 
	{
		int a=1,b=2,c=6,d=1,e=-4,f=-3;
		int deltr = (a*e)-(d*b);
		int deltx = (e*c)-(f*b);
		int delty = (a*f)-(c*d);
		System.out.println("dr: "+deltr);
		System.out.println("dx: "+deltx);
		System.out.println("dy: "+delty);
	}
}