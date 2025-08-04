package com.daddy_support.zombie_survival.game_screen_template;

import javax.swing.*;

public class DSRenderFrame {

    private JFrame frame;

    public DSRenderFrame(DSPanel dsPanel, String title, boolean isResizable) {
        frame = new JFrame();
        frame.add(dsPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(isResizable);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
    }

    public void show() {
        frame.setVisible(true);
    }
}
