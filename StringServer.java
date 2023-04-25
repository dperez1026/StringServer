import java.io.*;
import java.net.*;
import java.util.*;

public class StringServer {
    private static String message = ""; // the running string

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("StringServer running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread thread = new Thread(() -> handleRequest(clientSocket));
            thread.start();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();

            String requestLine = in.readLine();
            String[] requestParts = requestLine.split(" ");
            String method = requestParts[0];
            String path = requestParts[1];
            String query = "";
            int queryStart = path.indexOf('?');
            if (queryStart != -1) {
                query = path.substring(queryStart + 1);
                path = path.substring(0, queryStart);
            }

            if (method.equals("GET") && path.equals("/add-message")) {
                String newMessage = "";
                for (String param : query.split("&")) {
                    String[] parts = param.split("=");
                    String name = parts[0];
                    String value = parts[1];
                    if (name.equals("s")) {
                        newMessage = URLDecoder.decode(value, "UTF-8");
                    }
                }
                message += "\n" + newMessage;
                String response = "HTTP/1.1 200 OK\r\n\r\n" + message;
                out.write(response.getBytes("UTF-8"));
            } else {
                String response = "HTTP/1.1 404 Not Found\r\n\r\n";
                out.write(response.getBytes("UTF-8"));
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
