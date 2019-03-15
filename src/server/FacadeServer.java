
package server;

import classes.BaseClient;
import classes.BaseServer;
import interfaces.IFacadeServer;
import interfaces.IMessenger;
import interfaces.IReceiver;
import java.io.IOException;
import java.net.SocketException;


public class FacadeServer implements IFacadeServer{
    
    private static FacadeServer _instance;
    private BaseServer _tcpServer;
    private BaseClient _tcpClient;
    
    private BaseServer _udpServer;
    private BaseClient _udpClient;
    
    private FacadeServer(){}
    
    public FacadeServer getInstance(){
        if( FacadeServer._instance == null )
            FacadeServer._instance = new FacadeServer();
        
        return FacadeServer._instance;
    }
    
    // TODO: verificar: https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java

    @Override
    public void startTCPServer(int port, IReceiver receiver) throws IOException {
        this._tcpServer = new TCPServer(port, receiver);   
    }

    @Override
    public void stopTCPServer() {
        this._tcpServer.stopServer();
        this._tcpServer = null;
    }

    @Override
    public void startUDPServer(int port, IReceiver receiver) throws SocketException {
        this._udpServer = new UDPServer(port, receiver);
    }

    @Override
    public void stopUDPServer() {
        this._udpServer.stopServer();
        this._udpServer = null;
    }

    @Override
    public void sendTCPMessage(int port, String host, IMessenger messenger, String message) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendUDPMessage(int port, String host, IMessenger messenger, String message) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendUDPBroadcast(int port, String host, IMessenger messenger, String message) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
