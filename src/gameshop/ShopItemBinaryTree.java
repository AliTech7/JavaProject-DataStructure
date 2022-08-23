
package gameshop;

public class ShopItemBinaryTree {
    ShopItem root;
    public ShopItemBinaryTree() {
        root = null;
    }

    /* Recursive insert: 
    */

    public void recInsert(Weapon weapon, int numberInStock) {
        root = recInsertHelper(root, weapon, numberInStock);
    }
    public ShopItem recInsertHelper(ShopItem curr, Weapon weapon, int numberInStock) {
        if (curr == null) {
            ShopItem newNode = new ShopItem(weapon, numberInStock);
            return newNode;
        }

        if (weapon.weaponName.compareTo(curr.item.weaponName) < 0) {
            curr.left = recInsertHelper(curr.left, weapon, numberInStock);
        } 
        if (weapon.weaponName.compareTo(curr.item.weaponName) > 0) {
            curr.right = recInsertHelper(curr.right, weapon, numberInStock);
        }
        return curr; // note this also handles if the eitem exist already
    }
    
    /* InOrder Traversal: 
    */

    public void inOrderTraversal() {
        inOrderHelper(root);
        System.out.println("");
    }

    private void inOrderHelper(ShopItem curr) {
        if (curr != null) {
            inOrderHelper(curr.left);
            if(curr.numberInStock > 0){
                System.out.print("\nName: " + curr.item.weaponName + "\nDamage:" + curr.item.damage + "\nCost:"+ curr.item.cost+"\nQuantity in stock:" + curr.numberInStock);
            }
            inOrderHelper(curr.right);
        }
    }
    
    /* Recursive delete: 
    */
    
    public void delete(String weaponName){
        root = deleteWorker(root,weaponName);    
    }
    
    private ShopItem deleteWorker(ShopItem curr,String weaponName){
        if (curr == null) return curr;
        if (weaponName.compareTo(curr.item.weaponName) < 0) curr.left = deleteWorker(curr.left, weaponName);
        if (weaponName.compareTo(curr.item.weaponName) > 0) curr.right = deleteWorker(curr.right, weaponName);

        if (weaponName.compareTo(curr.item.weaponName) == 0)
        {
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;
            // get in-order successor
            ShopItem successor = curr.right;
            while (successor.left != null)
                successor = successor.left;
            curr.item = successor.item; //copy the data
            curr.numberInStock = successor.numberInStock;//copy the data
            curr.right = deleteWorker(curr.right, successor.item.weaponName);
        }
        return curr;
    }
    public ShopItem search(String weaponName)
    {
        return searchWorker(root, weaponName);
    }

    public ShopItem searchWorker(ShopItem curr, String weaponName)
    {
        if (curr == null) return null;
        if (weaponName.compareTo(curr.item.weaponName) == 0) return curr;
        if (weaponName.compareTo(curr.item.weaponName) < 0) return searchWorker(curr.left, weaponName);
        return searchWorker(curr.right, weaponName);
    }
}
