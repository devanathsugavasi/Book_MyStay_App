import java.util.*;

/**
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 * Goal: Handle multiple booking requests safely using synchronization
 */

public class UseCase11ConcurrentBookingSimulation {

    // Shared resources
    private static Queue<Reservation> bookingQueue = new LinkedList<>();
    private static RoomInventory inventory = new RoomInventory();

    public static void main(String[] args) {

        // Step 1: Add booking requests (simulate multiple users)
        bookingQueue.add(new Reservation("Alice", "SingleRoom"));
        bookingQueue.add(new Reservation("Bob", "SingleRoom"));
        bookingQueue.add(new Reservation("Charlie", "SingleRoom"));
        bookingQueue.add(new Reservation("David", "SingleRoom"));

        System.out.println("=================================");
        System.out.println("Concurrent Booking Simulation");
        System.out.println("=================================\n");

        // Step 2: Create multiple threads
        Thread t1 = new Thread(new BookingProcessor(), "Thread-1");
        Thread t2 = new Thread(new BookingProcessor(), "Thread-2");

        // Step 3: Start threads
        t1.start();
        t2.start();
    }

    // 🔐 Booking Processor (Thread)
    static class BookingProcessor implements Runnable {

        @Override
        public void run() {

            while (true) {

                Reservation request;

                // 🔐 Critical Section 1: Access queue safely
                synchronized (bookingQueue) {
                    if (bookingQueue.isEmpty()) {
                        return;
                    }
                    request = bookingQueue.poll();
                }

                processBooking(request);
            }
        }

        // 🔐 Critical Section 2: Allocation + Inventory update
        private void processBooking(Reservation request) {

            String roomType = request.getRoomType();

            synchronized (inventory) {

                int available = inventory.getAvailability(roomType);

                if (available > 0) {

                    // Allocate room
                    inventory.updateAvailability(roomType, available - 1);

                    System.out.println(Thread.currentThread().getName()
                            + " → Booking Confirmed for "
                            + request.getGuestName()
                            + " (" + roomType + ")");

                } else {

                    System.out.println(Thread.currentThread().getName()
                            + " → Booking Failed (No availability) for "
                            + request.getGuestName());
                }
            }
        }
    }
}