package org.abhinay.tic_tac_toe_game;

public class Player {
    private final String name;

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
