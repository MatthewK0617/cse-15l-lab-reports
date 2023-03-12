# Lab Report 5
This report will go through the steps on how to complete a basic grading script. 

## Template Code
A few files will be provided so that we can prioritize the implementation of the bash file auto-grader. To access the parent directory for our autograder, use the following command: `git clone https://github.com/ucsd-cse15l-w23/list-examples-grader <enter>`. Here is the link if you want to check that the file system matches: [https://github.com/ucsd-cse15l-w23/list-examples-grader](https://github.com/ucsd-cse15l-w23/list-examples-grader). 

## Managing Student Input
Since we are grading student's work, it is necessary to have immediate access to their files. As such, we should clone their files into the local directory. A convenient tool to use is how bash handle's parameters; to take advantage of this, we can plan on adding a parameter to our bash call that will eventually execute the grading. Since this is recognized as `$1` (the first parameter) by bash, we can add the line `git clone $1 [name-of-cloned-student-submission] <enter>`. Note that the `[name-of-cloned-student-submission]` is to be replaced with what you want to call it. We will call it `student-submission`. 
