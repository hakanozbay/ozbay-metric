package com.hakanozbay.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hakanozbay.metric.EditDistanceTest;
import com.hakanozbay.metric.JaccardDistanceTest;
import com.hakanozbay.metric.LongestCommonSubstringDistanceTest;
import com.hakanozbay.metric.OzbayMetricCalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({EditDistanceTest.class,
	JaccardDistanceTest.class,
	LongestCommonSubstringDistanceTest.class,
	OzbayMetricCalculatorTest.class})
public class UnitTestSuite {

}
