package tictactoe;

public class PrintHelper {
    public static void displayTicTacMatrix(char [][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == '_') {
                    System.out.print("  ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}
