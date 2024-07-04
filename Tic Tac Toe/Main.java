package TicTacToe;

import TicTacToe.Model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int boardSize = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player("Shakeeb", new PlayingPieceX()));
        players.add(new Player("Lovepreet", new PlayingPieceO()));

        TicTacToeGame game = new TicTacToeGame(players, boardSize);
        System.out.println("Game Winner Is: " + game.startGame());
    }
}


