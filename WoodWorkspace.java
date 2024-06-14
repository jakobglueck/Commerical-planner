import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WoodWorkspace implements Room{
            private List<Inventory> inventory = new ArrayList<>();

    @Override
    public void stepInRoom(){
        System.out.println("You enter the WoodWorkspace");
    }

    @Override
    public WoodWorkspace createRoom(){
        WoodWorkspace woodWorkspace = new WoodWorkspace();
        Random random=  new Random();
        int result = random.nextInt(5) + 3;
        for (int i = 0; i < result; i++){
            woodWorkspace.addInventory(this.generateRandomInventory());
        }
        return woodWorkspace;
    }

    private Inventory generateRandomInventory() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new RouterMachine();
        } else {
            return new CircleSaw();
        }
    }


    public void addInventory(Inventory inventory){
        if (inventory instanceof RouterMachine || inventory instanceof CircleSaw ){
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
