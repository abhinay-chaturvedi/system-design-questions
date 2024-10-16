package org.abhinay.tic_tac_toe_game;

import java.util.Scanner;

public class TicTacToeGame {
    private Player player1;
    private Player player2;
    private Player currPlayer;
    private Board board;
    private static TicTacToeGame instance;
    public static TicTacToeGame getInstance() {

        if(instance == null) {
            instance = new TicTacToeGame();
        }

        return instance;
    }
    private  TicTacToeGame() {
        player1 = new Player("abhinay", 'X');
        player2 = new Player("anuj", 'O');
        this.board = new Board();
    }
    public void assignFirstChance(int num) {
        if(num == 1) currPlayer = this.player1;
        else currPlayer = this.player2;
    }
    public void play() {
        board.printBoard();

        while (!board.isFull() && !board.hasWinner()) {
            System.out.println(this.currPlayer.getName() + "'s turn.");
            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");

            try {
                board.makeMove(row, col, currPlayer.getSymbol());
                board.printBoard();
                switchPlayer();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (board.hasWinner()) {
            switchPlayer();
            System.out.println(currPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
    public void switchPlayer() {
        this.currPlayer = (this.currPlayer == this.player1? this.player2: this.player1);
    }
    public int getValidInput(String text) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println(text);
            if(sc.hasNextInt()) {
                int input = sc.nextInt();
                System.out.println(input);
                if(input >=0 && input <= 2) return input;
            } else {
                sc.next();
            }
            System.out.println("Please enter valid input!");
        }

    }

}
