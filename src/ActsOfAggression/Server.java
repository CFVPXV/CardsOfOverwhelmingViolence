package ActsOfAggression;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server implements Runnable
{
    private Socket clientCon;
    public Server(Socket c)
    {
        clientCon = c;
    }
    @Override
    public void run()
    {
        try
        {
            Deck gameDeck = new Deck();
            gameDeck.allocStack();
            while(true)
            {
                DataInputStream in = new
                        DataInputStream(clientCon.getInputStream());
                DataOutputStream out = new
                        DataOutputStream(clientCon.getOutputStream());
                out.writeUTF();
            }
            clientCon.close();
        }
        catch(IOException e)
        {
            System.out.println("ERROR ON CLIENT SOCKET: "+e.getMessage());
        }
    }
}

