package tictactoe;

public class WinningCombination {
    public static String checkWinningCombination(char [][] matrix) {
        String result = "";
        for (int i = 0; i < 8; i++) {
            String combination = null;
            switch (i) {
                case 0 : combination = String.valueOf(matrix[0][0]) + String.valueOf(matrix[0][1]) + String.valueOf(matrix[0][2]);
                    break;
                case 1 : combination = String.valueOf(matrix[1][0]) + String.valueOf(matrix[1][1]) + String.valueOf(matrix[1][2]);
                    break;
                case 2 : combination = String.valueOf(matrix[2][0]) + String.valueOf(matrix[2][1]) + String.valueOf(matrix[2][2]);
                    break;
                case 3 : combination = String.valueOf(matrix[0][0]) + String.valueOf(matrix[1][0]) + String.valueOf(matrix[2][0]);
                    break;
                case 4 : combination = String.valueOf(matrix[0][1]) + String.valueOf(matrix[1][1]) + String.valueOf(matrix[2][1]);
                    break;
                case 5 : combination = String.valueOf(matrix[0][2]) + String.valueOf(matrix[1][2]) + String.valueOf(matrix[2][2]);
                    break;
                case 6 : combination = String.valueOf(matrix[0][2]) + String.valueOf(matrix[1][1]) + String.valueOf(matrix[2][0]);
                    break;
                case 7 : combination = String.valueOf(matrix[0][0]) + String.valueOf(matrix[1][1]) + String.valueOf(matrix[2][2]);
                    break;
            }
            if (combination.equals("XXX")) {
                result = "X wins";
            } else if (combination.equals("OOO")) {
                result = "O wins";
            }
        }
        int emptyCellCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ') {
                    emptyCellCounter++;
                }
            }
        }
        if (result.equals("") && emptyCellCounter == 0) {
            result = "Draw";
        }
        return result;
    }
}
