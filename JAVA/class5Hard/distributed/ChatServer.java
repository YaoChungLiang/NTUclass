import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.InetAddress;
/**
 * A multithreaded chat room server. When a client connects the server requests a screen
 * name by sending the client the text "SUBMITNAME", and keeps requesting a name until
 * a unique one is received. After a client submits a unique name, the server acknowledges
 * with "NAMEACCEPTED". Then all messages from that client will be broadcast to all other
 * clients that have submitted a unique screen name. The broadcast messages are prefixed
 * with "MESSAGE".
 *
 * This is just a teaching example so it can be enhanced in many ways, e.g., better
 * logging. Another is to accept a lot of fun commands, like Slack.
 */
public class ChatServer {

    private static Set<String> names = new HashSet<>();
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception {

        System.out.println(new Timestamp(System.currentTimeMillis()) + "> Admin: The chat server is on.");
        ExecutorService pool = Executors.newFixedThreadPool(128);
        /*
        InetAddress ip;
        String hostname = ip.getHostName();
        ip = InetAddress.getLocalHost();
        System.out.println("Your current IP address : " + ip);
        System.out.println("Your current Hostname : " + hostname);
        */
        try (ServerSocket listener = new ServerSocket(9999)) {
            while (true) {
                pool.execute(new Handler(listener.accept()));
            }
        }
        
    }

    private static class Handler implements Runnable {
    	
        private String name;
        private Socket socket;
        private Scanner in;
        private PrintWriter out;

        /**
         * Constructs a handler thread, squirreling away the socket. All the interesting
         * work is done in the run method. Remember the constructor is called from the
         * server's main method, so this has to be as short as possible.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Services this thread's client by repeatedly requesting a screen name until a
         * unique one has been submitted, then acknowledges the name and registers the
         * output stream for the client in a global set, then repeatedly gets inputs and
         * broadcasts them.
         */
        public void run() {
        	
            try {
            	
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                	
                    out.println("SUBMITNAME");
                    name = in.nextLine();
                    
                    if (name == null) {
                    	System.out.println(new Timestamp(System.currentTimeMillis()) + "> Admin: Invalid name. Reject.");
                        return;
                    }
                    
                    synchronized (names) {
                        if (!name.isEmpty() && !names.contains(name)) {
                            names.add(name);
                            System.out.println(new Timestamp(System.currentTimeMillis()) + "> " + name + " has logged in.");
                            break;
                        }
                    }
                    
                }

                out.println("NAMEACCEPTED " + name);
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE " + name + " has joined.");
                }
                writers.add(out);

                while (true) {
                	
                    String input = in.nextLine();
                    if (input.toLowerCase().startsWith("/quit")) {
                        return;
                    }
                    
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                        System.out.println(new Timestamp(System.currentTimeMillis()) + "> " + name + ": " + input);
                    }
                }
                
            } catch (Exception e) {
                System.out.println(e);
            } finally {
            	
                if (out != null) writers.remove(out);
                
                if (name != null) {
                    System.out.println(new Timestamp(System.currentTimeMillis()) + "> " + name + " left.");
                    names.remove(name);
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + " has left.");
                    }
                }
                
                try { socket.close(); } catch (IOException e) {}
            }
        }
    }
}
