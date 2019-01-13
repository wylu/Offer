package Offer.heap;

import java.util.Arrays;

public class PriorityQueue {

    private static final int DEFAULT_CAPACITY = 16;

    private int[] queue;
    private int size;

    /**
     * Constructs an empty queue with the default capacity.
     */
    public PriorityQueue(){
        this.size = 0;
        this.queue = new int[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty queue with the specified initial capacity.
     * @param capacity the initial capacity of the queue
     */
    public PriorityQueue(int capacity){
        this.size = 0;
        this.queue = (capacity > 0) ? new int[capacity] : new int[DEFAULT_CAPACITY];
    }

    /**
     * floating
     * @param i Index of its own node
     * @param x The value to insert
     */
    private void floating(int i, int x){
        while (i > 0){
            int p = (i - 1) / 2;
            if(queue[p] >= x) break;
            queue[i] = queue[p];
            i = p;
        }
        queue[i] =  x;
    }

    /**
     * sinking
     * @param x The value to move to the root
     */
    private void sinking(int x){
        int i = 0;
        while (2 * i + 1 < size){
            int a = 2 * i + 1, b = 2 * i + 2;
            if(b < size && queue[b] > queue[a]) a = b;
            if(queue[a] <= x) break;
            queue[i] = queue[a];
            i = a;
        }
        queue[i] = x;
    }

    /**
     * Increases the capacity of the queue
     */
    private void resize(){
        this.queue = Arrays.copyOf(this.queue, this.size * 2);
    }

    public void push(int x){
        if(size == queue.length) resize();
        floating(size++, x);
    }

    public int pop(){
        int res = queue[0];
        sinking(queue[--size]);
        return res;
    }

    public int front(){
        return queue[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        PriorityQueue queue = new PriorityQueue();
        for (int e: arr) queue.push(e);
        while (!queue.isEmpty()){
            System.out.print(queue.pop() + " ");
        }
    }

}
