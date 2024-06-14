import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Lounge implements Room{
    private List<Inventory> inventory = new ArrayList<>();

    @Override
    public void stepInRoom(){
        System.out.println("You enter the Lounge");
    }
    
    @Override
    public Lounge createRoom(){
        Lounge lounge = new Lounge();
        Random random=  new Random();
        int result = random.nextInt(5) + 3;
        for (int i = 0; i < result; i++){
            lounge.addInventory(this.generateRandomInventory());
        }
        return lounge;
    }

    private Inventory generateRandomInventory() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new Chair();
        } else {
            return new Desk();
        }
    }

    public void addInventory(Inventory inventory){
        if (inventory instanceof Chair || inventory instanceof Desk ){
            this.inventory.add(inventory);
        }
        else{
            System.out.println("Dieses Inventarstück ist nicht erlaubt in diesem Raum");
        }
    }
    
    @Override
    public List<Inventory> getInventory() {
        return inventory;
    }

}