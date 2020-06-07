package com.epam.thread.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {
    private static Logger logger = LogManager.getLogger();
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static final Queue<Transport> queue = new ArrayDeque<>();
    private static int currentSize = 0;
    private static int currentWeight = 0;
    public static final int MAX_SIZE = 500;
    public static final int MAX_WEIGHT = 1000;

    public static Transport take() throws InterruptedException {
        lock.lock();
        Transport temp;
        try {
            while (queue.isEmpty()) {
                logger.info("Queue is empty. Waiting for transports...");
                condition.await();
            }
            temp = queue.poll();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transport # ");
            stringBuilder.append(temp.hashCode());
            stringBuilder.append(" removed from queue");
            logger.info(stringBuilder.toString());
            condition.signalAll();
            return temp;
        } finally {
            lock.unlock();
        }
    }

    public static void put(Transport transport) {
        lock.lock();
        try {
            queue.add(transport);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transport # ")
                    .append(transport.hashCode())
                    .append(" added to queue");
            logger.info(stringBuilder.toString());
            currentSize += transport.getSize();
            currentWeight += transport.getWeight();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void uploadAllCars() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()
                    || (currentSize <= MAX_SIZE
                    || currentWeight <= MAX_WEIGHT)) {
                logger.info("Ferry not full, waiting for transports...");
                condition.await();
            }
            int tempSize = 0;
            int tempWeight = 0;
            while (queue.isEmpty()
                    || (queue.peek().getSize() + tempSize <= MAX_SIZE
                    && queue.peek().getWeight() + tempWeight <= MAX_WEIGHT)) {
                Transport tempTransport = queue.poll();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Transport # ")
                        .append(tempTransport.hashCode())
                        .append(" loaded");
                tempSize += tempTransport.getSize();
                tempWeight += tempTransport.getWeight();
            }
            logger.info("Total size = " + tempSize);
            logger.info("Total weight = " + tempWeight);
            currentSize = 0;
            currentWeight = 0;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
