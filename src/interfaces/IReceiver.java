
package interfaces;

import java.net.InetAddress;


public interface IReceiver {
    public void NotifyReception(int port, InetAddress IPAddress, String message);
    
    public void NotifyError(String message);
}
