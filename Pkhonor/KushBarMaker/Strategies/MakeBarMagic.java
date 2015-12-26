package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;

public class MakeBarMagic implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.contains(Variables.GetOre() )&& Players.getMyPlayer().getAnimation() == -1
                && Inventory.contains(Constants.NatureRune);
    }

    @Override
    public void execute() {
        if (Players.getMyPlayer().getAnimation() == -1){
            Menu.sendAction(543,Variables.GetOre() -1,Inventory.getItem(Variables.GetOre()).getSlot(),3214,1);
            Time.sleep(800);
        }
    }
}
