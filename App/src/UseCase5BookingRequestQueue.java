import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {
        // 1. Initialize the Booking Queue
        Queue<String> bookingRequests = new LinkedList<>();

        System.out.println("--- System Initialized: Accepting Booking Requests ---");

        // 2. Simulate incoming requests (Accepted in order)
        acceptRequest(bookingRequests, "Guest_01: Single Room");
        acceptRequest(bookingRequests, "Guest_02: Suite Room");
        acceptRequest(bookingRequests, "Guest_03: Double Room");

        // 3. Display the Queue Status
        displayQueueStatus(bookingRequests);
    }

    /**
     * Demonstrates how requests are accepted and queued
     * without performing inventory updates yet.
     */
    public static void acceptRequest(Queue<String> queue, String requestDetails) {
        queue.add(requestDetails);
        System.out.println("LOG: Received request -> " + requestDetails);
    }

    public static void displayQueueStatus(Queue<String> queue) {
        System.out.println("\n--- Current Booking Queue (Predictable Order) ---");
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            int position = 1;
            for (String request : queue) {
                System.out.println("Position " + position + ": " + request);
                position++;
            }
        }
        System.out.println("\nNote: No room allocation or inventory update has been performed yet.");
    }
}