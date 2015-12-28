import editDistance
import jaccardDistance
import longestCommonSubstringDistance

__author__ = "Hakan Ozbay"
__maintainer__ = "Hakan Ozbay"
__version__ = "1.0.0"

def calculate(base,term):
	base = base.lower()
	term = term.lower()
	edit_distance = editDistance.calculate(base,term)
	jaccard_distance = jaccardDistance.calculate(base,term)
	lcss_distance = longestCommonSubstringDistance.calculate(base,term)

	jaccard_metric = jaccard_distance
	lcss_metric = lcss_distance/(len(base) if len(base) > len(term) else len(term))
	edit_distance_metric = edit_distance/len(base)
	
	if jaccard_metric == 1:
		metric = edit_distance
	elif jaccard_metric == 0:
		metric = edit_distance_metric
	else:
		metric = jaccard_metric * edit_distance

	if lcss_metric > 0:
		metric /= lcss_metric
	else:
		metric *= (len(base) if len(base) < len(term) else len(term))

	return metric