package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;

/* Banking.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * Banking.java is part of KushBarMaker.
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

public class Banking implements Strategy {
    @Override
    public boolean activate() {
        return (Variables.GetPlace() == 0 && !Inventory.contains(Variables.GetOre()));
    }

    @Override
    public void execute() {
        if (Bank.getBank() != null){
            Bank.open();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Game.getOpenInterfaceId() == 23350;
                }
            },5000);
            if (Game.getOpenInterfaceId() == 23350){
                Variables.SetGainedAmount(Variables.GetGainedAmount() + Inventory.getCount(Variables.GetBar()));
                Time.sleep(200);
                Menu.sendAction(646,556,97,23412,1);
            }
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Inventory.isEmpty();
                }
            },4000);

            Time.sleep(300);
            if(Variables.GetSelectedBar() == 0 && Inventory.isEmpty() ){
                Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount() -1));
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Inventory.getCount(Variables.GetOre()) > 0;
                    }
                },3000);

                Menu.sendAction(431, Variables.GetReserveOre(), getBankSlot(Variables.GetReserveOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetReserveOreAmount() -1));
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return (Inventory.getCount(Variables.GetReserveOre()) > 0);
                    }
                }, 3000);
            }
            if (Inventory.isEmpty()){
                Menu.sendAction(431, Variables.GetOre(), getBankSlot(Variables.GetOre()), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetOreAmount()));
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return (Inventory.getCount(Variables.GetOre()) > 0);
                    }
                }, 3000);

                Menu.sendAction(431, Constants.COAL_ORE, getBankSlot(Constants.COAL_ORE), 5382, 4);
                Time.sleep(1200);
                Keyboard.getInstance().sendKeys(String.valueOf(Variables.GetCoalAmount()));
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return (Inventory.getCount(Constants.COAL_ORE) > 0);
                    }
                }, 3000);
                }
            Menu.clickButton(5384);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Game.getOpenInterfaceId() != 23350;
                }
            },3000);
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
