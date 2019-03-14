
package server;

import classes.BaseServer;
import interfaces.IReceiver;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer extends BaseServer{

    private final ServerSocket server;
    private TCPDelegate delegate;

    public TCPServer(int port, IReceiver receiver) throws IOException {
        super(port, receiver);
        this.server = new ServerSocket(port);
    }

    @Override
    protected void process() {
        try {
            
            System.out.println("-TCP Server- Waiting for clients....");
            // New client connected
            Socket client = server.accept();
            this.delegate = new TCPDelegate(client, this.receiver);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            // TODO: close
        }
    }

    @Override
    protected void closeServer() {
        try {
            this.server.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    
}
