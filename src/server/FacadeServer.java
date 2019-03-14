
package server;

import interfaces.IFacadeServer;
import interfaces.IMessenger;
import interfaces.IReceiver;


public class FacadeServer implements IFacadeServer{
    
    private static FacadeServer instance;
    
    private FacadeServer(){}
    
    public FacadeServer getInstance(){
        if( FacadeServer.instance == null )
            FacadeServer.instance = new FacadeServer();
        
        return FacadeServer.instance;
    }

    @Override
    public void StartTCPServer(int port, IReceiver receiver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void StopTCPServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void StartUDPServer(int port, IReceiver receiver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void StopUDPServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SendTCPMessage(String message, IMessenger messenger) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
