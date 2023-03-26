package tictactoe;

import java.util.Scanner;

import static tictactoe.PrintHelper.displayTicTacMatrix;
import static tictactoe.UserMove.proceedTheCoordinatesByUser;
import static tictactoe.WinningCombination.checkWinningCombination;

public class Main {
    public static void main(String[] args) {
        entryPoint();
    }

    public static void entryPoint() {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = getTicTacMatrix();
        System.out.print("Input command: ");
        String[] commands = scanner.nextLine().split(" ");
        if (commands.length == 3) {
            if (commands[0].equals("start")) {
                if ((commands[1].contains("user") || commands[1].contains("easy") || commands[1].contains("medium") || commands[1].contains("hard")) ||
                        (commands[2].contains("user") || commands[2].contains("easy") || commands[2].contains("medium") || commands[2].contains("hard"))) {
                    displayTicTacMatrix(matrix);
                    performGameLogic(scanner, matrix, commands[1], commands[2]);
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }

        if (commands.length == 1 && commands[0].equals("exit")) {
        } else {
            System.out.println("Bad parameters!");
            entryPoint();
        }
    }

    public static void performGameLogic(Scanner scanner, char[][] ticTacMatrix,
                                        String firstParam, String secondParam) {
        char[][] matrix;
        int moveCounter = 0;
        String result = "";
        matrix = proceedPlayerMove(scanner, ticTacMatrix, firstParam, 'X');
        displayTicTacMatrix(matrix);
        do {
            matrix = proceedPlayerMove(scanner, ticTacMatrix, secondParam, 'O');
            displayTicTacMatrix(matrix);
            result = checkWinningCombination(matrix);
            System.out.println(result);
            if (!result.equals("")) {
                break;
            }
            matrix = proceedPlayerMove(scanner, ticTacMatrix, firstParam, 'X');
            displayTicTacMatrix(matrix);
            result = checkWinningCombination(matrix);
            System.out.println(result);
            if (!result.equals("")) {
                break;
            }
            System.out.println(checkWinningCombination(matrix));
            moveCounter++;
        } while (moveCounter < 4);
    }

    public static char[][] proceedPlayerMove(Scanner scanner, char[][] ticTacMatrix,
                                         String param, char mark) {
        char [][] matrix = ticTacMatrix;
        int player = mark == 'X' ? 1 : 2;
        if (param.equals("user")) {
            matrix = proceedTheCoordinatesByUser(scanner, matrix, mark);
        } else if(param.equals("easy")) {
            matrix = ComputerMoveEasy.computersTurn(matrix, mark);
        } else if(param.equals("medium")) {
            matrix = ComputerMoveMediumLevel.computersTurn(matrix, mark);
        } else if(param.equals("hard")) {
            ComputerMoveHardLevel.computersTurn(matrix, player);
        }
        return matrix;
    }

    public static char[][] getTicTacMatrix() {
        return new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }
}
