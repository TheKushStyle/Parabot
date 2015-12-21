package KushBarMaker.Main;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JComboBox BarBox = new JComboBox();
        BarBox.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        BarBox.setModel(new DefaultComboBoxModel(new String[] {"Bronze", "Iron", "Silver", "Steel", "Gold", "Mithril", "Adamant", "Rune"}));
        BarBox.setSelectedIndex(0);
        BarBox.setBounds(177, 71, 232, 32);
        panel.add(BarBox);

        JComboBox PlaceBox = new JComboBox();
        PlaceBox.setModel(new DefaultComboBoxModel(new String[] {"Smithing Teleport", "Skilling Zone"}));
        PlaceBox.setSelectedIndex(0);
        PlaceBox.setBackground(SystemColor.controlShadow);
        PlaceBox.setBounds(177, 114, 232, 32);
        panel.add(PlaceBox);

        JButton StartButton = new JButton("Start");
        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int OreSelect = BarBox.getSelectedIndex();
                switch (OreSelect) {
                    case 0:
                        Variables.OreAmount = 12;
                        Variables.ResOreAmount = 12;
                        Variables.Ore = Constants.CopperOre;
                        Variables.OreRes = Constants.TinOre;
                        Variables.SelectedBar = 0;
                        Variables.Bar = Constants.BronzeBar;
                        break;
                    case 1:
                        Variables.OreAmount = 28;
                        Variables.Ore = Constants.IronOre;
                        Variables.SelectedBar = 1;
                        Variables.Bar = Constants.IronBar;
                        break;
                    case 2:
                        Variables.OreAmount = 28;
                        Variables.Ore = Constants.SilverOre;
                        Variables.SelectedBar = 2;
                        Variables.Bar = Constants.SilverBar;
                        break;
                    case 3:
                        Variables.OreAmount = 9;
                        Variables.CoalAmount = 18;
                        Variables.Ore = Constants.IronOre;
                        Variables.SelectedBar = 3;
                        Variables.Bar = Constants.SteelBar;
                        break;
                    case 4:
                        Variables.OreAmount = 28;
                        Variables.Ore = Constants.GoldOre;
                        Variables.SelectedBar = 4;
                        Variables.Bar = Constants.GoldBar;
                        break;
                    case 5:
                        Variables.OreAmount = 9;
                        Variables.CoalAmount = 18;
                        Variables.Ore = Constants.MithrilOre;
                        Variables.SelectedBar = 5;
                        Variables.Bar = Constants.MithrilBar;
                        break;
                    case 6:
                        Variables.OreAmount = 7;
                        Variables.CoalAmount = 22;
                        Variables.Ore = Constants.AdamantOre;
                        Variables.SelectedBar = 6;
                        Variables.Bar = Constants.AdamantBar;
                        break;
                    case 7:
                        Variables.OreAmount = 3;
                        Variables.CoalAmount = 26;
                        Variables.Ore = Constants.RuneOre;
                        Variables.SelectedBar = 7;
                        Variables.Bar = Constants.RuneBar;
                        break;
                    default:
                        System.out.println("Something went wrong please contact the developer.");
                }
                int Place = PlaceBox.getSelectedIndex();
                switch (Place){
                    case 0: Variables.Place = 0;
                        break;
                    case 1: Variables.Place = 1;
                        break;
                    default:
                        System.out.println("Something went wrong please contact the developer.");
                }
                setVisible(false);
                dispose();
            }
        });

        StartButton.setBackground(UIManager.getColor("ComboBox.buttonShadow"));
        StartButton.setBounds(46, 181, 353, 69);
        panel.add(StartButton);

        JLabel lblLocationToSmelt = new JLabel("Location To Smelt");
        lblLocationToSmelt.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        lblLocationToSmelt.setBounds(21, 121, 146, 21);
        panel.add(lblLocationToSmelt);



        JLabel NoteLael = new JLabel("Note: you need 80 Smithing,fishing,woodcutting and firemaking when using Skilling zone");
        NoteLael.setBounds(10, 152, 433, 18);
        panel.add(NoteLael);

    }
}
