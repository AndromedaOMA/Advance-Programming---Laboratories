package org.example;

public class Token {
    public int firstNumber;
    public int lastNumber;

    public Token(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(int lastNumber) {
        this.lastNumber = lastNumber;
    }

    @Override
    public String toString() {
        return "(" + firstNumber + "," + lastNumber + ")";
    }
}
