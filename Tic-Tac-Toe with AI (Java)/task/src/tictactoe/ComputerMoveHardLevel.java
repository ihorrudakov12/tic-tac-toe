package tictactoe;

import java.util.ArrayList;
import java.util.List;

import static tictactoe.WinningCombination.checkWinningCombination;

public class ComputerMoveHardLevel extends MoveModel {

    public static void computersTurn(char[][] matrix, int player) {
        System.out.println("Making move level \"hard\"");

        char symbol = ' ';
        if (player == 1) {
            symbol = 'X';
        } else if (player == 2) {
            symbol = 'O';
        }
        MoveModel bestMove = minimax(matrix, player, player);
        matrix[bestMove.index[0]][bestMove.index[1]] = symbol;
    }
    private static MoveModel minimax(char[][] matrix, int callingPlayer, int currentPlayer) {
        char enemySymbol = ' ';
        char callingSymbol = ' ';
        if (callingPlayer == 1) {
            callingSymbol = 'X';
            enemySymbol = 'O';
        } else if (callingPlayer == 2) {
            callingSymbol = 'O';
            enemySymbol = 'X';
        }

        char symbol = ' ';
        int enemyNumber = 0;
        if (currentPlayer == 1) {
            symbol = 'X';
            enemyNumber = 2;
        } else if (currentPlayer == 2) {
            symbol = 'O';
            enemyNumber = 1;
        }

        // find available spots
        int[][] availableSpots = emptyIndexes(matrix);

        if (!checkWinningCombination(matrix).equals("")) {
            if (!areThereEmptyIndexes(matrix)) {
                return new MoveModel(0);
            } else if (checkWinningCombination(matrix).toCharArray()[0] == enemySymbol) {
                return new MoveModel(-10);
            } else if (checkWinningCombination(matrix).toCharArray()[0] == callingSymbol) {
                return new MoveModel(10);
            }
        }

        List<MoveModel> moves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (availableSpots[i][j] == 1) {
                    // let's make a possible move
                    MoveModel move = new MoveModel();
                    move.index = new int[]{i, j};
                    matrix[i][j] = symbol;
                    MoveModel result = minimax(matrix, callingPlayer, enemyNumber);
                    // save the score for the minimax
                    move.score = result.score;
                    // then revert the occupied place back to empty, so next guesses can go on
                    matrix[i][j] = ' ';
                    moves.add(move);
                }
            }
        }

        // when the moves loop has ended, choose the move with the highest score
        int bestMove = 0;

        if (currentPlayer == callingPlayer) {
            int bestScore = -10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        } else {
            int bestScore = 10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        }

        // minimax returns the best move to the latest function caller
        return moves.get(bestMove);
    }


    private static int[][] emptyIndexes(char[][] stato) {
        int[][] empties = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (stato[i][j] == ' ') {
                    empties[i][j] = 1;
                } else {
                    empties[i][j] = 0;
                }
            }
        }
        return empties;
    }

    private static boolean areThereEmptyIndexes(char[][] stato) {
        boolean empties = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (stato[i][j] == ' ') {
                    empties = true;
                }
            }
        }
        return empties;
    }
}

class MoveModel {
    int[] index;
    int score;

    MoveModel() {

    }

    MoveModel(int s) {
        score = s;
    }
}
