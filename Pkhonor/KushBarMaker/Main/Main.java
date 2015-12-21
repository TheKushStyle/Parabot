package KushBarMaker.Main;

import KushBarMaker.Data.Variables;
import KushBarMaker.Strategies.*;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@ScriptManifest(author = "TheKushStyle" ,name = "Kush Bar Maker",category = Category.SMITHING,version = 1.2,description =
        "Makes Bars",servers = "PkHonor")
public class Main extends Script implements Paintable{
    private final ArrayList<Strategy> StuffToDO = new ArrayList<Strategy>();
    private final Image imgchat = getImage("http://i.imgur.com/u67eOA7.png");
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

        provide(StuffToDO);
        return true;
    }

    @Override
    public void paint(Graphics graphics) {
        Font font1 = new Font("Rockwell Extra Bold", Font.BOLD, 15);
        graphics.setColor(Color.green);
        graphics.drawImage(imgchat,0,337,null);
        graphics.setFont(font1);
        graphics.drawString("Total Produce: " + Variables.GainedAmount, 332, 420);

    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }
}
