import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office implements Room{
    private List<Inventory> inventory = new ArrayList<>();

    @Override
    public void stepInRoom(){
        System.out.println("You enter the Office");
    }

    @Override
    public Office createRoom(){
        Office office = new Office();
        Random random=  new Random();
        int result = random.nextInt(5) + 3;
        for (int i = 0; i < result; i++){
            office.addInventory(this.generateRandomInventory());
        }
        return office;
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
