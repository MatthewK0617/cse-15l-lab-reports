# Lab Report 5
This report will go through the steps on how to complete a basic grading script. 

## Template Code
A few files will be provided so that we can prioritize the implementation of the bash file auto-grader. To access the parent directory for our autograder, use the following command: `git clone https://github.com/ucsd-cse15l-w23/list-examples-grader <enter>`. Here is the link if you want to check that the file system matches: [https://github.com/ucsd-cse15l-w23/list-examples-grader](https://github.com/ucsd-cse15l-w23/list-examples-grader). 

## Editing the Grader File
Bash scripts use the file type `.sh`. As such, we will edit a file called `grade.sh` using the command `vim grade.sh`. You will need to enter `i` to insert the commands we will be covering. 

## Cloning Student Input
Since we are grading student's work, it is necessary to have immediate access to their files. As such, we should clone their files into the local directory. A convenient tool to use is how bash handle's parameters; to take advantage of this, we can plan on adding a parameter to our bash call that will eventually execute the grading. Since this is recognized as `$1` (the first parameter) by bash, we can add the line `git clone $1 [name-of-cloned-student-submission] <enter>`. Note that the `[name-of-cloned-student-submission]` is to be replaced with what you want to call it. We will call it `student-submission`. 

## Extracting Files
After cloning the students' work, we need to access their files. Since the students' were instructed to have their system setup so that there would be one file in their repository named **ListExamples.java**, we can safely assume that each of their files can be accessed using `student-submission/ListExamples.java`. Because we will be calling this multiple times and to maintain organization of our code, we can store this path in a variable called `file`. 

`file=student-submission/ListExamples.java <enter>`

## Organizing Directories
We also need to move the file stored in the path stored in `file` into the same directory as our tester code. The easiest way to do this is to copy the file over to the working directory. This can be done using the following command: `cp $file ss.java <enter>`. This copies the file identified by the path `file` into the working directory as a new file named `ss.java` (we chose **ss** as a substitution for **student submission**. 

## Java Files
To compile the necessary java files, we can use the `javac` command. Before we do this, it would be convenient to store the class path in another variable called `CPATH`. We can do this by adding `CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar' <enter>` at the top of the file. This enables us to conveniently call it when compiling and running our code. The compilation can be done with the command `javac -cp $CPATH *.java`, while executing the tester (**TestListExamples**) can be accomplished through `java -cp $CPATH org.junit.runner.JUnitCore TestListExamples <enter>`. 


## Output
In order to actually see the results, we should redirect the output into a text file. This can be done by adding `> out.txt` to the end of the execution command. The final command should look like so: `java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > out.txt`. We can then display the output by using `cat out.txt <enter>`. To narrow down the scope of our search to just the number of correct and incorrect cases, we can use `grep` to find the word "Failures" (note that `grep` is case sensitive); we can then redirect this to another text file which we can call `out1.txt`. We can choose whether we want to display `out.txt` or `out1.txt`, it is a matter of preference. Here is the the code: `grep -n "Failures" out.txt > out1.txt <enter>`. 

## Hidden Cases
Although our script is complete, it is missing some important components that will allow us to identify specific problems grouped under error handling. For instance, what should we do if the file does not exist? To ensure that we grade only if the file exists, we can create an `exit` clause for when the file doesn't exist ??? along with a message so that we know why the code exited. The following code block accomplishes this: 

```
if [[ ! -f $file ]]
then
   echo 'Could not find file'
   exit
fi
```
Another case we should check is if a student's code fails to compile. We can take advantage of the way bash handles errors. Right below where we compile the java files, we can implement the following code block: 

```
if [[ $? -ne 0 ]]
then
        echo 'Compile error'
        exit $?
fi
```
Exiting when there is a compile error is important not only because it is computationally efficient but also because it prevents the rest of our code from running; because we do not have a method of wiping our files after each grading except for when the grading is successful, it is important that we do not print outputs until the redirection is successful. 

We should also add a message at the beginning so we know that the files completed cloning so that we can narrow down our range of errors. Adding `echo 'Finished cloning'` below our `git clone...` command will accomplish this. Finally, since we don't want the bash file to get confused when we clone new student submissions, we should delete any prior existing student submissions using the command `rm -rf student-submission`. 

## Cleaning Up
To exit the file and ensure that it is saved, you can enter the command `<Esc> :wq <enter>`.


## Final Code
```
CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

file=student-submission/ListExamples.java

if [[ ! -f $file ]]
then
        echo 'Could not find file'
        exit
fi

cp $file ss.java
javac -cp $CPATH *.java

if [[ $? -ne 0 ]]
then
        echo 'Compile error'
        exit $?
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > out.txt
grep -n "Failures" out.txt > out1.txt

cat out.txt
```

## Testing
Here are a few examples using the `grade.sh` script in the command `bash grade.sh [github link]`. 

[**Github 1**](https://github.com/ucsd-cse15l-f22/list-methods-nested):  
This student's code is missing a semi-colon at the end of one of his lines. We can see that the code properly deals with this error by exiting and telling us that there is a compile error. 

![Screenshot 2023-03-12 at 3 10 39 PM](https://user-images.githubusercontent.com/41757629/224576738-f452c2c4-47de-478e-815f-9c255d20b8bd.png)


[**Github 2**](https://github.com/ucsd-cse15l-f22/list-methods-filename):  
This student's code is stored in a file with the wrong file name. We can see that the code properly deals with this error by exiting and telling us that the file could not be found. 

![Screenshot 2023-03-12 at 3 13 20 PM](https://user-images.githubusercontent.com/41757629/224576848-5620a7a7-8cf9-4b1b-98f6-3501691c6054.png)


[**Github 3**](https://github.com/ucsd-cse15l-f22/list-methods-nested):  
This student's code is stored in another nested directory. We can see that the code properly deals with this error by exiting and telling us that the file could not be found. 

![Screenshot 2023-03-12 at 3 18 29 PM](https://user-images.githubusercontent.com/41757629/224577129-595b9cbb-cbcf-4282-84ff-00790d978bfa.png)


[**Github 4**](https://github.com/ucsd-cse15l-f22/list-examples-subtle):  
This student's code has subtle bugs. We can see that the code properly deals with this error by displaying where the failures were. 

![Screenshot 2023-03-12 at 3 15 27 PM](https://user-images.githubusercontent.com/41757629/224576954-79737741-19fd-48a9-a245-68463ffd2fca.png)

