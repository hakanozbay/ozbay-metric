import unittest
from ozbayMetricCalculator import calculate

class MetricCalculatorTest(unittest.TestCase):
	
	def test_calculate_exact_match(self):
		metric_result = calculate("ban", "ban")
		self.assertEqual(metric_result, 0)

	def test_calculate_match_ignore_case_sensitivity(self):
		metric_result = calculate("SERVICE", "service")
		self.assertEqual(metric_result, 0)
		metric_result = calculate("service", "SERVICE")
		self.assertEqual(metric_result, 0)

	def test_calcualte_various_combintations_for_correctly_spelt_words(self):
		metric_result = calculate("ban", "ban")
		self.assertEqual(metric_result, 0)
		metric_result = calculate("ban", "bane")
		self.assertEqual(metric_result, 0.3333333333333333)
		metric_result = calculate("ban", "band")
		self.assertEqual(metric_result, 0.3333333333333333)
		metric_result = calculate("ban", "bat")
		self.assertEqual(metric_result, 0.75)
		metric_result = calculate("ban", "bands")
		self.assertEqual(metric_result, 1.3333333333333335)
		metric_result = calculate("ban", "banana")
		self.assertEqual(metric_result, 2.0)
		metric_result = calculate("ban", "bandana")
		self.assertEqual(metric_result, 2.3333333333333335)
		metric_result = calculate("ban", "bandit")
		self.assertEqual(metric_result, 3.0)
		metric_result = calculate("ban", "bandage")
		self.assertEqual(metric_result, 4.666666666666667)

	def test_calcualte_various_combintations_for_incorrectly_spelt_words(self):
		metric_result = calculate("piccadilly", "piccadilly")
		self.assertEqual(metric_result, 0)
		metric_result = calculate("piccadilyl", "piccadilly")
		self.assertEqual(metric_result, 0.25)
		metric_result = calculate("piccadlily", "piccadilly")
		self.assertEqual(metric_result, 0.33333333333333337)
		metric_result = calculate("picacdilly", "piccadilly")
		self.assertEqual(metric_result, 0.4)
		metric_result = calculate("picadily", "piccadilly")
		self.assertEqual(metric_result, 0.5)
		metric_result = calculate("picacdlily", "piccadilly")
		self.assertEqual(metric_result, 1.3333333333333335)
		metric_result = calculate("ipcacdily", "piccadilly")
		self.assertEqual(metric_result, 1.4814814814814814)
		metric_result = calculate("pcicadlyil", "piccadilly")
		self.assertEqual(metric_result, 2.0)