public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println();

        // Check availability
        System.out.println("Available Single Rooms: "
                + inventory.getAvailability("SingleRoom"));

        System.out.println();

        // Update inventory
        System.out.println("Updating SingleRoom availability to 8...");
        inventory.updateAvailability("SingleRoom", 8);

        System.out.println();

        // Display updated inventory
        inventory.displayInventory();
    }
}