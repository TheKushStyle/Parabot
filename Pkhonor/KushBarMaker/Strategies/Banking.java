package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.SceneObject;

public class Banking implements Strategy {
    @Override
    public boolean activate() {
        return (Variables.Place == 0 && !Inventory.contains(Variables.GetOre()));
    }

    @Override
    public void execute() {
        if (Bank.getBank() != null){
            Bank.open();
            Time.sleep(() -> Game.getOpenInterfaceId() == 23350,5000);
            if (Game.getOpenInterfaceId() == 23350){
                Variables.GainedAmount = Variables.GainedAmount + Inventory.getCount(Variables.GetBar());
                Time.sleep(200);
                Menu.sendAction(646,556,97,23412,1);
            }
            Time.sleep(() -> {
                return Inventory.isEmpty();
            },4000);

            Time.sleep(300);
            if(Variables.GetSelectedBar() == 0 && Inventory.isEmpty() ){
                Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount()));
                Time.sleep(() -> Inventory.getCount(Variables.GetOre()) > 0,3000);

                Menu.sendAction(431, Variables.GetReserveOre(), getBankSlot(Variables.GetReserveOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetReserveOreAmount()));
                Time.sleep(() -> (Inventory.getCount(Variables.GetReserveOre()) > 0), 3000);
            }
            else if (Inventory.isEmpty()){
                Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount()));
                Time.sleep(() -> (Inventory.getCount(Variables.GetOre()) > 0), 3000);

                Menu.sendAction(431, Constants.CoalOre, getBankSlot(Constants.CoalOre), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetCoalAmount()));
                Time.sleep(() -> (Inventory.getCount(Constants.CoalOre) > 0), 3000);
                }
            Menu.clickButton(5384);
            Time.sleep(() -> Game.getOpenInterfaceId() != 23350,3000);
            }
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
