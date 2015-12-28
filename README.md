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

### Executing the implemetation and tests

There is a ``` ozbayMetricRunner.py ``` in the 'python/src' folder of the repository. You can supply 2 words as 2 arguments to the file when executing, for it to then calcualte a result and print it out. Here is an example to illustrate:

```
$ python3 ozbayMetricRunner.py ban bat
The result of comparing ban with bat is: 0.75
```

To execute the tests in the Python implementation you need to run the "allTests.py" file in the 'python' folder.
Before you execute this, you must set the PYTHONPATH to inclue the src folder, like so:

``` export PYTHONPATH=src ```

To then execute the file:

``` python3 allTests.py ```

### Using the library in your code

If you want to use the calculator in your source code as a library, in your source code file you need to import the calculator and utilize it declaring it in 2 possible ways:

``` import ozbayMetricCalculator ```

You can then utilize it by calling ``` result = ozbayMetricCalculator.calculate(word1,word2) ```

Or alternatively:

``` from ozbayMetricCalculator import calculate ```

You can then utilize it by calling ``` result = calculate(word1,word2) ```

## Java implementation

You must have JDK 1.8 and Maven 3+ installed on your machine in order to run, compile and package the project.

There is a ``` OzbayMetricRunner.java ``` in the 'java/src/main/java/com/hakanozbay/app' folder of the repository. 

### Executing the implemetation and tests
 
If you are running this on the command line, without an IDE like Eclipse, you will need to package and compile the project using Maven first, like so:

```
$ cd java
$ mvn clean package
```



To execute the tests in the Java implementation you need to run the "UnitTestSuite.java" JUnit test in the 'src/test/java/com/hakanozbay/testsuite' folder.

[Jaccard Distance]: https://en.wikipedia.org/wiki/Jaccard_index
[Edit Distance]: https://en.wikipedia.org/wiki/Edit_distance
[Longest Common Substring Distance]: https://en.wikipedia.org/wiki/Longest_common_substring_problem 