import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 4: Room Search & Availability Check
 * Goal: Read-only search to display available rooms
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Step 1: Initialize inventory (state holder)
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create room domain objects (reuse existing classes)
        Map<String, Room> roomMap = new HashMap<>();
        roomMap.put("SingleRoom", new SingleRoom());
        roomMap.put("DoubleRoom", new DoubleRoom());
        roomMap.put("SuiteRoom", new SuiteRoom());

        // Step 3: Perform search (READ-ONLY operation)
        searchAvailableRooms(inventory, roomMap);
    }

    /**
     * Search Service - Read-only logic
     * Retrieves available rooms without modifying inventory
     */
    public static void searchAvailableRooms(RoomInventory inventory, Map<String, Room> roomMap) {

        System.out.println("=================================");
        System.out.println("Available Rooms");
        System.out.println("=================================\n");

        // Iterate through all room types
        for (String roomType : roomMap.keySet()) {

            // Get availability from inventory (READ ONLY)
            int availableCount = inventory.getAvailability(roomType);

            // Validation: show only rooms with availability > 0
            if (availableCount > 0) {

                // Get room details from domain model
                Room room = roomMap.get(roomType);

                // Defensive programming check
                if (room != null) {

                    // Display room details
                    room.displayRoomDetails();

                    // Display availability
                    System.out.println("Available Rooms: " + availableCount);
                    System.out.println("---------------------------------");
                }
            }
        }

        System.out.println("\nSearch completed successfully (No data modified)");
    }
}