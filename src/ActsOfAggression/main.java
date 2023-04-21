package ActsOfAggression;

import ActsOfAggression.Deck;

public class main {
    public static void main(String[] args){

        Deck theDeck = new Deck();

        theDeck.printDeck();

        theDeck.allocStack();

        theDeck.printStack();
    }
}
