package com.hakanozbay.metric;

import java.util.HashSet;
import java.util.Set;

class JaccardDistance implements Metric
{

	public double calculate(String base, String term) 
	{
		return calculateJaccardDistance(base, term);
	}

	protected double calculateJaccardDistance(String base, String term)
	{
		Set<Character> baseCharacters = generateUniqeSetOfLettersInWord(base);
		Set<Character> termCharacters = generateUniqeSetOfLettersInWord(term);
		
		int totalSize = baseCharacters.size() + termCharacters.size();
		
		Set<Character> union = new HashSet<Character>(totalSize);
		union.addAll(baseCharacters);
		union.addAll(termCharacters);
		
		int intersection = totalSize - union.size();
		
		double jaccardIndex =  intersection / (double) union.size(); 
		
		return  1 - jaccardIndex;
		
	}

	protected Set<Character> generateUniqeSetOfLettersInWord(String term) 
	{
		
		Set<Character> uniqeCharacters = new HashSet<Character>(term.length());
		
		for (char c: term.toCharArray())
			uniqeCharacters.add(c);
		
		return uniqeCharacters;
	}
}
