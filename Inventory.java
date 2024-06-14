
/**
 * Inventory
 */
abstract class Inventory {
    private static int seriennummerCounter = 12000;
    private String SerialNumber; 

    public Inventory() {
        this.SerialNumber = "00-" + seriennummerCounter++ + "-S04";
    }

    public String getSerialNumber(){
        return SerialNumber;
    };

    public String classInforamtion(){
        return this.getClass().getName() + " with Serial number: " + getSerialNumber();
    };
}