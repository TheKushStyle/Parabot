package KushBarMaker.Main;

import KushBarMaker.Data.Variables;
import KushBarMaker.Strategies.*;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/* Main.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * Main.java is part of KushBarMaker.
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

@ScriptManifest(author = "TheKushStyle",name = "Kush Bar Maker",category = Category.SMITHING,version = 1.4,
        description = "Makes Bar's at multiple locations",servers = "Pkhonor")
public class Main extends Script implements Paintable {
    final ArrayList<Strategy> StuffToDO = new ArrayList<>();

    public boolean onExecute() {
        UI GUI;
        GUI = new UI();
        GUI.setVisible(true);
        while (GUI.isVisible()) {
            sleep(20);
        }
        if (Variables.GetPlace() == 0) {
            StuffToDO.add(new MakeBar());
            StuffToDO.add(new Banking());
        }
        if (Variables.GetPlace() == 1) {
            StuffToDO.add(new MakeBarSkill());
            StuffToDO.add(new BankingSkill());
        }
        if (Variables.GetPlace() == 2) {
            StuffToDO.add(new MakeBarMagic());
            StuffToDO.add(new BankingMagic());
        }

        provide(StuffToDO);
        return true;
    }



    @Override
    public void paint(Graphics graphics) {
        final Image imgchat = getImage("http://i.imgur.com/kVXwhJc.png");
        Font font1 = new Font("Rockwell Extra Bold", Font.BOLD, 15);
        graphics.setColor(Color.green);
        graphics.drawImage(imgchat, 0, 337, null);
        graphics.setFont(font1);
        graphics.drawString("Levels Gained: " + Variables.GetGainedLevel(), 300, 400);
        graphics.drawString("Current Level: " + Skill.SMITHING.getLevel(), 300, 420);
        graphics.drawString("Total Produce: " + Variables.GetGainedAmount(), 300, 440);
        graphics.drawString("Total EXP: " + Skill.SMITHING.getExperience(), 300, 460);

    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            return null;
        }
    }
}
