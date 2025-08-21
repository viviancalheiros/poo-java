package hotel;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        String checkin = scanner.next();
        
        System.out.print("Check-out date (dd/MM/yyyy): ");
        String checkout = scanner.next();
        
        Reservation reservation = new Reservation(roomNumber, Reservation.stringToDate(checkin), Reservation.stringToDate(checkout));
        long nights = reservation.duration(Reservation.stringToDate(checkin), Reservation.stringToDate(checkout));
        if (nights == -1) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else if (nights > 0) {
            System.out.printf("Reservation: Room %d, check-in: %s, checkout: %s, %d nights%n", roomNumber, checkin, checkout, nights);
        }

        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkin = scanner.next();
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkout = scanner.next();

        reservation.updateDates(Reservation.stringToDate(checkin), Reservation.stringToDate(checkout));
        
        scanner.close();
    }
}
