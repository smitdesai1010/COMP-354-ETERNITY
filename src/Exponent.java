package src;

public class Exponent {

    static public double myPow(double x, int n) {

        int ret = n;
        if(n==0) {
            return 1;
        }
        if(n<0) {
            ret=(int)myAbs(n); //if n=-1, then make it n=1 and return reciprocal of result
            double result= myPow(x, ret-1)*x;
            return (1/result);
        }
        double k= myPow(x, ret/2);
        double powNumber=k*k;
        if(ret%2==1) { //if n is odd
            powNumber=powNumber *x;
        }
        return powNumber;
    }

    static double EPS = 0.0000000000001;

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

    public static double myAbs(double x){
        double ret = x;
        if (ret < 0){
            ret = -ret;
        }
        return ret;
    }

    public static double exponentiation(double base, double exp){

        if (exp % 1 == 0 ){
            return myPow(base, (int)exp);
        }

        if(exp == 0)
            return 1;
        else if (exp < 0){
            return 1 / exponentiation(base, -exp);
        }

        else if(exp >= 1){
            double temp = exponentiation(base, exp / 2);
            return temp * temp;
        }
        else{
            double low = 0;
            double high = 1.0;

            double sqr = mySqrt(base);
            double acc = sqr;
            double mid = high / 2;

            while(myAbs(mid - exp) > EPS){
                sqr = mySqrt(sqr);

                if (mid <= exp) {
                    low = mid;
                    acc *= sqr;
                } else{
                    high = mid;
                    acc *= (1/sqr);
                }

                mid = (low + high) / 2;
            }
            System.out.println(acc);
            return acc;
        }
    }

    public static void calculateExp(double base, double exp){
        double finalResult = exponentiation(base, exp);
        System.out.println("Calculation ended");
        System.out.println("The final result is "+finalResult);
    }
}
