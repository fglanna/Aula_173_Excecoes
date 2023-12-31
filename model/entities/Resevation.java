package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Resevation {

	private Integer roomNumberInteger;
	private Date checkin;
	private Date checkout;

	public Resevation(Integer roomNumberInteger, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		this.roomNumberInteger = roomNumberInteger;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Integer getRoomNumberInteger() {
		return roomNumberInteger;
	}

	public void setRoomNumberInteger(Integer roomNumberInteger) {
		this.roomNumberInteger = roomNumberInteger;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) {

		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions("Reservation dates for updates must be future dates ");

		}
		if (!checkout.after(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");

		}
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	@Override
	public String toString() {
		return "Room " + roomNumberInteger + ", check-in: " + sdf.format(checkin) + ", ckeck-out: "
				+ sdf.format(checkout) + ", " + duration() + " nights";

	}

}
