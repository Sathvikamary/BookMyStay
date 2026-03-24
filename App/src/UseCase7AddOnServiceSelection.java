import java.util.ArrayList;
import java.util.List;

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {
        // 1. Imagine we have a confirmed booking from Use Case 6
        String bookingId = "BK-9921";

        // 2. Initialize a list to hold the services
        List<String> selectedServices = new ArrayList<>();

        System.out.println("--- Add-On Service Selection for Booking: " + bookingId + " ---");

        // 3. Attach services (These do NOT affect RoomInventory)
        addService(selectedServices, "Complimentary Breakfast");
        addService(selectedServices, "Late Check-out (2:00 PM)");
        addService(selectedServices, "Airport Shuttle");

        // 4. Final Review
        displaySummary(bookingId, selectedServices);
    }

    /**
     * Demonstrates how optional services are attached
     * without touching room availability data.
     */
    public static void addService(List<String> services, String serviceName) {
        services.add(serviceName);
        System.out.println("ADDED: " + serviceName);
    }

    public static void displaySummary(String id, List<String> services) {
        System.out.println("\n--- Booking Summary ---");
        System.out.println("Booking Reference: " + id);
        System.out.println("Additional Services:");
        if (services.isEmpty()) {
            System.out.println("- No add-ons selected.");
        } else {
            for (String s : services) {
                System.out.println("- " + s);
            }
        }
    }
}