import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int choices = 0;

        do {
            VirtualPet.tick();
            System.out.println("Pero the puppy is your new pet!");
            System.out.println("Hunger: " + VirtualPet.getHungerLvl());
            System.out.println("Thirst: " + VirtualPet.getThirstLvl());
            System.out.println("Boredom: " + VirtualPet.getBoredLvl());

            System.out.println("What do you want to do?");
            System.out.println("1. See if Pero is hungry");
            System.out.println("2. See if Pero is thirsty");
            System.out.println("3. See if Pero is bored");
            System.out.println("4. Take Pero to the potty");
            System.out.println("0. To return to the main menu");

            choices = input.nextInt();

            switch (choices) {
                case 0: {
                    System.out.println("Pero the puppy is your new pet!");
                    System.out.println("Hunger: " + VirtualPet.getHungerLvl());
                    System.out.println("Thirst: " + VirtualPet.getThirstLvl());
                    System.out.println("Boredom: " + VirtualPet.getBoredLvl());

                    System.out.println("What do you want to do?");
                    System.out.println("1. See if Pero is hungry");
                    System.out.println("2. See if Pero is thirsty");
                    System.out.println("3. See if Pero is bored");
                    System.out.println("4. Take Pero to the potty");
                }
                case 1: {
                    VirtualPet.timeToEat(VirtualPet.hungerLvl);
                    if (VirtualPet.isHungry == true) {
                        VirtualPet.eat();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    break;
                }
                case 2: {
                    VirtualPet.timeToDrink(VirtualPet.thirstLvl);
                    if (VirtualPet.isThirsty) {
                        VirtualPet.drink();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    break;
                }
                case 3: {
                    VirtualPet.timeToPlay(VirtualPet.boredomLvl);
                    if (VirtualPet.isBored) {
                        VirtualPet.play();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    break;
                }
                case 4: {
                    VirtualPet.timeToPotty(VirtualPet.wasteLvl);
                    if (VirtualPet.waste) {
                        VirtualPet.potty();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    break;
                }
            }
        } while(choices == 0);
    }
}

