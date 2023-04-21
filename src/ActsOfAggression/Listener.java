package ActsOfAggression;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Listener implements Runnable
{
    ServerSocket serve;
    int maxNumber;
    int numOn;
    ExecutorService connections;
    Socket c;
    public Listener(int port, int max)
    {
        connections = Executors.newFixedThreadPool(max);
        maxNumber = max;
        try
        {
            serve = new ServerSocket(port);
        }
        catch (IOException e )
        {
            System.out.println("ERROR Creating the server: "+e.getMessage());
        }
    }
    @Override
    public void run()
    {
        while(true)
        {
            System.out.println("Waiting for players...");
            try
            {
                if(numOn < 2) {
                    c = serve.accept();
                    numOn++;
                }
                else{
                    throw new RuntimeException("Game has already begun...");
                }
                System.out.println("Client recieved, spawning new server thread!");
                connections.execute(new Server(c));
            }
            catch(IOException e)
            {
                System.out.println("Listener failed: "+e.getMessage());
                try
                {
                    serve.close();
                }
                catch(IOException t)
                {
                    System.out.println("ERROR: Listener was already closed!" +t.getMessage());
                }
                break;
            }
        }
        System.out.println("Server is not longer Listening!");
    }
    public int getMaxConnections()
    {
        return maxNumber;
    }
}
