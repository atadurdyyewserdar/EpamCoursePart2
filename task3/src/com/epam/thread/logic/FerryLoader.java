package com.epam.thread.logic;

import com.epam.thread.entity.Ferry;

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
