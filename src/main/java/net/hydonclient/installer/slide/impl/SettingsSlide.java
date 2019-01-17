package net.hydonclient.installer.slide.impl;

import net.hydonclient.installer.InstallerMain;
import net.hydonclient.installer.Settings;
import net.hydonclient.installer.slide.AbstractSlide;
import net.hydonclient.installer.utils.SwingUtil;

import javax.swing.*;

public class SettingsSlide extends AbstractSlide {

    @Override
    public void initialize(JFrame frame) {
        JCheckBox optifineCheckbox = new JCheckBox("Use Optifine", Settings.USE_OPTIFINE);
        optifineCheckbox.setBounds(InstallerMain.width / 2 - 150, 50, 300, 20);
        optifineCheckbox.addActionListener(e -> Settings.USE_OPTIFINE = optifineCheckbox.isSelected());
        optifineCheckbox.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(optifineCheckbox);

        JCheckBox betaCheckbox = new JCheckBox("Use Beta", Settings.USE_BETA);
        betaCheckbox.setBounds(InstallerMain.width / 2 - 150, 70, 300, 20);
        betaCheckbox.addActionListener(e -> Settings.USE_BETA = betaCheckbox.isSelected());
        betaCheckbox.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(betaCheckbox);

        JButton continueButton = new JButton("Install Now");
        continueButton.setBounds((InstallerMain.width - 120) / 2, 160, 130, 50);
        continueButton.addActionListener(e -> InstallerMain.advance());
        SwingUtil.decorate(continueButton);
        frame.add(continueButton);
    }
}
