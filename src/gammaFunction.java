//package src;

//gamma function is the function to solve factorial(!) for all real numbers including irrational numbers
public class gammaFunction {
	//these three values, pi, pi/2 and e are important for calculating certain values
	static double pi=3.14159265359;
	static double gammaOneHalf = arcCos.exponentiation(pi, .5);
	static double e=2.7182818284;
	/**for all integers and integers+0.5, there are theories to solve them with no need dealing with the integral
	 *input is the value of the variable
	 *clas is to mark whether the value is an integer, integer+0.5, or neither. 1 is integer, 2 is integer+0.5 and 3 is other numbers
	 *plus is to indicate whether the number is positive or negative, 1 is positive and 2 is negative
	 */
	public double input;
	public int clas;
	public int plus;
	//the default value of clas and plus are respectively 3 and 1
	public gammaFunction(double a) {
		input=a;
		clas=3;
		plus=1;
	}
	//the method to identify negative number
	public static void Negative(gammaFunction a) {
		if(a.input<0)
			a.plus=0;
	}
	//the method to identify integer
	public static void isInt(gammaFunction a) {
		if(a.input%1==0)
			a.clas=1;
	}
	//the method to identify integer+0.5
	public static void isHalf(gammaFunction a) {
		if(a.input%1==0.5||a.input%1==-0.5)
			a.clas=2;
	}
	//values are going through these methods to be distributed
	public static void distribution(gammaFunction a) {
		Negative(a);
		isInt(a);
		isHalf(a);
	}
	//the method to solve the positive integer values
	public static double gammaInt(double a) {
		a-=1;
		double b=1;
		while(a>0) {
			b*=a;
			a--;
		}
		return b;
	}
	//the method to solve the positive integer+1/2 values
	public static double gammaHalf(double a) {
		a-=1;
		double b=1;
		while (a>0) {
			b*=a;
			a--;
		}
		b*=gammaOneHalf;
		return b;
	}
	//the method to solve the negative integer-1/2 values
	public static double gammaNegHalf(double a) {
		double b=1;
		while(a<-1) {
			b=b/a;
			a++;
		}
		b*=-2*gammaOneHalf;
		return b;
	}
	/**the method to solve all other values except for negative integers.
	 *this is a rough method to solve the integral, I pick a relatively large number as the loop times where is supposed to be infinite
	 *also, due to the limit of the double type, some extremely small numbers that generated during the process will be treated as 0
	 *therefore, the result aren't totally accurate, thats why I would distinguish the methods for integer and integer+0.5
	 */
	public static double gammaOther(double value) {
		double division=10000.0/1000000.0;
		double a=0;
		double result=0;
		for(int i=0; i<1000000 ;i++) {
			a+=division;
			result+=division*arcCos.exponentiation(a,value-1)*arcCos.exponentiation(e,a*-1);
		}
		return result;
	}
	//here I used a switch to match each number to its correspondence method
	public static double gammaAlpha(gammaFunction a) {
		double result=0;
		switch(a.clas) {
		case 1:
			if(a.plus==1) {
			result=gammaInt(a.input);
			break;}
			else
			break;
		case 2:
			if(a.plus==1)
			result=gammaHalf(a.input);
			else
			result=gammaNegHalf(a.input);
			break;
		case 3:
			result=gammaOther(a.input);
			break;
		default:
			result=0;
			break;
		}
		System.out.println("gamma("+a.input+")= "+result);
		return result;
	}
	
	
	
	// public static void main(String[] args) {
	// 	Scanner input=new Scanner(System.in);
	// 	try {//welcome and guide message
	// 		System.out.println("Welcome to use the gammaFunction(v0.8)!");
	// 		System.out.print("please input value z: ");
	// 		// where user do the input
	// 		double number= input.nextDouble();
	// 		gammaFunction value=new gammaFunction(number);
	// 		distribution(value);
	// 		if(value.plus==0&&value.clas==1) 
	// 			//if the user input negative integers, the system will generate following words instead of doing the calculation
	// 			System.out.println("negetive integers are undefined in gamma function!");
	// 		else
	// 			System.out.println("gamma("+value.input+")="+gammaAlpha(value));}
	// 	catch(Exception e){
	// 		 System.out.println("Input are invalid, program terminated!");
	//            System.exit(0);
	// 	}
	// }
}
