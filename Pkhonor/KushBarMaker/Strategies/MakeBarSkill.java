package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.SceneObject;

/* MakeBarSkill.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * MakeBarSkill.java is part of KushBarMaker.
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

public class MakeBarSkill implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.contains(Variables.GetOre() )&& Players.getMyPlayer().getAnimation() == -1;
    }

    @Override
    public void execute() {
        SceneObject[] Furnace = SceneObjects.getNearest(Constants.FURNACE_SKILL);
        if (Furnace.length >0 && Furnace != null){
            Furnace[0].interact(SceneObjects.Option.FIRST);
            Time.sleep(500);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Game.getOpenBackDialogId() != -1;
                }
            },4000);

            if (Game.getOpenBackDialogId() == 2400){
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
                Time.sleep(1000);
                Keyboard.getInstance().sendKeys(String.valueOf(28));
                Time.sleep(1000);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return !Inventory.contains(Variables.GetOre());
                    }
                },6000);
            }
        }

    }
}
