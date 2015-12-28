package com.hakanozbay.metric;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LongestCommonSubstringDistanceTest {

	LongestCommonSubstringDistance longestCommonSubstringDistance;
	
	@Before
	public void setUp() 
	{
		longestCommonSubstringDistance = new LongestCommonSubstringDistance();
	}

	@After
	public void tearDown() 
	{
		longestCommonSubstringDistance = null;
	}

	@Test
	public void testLcssDistanceOfIdenticalWords() 
	{
		double distance = longestCommonSubstringDistance.calculate("hi", "hi");
		assertEquals(2, distance, 0);
	}
	
	@Test
	public void testLcssDistanceOfIdenticalWordsCaseSensitive() 
	{
		double distance = longestCommonSubstringDistance.calculate("hi", "Hi");
		assertEquals(1, distance, 0);
	}
	
	@Test
	public void testLcssDistanceOfSimilarWords() 
	{
		double distance = longestCommonSubstringDistance.calculate("cat", "bat");
		assertEquals(2, distance, 0);
	}
	
	@Test
	public void testLcssDistanceOfSubsetWords() 
	{
		double distance = longestCommonSubstringDistance.calculate("cat", "catch");
		assertEquals(3, distance, 0);
	}
	
	@Test
	public void testLcssDistanceOfAnagrams() 
	{
		double distance = longestCommonSubstringDistance.calculate("tame", "mate");
		assertEquals(1, distance, 0);
	}
	
	@Test
	public void testLcssDistanceOfWordsWithSimilarLetters() 
	{
		double distance = longestCommonSubstringDistance.calculate("act", "catch");
		assertEquals(1, distance, 0);
	}
	
	@Test
	public void testLcssDistanceOfWordsWithSameLetters() 
	{
		double distance = longestCommonSubstringDistance.calculate("ipcicadlyl", "piccadilly");
		assertEquals(3, distance, 0);
	}
	

}
