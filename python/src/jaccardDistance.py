import jaccardIndex

def calculate(base,term):
	return 1.0 - jaccardIndex.calculate(base,term)