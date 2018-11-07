package Offer.heap;

public class MinimumHeap {

    private int[] heap;
    private int size = 0;

    /**
     * Creates a heap of specified capacity
     * @param heapMaxSize The maximum capacity of the initialization heap
     */
    public MinimumHeap(int heapMaxSize){
        heap = new int[heapMaxSize];
    }

    /**
     * floating
     * @param i Index of its own node
     * @param x The value to insert
     */
    private void floating(int i, int x){
        while (i > 0){
            //父节点的索引下标
            int p = (i - 1) / 2;
            //如果已经没有大小颠倒则退出
            if(heap[p] <= x) break;
            //把父亲节点的数值放下来，而把自己提上去
            heap[i] = heap[p];
            i = p;
        }
        heap[i] = x;
    }

    /**
     * sinking
     * @param x The value to move to the root
     */
    private void sinking(int x){
        int i = 0;
        while (i * 2 + 1 < size){
            //比较子节点的值
            int a = i * 2 + 1, b = i * 2 + 2;
            if(b < size && heap[b] < heap[a]) a = b;
            //如果已经没有大小颠倒则退出
            if(heap[a] >= x) break;
            //把子节点的数值提上来
            heap[i] = heap[a];
            i = a;
        }
        heap[i] = x;
    }

    public void push(int x){
        floating(size++, x);
    }

    public int pop(){
        int res = heap[0];
        sinking(heap[--size]);
        return res;
    }

    public int top(){
        return heap[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        MinimumHeap heap = new MinimumHeap(arr.length + 1);
        for (int e: arr) heap.push(e);
        while (!heap.isEmpty()){
            System.out.print(heap.pop() + " ");
        }
    }

}
