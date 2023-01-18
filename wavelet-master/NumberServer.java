import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;

    public String handleRequest(URI url) { // function for handling a request to join a server given a url.
        if (url.getPath().equals("/")) {
            return String.format("Matthew, Number: %d", num); // if the path is equal to a given string, displays the
                                                              // number
            // (formatted)
        } else if (url.getPath().equals("/increment")) { // if path is equal to the given string, increments the number
                                                         // and tells client it is incremented. Stores value serverside.
            num += 1;
            return String.format("Number incremented!");
        } else { // every other case
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) { // if there is the string in the path then perform the following:
                String[] parameters = url.getQuery().split("="); // stores the parameters around each = sign
                if (parameters[0].equals("count")) { // if the first element in parameters is equal to the string, num
                                                     // is incremented by the second element in parameters. Num is also
                                                     // returned.
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
            return "404 Not Found!"; // error if fails to perform any other tasks
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException { // exception handler
        if (args.length == 0) { // checks if the port exists or not.
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]); // defines the port as the first element in argument.

        Server.start(port, new Handler()); // starts the server on localhost given the specific port.
    }
}
