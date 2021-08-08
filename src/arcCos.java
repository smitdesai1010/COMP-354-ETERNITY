public class arcCos{

    static double pi =  3.14159265358979;
    static double EPS = 0.0000000000001;




//simple function to convert radians to degrees 
    public static double degtoRad(double deg){
    double retRad = deg*pi/180;
        
        return retRad;
    }


    //implementation of a root finder using the Newton's method, 50 iterations 
        public static double mySqrt(double x) {
            if (x == 0)
                return 0;

            double n = 1; 
            double cnt=1; 
                    while(true) {
                        if(cnt == 50) {
                            return  n; 
                }
                n = n - (( (n*n)- x) /  (2*n)); 
                cnt+=1;
            }
            
        }





//revised function with base cases because of approximation. Uses equations from Doerfler's Dead Reckoning
    public static double acos(double x){
        if (x == -.5){
            return 120;
        }
        else if (x == -1){
            return 180;
        }
        else if (x == 1){
            return 0;    
        }
        else if (x == 0){
            return 90;
        }
        else if (x == .5){
            return 60;
        }

       double retNum;
       double num, denum, temp;
       temp = x * x;
       num = 1.0 - temp;
       temp = num;
       
       temp = exponentiation(num, .5);
       num = 3.0 * temp;
       denum = x + 2;
       retNum = num / denum;
       retNum *= 401/7;
    return retNum;
        
    }

    static public double myPow(double x, int n) {

        int ret = n;
            if(n==0) {
            return 1;
            }
            if(n<0) {
            ret=(int)myAbs(n); //if n=-1, then make it n=1 and return reciprocal of result
            double result= myPow(x, ret-1)*x;
            return (1.0/result);
            }
            double k= myPow(x, ret/2);
            double powNumber=k*k;
            if(ret%2==1) { //if n is odd
            powNumber=powNumber *x;
            }
            return powNumber;
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
        return 1.0;
    else if (exp < 0){
        return 1.0 / exponentiation(base, -exp);
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
        double mid = high / 2.0;

        while(myAbs(mid - exp) > EPS){
        sqr = mySqrt(sqr);

        if (mid <= exp) {
            low = mid;
            acc *= sqr;
        } else{
            high = mid;
            acc *= (1.0/sqr);
        }

        mid = (low + high) / 2;
        }

        return acc;
    }
    }

}
