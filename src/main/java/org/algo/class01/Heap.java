package org.algo.class01;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 堆的应用，线段最多重合区域，线段的数量
 * @Author cy
 * @Date 2023/6/16 10:07
 **/
public class Heap {
    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        // 默认小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(9);
        System.out.println(minHeap.peek());

        // 创建大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(10);
        maxHeap.add(2);
        maxHeap.add(15);
        maxHeap.add(4);
        System.out.println(maxHeap.peek());
    }
}
