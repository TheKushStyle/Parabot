package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.SceneObject;

public class BankingSkill implements Strategy {
    @Override
    public boolean activate() {
        return (Inventory.containts(Variables.GetBar()) && !Inventory.containts(Variables.GetOre())
                || Inventory.isEmpty());
    }

    @Override
    public void execute() {
        SceneObject[] Chest = SceneObjects.getNearest(Constants.DepositChest);

        Chest[0].interact(0);
        Time.sleep(1000);
        Time.sleep(() -> Game.getOpenInterfaceId() == 23350 && Chest[0].distanceTo() <= 1, 5000);
        Variables.GainedAmount = Variables.GainedAmount + Inventory.getCount(Variables.GetBar());
        Menu.sendAction(646,4587,46,23412,1);
        Time.sleep(1000);
        Time.sleep(() -> !Inventory.containts(Variables.GetBar()), 2000);
        if(Variables.GetSelectedBar() == 0 && !Inventory.containts(Variables.GetBar())){
            Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
            Time.sleep(1000);
            Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount()));
            Time.sleep(() -> (Inventory.getCount(Variables.GetOre()) == Variables.GetOreAmount()), 500);
            Menu.sendAction(431, Variables.GetReserveOre(), getBankSlot(Variables.GetReserveOre()), 5382, 4);
            Time.sleep(1000);
            Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetReserveOreAmount()));
            Time.sleep(1000);
            Time.sleep(() -> (Inventory.getCount(Variables.GetReserveOre()) == Variables.GetReserveOreAmount()), 500);
        }
        else{
            Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
            Time.sleep(1000);
            Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount()));
            Time.sleep(1000);
            Time.sleep(() -> (Inventory.getCount(Variables.GetOre()) == Variables.GetOreAmount()), 1000);
            if(Variables.GetCoalAmount() > 0) {
                Menu.sendAction(431, Constants.CoalOre, getBankSlot(Constants.CoalOre), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetCoalAmount()));
                Time.sleep(500);
                Time.sleep(() -> (Inventory.getCount(Constants.CoalOre) == Variables.GetCoalAmount()), 500);
            }
            Time.sleep(() -> (Inventory.getCount(Constants.CoalOre) == Variables.GetCoalAmount()), 500);
        }
        Menu.sendAction(200,229,5,5384,1);
        Time.sleep(600);
        Time.sleep(() -> !Bank.isOpen(),500);

    }

    public static int getBankSlot(int id) {

        int[] bankIds = Loader.getClient().getInterfaceCache()[5382].getItems();

        for (int i = 0; i < bankIds.length; i++) {
            if (bankIds[i] == id) {
                return i;
            }
        }
        return 0;
    }
}
