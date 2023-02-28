# Lab Report 4
The following will show you how to go quickly test java files using JUnit, and modify incorrect files using Vim. 

## Login to your server. 
As you can see in the following code, I was able to successfully login to my server using the following command:
`ssh cse15lwi23ant@ieng6.ucsd.edu`

<img width="680" alt="Screenshot 2023-02-27 at 7 05 52 PM" src="https://user-images.githubusercontent.com/41757629/221743212-f2999ed9-c560-411b-aeeb-54093dc5af05.png">


## Clone the directory.
The following command will allow you to copy the sample directory, which you will be debugging, onto your server: `git clone https://github.com/MatthewK0617/lab7`. Remember to use your github account to first fork the directory. 

<img width="566" alt="Screenshot 2023-02-27 at 7 07 17 PM" src="https://user-images.githubusercontent.com/41757629/221743363-a5ea338b-1daa-4d5b-ba4c-0f88840482a1.png">


## Testing ListExamples
To test if the files are working properly, first go to the directory that the files exist in. The command `cd lab7` will do this for you. To test the files, run the following commands:
`javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java`
`java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples.java`

<img width="869" alt="Screenshot 2023-02-27 at 7 08 14 PM" src="https://user-images.githubusercontent.com/41757629/221743497-1e6a85c8-fc0e-4714-854d-8e834d0bd7d8.png">


## View and edit the files
First, we should check to see what is causing the issue. It is useful to view our tester file using the command `vim TestListExamples.java`. Once you are familiarized with the tests (which also should display after running the above commands), you should exit the file using the command `:q`.
<img width="845" alt="Screenshot 2023-02-27 at 7 08 55 PM" src="https://user-images.githubusercontent.com/41757629/221743592-cf87fb2c-288c-4b03-8628-0c56a9bb1da5.png">

The command `vim ListExamples.java` will display **ListExamples.java**. To edit this file using Vim, first press `i` to insert.

<img width="592" alt="Screenshot 2023-02-27 at 7 09 29 PM" src="https://user-images.githubusercontent.com/41757629/221743669-0c50fc75-e06b-4937-a4c3-88c0d57e0be2.png">

After making the necessary revisions (see the image below), press **Esc** (the escape key) to stop inserting. Entering `:w` will then save your file, which you can then exit using the command `:q`.

<img width="237" alt="Screenshot 2023-02-27 at 7 10 12 PM" src="https://user-images.githubusercontent.com/41757629/221743776-deffd29d-0e3f-4ab6-960c-4f65287c2ea1.png">


## Testing after Revision
After revising the files, it is important to test again to make sure that you successfully debugged the files. To rerun the commands, you can retype them or use the built in terminal arrow commands to navigate to your previous command. For example, to compile the java files again, you would have to enter `<up><up><up><up><enter>`, while starting the JVM would then also require `<up><up><up><up><enter>`; this is because the command to compile the java files was four commands up in the command line history, while starting the JVM (which is only three commands up prior to the compilation) will then also be four commands up in the history. 

<img width="874" alt="Screenshot 2023-02-27 at 8 06 03 PM" src="https://user-images.githubusercontent.com/41757629/221751009-b62e0e54-d09a-436a-9a80-ec86791470a7.png">
