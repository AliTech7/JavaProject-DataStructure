
package gameshop;

class Player
    {
        public String name;
        public Backpack backpack;
        public int numItems;
        public double money;

        public Player(String n, double m)
        {
            name = n;
            money = m;
            numItems = 0;
            backpack = new Backpack(20);
        }

        public void buy(Weapon w)
        {
            if(backpack.add(w)){
                System.out.println(w.weaponName+" bought...");
                numItems++;
            }else{
                System.out.println("Backpack is full!");
            }
        }
        public void withdraw(double amt)
        {
            money = money - amt;
        }

        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }


        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }

        public void printBackpack()
        {
            System.out.println(" "+name+", you own "+numItems+" Weapons:");
            System.out.println(backpack.toString());
            System.out.println();
        }
    }
