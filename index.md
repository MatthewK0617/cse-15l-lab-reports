# Week 1

## Installing VScode
To install VScode, you should go to their website and install the optimal version for your machine. Once you open VScode, you should see the integrated terminal which is where you will be running the commands that will be displayed later in the tutorial. 


  ![Screenshot 2023-01-16 at 2 11 17 AM](https://user-images.githubusercontent.com/41757629/212653158-53598e11-cf31-4c47-b53c-cfb60a24a6e1.png)

## Connecting to the Server
To connect to the remote server, use the following commands: 


  ![Screenshot 2023-01-16 at 2 02 35 AM](https://user-images.githubusercontent.com/41757629/212652886-0fb4066c-ff33-4d86-97f8-b260e4503636.png)


The command ssh creates a secure encrypted connection between your computer and the server. You also have to append a specific server address to the ssh command in order to connect to a specific server. In addition, after you send a request to the server, you will be requested to enter a password to gain access. 


## Command Testing
After connecting, feel free to test commands (the following are example commands you can try): 


  ![Screenshot 2023-01-16 at 2 11 49 AM](https://user-images.githubusercontent.com/41757629/212653268-90e26b46-f370-417e-b9e3-3f7d9be5e500.png)


The commands I tested included 'cd' to go to the parent of the current directory. Appending '.' after cd allows you to dictate what directory you will navigate to (backwards). For example, the single '.' (an relative path) will direct you to the current directory, while '..' would direct you to a directory one level up. Furthermore, entering 'ls' will display the contents in the current directory. Appending '-a' to 'ls' also yields a view of the hidden content. 
