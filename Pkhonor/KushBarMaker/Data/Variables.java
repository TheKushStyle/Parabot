package KushBarMaker.Data;

import org.rev317.min.api.methods.Skill;

public class Variables {
    public static int Ore;
    public static int Bar;
    public static int OreRes;
    public static int Furnace;
    public static int GainedAmount;
    public static int CoalAmount;
    public static int OreAmount;
    public static int CoalAmountMagic;
    public static int OreAmountMagic;
    public static int ResOreAmount;
    public static int Place;
    public static int SelectedBar;
    public static int StartLevel;

    public static int GetGainedLevel(){return (Skill.SMITHING.getLevel() - StartLevel);}

    public static int GetSelectedBar(){return SelectedBar;}

    public static int GetPlace(){return Place;}

    public static int GetOre(){return Ore;}

    public static int GetBar(){return Bar;}

    public static int GetReserveOreAmount(){return ResOreAmount;}

    public static int GetReserveOre(){return OreRes;}

    public static int GetOreAmount(){return OreAmount;}

    public static int GetCoalAmount(){return CoalAmount;}

    public static int GetOreAmountMagic(){return OreAmountMagic;}

    public static int GetCoalAmountMagic(){return CoalAmountMagic;}

    public static int GetFurnace(){return Furnace;}
}
