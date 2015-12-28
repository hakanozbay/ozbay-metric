# Ozbay metric

This is a string metric that measures deviation (or proximity) between 2 words. The metric calculation is a formula that utilizes 3 existing String metric algorithms: [Jaccard Distance][], [Edit Distance][] and [Longest Common Substring Distance][].

The formula produces an output value is which is >= 0.0 where 0.0 is a perfect match, and increasing values demonstrate a decreasing likelihood of a match.

## Examples
| Base word | Term word | Ozbay Metric |
|:---------:|:---------:|:------------:|
|ban|ban|0.0|  
|ban|bane|0.3333333|
|ban|band|0.3333333|
|ban|bat|0.75|  
|ban|bands|1.3333333|
|ban|banana|2.0|
|ban|bandana|2.3333333|
|ban|bandit|3.0|
|ban|bandage|4.6666666|


This metric accommodates for words that are incorrectly spelt:


| Base word | Term word | Ozbay Metric |
|:---------:|:---------:|:------------:|
|piccadilly|piccadilly|0.0|
|piccadilly|piccadilyl|0.25|
|piccadilly|piccadlily|0.3333333|
|piccadilly|picacdilly|0.4|
|piccadilly|picadily|0.5|
|piccadilly|picacdlily|1.3333333|
|piccadilly|ipcacdily|1.48148|
|piccadilly|pcicadlyil|2.0|


## Python implementation

### Executing the implemetation and tests

There is a ``` ozbayMetricRunner.py ``` in the "python/src" folder of the repository. You can supply 2 words as 2 arguments to the file when executing, for it to then calcualte a result and print it out. Here is an example to illustrate:

```bash
$ python3 ozbayMetricRunner.py ban bat
The result of comparing ban with bat is: 0.75
```

To execute the tests in the Python implementation you need to run the "allTests.py" file in the 'python' folder.
Before you execute this, you must set the ``` PYTHONPATH ``` to inclue the src folder, like so:

```bash
export PYTHONPATH=src
```

To then execute the file:

```bash
$ python3 allTests.py
```

### Using the library in your code

If you want to use the calculator in your source code as a library, You must have a copy of this source code in your project.Then in your source code file you need to import the calculator and utilize it declaring it in 2 possible ways:

```python
import ozbayMetricCalculator
```

You can then utilize it by calling 
```python
result = ozbayMetricCalculator.calculate(word1,word2)
```

Or alternatively:

```python
from ozbayMetricCalculator import calculate 
```

You can then utilize it by calling 
```python
result = calculate(word1,word2)
```

## Java implementation

You must have JDK 1.8 and Maven 3+ installed on your machine in order to run, compile and package the project.

There is a ``` OzbayMetricRunner.java ``` in the 'java/src/main/java/com/hakanozbay/app' folder of the repository. 

### Executing the implemetation and tests

If you are running the implementation on the command line, without an IDE like Eclipse, you will need to package and compile the project using Maven first, like so:

```bash
$ cd java
$ mvn clean package
```

Afterwards navigate to the built jar pacakage, and supply 2 words as 2 arguments to the file when executing, for it to then calcualte a result and print it out. Here is an example to illustrate:

```bash
$ cd target
$ java -cp ozbay-metric-1.0.0.jar com.hakanozbay.app.OzbayMetricRunner ban bat
The result of comparing ban with bat is: 0.75
```

To execute the tests in the you can provide run the maven test goal, running the "UnitTestSuite" like so:

```bash
$ mvn test -Dtest=UnitTestSuite
```

## Using the library in your code

If you want to use the calculator in your source code as a library, assuming you use Maven for you project, you will first need to install the library to your local Maven repository by running the maven install command. You can do this by nagivating to the top level 'java' folder and executing the command:

```bash
$ mvn clean install
```

Afterwards, in your pom.xml file, declare the library as a dependency:

```xml
<dependency>
	<groupId>com.hakanozbay</groupId>
	<artifactId>ozbay-metric</artifactId>
	<version>1.0.0</version>
</dependency>
```

In your source code, you must import the ``` OzbayMetricCalculator ``` declaring it as:

```java
import com.hakanozbay.metric.OzbayMetricCalculator 
```

You can then utilize it by calling 
```java
double result = new OzbayMetricCalculator().calculate(word1,word2)
```


[Jaccard Distance]: https://en.wikipedia.org/wiki/Jaccard_index
[Edit Distance]: https://en.wikipedia.org/wiki/Edit_distance
[Longest Common Substring Distance]: https://en.wikipedia.org/wiki/Longest_common_substring_problem 