package src;
//We can change the naming conventions later
public class MeanAbsoluteDeviation {

    // Mean Abosulute Deviation
    public static double MAD(double[] dataSet) {
        // input validation
        if (dataSet.length == 0) {
            System.out.println("\nError in data provided to MAD function\n");
            return 0.0;
        }

        double dataMean = mean(dataSet);
        double distancesFromMean[] = new double[dataSet.length];

        // Calulating the absolute distance of each point from the mean
        for (int i = 0; i < dataSet.length; i++) {
            distancesFromMean[i] = dataSet[i] - dataMean;
            // absolute value
            if (distancesFromMean[i] < 0)
                distancesFromMean[i] *= -1;
        }

        // return average of all the distances
        double result = mean(distancesFromMean);
        System.out.println(result);
        return result;
    }

    //Calculate mean of double list, can make public for reuse later
    private static double mean(double[] list) {

        if (list.length == 0)
            return 0;

        double sum = 0;
        int n = list.length;

        //Do division by length as part of the summation to avoid double overflow
        for (double i : list) {
            sum += i/n;
        }
        return sum;
    }

}