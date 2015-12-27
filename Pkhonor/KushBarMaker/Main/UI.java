package KushBarMaker.Main;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.core.ui.Logger;
import org.rev317.min.api.methods.Skill;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/* UI.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * UI.java is part of KushBarMaker.
 *
 * KushBarMaker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * KushBarMaker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 *  see http://www.gnu.org/licenses/ for more details.
 */

public class UI extends JFrame {

    private JPanel contentPane;
    private final JLabel HeaderLabel = new JLabel("");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UI frame = new UI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UI() {
        setTitle("Kush Bar Maker");
        setBackground(SystemColor.windowBorder);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.textHighlight);
        panel.setBounds(0, 0, 434, 261);
        contentPane.add(panel);
        panel.setLayout(null);
        HeaderLabel.setBounds(0, 0, 433, 60);
        Image image = null;
        try {
            URL url = new URL("http://i.imgur.com/jvCQek9.png");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HeaderLabel.setIcon(new ImageIcon(image));
        panel.add(HeaderLabel);

        JLabel Barlabel = new JLabel("Wich Bar To Smelt :");
        Barlabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        Barlabel.setBounds(21, 74, 146, 21);
        panel.add(Barlabel);

        final JComboBox<String> BarBox = new JComboBox<>();
        BarBox.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        BarBox.setModel(new DefaultComboBoxModel<>(new String[]{"Bronze", "Iron", "Silver", "Steel", "Gold", "Mithril",
                "Adamant", "Rune"}));
        BarBox.setSelectedIndex(0);
        BarBox.setBounds(177, 71, 232, 32);
        panel.add(BarBox);

        final JComboBox<String> PlaceBox = new JComboBox<>();
        PlaceBox.setModel(new DefaultComboBoxModel<>(new String[]{"Smithing Teleport", "Skilling Zone",
                "SuperHeat (Must have FireStaff Equiped)"}));
        PlaceBox.setSelectedIndex(0);
        PlaceBox.setBackground(SystemColor.controlShadow);
        PlaceBox.setBounds(177, 114, 232, 32);
        panel.add(PlaceBox);

        JButton StartButton = new JButton("Start");
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int OreSelect = BarBox.getSelectedIndex();
                switch (OreSelect) {
                    case 0:
                        Variables.SetOreAmount(14);
                        Variables.SetResOreAmount(14);
                        Variables.SetOre(Constants.COPPER_ORE);
                        Variables.SetOreRes(Constants.TIN_ORE);
                        Variables.SetSelectedBar(0);
                        Variables.SetBar(Constants.BRONZE_BAR);
                        break;
                    case 1:
                        Variables.SetOreAmount(28);
                        Variables.SetOre(Constants.IRON_ORE);
                        Variables.SetSelectedBar(1);
                        Variables.SetBar(Constants.IRON_BAR);
                        Variables.SetOreAmountMagic(27);
                        Variables.SetCoalAmountMagic(0);
                        break;
                    case 2:
                        Variables.SetOreAmount(28);
                        Variables.SetOre(Constants.SILVER_ORE);
                        Variables.SetSelectedBar(2);
                        Variables.SetBar(Constants.SILVER_BAR);
                        Variables.SetOreAmountMagic(27);
                        Variables.SetCoalAmountMagic(0);
                        break;
                    case 3:
                        Variables.SetOreAmount(9);
                        Variables.SetCoalAmount(18);
                        Variables.SetOre(Constants.IRON_ORE);
                        Variables.SetSelectedBar(3);
                        Variables.SetBar(Constants.STEEL_BAR);
                        Variables.SetOreAmountMagic(13);
                        Variables.SetCoalAmountMagic(13);
                        break;
                    case 4:
                        Variables.SetOreAmount(28);
                        Variables.SetOre(Constants.GOLD_ORE);
                        Variables.SetSelectedBar(4);
                        Variables.SetBar(Constants.GOLD_BAR);
                        Variables.SetOreAmountMagic(27);
                        Variables.SetCoalAmountMagic(0);
                        break;
                    case 5:
                        Variables.SetOreAmount(9);
                        Variables.SetCoalAmount(18);
                        Variables.SetOre(Constants.MITHRIL_ORE);
                        Variables.SetSelectedBar(5);
                        Variables.SetBar(Constants.MITHRIL_BAR);
                        Variables.SetOreAmountMagic(9);
                        Variables.SetCoalAmountMagic(18);
                        break;
                    case 6:
                        Variables.SetOreAmount(7);
                        Variables.SetCoalAmount(21);
                        Variables.SetOre(Constants.ADAMANT_ORE);
                        Variables.SetSelectedBar(6);
                        Variables.SetBar(Constants.ADAMANT_BAR);
                        Variables.SetOreAmountMagic(6);
                        Variables.SetCoalAmountMagic(18);
                        break;
                    case 7:
                        Variables.SetOreAmount(5);
                        Variables.SetCoalAmount(20);
                        Variables.SetOre(Constants.RUNE_ORE);
                        Variables.SetSelectedBar(7);
                        Variables.SetBar(Constants.RUNE_BAR);
                        Variables.SetOreAmountMagic(5);
                        Variables.SetCoalAmountMagic(20);
                        break;
                    default:
                        Logger.addMessage("Something went wrong please contact the developer.",true);
                }
                int Place = PlaceBox.getSelectedIndex();
                switch (Place) {
                    case 0:
                        Variables.SetPlace(0);
                        break;
                    case 1:
                        Variables.SetPlace(1);
                        break;
                    case 2:
                        Variables.SetPlace(2);
                        break;
                    default:
                       Logger.addMessage("Something went wrong please contact the developer.",true);
                }
                Variables.SetStartLevel(Skill.SMITHING.getLevel());
                UI.this.setVisible(false);
                UI.this.dispose();
            }
        });

        StartButton.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        StartButton.setBounds(46, 181, 353, 69);
        panel.add(StartButton);

        JLabel lblLocationToSmelt = new JLabel("Location To Smelt");
        lblLocationToSmelt.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblLocationToSmelt.setBounds(21, 121, 146, 21);
        panel.add(lblLocationToSmelt);



        JLabel NoteLael = new JLabel("Note: you need 80 Smithing,Fishing,Woodcutting and Firemaking when using Skilling zone");
        NoteLael.setBounds(10, 152, 433, 18);
        panel.add(NoteLael);

    }
}
