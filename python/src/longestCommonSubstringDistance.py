from difflib import SequenceMatcher

def calculate(base, term):
	sequnce_matcher = SequenceMatcher(None, base, term)
	longest_common_substring_match = sequnce_matcher.find_longest_match(0, len(base), 0, len(term))
	longest_common_substring_size = longest_common_substring_match.size
	return longest_common_substring_size
