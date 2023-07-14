import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) throws Exception {

        VirtualPet.tick();

        Scanner input = new Scanner(System.in);

        System.out.println("Pero the puppy is your new pet!");
        System.out.println("Hunger: " + VirtualPet.getHungerLvl());
        System.out.println("Thirst: " + VirtualPet.getThirstLvl());
        System.out.println("Boredom: " + VirtualPet.getBoredLvl());

        System.out.println("What do you want to do?");
        System.out.println("1. See if Pero is hungry");
        System.out.println("2. See if Pero is thirsty");
        System.out.println("3. See if Pero is bored");
        System.out.println("4. Take Pero to the potty");
        System.out.println("0. Quit");

        int choices = input.nextInt();

            if (choices == 1) {
                VirtualPet.timeToEat(VirtualPet.hungerLvl);
                if (VirtualPet.isHungry) {
                    VirtualPet.eat();
                }
            } else if (choices == 2) {
                VirtualPet.timeToDrink(VirtualPet.thirstLvl);
                if (VirtualPet.isThirsty) {
                    VirtualPet.drink();
                }
            } else if (choices == 3) {
                VirtualPet.timeToPlay(VirtualPet.boredomLvl);
                if (VirtualPet.isBored) {
                    VirtualPet.play();
                }
            } else if (choices == 4) {
                VirtualPet.timeToPotty(VirtualPet.wasteLvl);
                if (VirtualPet.waste) {
                    VirtualPet.potty();
                }
            }


    }
}
