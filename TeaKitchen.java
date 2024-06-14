import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeaKitchen implements Room{
    private List<Inventory> inventory = new ArrayList<>();

    @Override
    public void stepInRoom(){
        System.out.println("You enter the  TeaKitchen");
    }
    
    @Override
    public TeaKitchen createRoom(){
        TeaKitchen teaKitchen = new TeaKitchen();
        Random random=  new Random();
        int result = random.nextInt(5) + 3;
        for (int i = 0; i < result; i++){
            teaKitchen.addInventory(this.generateRandomInventory());
        }
        return teaKitchen;
    }

    private Inventory generateRandomInventory() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new Sink();
        } else {
            return new TowelDispenser();
        }
    }
    

    public void addInventory(Inventory inventory){
        if (inventory instanceof Sink || inventory instanceof TowelDispenser ){
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
