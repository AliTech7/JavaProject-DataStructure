
package gameshop;

public class BackpackWeapon {
    public Weapon weapon;
    public BackpackWeapon next;    
    

    public BackpackWeapon(Weapon w){
        weapon = w;
        next=null;
    }   
}
