package com.daddy_support.zombie_survival.game_screen_template;

import com.daddy_support.zombie_survival.game_screen_template.helper.RenderCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DSPanel extends JPanel {

    private RenderCallback renderCallback;
    private BufferedImage bufferedImage;

    public DSPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(true);
    }

    public void createBuffer() {
        bufferedImage = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
    }

    public void setRenderCallback(RenderCallback renderCallback) {
        this.renderCallback = renderCallback;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bufferedImage != null) {
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.clearRect(0,0, getWidth(), getHeight());

            if(renderCallback != null) {
                renderCallback.render(g2d);
            }

            g2d.dispose();
            g.drawImage(bufferedImage, 0, 0, null);
        }
    }
}
