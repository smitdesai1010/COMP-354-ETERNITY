package src;

public class Logarithm
{
	/*
	 * This method is the natural logarithm and it is calculated by using the series found here: "https://en.wikipedia.org/wiki/Logarithm#Power_series" under more efficient series.
	 * The parameter n will be used in the calculation of the series and will be incremented as we go deeper in the recursion.
	 * The parameter x is the value you wish to find the natural log of in ln(x).
	 */
	
	public static double natLog(int n, double x)
	{
		
		double prec;										//prec is the precision we wish to achieve as the the series converges to the answer. The lower the number, the more precise the answer.
		double div = (x - 1) / (x + 1);
		int serie = (2*n) + 1;
		double divSerie = 1.0/serie;
		double exp = Exponent.exponentiation(div, serie);   // x^y from Eternity

		
		prec = (2*(divSerie * exp));						//Rather than writing the entire formula of the series in prec, they are divided into different variables like div, serie, divSerie, exp for clarity.
		
		if(prec > 0.000000001)
		{
			return prec + natLog(++n, x);					//The recursive function will continue until the desired precision is reached. Afterwards, they will all be added up in order to get the answer.
		}
		else
		{
			return 0;
		}
				
	}
	
	/*
	public static double natLog(double x)
	{
		
		double prec = 0;										//prec is the precision we wish to achieve as the the series converges to the answer. The lower the number, the more precise the answer.
		double div;
		int serie;
		double divSerie;
		double exp;   // x^y from Eternity
		int n = 0;
		
		double ans = 0;
		
		while(prec > 0.000000001)
		{
			div = (x - 1) / (x + 1);
			serie = (2*n) + 1;
			divSerie = 1.0/serie;
			exp = Exponent.exponentiation(div, serie);
			
			prec = (2*(divSerie * exp));	
			
			ans += prec;
			++n;
		}
	
		return ans;
				
	}
	*/
	/*
	 * Method to find the logarithm of X for base b.
	 * In order to find the logarithm for any base and any X, you can simply divide the natural log of X by the natural log of the base.
	 * Returns an answer of type double. The parameters are the base and the X in logb (x).
	 */
	public static double logarithm(double base, double X) 
	{

		double b = natLog(0, base);
		double x = natLog(0, X);
		
		//double ans = x/b;
		return x/b;
		//System.out.println("Logb (x) = " + ans);
	}
}
