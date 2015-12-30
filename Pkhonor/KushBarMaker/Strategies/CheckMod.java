package KushBarMaker.Strategies;

import KushBarMaker.Data.Variables;
import org.parabot.environment.api.utils.Filter;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Player;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* CheckMod.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * CheckMod.java is part of KushBarMaker.
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
public class CheckMod implements Strategy {
    private static ArrayList<String> staffNames = new ArrayList<String>();
    private static String staffName;

    @Override
    public boolean activate() {
        return checkMod();
    }

    @Override
    public void execute() {
        dropClient();
        Variables.SetResetAmount(Variables.GetResetAmount() +1);
        Time.sleep(60000);
        Mouse.getInstance().click(283,311,true);
    }
    public static final List<String> Mods = Arrays.asList("Mike","Rapsey","Donderstone2","Billy","Ryan","Mitchel",
            "Strdargoba","Im Amber","Pizzaroll94","Lkn","Jon","Joby","Motti","Kylo Ren","Amount","Kim","Hamade",
            "Dragon93","Sami","Slashy","Lottery Dude","Eater","Wir3d","Jade","Pksasaftw","Fungamer","Im On Meth",
            "Sverre","Pumpkim");

    public static boolean checkMod() {
        try {
            Player[] mods = Players.getPlayers(new Filter<Player>() {
                public boolean accept(Player p) {
                    String name = (p).getName();
                    if (name != null) {
                        for (String s : Mods) {
                            if (name.equalsIgnoreCase(s)) {
                                staffName = name;
                                System.out.println("staff Detected - " + staffName);
                                return true;
                            }
                        }
                    }
                    return false;
                }
            });
            return mods != null && mods.length > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private void dropClient() {
        try {
            Method dropClient = Loader.getClient().getClass().getDeclaredMethod("ag");
            dropClient.setAccessible(true);
            dropClient.invoke(Loader.getClient());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
