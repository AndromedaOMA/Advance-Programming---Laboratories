package org.example;

import java.util.ArrayList;
import java.util.List;

class Bag {
    private final List<Token> bagOfTokens = new ArrayList<>();

    public Bag() {
        bagOfTokens.add(new Token(1, 3));
        bagOfTokens.add(new Token(2, 6));
        bagOfTokens.add(new Token(3, 4));
        bagOfTokens.add(new Token(4, 1));
        bagOfTokens.add(new Token(3, 4));
        bagOfTokens.add(new Token(4, 1));
        bagOfTokens.add(new Token(5, 2));
        bagOfTokens.add(new Token(6, 3));
        System.out.println("Here we got aour bag of tokens" + bagOfTokens);
    }

    public synchronized List<Token> extractTiles(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany && !bagOfTokens.isEmpty(); i++) {
            extracted.add(bagOfTokens.remove(0));
        }
        return extracted;
    }
}