package net.hydonclient.installer;

import mdlaf.MaterialLookAndFeel;
import net.hydonclient.installer.slide.AbstractSlide;
import net.hydonclient.installer.slide.impl.InstallingSlide;
import net.hydonclient.installer.slide.impl.SettingsSlide;
import net.hydonclient.installer.slide.impl.WelcomeSlide;
import net.hydonclient.installer.utils.SwingUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InstallerMain {

    public static void main(String[] args) {
        InstallerMain.initialize();
    }

    private static JFrame frame;

    private static List<AbstractSlide> slides;
    private static int currentSlide = 0;

    public static int width = 550;
    public static int height = 325;

    private static void initialize() {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException ignored) {
        }

        slides = Arrays.asList(
                new WelcomeSlide(),
                new SettingsSlide(),
                new InstallingSlide()
        );

        frame = new JFrame("Hydon Installer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setLayout(null);

        try {
            frame.setIconImage(ImageIO.read(InstallerMain.class.getResourceAsStream("/icon/logo.png")));
        } catch (IOException ignored) {
        }

        frame.setSize(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dimension.width - width) / 2, (dimension.height - height) / 2);

        SwingUtil.addToolbar(frame);

        advance();

        frame.setVisible(true);
    }

    public static void advance() {
        if (currentSlide + 1 > slides.size())
            return;

        frame.getContentPane().removeAll();

        AbstractSlide requestedSlide = slides.get(currentSlide++);
        requestedSlide.initialize(frame);

        frame.repaint();
    }
}
