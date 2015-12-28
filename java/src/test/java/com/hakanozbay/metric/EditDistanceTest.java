package com.hakanozbay.metric;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditDistanceTest {

	EditDistance editDistance;
	
	@Before
	public void setUp() 
	{
		editDistance = new EditDistance();
	}

	@After
	public void tearDown() 
	{
		editDistance = null;
	}

	@Test
	public void testEditDistanceOfIdenticalWords()
	{
		double distance = editDistance.calculate("hi", "hi");
		assertEquals(0, distance, 0);
	}
	
	@Test
	public void testEditDistanceOfIdenticalWordsCaseSensitive()
	{
		double distance = editDistance.calculate("hi", "Hi");
		assertEquals(1, distance, 0);
	}
	
	@Test
	public void testEditDistanceOfSimilarWords()
	{
		double distance = editDistance.calculate("cat", "bat");
		assertEquals(1, distance, 0);
	}
	
	@Test
	public void testEditDistanceOfSubsetWords()
	{
		double distance = editDistance.calculate("cat", "catch");
		assertEquals(2, distance, 0);
	}
	
	@Test
	public void testEditDistanceOfAnagrams()
	{
		double distance = editDistance.calculate("tame", "mate");
		assertEquals(2, distance, 0);
	}
	
	@Test
	public void testEditDistanceOfWordsWithSimilarLetters()
	{
		double distance = editDistance.calculate("act", "catch");
		assertEquals(3, distance, 0);
	}
	
}
