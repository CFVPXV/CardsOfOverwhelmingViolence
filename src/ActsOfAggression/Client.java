package ActsOfAggression;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client implements Runnable
{
    private String ip;
    private int port;
    private String name;
    Socket con;
    DataInputStream in;
    DataOutputStream out;
    Scanner scnr;
    public Client(String i, int p, String n)
    {
        name = n;
        ip = i;
        port = p;
        try
        {
            System.out.println("Connecting to Server.");
            con = new Socket(ip,port);
            in = new DataInputStream(con.getInputStream());
            out = new DataOutputStream(con.getOutputStream());
        }
        catch (IOException e)
        {
            System.out.println("ERROR CONNECTING AS A CLIENT! "+e.getMessage());
        }
    }

    Socket getCon(){
        return con;
    }
    @Override
    public void run()
    {
        while(con.isConnected())
        {
            try
            {
                //Instead of waiting for the other client, await for five cards! Then when the server dists cards,
                //we know another client is connected
                scnr = new Scanner(System.in);
                //Then do-while and select card, send card, play again?
                //send response
                //Wait for result (points calculation)
                //Print result
                //Done
                System.out.println("Anything to say?");
                //Could possibly send a serializable object with data, either way
                String nm = scnr.nextLine();
                System.out.println("Sending Message: "+nm+" <"+name+">");
                out.writeUTF(nm+" <"+name+">");
                System.out.println("Read from server! "+in.readUTF());
            }
            catch(IOException e)
            {
                System.out.println("ERROR with client! "+e.getMessage());
            }
        }
    }
}
