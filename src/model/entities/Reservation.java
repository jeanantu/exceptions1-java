package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	// para tratar data
	// declarado como estatico para que nao seja possivel instanciar um novo formato
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
       	 throw new DomainException ("Check-out date must be after check-in date.");
        	
        }
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public void updateDates(Date checkin, Date checkout) {
		 Date now = new Date();
         
         if(checkin.before(now) || checkout.before(now)) {
         	throw new DomainException ("Reservation dates for update must be future dates");	
         }
         
         if(!checkout.after(checkin)) {
        	 throw new DomainException ("Check-out date must be after check-in date");
         	
         } 
		this.checkIn = checkin;
		this.checkOut = checkout;

	}
	
	public long duration() {
		//recebe data e calcula em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// converte milisegundos em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in:"
			+ sdf.format(checkIn)
			+ ", check-out:"
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nigths";
	}
	

}
