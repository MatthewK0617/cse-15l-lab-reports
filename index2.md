# Week 2, 3

## StringServer
```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String str = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return str;
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                str += parameters[1] + '\n';
                return str;
            }
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```
There are two classes within the StringServer.java file: Handler and StringServer. Within the Handler class, there is a method called handleRequest; this method takes in a URI object which dictates what value is returned. Within the StringServer class, there is the main method which takes in the command-line String[] arguments — in our case, this would be the port number. The `String str` variable is what will get displayed on the screen. The value will update (concatenate the new string(s) and enter a new line) as new strings queried. The prerequisite to Handler is the assumption that StringServer has already been started. 


![Screenshot 2023-01-29 at 1 57 01 PM](https://user-images.githubusercontent.com/41757629/215357811-6064a641-2d1e-4c33-a112-fff98cd90a16.png)
This query calls the method handleRequest. The argument is given as `/add-message?s=hellos`. Because it contains `/add`, the else statement is invoked which results in str getting updated from `""` to `"hellos"`.


![Screenshot 2023-01-29 at 1 57 31 PM](https://user-images.githubusercontent.com/41757629/215357826-aa37645e-2930-492e-a82b-eb75309e3f67.png)
This query calls the method handleRequest. The argument is given as `/add-message?s=hola`. Because it contains `/add`, the else statement is invoked which results in str getting updated from `"hellos"` to `"hellos '\n' hola"`.


## Bugs

```
  public void testReversed() {
    int[] input1 = {};
    assertArrayEquals(new int[] { 5, 4, 3 }, ArrayExamples.reversed(new int[] { 3, 4, 5 })); // 3
    assertArrayEquals(new int[] {1, 1, 1}, ArrayExamples.reversed(new int[] { 1, 1, 1 })); // 4
  }
```
Line 3 is a failure-inducing input. Below is the symptom: 

```
JUnit version 4.13.2
..E
Time: 0.008
There was 1 failure:
1) testReversed(ArrayTests)
arrays first differed at element [0]; expected:<5> but was:<3>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:78)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:418)
        at org.junit.Assert.assertArrayEquals(Assert.java:429)
        at ArrayTests.testReversed(ArrayTests.java:19)
        ... 30 trimmed
Caused by: java.lang.AssertionError: expected:<5> but was:<3>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ExactComparisonCriteria.assertElementsEqual(ExactComparisonCriteria.java:8)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:76)
        ... 36 more

FAILURES!!!
Tests run: 2,  Failures: 1
```

Line 4 does not induce failure. Running the line standalone yields the following symptoms: 

```
JUnit version 4.13.2
..
Time: 0.007

OK (2 tests)
```

The bug occurred because of two lines. Below is the buggy code:

```
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }
```

Here is the fixed code:

```
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      // arr[i] = newArray[arr.length - i - 1];
      newArray[i] = arr[arr.length - i - 1];
    }
    // return arr;
    return newArray; 
  }
```


## Useful Insights
As someone who's backend development experiences consist of Node.js and express servers, it is interesting to see the similarities and differences that exist between hosting servers on Java and JS. The use of JUnit to debug also gave me insight into how the debugging process can be simplified, as I had previously been manually testing each individual test case. 
