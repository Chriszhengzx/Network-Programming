import java.io.*;
import java.net.*;

/**
 * TextClient - A TCP client application that connects to a server on localhost
 * port 18990 and displays messages received from the server.
 * 
 * <p>The client establishes a connection to the specified server and enters
 * a loop to receive and display messages. When the server sends the message
 * "goodbye", the client gracefully terminates the connection and exits.</p>
 * 
 * <p>This client is designed to work with the TextServer application for
 * network programming lab exercises. It uses UTF encoding for reliable
 * text transmission and includes proper error handling for network
 * communication failures.</p>
 * 
 * @author Xin Zheng
 * @partner Independent Work
 */
public class TextClient {  

    public static void main(String[] args) {
        // Connect to local server (loopback address)
        String serverAddress = "127.0.0.1"; // Alternative: "localhost"
        int port = 18990;
        
        System.out.println("Attempting to connect to server at " + serverAddress + ":" + port);
        
        try (Socket socket = new Socket(serverAddress, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            
            System.out.println("Successfully connected to server: " + serverAddress + ":" + port);
            System.out.println("Local port assigned: " + socket.getLocalPort());
            System.out.println("\nWaiting for server messages...");
            
            int messageCount = 0;
            
            // Message reception loop
            while (true) {
                try {
                    // Read UTF-encoded message from server
                    String message = in.readUTF();
                    messageCount++;
                    
                    System.out.println("\n[Message #" + messageCount + "] Server says: " + message);
                    
                    // Check for termination message
                    if ("goodbye".equalsIgnoreCase(message.trim())) {
                        System.out.println("\nReceived goodbye message, terminating connection...");
                        
                        // Optional: Send acknowledgment back to server
                        // out.writeUTF("Client received goodbye");
                        // out.flush();
                        
                        break; // Exit reception loop
                    }
                    
                } catch (EOFException e) {
                    // Server closed the connection unexpectedly
                    System.out.println("\nConnection closed by server (EOF received)");
                    break;
                }
            }
            
        } catch (IOException e) {
            // Handle connection or communication errors
            System.err.println("Client error: " + e.getMessage());
            System.err.println("Error details: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\nClient program terminated");
    }
}