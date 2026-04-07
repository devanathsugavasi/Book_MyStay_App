import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request Queue (FIFO)
 * Goal: Store booking requests in arrival order without processing them
 */

// Reservation class (represents a booking request)
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayRequest() {
        System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Step 1: Create Booking Queue (FIFO)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Step 2: Add booking requests (simulate multiple users)
        bookingQueue.add(new Reservation("Alice", "SingleRoom"));
        bookingQueue.add(new Reservation("Bob", "DoubleRoom"));
        bookingQueue.add(new Reservation("Charlie", "SuiteRoom"));
        bookingQueue.add(new Reservation("David", "SingleRoom"));

        System.out.println("=================================");
        System.out.println("Booking Requests (FIFO Order)");
        System.out.println("=================================\n");

        // Step 3: Display queue (WITHOUT processing/removing)
        for (Reservation request : bookingQueue) {
            request.displayRequest();
        }

        System.out.println("\nAll requests stored successfully (No allocation done)");
    }
}