//Bruno Flávio Ferreira 9791330
//Edson yudi Toma 9791305

import java.util.Calendar;

public class Random {
	
	//Parametros do rand
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	//Semente
	private long xi;
	
	//Construtor
	public Random(int semente){
		xi = semente;
	}
	
	public Random(){
		xi = Calendar.getInstance().getTimeInMillis();
	}
	
	//Retorna um número aleatório entre [0, 1)
	public double getRand(){
		xi = (a + m*xi) % p;
		double d = xi;
		
		return d / p;		
	}
	
	//Retorna um número aleatório entre [0, max)
	public int getIntRand(int max){
		double num = getRand();
		
		return (int)(num * max);
	}
	
	public void setSemente(int k){
		xi = k;
	}
}
