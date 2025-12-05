import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * TextServer - A TCP server application that listens for client connections
 * on port 18990 and sends text messages entered by the server operator.
 * 
 * <p>The server supports multiple sequential client connections. After one client
 * disconnects, the server continues listening for new connections. The server
 * sends messages entered via console to the connected client. When the server
 * operator types "goodbye", the server sends this message and closes the current
 * client connection while remaining available for new clients.</p>
 * 
 * <p>This server is designed for network programming lab exercises and includes
 * delays to facilitate Wireshark packet capture analysis.</p>
 * 
 * @author Xin Zheng
 * @partner Independent Work
 */
public class TextServer {
    
    public static void main(String[] args) {
        // Use local loopback address for testing
        int port = 18990;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started, listening on port: " + port);
            System.out.println("Waiting for client connection...");
            
            int clientCount = 0;
            
            // Main server loop - continues indefinitely to accept multiple clients
            while (true) {
                // Accept client connection
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                     Scanner scanner = new Scanner(System.in)) {
                    
                    clientCount++;
                    System.out.println("\n=== Client #" + clientCount + " connected ===");
                    System.out.println("Client address: " + clientSocket.getInetAddress());
                    System.out.println("Client port: " + clientSocket.getPort());
                    System.out.println("Local port: " + clientSocket.getLocalPort());
                    
                    int messageCount = 0;
                    
                    // Communication loop with current client
                    while (true) {
                        System.out.print("\nServer input (type 'goodbye' to end): ");
                        String message = scanner.nextLine();
                        
                        // Send message to client using UTF encoding
                        out.writeUTF(message);
                        out.flush();  // Force immediate transmission
                        messageCount++;
                        
                        System.out.println("Message #" + messageCount + " sent: \"" + message + "\"");
                        
                        // Check if termination message was sent
                        if ("goodbye".equalsIgnoreCase(message.trim())) {
                            System.out.println("\nSent goodbye message, waiting 3 seconds for Wireshark to capture disconnection...");
                            
                            // Add delay for Wireshark to capture TCP FIN packets
                            try {
                                Thread.sleep(3000);  // 3-second delay
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            
                            System.out.println("Closing connection with client...");
                            break;  // Exit client communication loop
                        }
                    }
                    
                    System.out.println("=== Client #" + clientCount + " session ended ===");
                    
                } catch (IOException e) {
                    // Handle individual client connection errors without stopping server
                    System.out.println("Client connection handling exception: " + e.getMessage());
                }
                
                // Server continues to listen for next client
                System.out.println("\nWaiting for next client connection...");
                System.out.println("=================================");
            }
        } catch (IOException e) {
            // Fatal server error - cannot create ServerSocket
            System.err.println("Server startup failed: " + e.getMessage());
        }
    }
}