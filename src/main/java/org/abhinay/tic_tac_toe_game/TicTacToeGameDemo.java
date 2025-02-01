package org.abhinay.tic_tac_toe_game;

public class TicTacToeGameDemo {
    public void run() {
        TicTacToeGame ticTacToeGame = TicTacToeGame.getInstance();
        ticTacToeGame.assignFirstChance(1);
        ticTacToeGame.play();
    }
}
