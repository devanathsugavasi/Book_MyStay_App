import java.io.*;
import java.util.*;

/**
 * Use Case 12: Data Persistence & System Recovery
 */

public class UseCase12DataPersistenceRecovery {

    private static final String FILE_NAME = "booking_data.ser";

    public static void main(String[] args) {

        // Step 1: Create sample data
        RoomInventory inventory = new RoomInventory();

        List<Reservation> bookingHistory = new ArrayList<>();
        bookingHistory.add(new Reservation("Alice", "SingleRoom"));
        bookingHistory.add(new Reservation("Bob", "DoubleRoom"));

        System.out.println("Saving system state...\n");

        // Step 2: Save data
        saveState(inventory, bookingHistory);

        System.out.println("Simulating system restart...\n");

        // Step 3: Load data
        Object[] restored = loadState();

        if (restored != null) {
            RoomInventory restoredInventory = (RoomInventory) restored[0];
            List<Reservation> restoredHistory = (List<Reservation>) restored[1];

            // Step 4: Display restored data
            System.out.println("=================================");
            System.out.println("Recovered System State");
            System.out.println("=================================\n");

            restoredInventory.displayInventory();

            System.out.println("\nBooking History:");
            for (Reservation r : restoredHistory) {
                System.out.println("Guest: " + r.getGuestName()
                        + " | Room Type: " + r.getRoomType());
            }
        }
    }

    // 💾 SAVE (Serialization)
    public static void saveState(RoomInventory inventory, List<Reservation> history) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(history);

            System.out.println("State saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // 🔄 LOAD (Deserialization)
    public static Object[] loadState() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) ois.readObject();
            List<Reservation> history = (List<Reservation>) ois.readObject();

            System.out.println("State loaded successfully!\n");

            return new Object[]{inventory, history};

        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return null;
    }
}