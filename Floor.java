import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Floor implements CommercialPlanner{
    private Room[][] layout = new Room[3][3];
    
    @Override
    public void createFloor(){
        Staircase staircase = new Staircase();
        layout[1][1] = staircase.createRoom();
        List<Room> rooms = this.chooseRandomRoomTyp();
        int roomIndex = 0;
        for(int i = 0; i < 3; i++ ){
            for (int j = 0 ; j < 3;j++){
                if(i == 1 && j == 1){
                    continue;
                }
                else{
                layout[i][j] = rooms.get(roomIndex++).createRoom();
                }
            }
        }
    }

    public List<Room> chooseRandomRoomTyp(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Lounge());
        rooms.add(new Office());
        rooms.add(new SanitaryRoom());
        rooms.add(new TeaKitchen());
        rooms.add(new MetalWorkspace());
        rooms.add(new WoodWorkspace());

        Random random = new Random();
        rooms.add(createRandomRoom(random));
        rooms.add(createRandomRoom(random));
        Collections.shuffle(rooms);

        return rooms;

    }

    private Room createRandomRoom(Random random) {
        int randomRoomType = random.nextInt(6);
        switch (randomRoomType) {
            case 0: 
                return new Lounge();
            case 1: 
                return new Office();
            case 2: 
                return new SanitaryRoom();
            case 3: 
                return new TeaKitchen();
            case 4: 
                return new MetalWorkspace();
            case 5: 
                return new WoodWorkspace();
            default: 
                return null;
        }
    }

    @Override
    public void showFloor(){
        System.out.println("-----------------------------");
        System.out.println("Welcome to the Commerical Planner");
        System.out.println("Lets start to create a Floor for you");
        for(int i = 0; i < 3 ; i++ ){
            for (int j = 0 ; j < 3;j++){
                System.out.println("-----------------------------");
                layout[i][j].stepInRoom();
                System.out.println("-----------------------------");
                this.showInventoryForEachRoom(layout[i][j].getInventory());
            }
        }
    }

    public void showInventoryForEachRoom(List<Inventory> inventory){
        for (Inventory tempinventory : inventory) {
            System.out.println("Inventory piece: " + tempinventory.classInforamtion());
        }
    }

}
