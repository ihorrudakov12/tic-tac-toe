import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int digitCount = size * size;
        int [][] matrix = new int[size][size];
        int number;
        int count = 0;
        while (count < digitCount) {
            for (int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    number = scanner.nextInt();
                    matrix[i][j] = number;
                    count++;
                }
            }

        }

        boolean isSymmetric = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                }
            }
        }

        if (isSymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
