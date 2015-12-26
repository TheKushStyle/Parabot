package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;

public class BankingMagic implements Strategy {
    @Override
    public boolean activate() {
        return (Variables.GetPlace() == 2 && !Inventory.contains(Variables.GetOre()));
    }

    @Override
    public void execute() {
        if (Bank.getBank() != null){
            Bank.open();
            Time.sleep(() -> Game.getOpenInterfaceId() == 23350,5000);
            if (Game.getOpenInterfaceId() == 23350){
                Variables.GainedAmount = Variables.GainedAmount + Inventory.getCount(Variables.GetBar());
                Time.sleep(200);
                if(Inventory.contains(Variables.GetBar())){
                    Menu.sendAction(432,Variables.GetBar() -1,Inventory.getItem(Variables.GetBar()).getSlot(),5064,2);
                }
            }
            Time.sleep(() -> !Inventory.contains(Variables.GetBar()),4000);

            Time.sleep(300);
            if(Variables.GetSelectedBar() == 0 && Inventory.isEmpty() ){
                Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount() -1));
                Time.sleep(() -> Inventory.getCount(Variables.GetOre()) > 0,3000);
                Time.sleep(900);
                Menu.sendAction(431, Variables.GetReserveOre(), getBankSlot(Variables.GetReserveOre() -1), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetReserveOreAmount()));
                Time.sleep(() -> (Inventory.getCount(Variables.GetReserveOre()) > 0), 3000);
            }
            else if (Inventory.contains(Constants.NatureRune)){
                Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmountMagic()));
                Time.sleep(() -> (Inventory.getCount(Variables.GetOre()) > 0), 3000);
                Time.sleep(900);
                Menu.sendAction(431, Constants.CoalOre, getBankSlot(Constants.CoalOre), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetCoalAmountMagic()));
                Time.sleep(() -> (Inventory.getCount(Constants.CoalOre) > 0), 5000);
            }
            Menu.sendAction(200,451,0,5384,1);
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
