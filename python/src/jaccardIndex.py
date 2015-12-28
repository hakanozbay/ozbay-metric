def calculate(base, term):
	intersection_of_words = set(base).intersection(set(term))
	union_of_words = set(base).union(set(term))
	return len(intersection_of_words) / len (union_of_words)
