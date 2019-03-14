
package interfaces;


public interface IFacadeServer {
    
    public void StartTCPServer(int port, IReceiver receiver);
    
    public void StopTCPServer();
    
    public void StartUDPServer(int port, IReceiver receiver);
    
    public void StopUDPServer();
    
    public void SendTCPMessage(String message, IMessenger messenger);
    
}
