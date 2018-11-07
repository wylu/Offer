package Offer.Chapter2;

public class MatrixPath {
    private boolean hasPathCore(char[] matrix, int rows, int cols,
                                int i, int j, char[] str,
                                int[] pathLen, boolean[] visited){
        if (pathLen[0] == str.length) return true;
        boolean hasPath = false;
        if (i >= 0 && i < rows && j >= 0 && j < cols
                && matrix[i*cols+j] == str[pathLen[0]]
                && !visited[i*cols+j]){
            pathLen[0]++;
            visited[i*cols+j] = true;

            hasPath = hasPathCore(matrix, rows, cols, i, j-1, str, pathLen, visited)
                    || hasPathCore(matrix, rows, cols, i-1, j, str, pathLen, visited)
                    || hasPathCore(matrix, rows, cols, i, j+1, str, pathLen, visited)
                    || hasPathCore(matrix, rows, cols, i+1, j, str, pathLen, visited);
            if (!hasPath){
                pathLen[0]--;
                visited[i*cols+j] = false;
            }
        }
        return hasPath;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;

        boolean[] visited = new boolean[rows * cols];
        int[] pathLen = new int[1];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (hasPathCore(matrix, rows, cols, i, j, str, pathLen, visited))
                    return true;
            }
        }
        return false;
    }
}
