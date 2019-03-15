
package interfaces;


public interface IFacadeServer {
    
    public void startTCPServer(int port, IReceiver receiver) throws Exception;
    
    public void stopTCPServer() throws Exception;
    
    public void startUDPServer(int port, IReceiver receiver) throws Exception;
    
    public void stopUDPServer() throws Exception;
    
    public void sendTCPMessage(int port, String host, IMessenger messenger, String message) throws Exception;
    
    public void sendUDPMessage(int port, String host, IMessenger messenger, String message) throws Exception;
    
    public void sendUDPBroadcast(int port, String host, IMessenger messenger, String message) throws Exception;
}
