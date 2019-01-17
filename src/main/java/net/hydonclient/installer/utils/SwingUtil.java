package net.hydonclient.installer.utils;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.resources.MaterialColors;
import mdlaf.shadows.DropShadowBorder;
import net.hydonclient.installer.InstallerMain;

import javax.swing.*;
import java.awt.*;

public class SwingUtil {

    public static void decorate(JComponent component) {
        component.setBorder(new DropShadowBorder(Color.LIGHT_GRAY, 0, 5));
        MaterialUIMovement.add(component, MaterialColors.BLUE_600);
    }

    public static void addToolbar(JFrame frame) {
        JMenuBar bar = new JMenuBar();
        bar.setSize(InstallerMain.width, 30);
        bar.setLocation(0, 0);
        bar.setLayout(new GridLayout(1, 4));

        JLabel titleLabel = new JLabel("Hydon Installer");
        titleLabel.setSize(200, 30);
        bar.add(titleLabel);

        JSeparator separator = new JSeparator();
        bar.add(separator);
        bar.add(separator);

        JButton closeButton = new JButton("X");
        closeButton.setSize(40, 30);
        closeButton.setBorderPainted(false);
        closeButton.setSelected(false);
        closeButton.addActionListener(e -> System.exit(0));
        SwingUtil.decorate(closeButton);

        bar.add(closeButton);

        frame.setJMenuBar(bar);
    }

}
