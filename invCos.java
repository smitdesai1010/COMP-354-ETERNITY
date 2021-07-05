import java.util.Scanner;
import java.lang.*;



public class invCos{

    static double pi =  3.14159265358979;
//string parser used to evaluate strings into doubles
public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;
    
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
    
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
    
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
    
            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor
    
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
    
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
    
            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
    
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = mySqrt(x);
                    // else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    // else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    // else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
    
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
    
                return x;
            }
        }.parse();
    }


//simple function to convert radians to degrees 
public static double radToDeg(double rad){
   double retDeg = rad*180/pi;
    
    return retDeg;
}


//implementation of a root finder using the Newton's method, 200 iterations 
    public static double mySqrt(double x) {

        double n = 1; 
        double cnt=1; 
                while(true) {
                    if(cnt == 200) {
                        return  n; 
            }
            n = n - (( (n*n)- x) /  (2*n)); 
            cnt+=1;
        }
        
    }
 
 //A fast arccosine implementation, accurate to about 0.5 degrees, can be based on the observation that for x in [0,1], acos(x) ≈ √(2*(1-x)). 
 //An additional scale factor improves accuracy near zero. The optimal factor can be found by a simple binary search. Negative arguments are handled according to acos (-x) = π - acos (x).   
   public static double acos(double x){
    double C = 0.10501094;
    double r,s,t,u;
    
    if (x < 0)
        t = -x;
    else 
        t = x; 

    u = 1.0f - t;
    s = mySqrt(u + u);
    r = C * u * s + s;
    if ( x < 0 ) 
        r = pi - r;

    return r; 
}



public static void main(String[] args){
    double input = 0;
    Scanner scanner = new Scanner(System.in);

    try {//check for valid input
        System.out.println("Please enter a number between -1 and 1: ");
        input = eval(scanner.nextLine());
    }catch (Exception e){
        System.out.println("Input are invalid, program terminated!");
        System.exit(0);
    }
    
    scanner.close();
    if (input > 1|| input <-1)
        System.out.println("Invalid input.");
    else{
        double result = acos(input);
    
        System.out.println("The result is: " + result + " radians or " + radToDeg(result) + " degrees");
    }
}

}