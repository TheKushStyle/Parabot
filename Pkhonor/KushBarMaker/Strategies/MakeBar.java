package KushBarMaker.Strategies;


import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.SceneObject;

public class MakeBar implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.contains(Variables.GetOre()) && Players.getMyPlayer().getAnimation() == -1;
    }

    @Override
    public void execute() {
        SceneObject[] Furnace = SceneObjects.getNearest(Constants.Furnace);

        if (Inventory.contains(Variables.GetOre()) && Furnace != null){
            Furnace[0].interact(SceneObjects.Option.FIRST);
            Time.sleep(() -> Game.getOpenBackDialogId() == Constants.BarDialog,5600);
        if (Game.getOpenBackDialogId() == Constants.BarDialog){
            Time.sleep(200);
            switch (Variables.GetSelectedBar()) {
                case 0:
                    Menu.sendAction(315, 87359488, 48, 2414, 1);
                    Time.sleep(400);
                    break;
                case 1:
                    Menu.sendAction(315, 66404352, 120, 3988, 1);
                    Time.sleep(400);
                    break;
                case 2:
                    Menu.sendAction(315, 9187, 9, 3995, 4);
                    Time.sleep(400);
                    break;
                case 3:
                    Menu.sendAction(315, 66371584, 200, 3996, 1);
                    Time.sleep(400);
                    break;
                case 4:
                    Menu.sendAction(315, 66404352, 279, 4000, 1);
                    Time.sleep(400);
                    break;
                case 5:
                    Menu.sendAction(315, 66404352, 258, 4158, 1);
                    Time.sleep(400);
                    break;
                case 6:
                    Menu.sendAction(315, 66404352, 299, 7442, 1);
                    Time.sleep(400);
                    break;
                case 7:
                    Menu.sendAction(315, 66404352, 305, 7447, 1);
                    Time.sleep(400);
                    break;
                default:
                    System.out.println("Something went wrong please contact the developer.");
                }
            Time.sleep(1200);
            Keyboard.getInstance().sendKeys(String.valueOf(28));
            while (Inventory.contains(Variables.GetOre())){
                Time.sleep(500);
                }
            }
        }
    }
}
