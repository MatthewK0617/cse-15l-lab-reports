# Lab Report 5
This report will go through the steps on how to complete a basic grading script. 

## Template Code
A few files will be provided so that we can prioritize the implementation of the bash file auto-grader. To access the parent directory for our autograder, use the following command: `git clone https://github.com/ucsd-cse15l-w23/list-examples-grader <enter>`. Here is the link if you want to check that the file system matches: [https://github.com/ucsd-cse15l-w23/list-examples-grader](https://github.com/ucsd-cse15l-w23/list-examples-grader). 

## Cloning Student Input
Since we are grading student's work, it is necessary to have immediate access to their files. As such, we should clone their files into the local directory. A convenient tool to use is how bash handle's parameters; to take advantage of this, we can plan on adding a parameter to our bash call that will eventually execute the grading. Since this is recognized as `$1` (the first parameter) by bash, we can add the line `git clone $1 [name-of-cloned-student-submission]`. Note that the `[name-of-cloned-student-submission]` is to be replaced with what you want to call it. We will call it `student-submission`. 

## Extracting Files
After cloning the students' work, we need to access their files. Since the students' were instructed to have their system setup so that there would be one file in their repository named **ListExamples.java**, we can safely assume that each of their files can be accessed using `student-submission/ListExamples.java`. Because we will be calling this multiple times and to maintain organization of our code, we can store this path in a variable called `file`. 

`file=student-submission/ListExamples.java`

## Organizing Directories
We also need to move the file stored in the path stored in `file` into the same directory as our tester code. The easiest way to do this is to copy the file over to the working directory. This can be done using the following command: `cp $file ss.java`. This copies the file identified by the path `file` into the working directory as a new file named `ss.java` (we chose **ss** as a substitution for **student submission**. 

## Java Files
To compile the necessary java files, we can use the `javac` command. Before we do this, it would be convenient to store the class path in another variable called `CPATH`. We can do this using `CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'`. This makes it so that we can conveniently call it when compiling and running our code. The compilation can be done with the command `javac -cp $CPATH *.java`, while executing the tester (**TestListExamples**) can be accomplished through `java -cp $CPATH org.junit.runner.JUnitCore TestListExamples`. 


## Output
In order to actually see the results, we should redirect the output into a text file. This can be done by adding ` > out.txt` to the end of the execution command. The final command should look like so: `java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > out.txt`. We can then display the output by using `cat out.txt`. 

## Misc. 
