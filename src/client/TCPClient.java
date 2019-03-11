
package client;

import interfaces.BaseClient;
import interfaces.IMessenger;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class TCPClient extends BaseClient{

    public TCPClient(IMessenger messenger, int port, String ipHost) {
        super(messenger, port, ipHost);
    }

    @Override
    protected void process(String item) {
        try {
            
            this.serverSocket = new Socket(ipHost, port);
            this.dataOutput = new DataOutputStream( this.serverSocket.getOutputStream() );
            dataOutput.writeUTF( item );
            
        } catch (IOException e) {
            this.serverSocket = null;
            this.dataOutput = null;
            this.messenger.NotifyError(e.getMessage());
        }
    }
}
