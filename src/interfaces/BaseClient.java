
package interfaces;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Queue;

// TODO: use generics
public abstract class BaseClient implements Runnable{
    
    protected boolean alive;
    protected IMessenger messenger;
    
    protected Socket serverSocket;
    protected final int port;
    protected final String ipHost;
    
    //protected ObjectOutputStream dataOutput;
    protected DataOutputStream dataOutput;
    protected Queue<String> queue;
    

    public BaseClient(IMessenger messenger, int port, String ipHost) {
        this.messenger = messenger;
        this.port = port;
        this.ipHost = ipHost;
    }
    
    public void startClient(){
        this.alive = true;
        this.run();
    }
    
    public void stopClient(){
        this.alive = false;
    }
    
    public boolean isServerAlive(){
        return this.alive;
    }
    
    public boolean AddMessage(String msg){
        return this.queue.add(msg);
    }

    @Override
    public void run(){
        do{
            // TODO: Improve peek and sleep
            if(this.queue.size() > 0){
                String item = this.queue.peek();
                process(item);
            }
        }while(alive);
    }
    
    protected abstract void process(String item);
    
}
