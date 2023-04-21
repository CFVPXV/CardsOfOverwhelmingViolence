package ActsOfAggression;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class Client implements Runnable
{
    private String ip;
    private int port;
    private String name;
    Socket con;
    DataInputStream in;
    DataOutputStream out;
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
    @Override
    public void run()
    {
        while(con.isConnected())
        {
            try
            {
                Random r = new Random();
                String nm = "";
                for(int i =0; i < 10; i ++)
                {
                    nm += (char)r.nextInt(); //A-Z
                }
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
