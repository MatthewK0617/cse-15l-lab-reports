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
To connect to the remote server, use the following commands: 



## Useful Insights

