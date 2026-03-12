import java.util.HashMap;
import java.util.Map;

public class UseCase4RoomSearch{

    public static void main(String[] args) {

        // Step 1: Create inventory (from UC3)
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create Room objects (Domain Model)
        Map<String, Room> roomMap = new HashMap<>();
        roomMap.put("SingleRoom", new SingleRoom());
        roomMap.put("DoubleRoom", new DoubleRoom());
        roomMap.put("SuiteRoom", new SuiteRoom());

        // Step 3: Perform search (READ ONLY)
        searchAvailableRooms(inventory, roomMap);
    }

    // 🔍 Search Logic (Read-only)
    public static void searchAvailableRooms(RoomInventory inventory, Map<String, Room> roomMap) {

        System.out.println("===== Available Rooms =====\n");

        for (String roomType : roomMap.keySet()) {

            int count = inventory.getAvailability(roomType);

            // ✅ Only show available rooms
            if (count > 0) {

                Room room = roomMap.get(roomType);

                if (room != null) { // Defensive programming

                    room.displayRoomDetails();

                    System.out.println("Available Count: " + count);
                    System.out.println("----------------------------");
                }
            }
        }
    }
}