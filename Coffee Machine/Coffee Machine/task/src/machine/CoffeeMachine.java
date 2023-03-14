package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        MachineAction make = new MachineAction();
        Scanner sc = new Scanner(System.in);
        String action="";
        while (!action.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = sc.next();
            if (action.equals("buy")) {
                make.buy();
            } else if (action.equals("fill")) {
                make.fill();
            } else if (action.equals("take")) {
                make.take();
            } else if (action.equals("remaining")) {
                make.getValeus();
            }
        }
        /*
        System.out.printf("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!\n");

        int[] cupIngredient = {200,50,15};
        Scanner sc = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = sc.nextInt();
        int water = cups * cupIngredient[0];
        int milk = cups * cupIngredient[1];
        int coffee = cups * cupIngredient[2];
        System.out.printf("For "+ cups +" cups of coffee you will need:\n" +
                ""+water+"ml of water\n" +
                ""+milk+"ml of milk\n" +
                ""+coffee+" g of coffee beans\n");



        System.out.println("Write how many ml of water the coffee machine has:");
        int machineWater = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int machineMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee the coffee machine has:");
        int machineCoffee = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int neededCups = sc.nextInt();
        int machineCups = machineWater/cupIngredient[0];

        if((machineMilk/cupIngredient[1]) < machineCups){
            machineCups = machineMilk/cupIngredient[1];
        } else if ((machineCoffee/cupIngredient[2]) < machineCups) {
            machineCups = machineCoffee/cupIngredient[2];
        }

        if(neededCups == machineCups){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (neededCups < machineCups) {
            System.out.println("Yes, I can make that amount of coffee (and even "+(machineCups - neededCups)+" more than that)");
        } else if (neededCups > machineCups){
            System.out.println("No, I can make only "+machineCups+" cup(s) of coffee");
        }


         */
    }
}
