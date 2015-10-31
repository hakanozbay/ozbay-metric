# Ozbay metric

This is a string metric that measures deviation (or proximity) between 2 words. The metric calculation is a formula that utilizes 3 existing String metric algorithms: [Jaccard Distance][], [Edit Distance][] and [Longest Common Substring Distance][].

The formula produces an output value is which is >= 0.0 where 0.0 is a perfect match, and increasing values demonstrate a decreasing likelihood of a match.

## Examples

ban, ban = 0.0  
ban, bane = 0.3333333  
ban, band = 0.3333333  
ban, bat = 0.75  
ban, bands = 1.3333333333333335  
ban, banana = 2.0  
ban, bandana = 2.3333333333333335  
ban, bandit = 3.0  
ban, bandage = 4.666666666666667 


This metric accommodates for words that are incorrectly spelt:

piccadilly, piccadilly = 0.0  
piccadilyl, piccadilly = 0.25  
piccadlily, piccadilly = 0.3333333  
picacdilly, piccadilly = 0.4  
picadily, piccadilly = 0.5  
picacdlily, piccadilly = 1.3333333333333335  
ipcacdily, piccadilly = 1.48148  
pcicadlyil, piccadilly = 2.0 


## Python implementation

There is a ``` metricRunner.py ``` in the 'python/src' folder of the repository. You can supply 2 words as 2 arguments to the file when executing, for it to then calcualte a result and print it out. Here is an example to illustrate:

```
$ python3 metricRunner.py ban bat
The result of comparing ban with bat is: 0.75
```

To execute the tests in the python implementation you need to run the "allTests.py" file in the 'python' folder.
Before you execute this, you must set the PYTHONPATH to inclue the src folder, like so:

``` export PYTHONPATH=src ```

To then execute the file:

``` python3 allTests.py ```


[Jaccard Distance]: https://en.wikipedia.org/wiki/Jaccard_index
[Edit Distance]: https://en.wikipedia.org/wiki/Edit_distance
[Longest Common Substring Distance]: https://en.wikipedia.org/wiki/Longest_common_substring_problem 