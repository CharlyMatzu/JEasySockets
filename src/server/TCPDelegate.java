
package server;

import interfaces.IReceiver;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


class TCPDelegate implements Runnable{

    private final Socket client;
    private final IReceiver receiver;
    
    //private ObjectInputStream dataInput;
    private DataInputStream dataInput;
    //private DataOutputStream dataOutput;
    
    public TCPDelegate(Socket client, IReceiver receiver) {
        this.client = client;
        this.receiver = receiver;
    }
    
    @Override
    public void run() {
        process();
    }
    
    private void process(){
        try {
            
            dataInput = new DataInputStream(client.getInputStream());
            //dataOutput = new DataOutputStream(client.getOutputStream());
            //dataInput = new ObjectInputStream(client.getInputStream());
            
            String data = dataInput.readUTF();
            InetAddress address = client.getInetAddress();
            int tcpPort = client.getPort();
            
            this.receiver.NotifyReception(tcpPort, address, data);
            this.client.close();
            
        } catch (IOException ex) {
            Logger.getLogger(TCPDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
