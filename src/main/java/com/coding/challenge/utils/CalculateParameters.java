package com.coding.challenge.utils;

import java.util.Arrays;

/**
 * Utility class for calculating various parameters.
 */
public class CalculateParameters {
    /**
     * Calculates the maximum time gap between consecutive timestamps.
     *
     * @param timestampArr an array of timestamps
     * @return the maximum time gap
     */
    public static int calculateMaxTimeGap(long[] timestampArr){
        int maxTimeGap = Integer.MIN_VALUE;
        // If there's only one timestamp, the time gap is zero
        if(timestampArr.length == 1){
            return 0;
        }else{
            // Iterate through the array to find the maximum time gap
            for(int i = 0; i< timestampArr.length-1; i++){
                maxTimeGap = (int) Math.max(maxTimeGap, (timestampArr[i+1]-timestampArr[i]));
            }
            return maxTimeGap;
        }
    }


    /**
     * Calculates the sum of quantities.
     *
     * @param quantities an array of quantities
     * @return the sum of quantities
     */
    public static int calculateSum(int[] quantities){
        return Arrays.stream(quantities).sum();
    }

    /**
     * Calculates the maximum value in an array.
     *
     * @param prices an array of prices
     * @return the maximum value
     */
    public static int calculateMaxValue(int[] prices){
        return Arrays.stream(prices).max().getAsInt();
    }

    /**
     * Calculates the weighted average price.
     *
     * @param quantities an array of quantities
     * @param prices     an array of prices
     * @return the weighted average price
     */
    public static int calculateWeightedAveragePrice(int[] quantities, int[] prices){
       int numerator = 0;
        // Calculate the numerator for the weighted average
       for(int i = 0; i < quantities.length ; i ++){
           numerator += quantities[i] * prices[i];
       }
        // Calculate the denominator as the sum of quantities
       int denominator = calculateSum(quantities);
        // Calculate and return the weighted average price
       return numerator/denominator;
    }

}
