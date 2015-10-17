import unittest
from jaccardIndex import calculate

class TestJaccardIndex(unittest.TestCase):

  def test_identical_words(self):
      index = calculate("transport","transport")
      self.assertEqual(index, 1)

  def test_words_with_no_similarity(self):
      index = calculate("aaa","bbb")
      self.assertEqual(index, 0)

  def test_words_with_similarity(self):
      index = calculate("transport","transportation")
      self.assertEqual(index, 0.875)

