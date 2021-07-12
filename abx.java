import java.util.Scanner;

public class abx{
	public static double e = 2.7182818284590452353602874713527;

	public static int factorial(int x) {
		if (x == 0)
			return 1;
		else
			return (x * factorial(x - 1));
	}

	public static double ln(double x) {
		double fraction = ((x - 1) / (x + 1));
		double ans = 0;
		double power = 1;
		for (int i = 1; i < 50; i++) {
			if (i % 2 != 0) {
				for (int j = 0; j < i; j++) {
					power = power * fraction;
				}
				ans = ans + (power / i);
			}
		}
		return (2 * ans);
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
				remainAns = expPower(remainX * Main.logarithm(e, b));
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
				remainAns = expPower(remainX * Main.logarithm(e, b));
			for (int i = 0; i < -intX; i++) {
				ans = ans * b;
			}
			ans = 1 / ans;
		}
		return (a * ans * remainAns);
	}

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("For the expression: ab^x\nPlease enter a real number for 'a': ");
		double a = key.nextDouble();
		System.out.print("Please enter a real number for 'b': ");
		double b = key.nextDouble();
		System.out.print("Please enter a real number for 'x': ");
		double x = key.nextDouble();
		key.close();
		double answer;

		if (b < 0 && x % 1 != 0) {
			System.out.println("Input are invalid, program terminated!");
			System.exit(0);
		}
		else {
			answer = power(a, b, x);
			System.out.println("The resut is: " + answer);
		}
	}

}
