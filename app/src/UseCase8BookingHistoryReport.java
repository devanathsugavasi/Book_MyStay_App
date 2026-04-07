import java.util.*;

/**
 * Use Case 8: Booking History & Reporting
 * Goal: Store confirmed bookings and generate reports
 */

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        // Step 1: Booking History (List maintains order)
        List<Reservation> bookingHistory = new ArrayList<>();

        // Step 2: Simulate confirmed bookings (from UC6)
        bookingHistory.add(new Reservation("Alice", "SingleRoom"));
        bookingHistory.add(new Reservation("Bob", "DoubleRoom"));
        bookingHistory.add(new Reservation("Charlie", "SuiteRoom"));
        bookingHistory.add(new Reservation("David", "SingleRoom"));

        System.out.println("=================================");
        System.out.println("Booking History (Chronological)");
        System.out.println("=================================\n");

        // Step 3: Display booking history
        for (Reservation r : bookingHistory) {
            System.out.println("Guest: " + r.getGuestName() +
                    " | Room Type: " + r.getRoomType());
        }

        // Step 4: Generate report (summary)
        generateReport(bookingHistory);
    }

    // 📊 Reporting Service
    public static void generateReport(List<Reservation> history) {

        System.out.println("\n=================================");
        System.out.println("Booking Summary Report");
        System.out.println("=================================\n");

        // Count bookings per room type
        Map<String, Integer> report = new HashMap<>();

        for (Reservation r : history) {
            String type = r.getRoomType();

            report.put(type, report.getOrDefault(type, 0) + 1);
        }

        // Display report
        for (String roomType : report.keySet()) {
            System.out.println(roomType + " → " + report.get(roomType) + " bookings");
        }

        System.out.println("\nTotal Bookings: " + history.size());
    }
}