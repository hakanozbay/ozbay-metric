package com.hakanozbay.metric;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaccardDistanceTest {

	JaccardDistance jaccardDistance;
	
	@Before
	public void setUp()
	{
		jaccardDistance = new JaccardDistance();
	}
	
	@After
	public void taerDown()
	{
		jaccardDistance = null;
	}
	
	@Test
	public void testIdenticalWords()
	{
		double distance = jaccardDistance.calculate("transport", "transport");
		assertEquals(0, distance, 0);
	}

	@Test
	public void testWordsWithNoSimilarity()
	{
		double distance = jaccardDistance.calculate("aaa", "bbb");
		assertEquals(1, distance, 0);
	}
	
	@Test
	public void testWordsWithSimilarity()
	{
		double distance = jaccardDistance.calculate("transport","transportation");
		assertEquals(0.125, distance, 0);
	}

	  
}
