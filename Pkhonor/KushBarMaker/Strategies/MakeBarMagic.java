package KushBarMaker.Strategies;

import KushBarMaker.Data.Constants;
import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;

/* MakeBarMagic.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * MakeBarMagic.java is part of KushBarMaker.
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

public class MakeBarMagic implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.contains(Variables.GetOre() )&& Players.getMyPlayer().getAnimation() == -1
                && Inventory.contains(Constants.NATURE_RUNE);
    }

    @Override
    public void execute() {
        if (Players.getMyPlayer().getAnimation() == -1){
            Menu.sendAction(543,Variables.GetOre() -1,Inventory.getItem(Variables.GetOre()).getSlot(),3214,1);
            Time.sleep(800);
        }
    }
}
