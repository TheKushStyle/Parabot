package KushBarMaker.Data;

import org.rev317.min.api.methods.Skill;

/* Variables.java
 *
 * Version 1.0
 *
 * Copyright 2014 - 2014 TheKushStyle
 * Variables.java is part of KushBarMaker.
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

public class Variables {
    private static int Ore;
    private static int Bar;
    private static int OreRes;
    private static int Furnace;
    private static int GainedAmount;
    private static int CoalAmount;
    private static int OreAmount;
    private static int CoalAmountMagic;
    private static int OreAmountMagic;
    private static int ResOreAmount;
    private static int Place;
    private static int SelectedBar;
    private static int StartLevel;

    public static void SetOre(int Ore){Variables.Ore = Ore;}
    public static void SetBar(int Bar){Variables.Bar = Bar;}
    public static void SetOreRes(int OreRes){Variables.OreRes = OreRes;}
    public static void SetFurnace(int Furnace){Variables.Furnace = Furnace;}
    public static void SetCoalAmount(int CoalAmount){Variables.CoalAmount = CoalAmount;}
    public static void SetOreAmount(int OreAmount){Variables.OreAmount = OreAmount;}
    public static void SetCoalAmountMagic(int CoalAmountMagic){Variables.CoalAmountMagic = CoalAmountMagic;}
    public static void SetOreAmountMagic(int OreAmountMagic){Variables.OreAmountMagic = OreAmountMagic;}
    public static void SetResOreAmount(int ResOreAmount){Variables.ResOreAmount = ResOreAmount;}
    public static void SetPlace(int Place){Variables.Place = Place;}
    public static void SetSelectedBar(int SelectedBar){Variables.SelectedBar = SelectedBar;}
    public static void SetStartLevel(int StartLevel){Variables.StartLevel = StartLevel;}
    public static void SetGainedAmount(int GainedAmount){Variables.GainedAmount = GainedAmount;}

    public static int GetOre(){return Ore;}
    public static int GetGainedLevel(){return (Skill.SMITHING.getLevel() - StartLevel);}
    public static int GetSelectedBar(){return SelectedBar;}
    public static int GetPlace(){return Place;}
    public static int GetBar(){return Bar;}
    public static int GetReserveOreAmount(){return ResOreAmount;}
    public static int GetReserveOre(){return OreRes;}
    public static int GetOreAmount(){return OreAmount;}
    public static int GetCoalAmount(){return CoalAmount;}
    public static int GetOreAmountMagic(){return OreAmountMagic;}
    public static int GetCoalAmountMagic(){return CoalAmountMagic;}
    public static int GetFurnace(){return Furnace;}
    public static int GetGainedAmount(){return GainedAmount;}
}
