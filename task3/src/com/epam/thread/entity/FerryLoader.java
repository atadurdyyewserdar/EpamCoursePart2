package com.epam.thread.entity;

public class FerryLoader implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Ferry.uploadAllCars();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
