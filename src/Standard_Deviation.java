
public class Standard_Deviation {

	public static void main(String[] args) {
        // For Testing, this is how method is used
		// need to setup a parser
        double[] data = { 1.0, 2.0, 3.0 };
        System.out.println(StandardDeviation(data));
    }

    // Standard Deviation
    public static double StandardDeviation(double[] dataSet) 
    {
        try
        {      
	        if (dataSet.length == 0) 
	        	throw new IllegalArgumentException("Input length is zero");
	
	        double dataMean = mean(dataSet);	//calculating mean
	        double sumOfdistancesFromMean = 0; 
	
	        for (double value : dataSet)
	        	sumOfdistancesFromMean += square(value-dataMean) ;
	
	        double variance = sumOfdistancesFromMean/dataSet.length;
	        
	        return sqrt(variance);
		        
    	}
        
        catch (IllegalArgumentException e)
        {
        	System.out.println(e);
        }
        
        
        catch (Exception e)
        {
        	System.out.println("General Exception: "+e);
        }
        
        return 0.0;
    }

    
    private static double mean(double[] list) throws IllegalArgumentException
    {
        double average = 0;
        int length = list.length;
        
        if (list.length == 0)
        	throw new IllegalArgumentException("Input size is zero");
        
        for (double value : list) 
            average += value/length;		//to prevent overflow while adding
        
        return average;
    }
    

	   
    private static double decimalSqrt(double value, double i, double j)   
    {  
	    double midValue = (i+j)/2;  
	    double currSquare = square(midValue);  
	    
	    double absValue = currSquare-value < 0 ? value-currSquare : currSquare-value;
	    
	    if( currSquare == value || absValue < 0.0000001 )   
	    	return midValue;   
	    
	    else if(currSquare > value)  
	    	return decimalSqrt(value, i, midValue);  
	    
	    else  
	    	return decimalSqrt(value, midValue, j);  
    }  
   
    
    private static double sqrt(double value) throws ArithmeticException
    {
    	if (value == 0)
    		return 0;
    	
    	if (value < 0)
    		throw new ArithmeticException("Sqrt cannot be calculated for negative values");
    	
    	double i = 1;  
    	
 	    while(true)   
 	    {  
 		    if(i*i == value)  
 		    	return i;  
 		    
 		    else if(i*i > value)   
 		    	return decimalSqrt(value,i-1,i);  
 		    
 		    i++;  
 	    }  
    }
    
    
    
    private static double square(double value)
    {    	
    	return value*value;
    }
    
    
}
