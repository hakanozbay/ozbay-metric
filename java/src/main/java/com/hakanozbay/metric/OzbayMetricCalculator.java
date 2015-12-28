package com.hakanozbay.metric;

public class OzbayMetricCalculator implements Metric {

	public double calculate(String base, String term) {
		
		String baseLowerCase = base.toLowerCase();
		String termLowerCase = term.toLowerCase();
		
		double jaccardDistance = calculateJaccardDistannce(baseLowerCase, termLowerCase);
		double editDistance = calculateEditDistance(baseLowerCase, termLowerCase);
		double longestCommonSubstringDistance = calculateLongestCommonSubstringDistance(baseLowerCase, termLowerCase);
	
		double jaccardMetric = jaccardDistance;
		double lcssMetric = longestCommonSubstringDistance/(base.length() > term.length()? base.length() : term.length());
		double editDistanceMetric = editDistance/base.length();
		
		double metric;
		
		if (jaccardMetric == 1)
			metric = editDistance;
		else if (jaccardMetric == 0)
			metric = editDistanceMetric;
		else
			metric = jaccardMetric * editDistance;

		if (lcssMetric > 0)
			metric /= lcssMetric;
		else
			metric *= (base.length() < term.length()? base.length(): term.length());

		return metric;
	}


	protected double calculateJaccardDistannce(String base, String term)
	{
		return new JaccardDistance().calculate(base, term);
	}
	
	protected double calculateEditDistance(String base, String term) 
	{
		return new EditDistance().calculate(base, term);
	}

	protected double calculateLongestCommonSubstringDistance(String baseLowerCase, String termLowerCase) 
	{
		return new LongestCommonSubstringDistance().calculate(baseLowerCase, termLowerCase);
	}
	
}
