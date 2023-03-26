package tictactoe;

import tictactoe.models.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerMoveMediumLevel extends ComputerMove {
    public static char [][] computersTurn(char [][] matrix, char mark) {
        System.out.println("Making move level \"medium\"");
        char oppositeMark = mark == 'X' ? 'O' : 'X';
        List<String> moveToWin = getPreferableCoordinatesToMove(matrix, mark);
        List<String> moveToBlock = getPreferableCoordinatesToMove(matrix, oppositeMark);
        if (moveToWin.size() > 0) {
            String[] coordinates = moveToWin.stream().findAny().get().split(" ");
            matrix = proceedMove(matrix, Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), mark);
        } else if (moveToBlock.size() > 0) {
            String[] coordinates = moveToBlock.stream().findAny().get().split(" ");
            matrix = proceedMove(matrix, Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), mark);
        } else {
            matrix = proceedTheCoordinatesByComputer(matrix, mark);
        }
        return matrix;
    }

    public static List<String> getPreferableCoordinatesToMove(char [][] matrix, char mark) {
        List<String> coordinates = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String res = checkRowOrColumnWithTheSameChar(matrix, mark, i, true);
            if (!res.equals("")) {
                coordinates.add(res);
            }
        }
        for (int i = 0; i < 3; i++) {
            String res = checkRowOrColumnWithTheSameChar(matrix, mark, i, false);
            if (!res.equals("")) {
                coordinates.add(res);
            }
        }
        String res = checkByDiagonal(matrix, mark, true);
        if (!res.equals("")) {
            coordinates.add(res);
        }
        res = checkByDiagonal(matrix, mark, false);
        if (!res.equals("")) {
            coordinates.add(res);
        }
        return coordinates;
    }

    public static String checkRowOrColumnWithTheSameChar(char [][] matrix, char mark,
                                                              int index, boolean row) {
        int markSum = 0;
        int emptySum = 0;
        String result = "";
        String coor = "";
        for (int i = 0; i < 3; i++) {
            if (row) {
                if (matrix[index][i] == mark) {
                    markSum++;
                }
                if (matrix[index][i] == ' ') {
                    emptySum++;
                    coor = String.valueOf(i);
                }
            } else {
                if (matrix[i][index] == mark) {
                    markSum++;
                }
                if (matrix[i][index] == ' ') {
                    emptySum++;
                    coor = String.valueOf(i);
                }
            }
            if (markSum == 2 && emptySum == 1 && row) {
                result = String.valueOf(index) + " " + coor;
            } else if (markSum == 2 && emptySum == 1 && !row) {
                result = coor + " " + String.valueOf(index);
            }
        }
        return result;
    }
    public static String checkByDiagonal(char [][] matrix, char mark,
                                          boolean left) {
        int markSum = 0;
        int emptySum = 0;
        String result = "";
        String coor = "";
        if (left) {
            for (int i = 0; i < 3; i++) {
                if (matrix[i][i] == mark) {
                    markSum++;
                }
                if (matrix[i][i] == ' ') {
                    emptySum++;
                    coor = String.valueOf(i) + " " + String.valueOf(i);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (matrix[i][2 - i] == mark) {
                    markSum++;
                }
                if (matrix[i][2 - i] == ' ') {
                    emptySum++;
                    coor = String.valueOf(i) + " " + String.valueOf(2 - i);
                }
            }
        }
        if (markSum == 2 && emptySum == 1) {
            result = coor;
        }
        return result;
    }
}
