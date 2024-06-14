/**
 * Room
 */
import java.util.List;

public interface Room {
    void stepInRoom();

    Room createRoom();
    
    List<Inventory> getInventory();
}