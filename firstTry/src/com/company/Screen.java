package com.company;

import java.awt.Dimension;
import javax.swing.JPanel;

public abstract class Screen extends JPanel{
    protected Main app;
    public Screen(Main app) {
        this.app = app;
    }
    public Dimension getPreferredSize() {
        return new Dimension(Main.WIN_WIDTH, Main.WIN_HEIGHT);
    }

    public abstract void onOpen();
}
