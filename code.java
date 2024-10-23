import java.util.Scanner;

public class FlightReservation {
    private static final int NUM_SEATS = 130;
    private static boolean[] seats = new boolean[NUM_SEATS];
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("Book your flight with a happy ease");
            System.out.println("a. Reserve a seat");
            System.out.println("b. View available seats");
            System.out.println("c. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            switch (choice) {
                case "a":
                    reserveSeat();
                    break;

                case "b":
                    viewAvailableSeats();
                    break;

                case "c":
                    System.out.println("Thank you Have a safe journey!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    private static void reserveSeat() {
        System.out.print("Enter seat number (1-" + NUM_SEATS + "): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > NUM_SEATS) {
            System.out.println("Incorrect seat number. Please enter a number between 1 and " + NUM_SEATS + ".");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Sorry, that seat is already reserved.");
        } else {
            seats[seatNumber - 1] = true;
            String seatType = getSeatType(seatNumber);
            String passengerName = getPassengerName();
            int passengerAge = getPassengerAge();
            System.out.println("Seat " + seatNumber + " (" + seatType + ") reserved for " + passengerName + " (Age: " + passengerAge + ").");
        }
    }
    private static void viewAvailableSeats() {
        int availableSeats = 0;
        for (int i = 0; i < NUM_SEATS; i++) {
            if (!seats[i]) {
                String seatType = getSeatType(i + 1);
                System.out.println("Seat " + (i + 1) + " (" + seatType + ") is available.");
                availableSeats++;
            }
        }
        System.out.println("Number of available seats: " + availableSeats);
    }
    private static String getSeatType(int seatNumber) {
        String seatType = "";
        if (seatNumber <= 65 && (seatNumber == 1 || seatNumber == 2 || seatNumber % 2 == 0)) {
            seatType = "window";
        } else if (seatNumber > 65 && (seatNumber == 129 || seatNumber == 130 || seatNumber % 2 == 1)) {
            seatType = "window";
        } else {
            seatType = "normal";
        }
        return seatType;
    }

    private static String getPassengerName() {
        System.out.print("Enter passenger name: ");
        String name = scanner.next();
        return name;
    }
    private static int getPassengerAge() {
        System.out.print("Enter passenger age: ");
        int age = scanner.nextInt();
        return age;
    }
}
