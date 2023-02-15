package RaidUDC;

public class Champions {
    protected String name, rarity, fact;
    protected double def, acc, res, atk, cDmg, cRate, spd;

    public Champions() {
        name = rarity = fact = "N/A";
        def = acc = res = atk = cDmg = cRate = 0;
    }

    // General setters
    public void setName(String name) { // sets the name
        this.name = name;
    }

    public void setRarity(String rarity) { // sets the rarity
        this.rarity = rarity;
    }

    public void setFact(String fact) { // sets the faction
        this.fact = fact;
    }

    public void setDef(double def) { // sets the defense
        this.def = def;
    }

    public void setAcc(double acc) { // sets the accuracy
        this.acc = acc;
    }

    public void setRes(double res) { // sets the resistance
        this.res = res;
    }

    public void setAtk(double atk) { // sets the atack
        this.atk = atk;
    }

    public void setCDmg(double cDmg) { // sets the critical damage
        this.cDmg = cDmg;
    }

    public void setCRate(double cRate) { // sets the critical rate
        this.cRate = cRate;
    }

    public void setSpd(double spd) { // sets the speed
        this.spd = spd;
    }

    // Getter of the general champion information
    public String getChampInfo() {
        return "\n-------------------------------------\n" + name + " is a " + rarity + " champion of the " + fact
                + " faction.\n\nThese are it's stats:\n DEFENSE: "
                + def + "\n ACCURACY: " + acc + "\n RESISTANCE: " + res + "\n ATTACK: " + atk + "\n CRITICAL DAMAGE: "
                + cDmg + "\n CRITICAL RATE: " + cRate + "\n SPEED: " + spd + "\n-------------------------------------";
    }
}
