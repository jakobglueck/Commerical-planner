import java.util.ArrayList;
import java.util.List;

public class Staircase implements Room{
       private List<Inventory> inventory = new ArrayList<>();

    @Override
    public void stepInRoom(){
        System.out.println("You enter the Staircase");
    }
    public Staircase createRoom(){
        Staircase staircase = new Staircase();
        return staircase;
    }

    @Override
    public List<Inventory> getInventory() {
        return inventory;
    }
    
}
