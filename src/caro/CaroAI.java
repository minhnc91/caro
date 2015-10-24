package caro;

public class CaroAI {
    private static final int SCORE_PLUS2  = 10;
    private static final int SCORE_PLUS3  = 100;
    private static final int SCORE_PLUS4  = 1000;
    private static final int SCORE_PLUS5  = 10000;

    private static final int SCORE_MINUS1 = 10;
    private static final int SCORE_MINUS2 = 1000;

    public static NextMove getNextMove(int[][] caroBoard, int ai) {
        int[][] scoreEstimate = estimateScore(caroBoard, ai);
        NextMove bestMove = null;

        // Need ban human move
        bestMove = checkHumanMove(caroBoard, ai);
        if (bestMove != null) {
            return bestMove;
        }

        // Best score
        bestMove = new NextMove(caroBoard[0][0], 1, 1);
        int maxScore = scoreEstimate[0][0];
        for (int i = 0; i < scoreEstimate.length; i++) {
            for (int j = 0; j < scoreEstimate.length; j++) {
                if (maxScore < scoreEstimate[i][j]) {
                    maxScore = scoreEstimate[i][j];
                    bestMove = new NextMove(caroBoard[i][j], i + 1, j + 1);
                }
            }
        }

        return bestMove;
    }

    private static NextMove checkHumanMove(int[][] caroBoard, int ai) {
        // TODO Auto-generated method stub
        return null;
    }

    private static int[][] estimateScore(int[][] caroBoard, int ai) {
        int[][] scoreEstimate = new int[caroBoard.length][caroBoard.length];

        for (int i = 0; i < caroBoard.length; i++) {
            for (int j = 0; j < caroBoard.length; j++) {
                scoreEstimate[i][j] = getScore(caroBoard, i, j, ai);
            }
        }

        return scoreEstimate;
    }

    private static int getScore(int[][] caroBoard, int i, int j, int ai) {
        if (caroBoard[i][j] == 0) {
            return 0;
        }

        int score = 1;

        if (isNearHaveOne(caroBoard, i, j, ai)) {
            score += SCORE_PLUS2;
        }

        if (isNearHaveTwo(caroBoard, i, j, ai)) {
            score += SCORE_PLUS3;
        }

        if (isNearHaveThree(caroBoard, i, j, ai)) {
            score += SCORE_PLUS4;
        }

        if (isNearHaveFour(caroBoard, i, j, ai)) {
            score += SCORE_PLUS5;
        }

        return score;
    }

    private static boolean isNearHaveFour(int[][] caroBoard, int i, int j, int ai) {
        // TODO Auto-generated method stub
        return false;
    }

    private static boolean isNearHaveThree(int[][] caroBoard, int i, int j, int ai) {
        // TODO Auto-generated method stub
        return false;
    }

    private static boolean isNearHaveTwo(int[][] caroBoard, int i, int j, int ai) {
        // TODO Auto-generated method stub
        return false;
    }

    private static boolean isNearHaveOne(int[][] caroBoard, int i, int j, int ai) {
        // TODO Auto-generated method stub
        return false;
    }

}
