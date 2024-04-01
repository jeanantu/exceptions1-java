package applications;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number:");
	        Integer roomNumber = sc.nextInt();
	        System.out.print("Check-in date (dd/mm/yyyy):");
	        //recebe a data como string e faz parse/conversao para tipo date
	        Date checkIn = sdf.parse(sc.next());
	        System.out.print("Check-out date (dd/mm/yyyy):");
	        //recebe a data como string e faz parse/conversao para tipo date
	        Date checkOut = sdf.parse(sc.next());
	        
	
	    	Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
	    	System.out.println("Reservation: "+ reservation);  
	    	
	    	System.out.println(); 
	    	System.out.println("Enter data to update the reservation:"); 
	    	System.out.print("Check-in date (dd/mm/yyyy):");
	        checkIn = sdf.parse(sc.next());
	        System.out.print("Check-out date (dd/mm/yyyy):");
	        checkOut = sdf.parse(sc.next());
	        
	      
	        reservation.updateDates(checkIn, checkOut);
	        System.out.println("Reservation: "+ reservation);  
		} catch (ParseException e) {
			 System.out.print("Invalid date format");
		} catch (DomainException e) {
			System.out.print("Error in reservation : "+ e.getMessage());
		} catch (Exception e) {
			 System.out.print("Error inexpected");
		}

        
        sc.close();
        
	}

}
