package com.train.booking;

import java.util.LinkedList;
import java.util.List;

public class TicketService {
	
	private static List<Ticket>allTicket=new LinkedList<>();
	
	public static void addNewTicket(int trainNumber,List<Passenger>passengerList) {
	
		int pnr=allTicket.size()+1;
		Train bookedTrain=TrainService.findTrain(trainNumber);
		allTicket.add(new Ticket(pnr,bookedTrain ,passengerList) );
		
	}

	
	public static void showTicketDetails(int pnr) {
		Ticket tempTicket=null;
		for(Ticket t: allTicket) {
			if(t.getPnr()==pnr) {
			tempTicket=t;
			break;
			}
		}
		
		Train tempTrain=tempTicket.getBookedTrain();
		List<Passenger> passengerList=tempTicket.getPassengerList();
		int totalFare=tempTrain.getFare() * passengerList.size();
		
		System.out.println("**** YOUR BOKING DETAILS *******");
		System.out.println("PNR=> "+ tempTicket.getPnr()+" TR.NO "+tempTrain.getTrainNumber());
		
		System.out.println("Tain Name: "+tempTrain.getTrainName());
		System.out.println("From Station: "+tempTrain.getFromStation()+ "To Station: "+tempTrain.getToStation());
		System.out.println("DOJ: "+tempTrain.getDoj()+ "Fare: "+tempTrain.getFare()+" Total Fare: "+totalFare );
		
		System.out.println("\n Passenger info below\n");
		
		System.out.println("Passenger Name    Age");
		for(Passenger p: passengerList) {
			System.out.println(p.getPassengerName()+"\t"+p.getAge());
		}
		
		System.out.println("***************************************");
	}
	
	
	
	
	
	
}
