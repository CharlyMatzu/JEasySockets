
package server;

import classes.BaseServer;
import interfaces.IReceiver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

class UDPServer extends BaseServer{
    
    private final DatagramSocket server;
    private final DatagramPacket receivePacket;
    private final byte[] receiveData = new byte[1024];
    //private byte[] sendData = new byte[1024];

    public UDPServer(int port, IReceiver receiver) throws SocketException {
        super(port, receiver);
        this.server = new DatagramSocket(port);
        this.receivePacket = new DatagramPacket(receiveData, receiveData.length);
    }
    
    
    @Override
    public void process() {
        try {
            
            // UDP Data
            this.server.receive(receivePacket);
            String sentence = new String( receivePacket.getData() );
            // Communication data
            InetAddress address = receivePacket.getAddress();
            int udpPort = receivePacket.getPort();
            // Notify
            this.receiver.NotifyReception(udpPort, address, sentence);
            
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            // TODO: close
        }
    }

    @Override
    public void closeServer() {
        this.server.close();
    }
    
}
