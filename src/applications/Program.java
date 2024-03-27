package applications;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
        Integer roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy):");
        //recebe a data como string e faz parse/conversao para tipo date
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyyy):");
        //recebe a data como string e faz parse/conversao para tipo date
        Date checkOut = sdf.parse(sc.next());
        
        //se data checkout nao for posterior a data de checkin 
        if(!checkOut.after(checkIn)) {
        	System.out.print("Error in reservation: check-out date must be after check-in date");
        }else {
        	//Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
        	Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
        	System.out.println("Reservation: "+ reservation);  
        	
        	System.out.println(); 
        	System.out.println("Enter data to update the reservation:"); 
        	System.out.print("Check-in date (dd/mm/yyyy):");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy):");
            checkOut = sdf.parse(sc.next());
            
          
            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null) {
            	System.out.println("Error in reservation: "+ error);
            } else {
            	System.out.println("Reservation: "+ reservation);      	
            }   
        }
        
        sc.close();
        
	}

}
