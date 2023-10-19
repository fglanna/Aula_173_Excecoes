package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Resevation;

public class HotelReservation {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(scan.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(scan.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in Reservation: Check-out date must be after check-in date");

		} else {
			Resevation resevation = new Resevation(number, checkin, checkout);
			System.out.println("Reservation: " + resevation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(scan.next());

			String error = resevation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + resevation);
			}
		}
	}
}
