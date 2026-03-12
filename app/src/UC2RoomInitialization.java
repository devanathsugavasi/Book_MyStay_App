public class UC2RoomInitialization {

    public static void main(String[] args) {

        // Create room objects
        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 10;
        int doubleAvailable = 6;
        int suiteAvailable = 3;

        System.out.println("Hotel Room Availability\n");

        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailable);
        System.out.println("--------------------------------");

        doub.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailable);
        System.out.println("--------------------------------");

        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
    }
}