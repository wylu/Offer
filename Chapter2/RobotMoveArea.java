package Offer.Chapter2;

public class RobotMoveArea {
    private int getDigitSum(int num) {
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private boolean check(int threshold, int rows, int cols,
                          int i, int j, boolean[] visited) {
        return i >= 0 && i < rows && j >= 0 && j < cols
                && getDigitSum(i) + getDigitSum(j) <= threshold
                && !visited[i * cols + j];
    }


    private int movingCountCore(int threshold, int rows, int cols,
                                int i, int j, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, i, j, visited)) {
            visited[i*cols+j] = true;
            count = 1 + movingCountCore(threshold, rows, cols, i, j+1, visited)
                    + movingCountCore(threshold, rows, cols, i+1, j, visited);
        }
        return count;
    }


    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }
}
