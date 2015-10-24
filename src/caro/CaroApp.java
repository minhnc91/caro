package caro;

public class CaroApp {
    private static final int CARO_SIZE = 20;
    private static final int CARO_0    = 0;
    private static final int CARO_1    = 1;
    private static final int CARO_2    = 2;

    private static int[][]   caroBoard = new int[CARO_SIZE][CARO_SIZE];

    public static void main(String[] args) {
        printCaroBoard(caroBoard);
        System.out.println("*****\nInput next move:\n 1. x or o\n 2. X =? \n 3. Y = ?\n*****\n Input:");

        NextMove nextMove = CaroAI.getNextMove(caroBoard);
        printNextMove(nextMove);
    }

    private static void printNextMove(NextMove nextMove) {
        System.out.println("Next move: x = " + nextMove.getX() + ", y = " + nextMove.getY());
    }

    private static void printCaroBoard(int[][] caroBoard) {
        System.out.println("***CaroBoard***");
        for (int i = 0; i < CARO_SIZE; i++) {
            // X
            if (i == 0) {
                System.out.print("   ");
                for (int j = 0; j < CARO_SIZE; j++) {
                    System.out.print(j + 1);
                    if (j + 1 < 10) {
                        System.out.print("  ");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }

            for (int j = 0; j < CARO_SIZE; j++) {
                // Y
                if (j == 0) {
                    System.out.print(i + 1);
                    System.out.print("  ");
                }

                switch (caroBoard[i][j]) {
                case CARO_0:
                    System.out.print(".  ");
                    break;
                case CARO_1:
                    System.out.print("o  ");
                    break;
                case CARO_2:
                    System.out.print("x  ");
                    break;
                default:
                    break;
                }
            }
            System.out.print("\n");
        }
    }

}
