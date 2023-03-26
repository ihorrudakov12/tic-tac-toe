package tictactoe;

public class Move {
    public static char[][] proceedMove(char [][] matrix, int x, int y, char mark) {
        if (matrix[x][y] == ' ') {
            matrix[x][y] = mark;
        }
        return matrix;
    }
}
