
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
        if (dataSet.length == 0) 
        {
            System.out.println("\nEmpty dataSet provided to Standard deviation function\n");
            return 0.0;
        }

        double dataMean = mean(dataSet);	//calculating mean
        double sumOfdistancesFromMean = 0; 

        for (double value : dataSet)
        	sumOfdistancesFromMean += square(value-dataMean) ;

        double variance = sumOfdistancesFromMean/dataSet.length;
        
        return sqrt(variance);
    }

    
    //Calculate mean of double list, can make public for reuse later
    private static double mean(double[] list) 
    {
        double average = 0;
        int length = list.length;
        
        for (double value : list) 
            average += value/length;		//to prevent overflow while adding
        
        return average;
    }
    
    
    
    private static double sqrt(double value)
    {
    	
    	return value;
    }
    
    
    
    private static double square(double value)
    {
    	return value*value;
    }
    
    
}
