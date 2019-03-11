
package interfaces;

public abstract class BaseServer implements Runnable{
    
    protected boolean alive;
    protected IReceiver receiver;
    protected final int port;
    
    public BaseServer(int port, IReceiver receiver){
        this.port = port;
        this.receiver = receiver;
    }
    
    public void startServer(){
        this.alive = true;
        this.run();
    }
    
    public void stopServer(){
        this.alive = false;
    }
    
    public boolean isServerAlive(){
        return this.alive;
    }

    @Override
    public void run(){
        do{
            process();
        }while(alive);
        closeServer();
    }
    
    protected abstract void process();
    
    protected abstract void closeServer();
    
}
