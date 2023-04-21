package ActsOfAggression;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Stack;

public class Server implements Runnable
{
    //Do client connection count here?
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
            //Move the deck to main!


            //Do:
                //Read card
                //Read response
            //while true
            //DonePlaying == true goes into while
            //Read cards should be in an array or list or queue

            //Also check if user actually has power to play card!
            while(true)
            {
                DataInputStream in = new
                        DataInputStream(clientCon.getInputStream());
                DataOutputStream out = new
                        DataOutputStream(clientCon.getOutputStream());
                if(in.readUTF() == "Q"){
                    break;
                }
                out.writeUTF("NO");
            }
            clientCon.close();
        }
        catch(IOException e)
        {
            System.out.println("ERROR ON CLIENT SOCKET: "+e.getMessage());
        }
    }
}

