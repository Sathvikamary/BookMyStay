import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UseCase4RoomSearch {

    public static void main(String[] args) {
        // 1. Setup Data (In a real app, these would come from a Database)
        RoomInventory inventory = new RoomInventory();
        List<Room> allRooms = getInitialRoomData();

        // 2. Perform Search (Read-Only)
        System.out.println("--- Guest Room Search Results ---");
        System.out.println("Showing all rooms with current availability:\n");

        searchAvailableRooms(allRooms, inventory);
    }

    /**
     * This method demonstrates read-only access.
     * It views data without modifying the inventory Map.
     */
    public static void searchAvailableRooms(List<Room> rooms, RoomInventory inventory) {
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();

        boolean found = false;
        for (Room room : rooms) {
            int count = currentAvailability.getOrDefault(room.getType(), 0);

            // Only display if availability is greater than 0
            if (count > 0) {
                displayRoomDetails(room, count);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Sorry, no rooms are currently available.");
        }
    }

    private static void displayRoomDetails(Room room, int availableCount) {
        System.out.println("Type: " + room.getType());
        System.out.println("Price: $" + room.getPricePerNight());
        System.out.println("Status: " + availableCount + " rooms remaining");
        System.out.println("---------------------------------");
    }

    private static List<Room> getInitialRoomData() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Single Room", 1, 250, 1500.0));
        rooms.add(new Room("Double Room", 2, 400, 2500.0));
        rooms.add(new Room("Suite Room", 3, 750, 5000.0));
        return rooms;
    }
}