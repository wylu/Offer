package Offer.Chapter5;

import java.util.PriorityQueue;

public class MedianOfDataStream {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, (o1, o2) -> o2 - o1);

    public void insert(Integer num){
        if (count % 2 == 0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    public Double getMedian(){
        return (count % 2 == 0) ? (maxHeap.peek() + minHeap.peek()) / 2.0 : 1.0 * minHeap.peek();
    }
}
