
package gameshop;

import java.util.Scanner;

public class GameShop {

        public static int getInteger(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextInt()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextInt();
        }
        
        public static double getDouble(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextDouble()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextDouble();
        }
        
    
        public static void addWeapons(ShopItemBinaryTree bt,Scanner sc)
        {
            System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
            String weaponName; int weaponRange; int weaponDamage; double weaponWeight; double weaponCost;
            int quantity;
            System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
            weaponName=sc.next();
            while (weaponName.compareTo("end") != 0)
            {
                weaponRange= getInteger(sc,"Please enter the Range of the Weapon (0-10):"); 
                weaponDamage=getInteger(sc,"Please enter the Damage of the Weapon:"); 
                weaponWeight= getDouble(sc,"Please enter the Weight of the Weapon (in pounds):");
                weaponCost=getDouble(sc,"Please enter the Cost of the Weapon:");
                Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
                quantity=getInteger(sc,"Please enter the quantity in stock:"); 
                bt.recInsert(w, quantity);
                System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
                weaponName = sc.next();
            }
        }

        public static void deleteWeapons(ShopItemBinaryTree bt,Scanner sc)
        {
            String weaponName;
            System.out.print("Please enter the NAME of the Weapon to delete ('end' to quit):");
            weaponName=sc.next();
            while (weaponName.compareTo("end") != 0)
            {
                bt.delete(weaponName);
                System.out.println("Proceed");
                System.out.print("Please enter the NAME of another Weapon to delete ('end' to quit):");
                weaponName = sc.next();
            }
        }

        public static void showRoomMenu(ShopItemBinaryTree bt,Player p){
            System.out.println("WELCOME TO THE SHOWROOM!!!!");
            bt.inOrderTraversal();
            System.out.println("You have "+p.money+" money.");
            System.out.println("Please select a weapon to buy('end' to quit):");
        }
        
        public static void showRoom(ShopItemBinaryTree bt, Player p,Scanner sc)
        {
            String choice;
            showRoomMenu(bt,p);
            choice=sc.next();
            while (choice.compareTo("end") != 0 && !p.inventoryFull())
            {
                ShopItem si = bt.search(choice);
                if (si != null)
                {
                    if (si.item.cost > p.money)
                    {
                        System.out.println("Insufficient funds to buy "+si.item.weaponName );
                    }
                    else
                    {
                        p.buy(si.item);
                        p.withdraw(si.item.cost);
                        si.numberInStock--;
                    }
                }
                else
                {
                    System.out.println(" ** "+choice+" not found!! **" );
                }
                choice = sc.next();
            }
            System.out.println("");
        }
        
        public static void printBackpack(Player p){
            p.printBackpack();
        }
        
        public static void printCharacter(Player p){
            p.printCharacter();
        }
        
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            String pname;
            System.out.println("Please enter Player name:");
            pname=sc.next();
            Player pl= new Player(pname,45);
            ShopItemBinaryTree bt= new ShopItemBinaryTree();
            String option = "";
            while(option.compareTo("6") != 0){
                System.out.println("Pleas choose an option");
                System.out.println("1)	Add Items to the shop");
                System.out.println("2)	Delete Items from the shop");
                System.out.println("3)	Buy from the Shop");
                System.out.println("4)	View backpack");
                System.out.println("5)	View Player");   
                System.out.println("6)	Exit");
                option = sc.next();
                switch (option) {
                    case "1" -> addWeapons(bt, sc);
                    case "2" -> deleteWeapons(bt, sc);
                    case "3" -> showRoom(bt, pl, sc);
                    case "4" -> printBackpack(pl);
                    case "5" -> printCharacter(pl);
                    default -> System.out.println("Wrong Choice");
                }
            }
        }
}
