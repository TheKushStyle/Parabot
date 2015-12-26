package KushBarMaker.Main;

import KushBarMaker.Data.Variables;
import KushBarMaker.Strategies.*;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;
import org.rev317.min.api.wrappers.SceneObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@ScriptManifest(author = "TheKushStyle" ,name = "Kush Bar Maker",category = Category.SMITHING,version = 1.3,description =
        "Makes Bars",servers = "PkHonor")
public class Main extends Script implements Paintable{
    private final ArrayList<Strategy> StuffToDO = new ArrayList<Strategy>();
    private final Image imgchat = getImage("http://i.imgur.com/kVXwhJc.png");
    public boolean onExecute(){
        UI GUI;
        GUI = new UI();
        GUI.setVisible(true);
        while (GUI.isVisible()){
            sleep(20);
        }
        if (Variables.Place == 0){
            StuffToDO.add(new MakeBar());
            StuffToDO.add(new Banking());
        }
        if (Variables.Place == 1){
            StuffToDO.add(new MakeBarSkill());
            StuffToDO.add(new BankingSkill());
        }
        if (Variables.Place == 2){
            StuffToDO.add(new MakeBarMagic());
            StuffToDO.add(new BankingMagic());
        }

        provide(StuffToDO);
        return true;
    }

    @Override
    public void paint(Graphics graphics) {
        Font font1 = new Font("Rockwell Extra Bold", Font.BOLD, 15);
        graphics.setColor(Color.green);
        graphics.drawImage(imgchat,0,337,null);
        graphics.setFont(font1);
        graphics.drawString("Levels Gained: " + Variables.GetGainedLevel(), 300, 400);
        graphics.drawString("Current Level: " + Skill.SMITHING.getLevel(), 300, 420);
        graphics.drawString("Total Produce: " + Variables.GainedAmount, 300, 440);
        graphics.drawString("Total EXP: " + Skill.SMITHING.getExperience(), 300, 460);

    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }
}
