package net.hydonclient.installer.slide.impl;

import net.hydonclient.installer.InstallerMain;
import net.hydonclient.installer.slide.AbstractSlide;
import net.hydonclient.installer.utils.SwingUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WelcomeSlide extends AbstractSlide {

    @Override
    public void initialize(JFrame frame) {
        try {
            JLabel icon = new JLabel();
            icon.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/icon/logo.png")).getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            icon.setBounds((InstallerMain.width - 100) / 2, 40, 100, 100);
            frame.add(icon);

            JButton continueButton = new JButton("Continue");
            continueButton.setBounds((InstallerMain.width - 120) / 2, 160, 130, 50);
            continueButton.addActionListener(e -> InstallerMain.advance());
            SwingUtil.decorate(continueButton);

            frame.add(continueButton);
        } catch (IOException ignored) {
        }
    }

}
