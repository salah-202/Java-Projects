package machine;

import java.util.Arrays;
import java.util.Scanner;

public class MachineAction {
    Scanner sc = new Scanner(System.in);
    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int money = 550;

    private int cups = 9;

    private boolean check(int w,int m,int c){
        if(w > water){
           System.out.println("Sorry, not enough water!");
           return false;
        }else if(m > milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (c > coffee) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        }
        return true;
    }
    public void getValeus(){
        System.out.printf("The coffee machine has:\n" +
                ""+water+" ml of water\n" +
                ""+milk+" ml of milk\n" +
                ""+coffee+" g of coffee beans\n" +
                ""+cups+" disposable cups\n" +
                "$"+money+" of money\n");
    }
    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choose = sc.next();
        if(choose.equals("back")){
            return;
        }
        int option = Integer.parseInt(choose);
        if (option == 1 && check(250,0,16)){
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffee -= 16;
            cups--;
            money += 4;
        } else if (option == 2 && check(350,75,20)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffee -= 20;
            cups--;
            money += 7;
        }else if(option == 3 && check(200,100,12)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffee -= 12;
            cups--;
            money += 6;
        }
    }
    public void fill(){
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee you want to add:");
        coffee += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += sc.nextInt();
    }

    public void take(){
        System.out.println("I gave you $"+money);
        money = 0;
    }

}
