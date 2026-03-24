import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        // 1. Setup the Inventory and Request Queue
        RoomInventory inventory = new RoomInventory();
        Queue<String> bookingRequests = new LinkedList<>();

        // 2. Add some simulated requests to the queue (FIFO)
        bookingRequests.add("Single Room");
        bookingRequests.add("Suite Room");
        bookingRequests.add("Single Room"); // A second request for the same type

        System.out.println("--- Starting Room Allocation Process ---");

        // 3. Process the Queue until empty
        while (!bookingRequests.isEmpty()) {
            String requestedType = bookingRequests.poll(); // Consume the request
            processReservation(requestedType, inventory);
        }

        System.out.println("\n--- Final Inventory Status ---");
        System.out.println(inventory.getRoomAvailability());
    }

    /**
     * The core logic: Safely checks inventory and allocates a room.
     */
    public static void processReservation(String roomType, RoomInventory inventory) {
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        int availableCount = currentAvailability.getOrDefault(roomType, 0);

        if (availableCount > 0) {
            // SUCCESS: Allocate the room and decrement the count
            int newCount = availableCount - 1;
            inventory.updateAvailability(roomType, newCount);

            System.out.println("CONFIRMED: Reserved 1 [" + roomType + "]. Remaining: " + newCount);
        } else {
            // FAILURE: No rooms left
            System.out.println("REJECTED: No [" + roomType + "] available for this request.");
        }
    }
}