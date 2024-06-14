import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MetalWorkspace implements Room{
        private List<Inventory> inventory = new ArrayList<>();

    @Override
    public void stepInRoom(){
        System.out.println("You enter the MetalWorkspace");
    }
    
    @Override
    public MetalWorkspace createRoom(){
        MetalWorkspace metalWorkspace = new MetalWorkspace();
        Random random=  new Random();
        int result = random.nextInt(5) + 3;
        for (int i = 0; i < result; i++){
            metalWorkspace.addInventory(this.generateRandomInventory());
        }
        return metalWorkspace;
    }

    private Inventory generateRandomInventory() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new Polisher();
        } else {
            return new WeldingMachine();
        }
    }

    public void addInventory(Inventory inventory){
        if (inventory instanceof Polisher || inventory instanceof WeldingMachine ){
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
