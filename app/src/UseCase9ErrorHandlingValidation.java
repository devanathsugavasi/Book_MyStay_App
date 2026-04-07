import java.util.*;

/**
 * Use Case 9: Error Handling & Validation
 * Goal: Validate inputs and prevent invalid system state
 */

// ✅ Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        // Test cases (valid + invalid)
        List<Reservation> requests = new ArrayList<>();
        requests.add(new Reservation("Alice", "SingleRoom"));   // valid
        requests.add(new Reservation("Bob", "InvalidRoom"));     // invalid type
        requests.add(new Reservation("Charlie", "SuiteRoom"));   // valid

        System.out.println("=================================");
        System.out.println("Booking Validation Process");
        System.out.println("=================================\n");

        for (Reservation r : requests) {
            try {
                validateBooking(r, inventory);

                // If valid → simulate success
                System.out.println("Booking Validated Successfully!");
                System.out.println("Guest: " + r.getGuestName());
                System.out.println("Room Type: " + r.getRoomType());
                System.out.println("---------------------------------");

            } catch (InvalidBookingException e) {

                // Graceful error handling
                System.out.println("Booking Failed!");
                System.out.println("Reason: " + e.getMessage());
                System.out.println("Guest: " + r.getGuestName());
                System.out.println("---------------------------------");
            }
        }

        System.out.println("\nSystem running safely after validation.");
    }

    // ✅ Validation Method (Fail-Fast)
    public static void validateBooking(Reservation r, RoomInventory inventory)
            throws InvalidBookingException {

        String roomType = r.getRoomType();

        // 1️⃣ Validate room type
        if (!isValidRoomType(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        // 2️⃣ Validate availability
        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
        }

        // 3️⃣ Prevent negative inventory (extra safety)
        if (available < 0) {
            throw new InvalidBookingException("Invalid inventory state detected!");
        }
    }

    // Helper method: check valid room types
    public static boolean isValidRoomType(String roomType) {
        return roomType.equals("SingleRoom") ||
                roomType.equals("DoubleRoom") ||
                roomType.equals("SuiteRoom");
    }
}