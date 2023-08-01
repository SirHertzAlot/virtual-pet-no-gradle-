import java.util.*;

public class VirtualPet {

    public static TimerTask task;
    static Timer timer = new Timer();
    static int hungerLvl = 0; //0 is starting point, not hungry. 5 is end point, and very hungry!!
    static int thirstLvl = 0;
    static int wasteLvl = 0;
    static int boredomLvl = 0; //0 is not thirsty. 5 is very thirsty!!
    static boolean isHungry = false;
    static boolean isThirsty = false;
    static boolean isBored = false;
    static int feedMe = 2;
    static int waterMe = 1;
    static int playWithMe = 2;
    static boolean waste = false;
    static boolean sickness = false;
    
    public VirtualPet(boolean eat, boolean drink, boolean needBathroom, boolean wantToPlay, boolean sickness) {
        this.isHungry = eat;
        this.isThirsty = drink;
        this.isBored = wantToPlay;
        this.waste = needBathroom;
        this.sickness = sickness;
    }
    public static int getHungerLvl(){
        return hungerLvl;
    }

    public static int getThirstLvl(){
        return thirstLvl;
    }

    public static int getBoredLvl(){
        return boredomLvl;
    }

    public static int getPottyLvl(){
        return wasteLvl;
    }

    public static boolean timeToEat(int hungerLvl) {
        if(getHungerLvl() == 1){
            System.out.println("looks like your pet is hungry! Hunger level is: " + hungerLvl);
            return isHungry = true;
        } else if(getHungerLvl() > 1 && getHungerLvl() <= 4)  {
            System.out.println("Your pet is starving!! Hunger level is: " + hungerLvl);
            return isHungry = true;
        } else if (getHungerLvl() == 5){
            System.out.println("Your pet is dead. You didn't feed it in time, sorry.. Hunger level is: " + hungerLvl);
            return isHungry = false;
        } else {
            System.out.println("Looks like your pet isn't hungry");
        }

        return isHungry;
    }

    public static boolean timeToDrink(int thirstLvl) {
        if(getThirstLvl() == 1){
            isThirsty = true;
            System.out.println("looks like your pet is thirsty! Thirst level is: " + thirstLvl);
        } else if(getThirstLvl() > 1 && getThirstLvl() <= 4)  {
            isThirsty = true;
            System.out.println("Your pet is very thirsty!! Thirst level is: " + thirstLvl);
        } else if (getThirstLvl() == 5){
            isThirsty = false;
            System.out.println("Your pet is dead. It died of dehydration.. Thirst level is: " + thirstLvl);
        } else {
            System.out.println("Looks like your pet isn't thirsty.");
        }

        return isThirsty;
    }

    public static boolean timeToPlay(int boredomLvl) {
        if(getBoredLvl() == 1){
            isBored = true;
            System.out.println("Looks like your pet is bored! Boredom level is: " + boredomLvl);
        } else if(getBoredLvl() > 1 && getBoredLvl() <= 4)  {
            isBored = true;
            System.out.println("Your pet is so bored it's reading!! Boredom level is: " + boredomLvl);
        } else if (getBoredLvl() == 5){
            isBored = false;
            System.out.println("Your pet is dead. It died of boredom, sorry.. Boredom level is: " + boredomLvl);
        } else {
            System.out.println("Looks like your pet isn't bored");
        }
        return isBored;
    }

    public static boolean timeToPotty(int wasteLvl) {
        if(getPottyLvl() >= 3){
            waste = true;
            System.out.println("Oh, it looks like your pet is ready to use the bathroom!");
        } else if(getPottyLvl() == 5) {
            sickness = false;
            System.out.println("Your pet has died. It needed to use the bathroom very bad and you ignored it. Sorry.");
        } else {
            waste = false;
            System.out.println("Your pet isn't ready to use the potty yet.");
        }
        return waste;
    }

    public static int eat(){
        if(isHungry){
            hungerLvl -= feedMe;
            wasteLvl += hungerLvl;
            System.out.println("Pero is very thankful for the food!");
        } else {
            hungerLvl = hungerLvl;
        }
        return hungerLvl;
    }

    public static int drink(){
        if(isThirsty){
            thirstLvl -= waterMe;
            wasteLvl += thirstLvl;
            System.out.println("Pero is very thankful for the water!");
        } else {
            thirstLvl = thirstLvl;
        }
        return thirstLvl;
    }

    public static int play(){
        if(isBored){
            boredomLvl -= playWithMe;
            playWithMe += thirstLvl;
            System.out.println("Pero loves to play! He asks to be petted after playing");
        } else {
            boredomLvl = boredomLvl;
        }
        return boredomLvl;
    }

    public static int potty(){
        if(timeToPotty(wasteLvl)){
            wasteLvl -= wasteLvl;
            System.out.println("Pero looks very relieved after using the potty!");
        } else {
            wasteLvl = wasteLvl;
        }
        return wasteLvl;
    }

    public static void tick(){
        task = new TimerTask(){
            public void run(){
                for(int i = 0; i < 1; i++){
                    hungerLvl++;
                    thirstLvl++;
                    boredomLvl++;

                    if(getThirstLvl() == 5 || getHungerLvl() == 5 || getBoredLvl() == 5 || getPottyLvl() == 5){
                        this.cancel();
                        System.out.println("Game over! See you next time!");
                        System.exit(0);
                    }
                }
            };
        };

        timer.scheduleAtFixedRate(task, 120000, (1000 * 60) * 4);
    }
}
