import argparse
from ozbayMetricCalculator import calculate

__author__ = "Hakan Ozbay"
__maintainer__ = "Hakan Ozbay"
__version__ = "1.0.0"

def perform_metric_calculation():

	parser = argparse.ArgumentParser(description='Calculate the similarity of 2 words using the Ozbay metric')
	parser.add_argument("base", type=str, help="The first word to be compared with")
	parser.add_argument("term",type=str, help="The second word to be compared with")

	args = parser.parse_args()

	result = calculate(args.base,args.term)

	print("The result of comparing %s with %s is: %s" % (args.base, args.term, result))

if __name__ == "__main__":
	perform_metric_calculation()