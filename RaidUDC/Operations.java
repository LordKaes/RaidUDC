package RaidUDC;

import java.util.Scanner;

public class Operations {
    private Scanner tec = new Scanner(System.in);
    private double enemyDef, lowLvl;

    public void enemyEffectiveDefense() {
        double r = 0;
        int opt, dD;
        String sets, crushRend, cruel;

        System.out.println("\n\n+++++++++++++++++++++++++++++++++++");
        System.out.println("------------------------------------");
        System.out.println("ENEMY EFFECTIVE DEFENSE CALCULATION");
        System.out.println("------------------------------------");
        System.out.println("\nWhat's the lowest enemy level?");
        lowLvl = tec.nextDouble();
        System.out.println("\nWhat's the current enemy defense.");
        enemyDef = tec.nextDouble();

        /* This part calculates the current decrease defense of a an enemy. */
        System.out.println("\nDoes the enemy has decrease defense debuff?");
        System.out.println("1. YES\n2. NO");
        opt = tec.nextInt();
        if (opt == 2)
            dD = 0;
        else if (opt > 2 || opt < 1) {
            System.out.println("\nYou chose a wrong option... The decrease defense will be set to 0");
            dD = 0;
        } else {
            do {
                System.out.println("\nHow much decrease defense does the enemy has? (30 or 60)");
                dD = tec.nextInt();
            } while (dD != 30 && dD != 60);
        }

        /*
         * This part checks if the champion has any set related to Savage or Cruel ones.
         * These sets can decrease the defense.
         */
        System.out.println("\nDoes your champion has Savage or Cruel sets?\n1. YES\n2. NO");
        opt = tec.nextInt();
        if (opt == 2)
            sets = "None";
        else if (opt > 2 || opt < 1) {
            System.out.println("\n\n *** You chose a wrong option... The champion won't have any set. *** ");
            sets = "None";
        } else {
            do {
                System.out.println("\nWich sets does this champion have?");
                System.out.println("CHOOSE:\n1. Savage\n2. Savage + Cruel\n3. 1x Cruel\n4. 2x Cruel\n5. 3x Cruel");
                opt = tec.nextInt();
            } while (opt < 1 || opt > 5);

            if (opt == 1)
                sets = "Savage";
            else if (opt == 2)
                sets = "Savage + Cruel";
            else if (opt == 3)
                sets = "1x Cruel";
            else if (opt == 4)
                sets = "2x Cruel";
            else
                sets = "3x Cruel";
        }

        /*
         * This part checks if the champion has the Crushing Rend blessing.
         * This blessing decreases the defense of the enmy.
         */
        System.out.println("\nDoes your champion has the Crushing Rend blessing?\n1. YES\n2. NO");
        opt = tec.nextInt();
        if (opt == 2)
            crushRend = "None";
        else if (opt > 2 || opt < 1) {
            System.out.println("\n\n *** You chose a wrong option... The champion won't have the blessing. *** ");
            crushRend = "None";
        } else {
            do {
                System.out.println("\nHow many awakened stars does this champion have?");
                System.out.println("CHOOSE:\n1. 1-2*\n2. 3-4*\n3. 5*\n4. 6*");
                opt = tec.nextInt();
            } while (opt < 1 || opt > 4);

            if (opt == 1)
                crushRend = "1-2*";
            else if (opt == 2)
                crushRend = "3-4*";
            else if (opt == 3)
                crushRend = "5*";
            else
                crushRend = "6*";
        }

        /*
         * This part checks if the champion has the Cruelty blessing.
         * This blessing decreases the defense of the enmy.
         */
        System.out.println("\nDoes one of your champions haves the Cruelty blessing?\n1. YES\n2. NO");
        opt = tec.nextInt();
        if (opt == 2)
            cruel = "None";
        else if (opt > 2 || opt < 1) {
            System.out.println("\n\n *** You chose a wrong option... The champion won't have the blessing. *** ");
            cruel = "None";
        } else {
            do {
                System.out.println("\nHow many awakened stars does this champion have?");
                System.out.println("CHOOSE:\n1. 1-2*\n2. 3-4*\n3. 5*\n4. 6*");
                opt = tec.nextInt();
            } while (opt < 1 || opt > 4);

            if (opt == 1)
                cruel = "1-2*";
            else if (opt == 2)
                cruel = "3-4*";
            else if (opt == 3)
                cruel = "5*";
            else
                cruel = "6*";
        }

        r = trueEnemyDef(dD) * setBonif(sets) * crushRendBonif(crushRend) * cruelBonif(cruel);

        System.out.println(
                "\n*********************************************\n The enemy effective defense is calculated like this:");
        System.out.println(trueEnemyDef(dD) + " * " + setBonif(sets) + " * " + crushRendBonif(crushRend) + " * "
                + cruelBonif(cruel) + " = " + r + "\n**********************************************"
                + "\n+++++++++++++++++++++++++++++++++++");
    }

    /*
     * METHOD: trueEnemyDef
     * This calculates the reduction of the defense thanks to the dec.def (decDef
     * can only can be 30, 60 or 0).
     */
    private double trueEnemyDef(int decDef) {
        double r = 0;

        if (decDef == 30)
            r = enemyDef * 0.7;
        else if (decDef == 60)
            r = enemyDef * 0.4;
        else
            r = enemyDef * 1;

        return r;
    }

    /*
     * METHOD: setBonif
     * This calculates the defense decreased by the help of the different sets.
     * Like Savage or Cruel.
     */

    private double setBonif(String set) {
        double r = 0;

        if (set == "Savage")
            r = 0.75;
        else if (set == "Savage + Cruel")
            r = 0.7;
        else if (set == "1x Cruel")
            r = 0.95;
        else if (set == "2x Cruel")
            r = 0.9;
        else if (set == "3x Cruel")
            r = 0.85;
        else if (set == "None")
            r = 1;

        return r;
    }

    /*
     * METHOD: crushRendBonif
     * This calculates the defense decreased by the help of Crushing Rend blessing.
     * 1 star to 6 stars.
     */

    private double crushRendBonif(String cRB) {
        double r = 0;

        if (cRB == "None")
            r = 1;
        else if (cRB == "1-2*")
            r = 1 - (0.01 * (lowLvl / 50));
        else if (cRB == "3-4*")
            r = 1 - (0.01 * (lowLvl / 40));
        else if (cRB == "5*")
            r = 1 - (0.01 * (lowLvl / 25));
        else if (cRB == "6*")
            r = 1 - (0.01 * (lowLvl / 10));

        return r;
    }

    /*
     * METHOD: blessBonif
     * This calculates the defense decreased by the help of Cruelty blessing.
     * 1 star to 6 stars.
     */

    private double cruelBonif(String cB) {
        double r = 0;

        if (cB == "None")
            r = 1;
        else if (cB == "1-2*")
            r = 0.1;
        else if (cB == "3-4*")
            r = 0.2;
        else if (cB == "5*")
            r = 0.3;
        else if (cB == "6*")
            r = 0.4;

        return r;
    }
}
