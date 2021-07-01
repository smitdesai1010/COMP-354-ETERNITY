import java.util.Scanner;
import java.math.BigDecimal;

public class Exponent {

    public static double calculate(double base, int exponent[]){
        //in case that exponent = 0, final result is 1
        double finalResult = 1;

        if(exponent[0] > 0){
            finalResult = power(base, exponent[0]);
            finalResult = findNthRoot(finalResult, exponent[1]);
        }
        //fix a small bug when both base and exponent are negative
        else if (base < 0 && exponent[0] < 0){
            exponent[0] = -exponent[0];
            finalResult = power(base, exponent[0]);
            finalResult = findNthRoot(finalResult, exponent[1]);
            finalResult = -1/finalResult;

        }
        //if the base is negative, make the base positive, and use 1 divide the result at the end
        else if (exponent[0] < 0){
            exponent[0] = -exponent[0];
            finalResult = power(base, exponent[0]);
            finalResult = findNthRoot(finalResult, exponent[1]);
            finalResult = 1/finalResult;
        }

        return finalResult;
    }

    //Reference: https://blog.csdn.net/u014039577/article/details/79281046
    //solving the problem of double calculation
    public static double multiply(Double... doubles){
        BigDecimal result = new BigDecimal(1);
        for(Double a : doubles){
            result = result.multiply(new BigDecimal(String.valueOf(a)));
        }
        return result.doubleValue();
    }

    public static double power(double base, double exponent){
        double finalResult = 1.0;
        for (int i = 0; i < exponent; i++) {
            finalResult *= base;
        }
        return finalResult;
    }

    //reference: https://www.geeksforgeeks.org/n-th-root-number/
    //rename pow method
    static double findNthRoot(double A, int N) {

        // initially guessing a random number between 0 and 9
        double xPre = Math.random() % 10;

        // smaller eps, denotes more accuracy
        double eps = 0.001;

        // initializing difference between two roots by INT_MAX
        double delX = 2147483647;

        // xK denotes current value of x
        double xK = 0.0;

        // loop untill we reach desired accuracy
        while (delX > eps) {
            // calculating current value from previous value by newton's method
            xK = ((N - 1.0) * xPre + A / power(xPre, N - 1)) / (double) N;
            delX = Math.abs(xK - xPre);
            xPre = xK;
        }

        return xK;
    }

    public static int[] transfer(double y){
        int[] exponent = new int[2];
        int temp = 1;

        while (y % 1 != 0){
            y = multiply(y, 10.0);
            temp *= 10;
        }
        exponent[0] = (int)y;
        exponent[1] = temp;

        return exponent;
    }

    public static void main(String[] args){

        double[] input = new double[2];
        Scanner scanner = new Scanner(System.in);

        try {//check for valid input
            System.out.println("Please enter a valid base: ");
            input[0] = scanner.nextDouble();

            System.out.println("Please enter a valid exponent: ");
            input[1] = scanner.nextDouble();
        }catch (Exception e){
            System.out.println("Input are invalid, program terminated!");
            System.exit(0);
        }


        scanner.close();

        int[] exponent = transfer(input[1]);
        double result = calculate(input[0], exponent);

        System.out.println("The result is: "+ result);
    }
}
