package RaidUDC;

import java.util.*;

public class UDCMain {
    private static Scanner tec = new Scanner(System.in);;
    public static Champions Ronda = new Champions();
    public static Operations op = new Operations();

    public static void main(String[] args) {

        welcome();
        championSelection();
        System.out.println(Ronda.getChampInfo());
        op.enemyEffectiveDefense();
    }

    /* MAIN METHODS */

    private static void welcome() {
        System.out.println("\n_______________________________________________");
        System.out.println("\nWelcome to the RSL: Universal Damage Calculator.");
        System.out.println("------------------------------------------------");
        System.out.println("\n > Author (excel): Pengun\n > Java Implementation: Lord_Kaes");
        System.out.println("\n ------  ------  ------  ------  ------");
        System.out.println("\n > Version: b2.1\n > Creation Date: 18/01/2023");
        System.out.println(" > STATUS: On development...");
        System.out.println("_______________________________________________");

    }

    private static void championSelection() {
        String name, fact, rar;
        double def, acc, res, atk, cDmg, cRate, spd;
        System.out.print("\n\nWrite the champion's name: "); // NAME
        name = tec.next();
        Ronda.setName(name);
        System.out.print("\nWhat's the champion's rarity: "); // RARITY
        rar = tec.next();
        Ronda.setRarity(rar);
        System.out.print("\nWhat's the champion's faction: "); // FACTION
        fact = tec.next();
        Ronda.setFact(fact);
        System.out.print("\nWhat's the champion's attack: "); // ATTACK
        atk = tec.nextDouble();
        Ronda.setAtk(atk);
        System.out.print("\nWhat's the champion's critical damage: "); // CRITICAL DAMAGE
        cDmg = tec.nextDouble();
        Ronda.setCDmg(cDmg);
        System.out.print("\nWhat's the champion's critical rate: "); // CRITICAL RATE
        cRate = tec.nextDouble();
        Ronda.setCRate(cRate);
        System.out.print("\nWhat's the champion's defense: "); // DEFENSE
        def = tec.nextDouble();
        Ronda.setDef(def);
        System.out.print("\nWhat's the champion's accuracy: "); // ACCURACY
        acc = tec.nextDouble();
        Ronda.setAcc(acc);
        System.out.print("\nWhat's the champion's resistance: "); // RESISTANCE
        res = tec.nextDouble();
        Ronda.setRes(res);
        System.out.print("\nWhat's the champion's speed: "); // SPEED
        spd = tec.nextDouble();
        Ronda.setSpd(spd);
    }
}
