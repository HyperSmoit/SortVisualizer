package com.company;

import javax.swing.*;
import java.util.ArrayList;
import com.company.Screen;

public class Main {
    private final JFrame window;

    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;
    private final ArrayList<Screen> screens;


    public Main() {
        screens = new ArrayList<>();
        window = new JFrame("Main Menu");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public Screen getCurrentScreen() {
        return screens.get(screens.size() - 1);
    }

    public void pushScreen(Screen screen) {
        if (!screens.isEmpty()) {
            window.remove(getCurrentScreen());
        }
        screens.add(screen);
        window.setContentPane(screen);
        window.validate();
        screen.onOpen();
    }
    public void popScreen() {
        if (!screens.isEmpty()) {
            Screen prev = getCurrentScreen();
            screens.remove(prev);
            window.remove(prev);
            if (!screens.isEmpty()) {
                Screen current = getCurrentScreen();
                window.setContentPane(current);
                window.validate();
                current.onOpen();
            }
            else {
                window.dispose();
            }
        }
    }


    public void start() {
        pushScreen(new MainMenuScreen(this));
        window.pack();
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            new Main().start();
        });
    }
}
