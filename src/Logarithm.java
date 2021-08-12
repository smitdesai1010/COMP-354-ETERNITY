//package src;

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
		double exp = exponent(serie, div);

		
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
	 * Exponential function that returns a result of type double where the parameter exp is the exponent and base is the number of time it will be multiplied
	 * by itself depending on the exponent. This method will mostly be used in the natural log method in the series that will approach the actual natural log of a number.
	 */
	public static double exponent(int exp, double base)
	{
		double b = base;
		double ans = b;
		
		for(int i = 1; i < exp; i++)
		{
			ans *= b;
		}
		
		return ans;
	}
	
	

	/*
	 * Method to find the logarithm of X for base b.
	 * In order to find the logarithm for any base and any X, you can simply divide the natural log of X by the natural log of the base.
	 * Returns an answer of type double. The parameters are the base and the X in logb (x).
	 */
	public static double logarithm(double base, double X) 
	{

		double b = natLog(0, base);
		double x = natLog(0, X);
		
		double ans = x/b;
		


		return ans;
	}
}
