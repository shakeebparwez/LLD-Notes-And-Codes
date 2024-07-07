package SnakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(){

        initializeGame();
    }

    private void initializeGame() {

        board = new Board(10, 5,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("Shakeeb", 0);
        Player player2 = new Player("Lovepreet", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame(){

        while(winner == null) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("Player Turn Is: " + playerTurn.id + " Current Position Is: " + playerTurn.currentPosition);

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("Player Turn Is: " + playerTurn.id + " New Position Is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1){

                winner = playerTurn;
            }

        }

        System.out.println("Winner Is: " + winner.id);
    }


    private Player findPlayerTurn() {

        Player playerTurns = playersList.removeFirst();
        playersList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "Ladder" : "Snake";
            System.out.println("Jump Done By: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}

