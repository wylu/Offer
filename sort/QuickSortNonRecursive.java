package Offer.sort;


import java.util.LinkedList;

public class QuickSortNonRecursive {

    private static int partition(int[] arr, int left, int right){
        int i = left, j = right, base = arr[left], tmp;
        while (i < j){
            while (arr[j] >= base && i < j) j--;
            while (arr[i] <= base && i < j) i++;
            if (i < j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        return i;
    }

    public static void sort(int[] arr, int left, int right){
        if (left >= right) return;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()){
            int end = stack.pop();
            int begin = stack.pop();
            if (begin < end){
                int i = partition(arr, begin, end);
                stack.push(begin);
                stack.push(i-1);
                stack.push(i+1);
                stack.push(end);
            }
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 4, 9, 6, 0, 7, 2, 5, 8};
        for (int e: arr) {
            System.out.print(e + "");
        }
        System.out.println();
        sort(arr, 0, arr.length - 1);
        for (int e: arr) {
            System.out.print(e + "");
        }
        System.out.println();
    }

}
