package caro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaroApp {
    private static final int CARO_SIZE    = 20;
    private static final int CARO_DEFAULT = 0;
    private static final int CARO_O       = 1;                            // "o"
    private static final int CARO_X       = 2;                            // "x"

    private static int[][]   caroBoard    = new int[CARO_SIZE][CARO_SIZE];

    private static int       ai;
    private static int       human;
    private static boolean   isFirstInput = true;

    public static void main(String[] args) {

        while (true) {
            printCaroBoard(caroBoard);
            System.out.println("*****\nInput next move:\n 1. x or o\n 2. X =? \n 3. Y = ?\n*****\n Input (ex: x,1,2):");
            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String inputStr = bufferRead.readLine();

                moveFromInput(inputStr);

                NextMove nextMove = CaroAI.getNextMove(caroBoard, ai, human);
                printNextMove(nextMove);

                move(nextMove);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void moveFromInput(String inputStr) {
        String[] input = inputStr.split(",");
        NextMove nextMove = null;

        switch (input[0]) {
        case "o":
            nextMove = new NextMove(CARO_O, Integer.parseInt(input[1]) - 1, Integer.parseInt(input[2]) - 1);
            if (isFirstInput){
                ai = CARO_X;
                human = CARO_O;
                isFirstInput = false;
            }
            break;
        case "x":
            nextMove = new NextMove(CARO_X, Integer.parseInt(input[1]) - 1, Integer.parseInt(input[2]) - 1);
            if (isFirstInput){
                ai = CARO_O;
                human = CARO_X;
                isFirstInput = false;
            }
            break;
        default:
            break;
        }

        if (nextMove != null) {
            move(nextMove);
        }
    }

    private static void move(NextMove nextMove) {
        caroBoard[nextMove.getX()][nextMove.getY()] = nextMove.getVal();
    }

    private static void printNextMove(NextMove nextMove) {
        System.out.println("Next move: type = " + nextMove.getVal() + ", x = " + nextMove.getX() + ", y = " + nextMove.getY());
        System.out.println("--------------------------------------------------");
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
                case CARO_DEFAULT:
                    System.out.print(".  ");
                    break;
                case CARO_O:
                    System.out.print("o  ");
                    break;
                case CARO_X:
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
