import java.util.*;

public class VirtualPet {

    Timer timer = new Timer();
    TimerTask task;
    int hungerLvl = 0; //0 is starting point, not hungry. 5 is end point, and very hungry!!
    boolean isHungry = false;
    int feedMe = 2;
    int thirstLvl = 0;
    int waterMe = 1;
    boolean isThirsty = false;
    boolean waste = false;
    int wasteLvl = 0;
    int boredomLvl = 0; //0 is not thirsty. 5 is very thirsty!!
    int playWithMe = 2;
    boolean isBored = false;
    boolean sickness = false;
    
    public VirtualPet(boolean eat, boolean drink, boolean needBathroom, boolean wantToPlay, boolean sickness){
        this.isHungry = eat;
        this.isThirsty = drink;
        this.isBored = wantToPlay;
        this.waste = needBathroom;
        this.sickness = sickness;
        task = new TimerTask(){
            public void run(){
                for(int i = 0; i > 4; i++){
                    hungerLvl++;
                    thirstLvl++;
                    boredomLvl++;
                }
            }

        };
    }
    public int getHungerLvl(){
        return hungerLvl;
    }

    public int getThirstLvl(){
        return thirstLvl;
    }

    public int getBoredLvl(){
        return boredomLvl;
    }

    public int getPottyLvl(){
        return wasteLvl;
    }

    public boolean timeToEat(int hungerLvl) {
        if(getHungerLvl() == 1){
            isHungry = true;
            System.out.println("looks like your pet is hungry! Hunger level is: " + hungerLvl);
        } else if(getHungerLvl() > 1 && getHungerLvl() < 4)  {
            isHungry = true;
            System.out.println("Your pet is starving!! Hunger level is: " + hungerLvl);
        } else if (getHungerLvl() == 5){
            isHungry = false;
            System.out.println("Your pet is dead. You didn't feed it in time, sorry.. Hunger level is: " + hungerLvl);
        }

        return isHungry;
    }

    public boolean timeToDrink(int thirstLvl) {
        if(getThirstLvl() == 1){
            isThirsty = true;
            System.out.println("looks like your pet is thirsty! Thirst level is: " + thirstLvl);
        } else if(getThirstLvl() > 1 && getThirstLvl() < 4)  {
            isThirsty = true;
            System.out.println("Your pet is very thirsty!! Thirst level is: " + thirstLvl);
        } else if (getThirstLvl() == 5){
            isThirsty = false;
            System.out.println("Your pet is dead. It died of dehydration.. Thirst level is: " + thirstLvl);
        }

        return isThirsty;
    }

    public boolean timeToPlay(int boredomLvl) {
        if(getBoredLvl() == 1){
            isBored = true;
            System.out.println("Looks like your pet is bored! Boredom level is: " + boredomLvl);
        } else if(getBoredLvl() > 1 && getBoredLvl() < 4)  {
            isBored = true;
            System.out.println("Your pet is so bored it's reading!! Boredom level is: " + boredomLvl);
        } else if (getBoredLvl() == 5){
            isBored = false;
            System.out.println("Your pet is dead. It died of boredom, sorry.. Boredom level is: " + boredomLvl);
        }
        return isBored;
    }

    public boolean timeToPotty(int wasteLvl) {
        if(!timeToEat(hungerLvl) && !timeToPlay(boredomLvl) && getPottyLvl() > 3){
            waste = true;
            System.out.println("Oh, it looks like your pet is ready to use the bathroom!");
        } else {
            waste = false;
            System.out.println("Your pet isn't ready to use the potty yet.");
        }
        return waste;
    }

    public int eat(){
        if(timeToEat(hungerLvl)){
            hungerLvl -= feedMe;
            wasteLvl += hungerLvl;
        } else {
            hungerLvl = hungerLvl;
        }
        return hungerLvl;
    }

    public int drink(){
        if(timeToDrink(thirstLvl)){
            thirstLvl -= waterMe;
            wasteLvl += thirstLvl;
        } else {
            thirstLvl = thirstLvl;
        }
        return thirstLvl;
    }

    public int play(){
        if(timeToPlay(boredomLvl)){
            boredomLvl -= playWithMe;
            playWithMe += thirstLvl;
        } else {
            boredomLvl = boredomLvl;
        }
        return boredomLvl;
    }

    public int potty(){
        if(timeToPotty(wasteLvl)){
            wasteLvl -= wasteLvl;
        } else {
            wasteLvl = wasteLvl;
        }
        return wasteLvl;
    }

    public void tick(){
        timer.scheduleAtFixedRate(task, 1000, (1000 * 60) * 5);
    }
}
