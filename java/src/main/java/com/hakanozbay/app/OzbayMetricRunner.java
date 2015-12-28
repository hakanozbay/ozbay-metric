package com.hakanozbay.app;

import com.hakanozbay.metric.OzbayMetricCalculator;

public class OzbayMetricRunner 
{
    public static void main( String[] args )
    {
    	OzbayMetricCalculator calculator = new OzbayMetricCalculator();
    	double result = calculator.calculate(args[0], args[1]);
        System.out.println("The result of comparing " + args[0] + " with " + args[1]
        		+ " is: " + result  );
    }
}
