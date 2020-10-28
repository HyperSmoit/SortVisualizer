package com.company;

import Algorithm.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public final class MainMenuScreen extends Screen {
    private static final Color BACKGROUND_COLOUR = new Color(12, 140, 134);
    private final ArrayList<AlgorithmRadioBox> radioBoxes;


    public MainMenuScreen(Main app) {
        super(app);
        radioBoxes = new ArrayList<>();
        setUpGUI();
    }

    private void addRadioBox(SortingAlgorithm algorithm, JPanel panel) {
        JRadioButton box = new JRadioButton("", true);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.setBackground(BACKGROUND_COLOUR);
        box.setForeground(Color.BLACK);
        radioBoxes.add(new AlgorithmRadioBox(algorithm, box));
        panel.add(box);
    }

    private void initContainer(JPanel p) {
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(BACKGROUND_COLOUR);
    }

    public void setUpGUI() {
        JPanel sortAlgorithmContainer = new JPanel();
        JPanel optionsContainer = new JPanel();
        JPanel outerContainer = new JPanel();
        initContainer(this);
        initContainer(optionsContainer);
        initContainer(sortAlgorithmContainer);

        outerContainer.setBackground(BACKGROUND_COLOUR);
        outerContainer.setLayout(new BoxLayout(outerContainer, BoxLayout.LINE_AXIS));

        sortAlgorithmContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRadioBox(new BubbleSort(),       sortAlgorithmContainer);
        addRadioBox(new SelectionSort(),    sortAlgorithmContainer);
        addRadioBox(new QuickSort(),        sortAlgorithmContainer);
        addRadioBox(new MergeSort(),        sortAlgorithmContainer);
        addRadioBox(new InsertionSort(),    sortAlgorithmContainer);

        JButton startButton = new JButton("Begin Visual Sorter");
        startButton.addActionListener((ActionEvent e) -> {
            ArrayList<SortingAlgorithm> algorithms = new ArrayList<>();
            for (AlgorithmRadioBox cb : radioBoxes) {
                if (cb.isSelected()) {
                    algorithms.add(cb.getAlgorithm());
                }
            }
            app.pushScreen(
                    new SortVisScreen(
                            algorithms,
                            app
                    ));
        });
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        outerContainer.add(optionsContainer);
        outerContainer.add(Box.createRigidArea(new Dimension(5,0)));
        outerContainer.add(sortAlgorithmContainer);

        int gap = 15;
        add(Box.createRigidArea(new Dimension(0, gap)));
        add(outerContainer);
        add(Box.createRigidArea(new Dimension(0, gap)));
        add(startButton);
    }

    @Override
    public void onOpen() {
        radioBoxes.forEach((box) -> {
            box.unselect();


        });

    }

    private class AlgorithmRadioBox {
        private final SortingAlgorithm algorithm;
        private final JRadioButton box;

        public AlgorithmRadioBox(SortingAlgorithm algorithm, JRadioButton box) {
            this.algorithm = algorithm;
            this.box = box;
            this.box.setText(algorithm.getName());
        }

        public void unselect() {
            box.setSelected(false);
        }


        public boolean isSelected() {
            return box.isSelected();
        }

        public SortingAlgorithm getAlgorithm() {
            return algorithm;
        }
    }

}
