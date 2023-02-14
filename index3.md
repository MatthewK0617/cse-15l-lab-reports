# Week 4, 5

## Command Testing: `find`
This tutorial will demonstrate the use of four different instances of the `find` command. 

### `-empty`
Using `find [directory] -empty` will return all the empty files and directories within the directory of interest.

```
matthewkim@Matthews-MacBook-Pro written_2 % find ./non-fiction -empty
matthewkim@Matthews-MacBook-Pro written_2 % find ./travel_guides -empty
```
As expected (since the files all contain text), the command returns nothing for both directories within written_2. However, this function is particularly useful if there were to be empty files in case you wanted to delete them for organization purposes without inspecting each file individually. 

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
As expected, the command returns an in-order list of directories and files — that is, it follows the natural file and directory ordering. The `...` connotes the existence of more files and directories that were not listed in this tutorial to save space. This command is useful when you want to view the structure of a directory. 

### `-user [name]`
Using `find [directory] -user [name]` will return all the files and directories belonging to a certain user; in other words, the user who created the file. 

```
matthewkim@Matthews-MacBook-Pro written_2 % find ./non-fiction -user matthewkim
./
.//non-fiction
.//non-fiction/OUP
.//non-fiction/OUP/Berk
.//non-fiction/OUP/Berk/ch2.txt

...

matthewkim@Matthews-MacBook-Pro written_2 % find ./travel_guides -user matthewkim
./travel_guides
./travel_guides/berlitz1
./travel_guides/berlitz1/HandRLasVegas.txt
./travel_guides/berlitz1/HistoryJapan.txt

...
```

Because the examples are operating from a local machine, the output will include every file since by default you are the owner. This would prove to be useful on servers because multiple people are capable of accessing files. For example, if you wanted to delete/modify a file but weren't sure of who the file belongs to, this command would help identify the user. 

### `-size +N/-N`
Using `find [directory] -size +N/-N` will return all the files that are have more than N blocks (+N) or less than N blocks (-N). Note that a block is defined as 24 bytes for most 8-byte systems. 

```
matthewkim@Matthews-MacBook-Pro written_2 % find ./travel_guides -size +500 
./travel_guides/berlitz1/WhereToItaly.txt

matthewkim@Matthews-MacBook-Pro written_2 % find ./travel_guides -size +250
./travel_guides/berlitz1/WhereToIndia.txt
./travel_guides/berlitz1/WhereToItaly.txt
./travel_guides/berlitz1/WhereToMalaysia.txt
./travel_guides/berlitz1/WhereToJapan.txt
./travel_guides/berlitz1/WhereToFrance.txt
./travel_guides/berlitz2/Canada-WhereToGo.txt
./travel_guides/berlitz2/China-WhereToGo.txt

```
The first command returns a list of files that have more than 500 blocks, the only one being `WhereToItaly.txt`. The second command returns a slightly longer list, which is to be expected since we decreased the block requirement. This command can be useful when looking for files of certain sizes within your system so that you can inspect them via the path returned. 


Source: https://www.geeksforgeeks.org/find-command-in-linux-with-examples/ 

