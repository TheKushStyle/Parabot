import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;
import org.rev317.min.api.wrappers.TilePath;

import java.util.ArrayList;

/**
 * Created by TheKushStyle on 12-12-2015.
 */
@ScriptManifest(author = "TheKushStyle",name = "Memories ShrimpFisher", category = Category.FISHING,version = 1.0,description = "Fishes Shrimps", servers = "Pkhonor")
public class Memories_ShrimpFisher extends Script {
    private final ArrayList<Strategy> StuffToDO = new ArrayList<Strategy>();

    public static int randomInt(){
        java.util.Random randomInt = new java.util.Random();

        int randomNum = randomInt.nextInt((1000) + 1);
        return randomNum;
    }

    public boolean onExecute(){
        StuffToDO.add(new WalkBank());
        StuffToDO.add(new OpenBank());
        StuffToDO.add(new Deposit());
        StuffToDO.add(new CloseBank());
        StuffToDO.add(new WalkSpot());
        StuffToDO.add(new FishShrimp());
        provide(StuffToDO);
        return true;
    }
    public static Tile[] TobankPath = { new Tile(2827,3436,0), new Tile(2815,3436), new Tile(2809,3437,0), new Tile(2809,3439),new Tile(2809,3441)};

    private class WalkBank implements Strategy {
        @Override
        public boolean activate() {
            if (!Bank.isOpen() && Inventory.isFull()){
                return true;
            }
            return false;
        }

        @Override
        public void execute() {
            TilePath ToBank = new TilePath(TobankPath);
            if (ToBank != null && !ToBank.hasReached()){
                ToBank.traverse();
                sleep(6000);
            }
            System.out.print("Walking to bank");
        }
    }

    public SceneObject[] BankBooth = SceneObjects.getNearest(2213);

    private class OpenBank implements Strategy {
        @Override
        public boolean activate() {
            if(!Bank.isOpen() && Inventory.isFull() && BankBooth.length >0 && BankBooth[0].distanceTo() < 2)
            {
                return true;
            }

            return false;
        }

        @Override
        public void execute() {
            BankBooth[0].interact(0);
            sleep(randomInt());
            System.out.print("Opened Bank");
        }
    }

    private class Deposit implements Strategy {
        @Override
        public boolean activate() {
            if (Bank.isOpen() && Inventory.isFull()){
                return true;
            }
            return false;
        }

        @Override
        public void execute() {
        Bank.depositAllExcept(304);
        System.out.print("Deposited");
        sleep(randomInt());
        }
    }

    private class CloseBank implements Strategy {
        @Override
        public boolean activate() {
            if (Bank.isOpen() && Inventory.containts(304) && !Inventory.containts(318)){
                return true;
            }
            return false;
        }

        @Override
        public void execute() {
        Bank.close();
        sleep(randomInt());
        }
    }

    public static Tile[] ToSpotPath = {new Tile(2809,3438,0),new Tile(2812,3435),new Tile(2819,3436),new Tile(2832,3435)};

    private class WalkSpot implements Strategy {
        @Override
        public boolean activate() {
            
            if (!Bank.isOpen() && Inventory.containts(304) && !Inventory.isFull()){
                return true;
            }
            return false;
        }

        @Override
        public void execute() {
            TilePath ToShrimp = new TilePath(ToSpotPath);
            if (ToShrimp != null && !ToShrimp.hasReached()) {
                ToShrimp.traverse();
                sleep(5000);
            }
        }
    }

    private class FishShrimp implements Strategy {
        Npc[] ShrimpSpot = Npcs.getNearest(316);
        @Override
        public boolean activate() {
            if (Inventory.containts(304) && !Inventory.isFull() && Players.getMyPlayer().getAnimation() == -1 && ShrimpSpot != null && ShrimpSpot[0].distanceTo() < 3){
                return true;
            }
            return false;
        }

        @Override
        public void execute() {
        ShrimpSpot[0].interact(0);
        sleep(randomInt());
        }
    }
}
