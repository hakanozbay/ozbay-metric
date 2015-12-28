package com.hakanozbay.metric;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OzbayMetricCalculatorTest {

	OzbayMetricCalculator ozbayMetricCalculator;
	
	@Before
	public void setUp()
	{
		ozbayMetricCalculator = new OzbayMetricCalculator();
	}
	
	@After
	public void tearDown()
	{
		ozbayMetricCalculator = null;
	}
	
	@Test
	public void testCalculateExactMatch() 
	{
		double result = ozbayMetricCalculator.calculate("ban", "ban");
		assertEquals(0,result,0);
	}
	
	@Test
	public void testCalculateExactMatchIgnoreCase() 
	{
		double result = ozbayMetricCalculator.calculate("SERVICE", "service");
		assertEquals(0,result,0);
		result = ozbayMetricCalculator.calculate("service","SERVICE");
		assertEquals(0,result,0);
	}
	
	@Test
	public void testCalcualteVariousCombintationsForCorrectlySpeltWords()
	{
		double result = ozbayMetricCalculator.calculate("ban", "bane");
		assertEquals(0.3333333333333333,result,0);
		result = ozbayMetricCalculator.calculate("ban", "band");
		assertEquals(0.3333333333333333,result,0);
		result = ozbayMetricCalculator.calculate("ban", "bat");
		assertEquals(0.75,result,0);
		result = ozbayMetricCalculator.calculate("ban", "bands");
		assertEquals(1.3333333333333335,result,0);
		result = ozbayMetricCalculator.calculate("ban", "banana");
		assertEquals(2.0,result,0);
		result = ozbayMetricCalculator.calculate("ban", "bandana");
		assertEquals(2.3333333333333335,result,0);
		result = ozbayMetricCalculator.calculate("ban", "bandit");
		assertEquals(3.0,result,0);
		result = ozbayMetricCalculator.calculate("ban", "bandage");
		assertEquals(4.666666666666667,result,0);
	}
	
	@Test
	public void testCalcualteVariousCombintationsForIncorrectlySpeltWords()
	{
		double result = ozbayMetricCalculator.calculate("piccadilly", "piccadilly");
		assertEquals(0,result,0);
		result = ozbayMetricCalculator.calculate("piccadilyl", "piccadilly");
		assertEquals(0.25,result,0);
		result = ozbayMetricCalculator.calculate("piccadlily", "piccadilly");
		assertEquals(0.33333333333333337,result,0);
		result = ozbayMetricCalculator.calculate("picacdilly", "piccadilly");
		assertEquals(0.4,result,0);
		result = ozbayMetricCalculator.calculate("picadily", "piccadilly");
		assertEquals(0.5,result,0);
		result = ozbayMetricCalculator.calculate("picacdlily", "piccadilly");
		assertEquals(1.3333333333333335,result,0);
		result = ozbayMetricCalculator.calculate("ipcacdily", "piccadilly");
		assertEquals(1.4814814814814814814,result,0);
		result = ozbayMetricCalculator.calculate("pcicadlyil", "piccadilly");
		assertEquals(2.0,result,0);

	}


}
