package com.company;

import Algorithm.SortingAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class SortVisScreen extends Screen {
    private final SortArray sortArray;
    private final ArrayList<SortingAlgorithm> sortQueue;

    public SortVisScreen(ArrayList<SortingAlgorithm> algorithms, Main app) {
        super(app);
        setLayout(new BorderLayout());
        sortArray = new SortArray();
        add(sortArray, BorderLayout.CENTER);
        sortQueue = algorithms;
    }

    private void longSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void shuffleAndWait() {
        sortArray.shuffle();
        sortArray.resetColours();
        longSleep();
    }

    public void onOpen() {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                for (SortingAlgorithm algorithm : sortQueue) {
                    shuffleAndWait();

                    sortArray.setName(algorithm.getName());
                    sortArray.setAlgorithm(algorithm);

                    algorithm.runSort(sortArray);
                    sortArray.resetColours();
                    sortArray.highlightArray();
                    sortArray.resetColours();
                    longSleep();
                }
                return null;
            }

            @Override
            public void done() {
                app.popScreen();
            }
        };

        swingWorker.execute();
    }
}
