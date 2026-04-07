import java.util.*;

/**
 * Use Case 7: Add-On Service Selection
 * Goal: Attach optional services to reservation without changing core logic
 */

// Service class (Add-on feature)
class Service {

    private String serviceName;
    private double price;

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Step 1: Sample reservations (simulate confirmed bookings from UC6)
        Reservation r1 = new Reservation("Alice", "SingleRoom");
        Reservation r2 = new Reservation("Bob", "DoubleRoom");

        // Step 2: Map → ReservationID → List of Services
        Map<String, List<Service>> serviceMap = new HashMap<>();

        // Step 3: Add services for reservation 1
        List<Service> servicesForR1 = new ArrayList<>();
        servicesForR1.add(new Service("Breakfast", 20));
        servicesForR1.add(new Service("Airport Pickup", 50));

        serviceMap.put("RES-1", servicesForR1);

        // Step 4: Add services for reservation 2
        List<Service> servicesForR2 = new ArrayList<>();
        servicesForR2.add(new Service("Extra Bed", 30));

        serviceMap.put("RES-2", servicesForR2);

        // Step 5: Display services + calculate cost
        System.out.println("=================================");
        System.out.println("Add-On Services for Reservations");
        System.out.println("=================================\n");

        for (String reservationId : serviceMap.keySet()) {

            System.out.println("Reservation ID: " + reservationId);

            List<Service> services = serviceMap.get(reservationId);

            double totalCost = 0;

            for (Service s : services) {
                System.out.println("Service: " + s.getServiceName() +
                        " | Price: $" + s.getPrice());
                totalCost += s.getPrice();
            }

            System.out.println("Total Add-On Cost: $" + totalCost);
            System.out.println("---------------------------------");
        }

        System.out.println("\nCore booking & inventory remain unchanged.");
    }
}