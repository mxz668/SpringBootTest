package com.xz.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayBlockingQueue<>(6);
        queue.add("1");
        queue.add("2");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
