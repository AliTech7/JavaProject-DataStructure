
package gameshop;

public class backpackLinkedList {
    BackpackWeapon head;

    public backpackLinkedList(){
        head=null;
    }
    
    
    public void add(Weapon w){      
        BackpackWeapon b = new BackpackWeapon(w);
        if (head==null){//case 1
            head= b;
            return;
        }

        BackpackWeapon curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
  
        curr.next=b;     
    }

    
    public String toString(){
        String s="\n";
        BackpackWeapon curr=head;
        while (curr!=null){
            s += curr.weapon.weaponName;
            curr=curr.next;
        }
        return s+"\n";
    }
}
