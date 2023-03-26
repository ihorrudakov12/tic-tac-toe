package tictactoe;

import java.util.Random;

public class ComputerMoveEasy extends Move {

    public static int getRandomDigit() {
        return new Random().nextInt(3);
    }

    public static int [] getRandomIndexes() {
        int x = getRandomDigit();
        int y = getRandomDigit();
        return new int[] {x, y};
    }

    public static char [][] computersTurn(char [][] matrix, char mark) {
        System.out.println("Making move level \"easy\"");
        return proceedTheCoordinatesByComputer(matrix, mark);
    }
    public static char [][] proceedTheCoordinatesByComputer(char [][] matrix, char mark) {
        int x = getRandomIndexes()[0];
        int y = getRandomIndexes()[1];
        if (matrix[x][y] == ' ') {
            return proceedMove(matrix, x, y, mark);
        } else {
            return proceedTheCoordinatesByComputer(matrix, mark);
        }
    }
}
