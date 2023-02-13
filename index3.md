# Week 4, 5

## Command Testing: `find`
This tutorial will demonstrate the use of four different instances of the `find` command. 

### `-empty`
Using `find [directory] -empty` will return all the empty files and directories within the directory of interest.

```
matthewkim@Matthews-MacBook-Pro written_2 % find ./non-fiction -empty
matthewkim@Matthews-MacBook-Pro written_2 % find ./travel_guides -empty
```
As expected (since the files all contain text), the command returns nothing for both directories within written_2. 

### `-print`
Using `find [directory] -print` will return all the file and directory paths within the directory of interest. 

```
matthewkim@Matthews-MacBook-Pro written_2 % find ./travel_guides -print
./travel_guides
./travel_guides/berlitz1
./travel_guides/berlitz1/HandRLasVegas.txt
./travel_guides/berlitz1/HistoryJapan.txt
./travel_guides/berlitz1/IntroMalaysia.txt

...

matthewkim@Matthews-MacBook-Pro written_2 % find ./non-fiction -print  
./non-fiction
./non-fiction/OUP
./non-fiction/OUP/Berk
./non-fiction/OUP/Berk/ch2.txt

...
```
As expected, the command returns an in-order list of directories and files. The `...` connotes the existence of more files and directories that were not listed in this tutorial to save space. 

### `-newer file`
Using `find [directory] -newer file` will return all the files and directories created after the directory of interest. 


