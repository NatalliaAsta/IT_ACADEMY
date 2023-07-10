package lesson5.main;

import lesson5.matrix.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] twoDimMatrix;
        twoDimMatrix = Matrix.create();
        Matrix.print(twoDimMatrix);

        Matrix.equalDiagonals(twoDimMatrix);

        String[] diagonalsArray = Matrix.diagonalsToArray(twoDimMatrix);
        Matrix.print(diagonalsArray);

        Matrix.performArray(diagonalsArray, Matrix.START_POSITION, Matrix.FINISH_POSITION, Matrix.FOR_COMPARE);
    }
}
