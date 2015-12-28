import unittest
from editDistance import calculate

class EditDistanceTest(unittest.TestCase):

	def test_edit_distance_of_identical_words(self):
		editDistance = calculate("hi","hi")
		self.assertEqual(editDistance, 0)

	def test_edit_distance_of_identical_words_case_senseitive(self):
		editDistance = calculate("hi","Hi")
		self.assertEqual(editDistance, 1)		

	def test_edit_distance_of_similar_words(self):
		editDistance = calculate("cat","bat")
		self.assertEqual(editDistance, 1)		

	def test_edit_distance_of_subset_words(self):
		editDistance = calculate("cat","catch")
		self.assertEqual(editDistance, 2)

	def test_edit_distance_of_anagrams(self):
		editDistance = calculate("tame","mate")
		self.assertEqual(editDistance, 2)

	def test_edit_distance_of_words_with_similar_letters(self):
		editDistance = calculate("act","catch")
		self.assertEqual(editDistance, 3)
