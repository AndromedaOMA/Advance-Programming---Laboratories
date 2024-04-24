package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private List<Token> tokenList;

    public Bag() {
        tokenList = new ArrayList<>();
        tokenList.add(new Token(6, 7));
        tokenList.add(new Token(7, 8));
        tokenList.add(new Token(8, 9));
        tokenList.add(new Token(9, 10));
        tokenList.add(new Token(10, 1));
        tokenList.add(new Token(1, 3));
        tokenList.add(new Token(2, 4));
        tokenList.add(new Token(3, 5));
        tokenList.add(new Token(4, 6));
        tokenList.add(new Token(5, 7));
        tokenList.add(new Token(6, 8));
        tokenList.add(new Token(7, 9));
        tokenList.add(new Token(8, 10));
        tokenList.add(new Token(9, 1));
        tokenList.add(new Token(10, 2));
    }

    public synchronized Token getToken() {
        if (tokenList.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(tokenList.size());
        Token token = tokenList.get(index);
        tokenList.remove(token);
        return token;
    }

    public boolean isEmpty() {
        return tokenList.isEmpty();
    }
}
