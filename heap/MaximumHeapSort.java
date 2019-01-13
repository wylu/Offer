package Offer.heap;

import java.util.Arrays;

public class MaximumHeapSort {

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * sinking
     * @param heap The Heap to be adjusted
     * @param i The index of value which need to be sunk
     * @param x The value to be sunk
     * @param size The current valid size of heap
     */
    private static void sinking(int[] heap, int i, int x, int size){
        while (i * 2 + 1 < size){
            int a = i * 2 + 1, b = i * 2 + 2;
            //定位到最大的孩子节点
            if(b < size && heap[b] > heap[a]) a = b;
            //如果当前节点大于等于最大孩子节点，说明调整完毕
            if(heap[a] <= x) break;
            heap[i] = heap[a];
            i = a;
        }
        heap[i] = x;
    }

    /**
     * Build a heap according to an array
     * @param arr An array to form a heap
     */
    private static void buildHeap(int[] arr){
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            sinking(arr, i, arr[i], arr.length);
        }
    }

    /**
     * Heap sort
     * @param arr Unsorted array
     */
    public static void sort(int[] arr){
        //根据无序数组构建二叉堆
        buildHeap(arr);
        //循环删除堆顶元素，移到数组尾部，调节堆产生新的堆顶
        for (int i = arr.length - 1; i > 0; i--){
            //最后一个元素和堆顶元素交换
            swap(arr, i, 0);
            //下沉调整最大堆
            sinking(arr, 0, arr[0], i);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{10, 8, 9, 7, 5, 4, 6, 3, 2};
        MaximumHeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
