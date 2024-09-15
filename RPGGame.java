import java.util.Scanner;
import java.util.Random;

public class RPGGame {
    // global scanner
    static Scanner input = new Scanner(System.in);
    // global random
    static Random random = new Random();

    // player vars
    static String pPlayerName;
    static int pPlayerGold = 500;
    static int pLastPlayerGold = 0;
    static int pPlayerLives = 3;

    static int pPlayerHP = 100;
    static int pEnemyHP = 100;
    static int pPlayerDamage;
    static int pEnemyDamage;

    // weapons vars
    static int pPlayerActiveWeapons;
    static String pPlayerCurrentWeapons;
    static String pPlayerWeapons[] = {"Knife", "Deagle", "M4A1"};
    static int pWeaponDamage = 0;

    // attack vars
    static int pPlayerAttack;

    public static void askPlayerName() {
        System.out.print("Enter player name: ");
        pPlayerName = input.nextLine();
    }

    public static void displayInfo() {
        System.out.println("Player: " + pPlayerName);
        System.out.println("Gold: " + pPlayerGold);
        System.out.println("Lives: " + pPlayerLives);
        System.out.println("HP: " + pPlayerHP);
    }

    public static void setPlayerGold(int gold) {
        pLastPlayerGold = gold;
        pPlayerGold += gold;
    }

    public static void attackEnemy(int enemy) {
        pEnemyDamage = random.nextInt(100) + 20;

        while(pPlayerHP > 0 && pEnemyHP > 0) {
            pPlayerDamage = pWeaponDamage;
            pEnemyHP -= pPlayerDamage;

            if(pEnemyHP < 0)
                pEnemyHP = 0;

            System.out.println("You attack the enemy with " + pPlayerCurrentWeapons + " for " + pPlayerDamage + " damage.");
            System.out.println("Enemy HP: " + pEnemyHP);

            if(pEnemyHP <= 0) {
                System.out.println("You defeated the enemy!");
                return;
            }

            pPlayerHP -= pEnemyDamage;

            if(pPlayerHP < 0)
                pPlayerHP = 0;

            System.out.println("The enemy attacks you for " + pEnemyDamage + " damage.");
            System.out.println("Your HP: " + pPlayerHP);

            if (pPlayerHP <= 0) {
                pPlayerLives--;
                if (pPlayerLives > 0) {
                    System.out.println("You died. Remaining lives: " + pPlayerLives);
                    pPlayerHP = 100; 
                } else {
                    System.out.println("Game over! You have no lives left.");
                    System.exit(0);
                }
            }
        }
    }

    public static void askPlayerWeapons() {
        System.out.println("1. Knife\n2. Deagle\n3. M4A1");
        System.out.print("Choose your weapon: ");
        pPlayerActiveWeapons = input.nextInt();

        if(pPlayerActiveWeapons == 1) {
            pPlayerCurrentWeapons = pPlayerWeapons[0];
            pWeaponDamage = 30;
        } else if(pPlayerActiveWeapons == 2) {
            pPlayerCurrentWeapons = pPlayerWeapons[1];
            pWeaponDamage = 50;
        } else if(pPlayerActiveWeapons == 3) {
            pPlayerCurrentWeapons = pPlayerWeapons[2];
            pWeaponDamage = 70;
        } else {
            System.out.println("Invalid");
        }
    }

    public static void main(String[] args) {
        askPlayerName();
        displayInfo();

        System.out.println("-------------------------");

        System.out.println("1. Slime\n2. Goblin\n3. Orc\n4. Dragon");
        System.out.print("Choose enemy to attack: ");
        int enemy = input.nextInt();

        System.out.println("-------------------------");

        switch(enemy) {
            case 1:  
                //setPlayerGold(20);
                //System.out.println("You got " + pLastPlayerGold + "!. Your gold is now " + pPlayerGold);
            case 2: 
                //setPlayerGold(100);
                //System.out.println("You got " + pLastPlayerGold + "!. Your gold is now " + pPlayerGold);
            case 3:
                /*pPlayerLives--;
                if(pPlayerLives > 0) {
                    System.out.println("You died.." + " Your remaining lives are " + pPlayerLives);
                    break;
                } else {
                    System.out.println("Game over! You have no lives left");
                    break;
                }*/
            case 4:
                //pPlayerLives = 0;
                //System.out.println("GAME OVER!!!");
                askPlayerWeapons();
                attackEnemy(enemy);
                break;
            default:
                System.out.println("The god of intelligence took your brains out!");   
        }
    }
}