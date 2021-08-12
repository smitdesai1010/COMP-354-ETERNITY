//package src;

public class abx{
	public static double e = 2.7182818284590452353602874713527;

	public static int factorial(int x) {
		if (x == 0)
			return 1;
		else
			return (x * factorial(x - 1));
	}

	public static double natLog(int n, double x)
	{
		
		double prec;										
		double div = (x - 1) / (x + 1);
		int serie = (2*n) + 1;
		double divSerie = 1.0/serie;
		double exp = exponent(serie, div);

		
		prec = (2*(divSerie * exp));						
		
		if(prec > 0.000000001)
		{
			return prec + natLog(++n, x);					
		}
		else
		{
			return 0;
		}
				
	}

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

	public static double logarithm(double base, double X) 
	{

		double b = natLog(0, base);
		double x = natLog(0, X);
		
		double ans = x/b;
		
		return ans;
	}  

	public static double expPower(double x) {
		double ans = x + 1;
		if (x == 0)
			return ans;
		else {
			for (int i = 0; i < 10; i++) {
				ans = ans + power(1, x, (i + 2)) / factorial(i + 2);
			}
			return ans;
		}
	}

	public static int floor(double x) {
		int value = (int) x;
		return value;
	}

	public static double power(double a, double b, double x) {
		double ans = 1;
		double remainAns = 0;
		int intX;
		double remainX;
		if (x >= 0) {
			intX = floor(x);
			remainX = x - intX;
			if (remainX == 0)
				remainAns = 1;
			else
				remainAns = expPower(remainX * Logarithm.logarithm(e, b));
      
			for (int i = 0; i < intX; i++) {
				ans = ans * b;
			}
		}
		else {
			intX = floor(x) + 1;
			remainX = x - intX;
			if (remainX == 0)
				remainAns = 1;
			else
				remainAns = expPower(remainX * Logarithm.logarithm(e, b));

			for (int i = 0; i < -intX; i++) {
				ans = ans * b;
			}
			ans = 1 / ans;
		}
		return (a * ans * remainAns);
	}

	public static double calculatePower(double a, double b, double x) {
		double answer;
		answer = power(a, b, x);
		return answer;
	}

}
