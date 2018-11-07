package Offer.Chapter4;

import java.util.ArrayList;

public class PrintMatrixClockwisely {
    private void printMatrixInCircle(int[][] matrix, int rows, int cols,
                                     int start, ArrayList<Integer> res) {
        int endX = cols - 1 - start, endY = rows - 1 - start;
        for (int i = start; i <= endX; i++) res.add(matrix[start][i]);
        if (endY > start)
            for (int i = start + 1; i <= endY; i++) res.add(matrix[i][endX]);
        if (endY > start && endX > start)
            for (int i = endX - 1; i >= start; i--) res.add(matrix[endY][i]);
        if (endX > start && endY - start > 1)
            for (int i = endY - 1; i > start; i--) res.add(matrix[i][start]);
    }

    public ArrayList<Integer> printMatrixClockwisely(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length, start = 0;
        while (cols > start * 2 && rows > start * 2)
            printMatrixInCircle(matrix, rows, cols, start++, res);
        return res;
    }
}
