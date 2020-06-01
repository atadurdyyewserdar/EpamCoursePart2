package com.epam.thread.runner;

import com.epam.thread.entity.FerryLoader;
import com.epam.thread.entity.Transport;
import com.epam.thread.entity.TransportType;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        new Thread(new FerryLoader()).start();
        for (int i = 0; i < 100; i++) {
            new Thread(new Transport(TransportType.HEAVY, random.nextInt(70),
                    random.nextInt(30))).start();
        }
    }
}
