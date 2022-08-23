
package gameshop;


    class Backpack
    {
        double maxWeight;
        double presentWeight;
        backpackLinkedList backpackList;
        
        public Backpack(double maxWeight) {
            this.maxWeight = maxWeight;
            this.presentWeight = 0;
            this.backpackList = new backpackLinkedList();
        }
        
        public boolean add(Weapon w){
            if(this.presentWeight + w.weight < this.maxWeight){
                this.presentWeight += w.weight;
                backpackList.add(w);
                return true;
            }else{
                return false;
            }
        }

        public String toString(){
            String s = "";
            s += (backpackList.toString());
            return s;
        }        
    }
