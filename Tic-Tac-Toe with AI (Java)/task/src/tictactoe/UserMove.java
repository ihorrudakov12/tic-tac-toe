package tictactoe;

import java.util.Scanner;

public class UserMove extends Move {
    public static char [][] proceedTheCoordinatesByUser(Scanner scanner, char [][] matrix, char mark) {
        System.out.print("Enter the coordinates: ");
        int x, y;
        String line = scanner.nextLine();
        String [] digits = line.split(" ");
        if (digits[0].matches("[\\d]") && digits[1].matches("[\\d]")) {
            x = Integer.parseInt(digits[0]) - 1;
            y = Integer.parseInt(digits[1]) - 1;
            if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
                if (matrix[x][y] == ' ') {
                    return proceedMove(matrix, x, y, mark);
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    return proceedTheCoordinatesByUser(scanner, matrix, mark);
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                return proceedTheCoordinatesByUser(scanner, matrix, mark);
            }
        } else {
            System.out.println("You should enter numbers!");
            return proceedTheCoordinatesByUser(scanner, matrix, mark);
        }
    }
}
