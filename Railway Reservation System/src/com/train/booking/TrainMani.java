package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainMani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Now Searching for Train....");
		TrainService.searchTrainsBetweenStations("Rajshahi", "Khulna", LocalDate.now(), 45);

		BankAccount b1=new BankAccount();
		b1.setActNumber(999);
		b1.setActBalance(2345);
		
		Passenger p1=new Passenger(23,"Tusher",24,b1);
		Passenger p2=new Passenger(22,"Rone",34,b1);
		Passenger p3=new Passenger(34,"Boby",37,b1);
		Passenger p4=new Passenger(29,"Tarak",45,b1);
		Passenger p5=new Passenger(54,"Bably",45,b1);
		
		int initialBalance=b1.getActBalance();
		List<Passenger> passengerList=new LinkedList<>();
		
		passengerList.add(p1);
		passengerList.add(p2);
		passengerList.add(p3);
		passengerList.add(p4);
		passengerList.add(p5);
		
		System.out.println("Now booking tickets for 3 passenger in train number 101....");
		
		TrainService.bookTickets(102, passengerList);
		
		System.out.println("Now printing the ticket details....");
		TicketService.showTicketDetails(1);
		
		System.out.println("\n\n\n");
		TrainService.searchTrainsBetweenStations("Rajshahi", "Khulna", LocalDate.now(), 45);
		
		int balanceAfterBooking=b1.getActBalance();
		
		System.out.println("Initial balance= "+initialBalance);
		System.out.println("Balance after booking = "+ balanceAfterBooking);
	
	}

}
