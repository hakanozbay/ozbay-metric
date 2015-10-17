import unittest
from longestCommonSubstringDistance import calculate

class LongestCommonSubstringTest(unittest.TestCase):

	def test_lcss_distance_of_identical_words(self):
		lcss_distance = calculate("hi","hi")
		self.assertEqual(lcss_distance, 2)

	def test_lcss_distance_of_identical_words_case_senseitive(self):
		lcss_distance = calculate("hi","Hi")
		self.assertEqual(lcss_distance, 1)		

	def test_lcss_distance_of_similar_words(self):
		lcss_distance = calculate("cat","bat")
		self.assertEqual(lcss_distance, 2)		

	def test_lcss_distance_of_subset_words(self):
		lcss_distance = calculate("cat","catch")
		self.assertEqual(lcss_distance, 3)

	def test_lcss_distance_of_anagrams(self):
		lcss_distance = calculate("tame","mate")
		self.assertEqual(lcss_distance, 1)

	def test_lcss_distance_of_words_with_similar_letters(self):
		lcss_distance = calculate("act","catch")
		self.assertEqual(lcss_distance, 1)

	def test_lcss_distance_of_words_with_same_letters(self):
		lcss_distance = calculate("ipcicadlyl","piccadilly")
		self.assertEqual(lcss_distance, 3)

