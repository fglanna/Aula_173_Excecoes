package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Resevation;
import model.exceptions.DomainExceptions;

public class HotelReservation {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.print("Room Number: ");
			int number = scan.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(scan.next());

			Resevation resevation = new Resevation(number, checkin, checkout);
			System.out.println("Reservation: " + resevation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(scan.next());

			resevation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + resevation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		} 
		catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}
}