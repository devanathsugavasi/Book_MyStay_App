import java.util.*;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 * Goal: Allocate rooms safely and prevent double booking
 */

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Step 1: Create inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Booking queue (reuse Reservation from UC5)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "SingleRoom"));
        bookingQueue.add(new Reservation("Bob", "DoubleRoom"));
        bookingQueue.add(new Reservation("Charlie", "SuiteRoom"));
        bookingQueue.add(new Reservation("David", "SingleRoom"));

        // Step 3: Allocation tracking (Map + Set)
        Map<String, Set<String>> allocatedRooms = new HashMap<>();

        allocatedRooms.put("SingleRoom", new HashSet<>());
        allocatedRooms.put("DoubleRoom", new HashSet<>());
        allocatedRooms.put("SuiteRoom", new HashSet<>());

        System.out.println("=================================");
        System.out.println("Room Allocation Started");
        System.out.println("=================================\n");

        // Step 4: Process queue (FIFO)
        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();

            String roomType = request.getRoomType();
            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique ID
                String roomId = generateRoomId(roomType,
                        allocatedRooms.get(roomType).size() + 1);

                // Ensure uniqueness using Set
                if (!allocatedRooms.get(roomType).contains(roomId)) {

                    allocatedRooms.get(roomType).add(roomId);

                    // Update inventory immediately
                    inventory.updateAvailability(roomType, available - 1);

                    // Confirm booking
                    System.out.println("Booking Confirmed!");
                    System.out.println("Guest: " + request.getGuestName());
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Allocated Room ID: " + roomId);
                    System.out.println("---------------------------------");

                }

            } else {
                System.out.println("Booking Failed (No availability)");
                System.out.println("Guest: " + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("---------------------------------");
            }
        }

        System.out.println("\nAll requests processed successfully.");
    }

    // Helper: Generate Room ID
    public static String generateRoomId(String roomType, int number) {
        return roomType + "-" + number;
    }
}