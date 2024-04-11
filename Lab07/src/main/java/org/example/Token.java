package org.example;

class Token {
    private int number1;
    private int number2;

    public Token(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public Object getNumber1() {
        return this.number1;
    }

    public Object getNumber2() {
        return this.number2;
    }

    @Override
    public String toString() {
        return "(" + number1 + ", " + number2 + ")";
    }
}