import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String str = "";

    public String handleRequest(URI url) { // function for handling a request to join a server given a url.
        if (url.getPath().equals("/")) {

        } else {
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                // System.out.println(parameters[1]);
                if (parameters[0].equals("s")) {
                    str += parameters[1];
                    return String.format("String increased by %s! It's now %s", parameters[1], str);
                }
            } else if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                // System.out.println(parameters[1]);
                if (parameters[0].equals("s")) {
                    for (int i = 0; i < parameters.length; i++) {
                        if (parameters[i].contains("apple")) {
                            return parameters[i];
                        }
                    }
                    // return String.format("Found the strings %s", parameters[1], str);
                }
            }
        }
        return "404 Not Found!"; // error if fails to perform any other tasks

    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException { // exception handler
        if (args.length == 0) { // checks if the port exists or not.
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]); // defines the port as the first element in argument.

        Server.start(port, new Handler()); // starts the server on localhost given the specific port.
    }
}
