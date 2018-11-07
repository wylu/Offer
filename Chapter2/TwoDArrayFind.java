package Offer.Chapter2;

public class TwoDArrayFind {
    public boolean find(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new TwoDArrayFind().find(matrix, 7));
    }
}
