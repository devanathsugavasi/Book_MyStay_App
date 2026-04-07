import java.util.*;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Goal: Safely cancel bookings and restore system state
 */

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        // Step 1: Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Simulate allocated bookings (from UC6)
        Map<String, String> bookingMap = new HashMap<>();
        bookingMap.put("RES-1", "SingleRoom");
        bookingMap.put("RES-2", "DoubleRoom");
        bookingMap.put("RES-3", "SuiteRoom");

        // Step 3: Stack for rollback (LIFO)
        Stack<String> rollbackStack = new Stack<>();

        // Step 4: Perform cancellation
        System.out.println("=================================");
        System.out.println("Booking Cancellation Process");
        System.out.println("=================================\n");

        cancelBooking("RES-2", bookingMap, rollbackStack, inventory); // valid
        cancelBooking("RES-5", bookingMap, rollbackStack, inventory); // invalid

        System.out.println("\nRollback Stack (Released Room IDs):");
        for (String id : rollbackStack) {
            System.out.println(id);
        }
    }

    // 🔁 Cancellation Logic
    public static void cancelBooking(String reservationId,
                                     Map<String, String> bookingMap,
                                     Stack<String> rollbackStack,
                                     RoomInventory inventory) {

        System.out.println("Processing cancellation for: " + reservationId);

        // Validate booking exists
        if (!bookingMap.containsKey(reservationId)) {
            System.out.println("Cancellation Failed: Reservation not found!");
            System.out.println("---------------------------------");
            return;
        }

        String roomType = bookingMap.get(reservationId);

        // Generate room ID (for rollback tracking)
        String roomId = roomType + "-" + reservationId;

        // Push to stack (LIFO)
        rollbackStack.push(roomId);

        // Restore inventory
        int current = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // Remove booking
        bookingMap.remove(reservationId);

        // Confirm cancellation
        System.out.println("Cancellation Successful!");
        System.out.println("Released Room ID: " + roomId);
        System.out.println("Updated Inventory for " + roomType +
                ": " + inventory.getAvailability(roomType));
        System.out.println("---------------------------------");
    }
}