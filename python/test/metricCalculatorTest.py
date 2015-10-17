import unittest
from metricCalculator import calculate

class MetricCalculatorTest(unittest.TestCase):
	
	def test_calculate_exact_match(self):
		metric_result = calculate("ban", "ban")
		print(metric_result)
		self.assertEqual(metric_result, 0)

	def test_calculate_match_ignore_case_sensitivity(self):
		metric_result = calculate("SERVICE", "service")
		self.assertEqual(metric_result, 0)
		metric_result = calculate("service", "SERVICE")
		self.assertEqual(metric_result, 0)
