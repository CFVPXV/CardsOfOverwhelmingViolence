package ActsOfAggression;

import ActsOfAggression.Deck;

import java.util.Scanner;

public class main {

    //Could make results
    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        Thread driver = null;
        Deck gameDeck;
        Client client1;
        Client client2;
        
        System.out.println("Client or server?");
        String ech = scnr.next();
        
        if(ech.compareTo("C") == 0){
            System.out.println("Enter Name: ");
            String n = scnr.next();
            System.out.println("Starting Client");
            client1 = new Client("127.0.0.1",9000,n);
            driver = new Thread(new Client("127.0.0.1",9000,n));
            
        } else if (ech.compareTo("S") == 0) {
            //Allocate cards here, and then await for two clients!
            //Must be done before listener is invoked, but after we have declared this a server...
            gameDeck = new Deck();
            gameDeck.allocStack();

            if()

            //In a for loop five times:
            //Then client1.objWriter (or data writer), deck.pop(i)
            //Then client2.objWriter (or data writer), deck.pop(i)
            //We will then just have to find out how to reference our clients! Get socket from client...

            //We wait until both clients are done...
            //Then calculate winner
            //Finally, send results
            //Then tell server to stop
            //THEN we may join the threads
            System.out.println("New game server!");
            try {
                driver = new Thread(new Listener(9000, 2));
            } catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }

        driver.start();

        try {
            driver.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
