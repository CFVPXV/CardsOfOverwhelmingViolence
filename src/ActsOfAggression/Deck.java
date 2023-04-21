package ActsOfAggression;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck {

    //Remake this to a class which is serializable?

    private String[] theDeck;
    private boolean isIn[];
    Random rand;
    Stack<String> distroStack;

    Deck(){
        theDeck = new String[18];

        for(int i = 0; i < theDeck.length; i++){
            if(i < 6){
                theDeck[i] = "R of " + (6 - i);
            }
            else if(i < 12){
                theDeck[i] = "P of " + (12 - i);
            }
            else if(i < 18){
                theDeck[i] = "S of " + (18 - i);
            }
        }
    }

    void allocStack(){
        rand = new Random();
        isIn = new boolean[18];
        int i = 0;
        int possible = 0;
        distroStack = new Stack<>();

        while(i < theDeck.length){
            possible = rand.nextInt(18);
            if(isIn[possible] == false) {
                distroStack.push(theDeck[possible]);
                isIn[possible] = true;
                i++;
            }
            else{
                continue;
            }
        }
    }
    void printDeck(){
        for(int i = 0; i < theDeck.length; i++){
            System.out.println(theDeck[i]);
        }
    }

    void printStack(){
        for(int i = 0; i < 18; i++){
            System.out.println(distroStack.pop());
        }
    }

    Stack<String> getDistroStack(){
        return distroStack;
    }

}
