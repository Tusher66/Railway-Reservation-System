package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainService {
	
	private static List<Train> allTrain=new LinkedList<>();

	static {
		allTrain.add(new Train(101,"Bonolata","Rajshahi","Dhaka",125,375,LocalDate.now()));
		allTrain.add(new Train(102,"Padma","Rajshahi","Dhaka",100,345,LocalDate.now()));
		allTrain.add(new Train(103,"Silksity","Rajshahi","Dhaka",102,345,LocalDate.now()));
		allTrain.add(new Train(104,"Dumkatu","Rajshahi","Dhaka",134,345,LocalDate.now()));
		allTrain.add(new Train(105,"Titumir","Rajshahi","Dinajpur",19,250,LocalDate.now()));
		allTrain.add(new Train(106,"Sagordari","Rajshahi","Khulna",143,125,LocalDate.now()));
		allTrain.add(new Train(107,"Borandro","Rajshahi","Dinajpur",25,250,LocalDate.now()));
	
	}
	public TrainService() {
		super();
	}
	
	public static Train findTrain(int trainNumber) {
		Train temp=null;
		for(Train t:allTrain) {
			if(t.getTrainNumber()==trainNumber){
				temp=t;
				break;
			}
		}
		return temp;
	}


public static void searchTrainsBetweenStations(String fromStation,String toStation, LocalDate doj,int numofSeats) {
	List<Train> searchTrainList=new LinkedList<>();
	for(Train t:allTrain) {
		if(t.getFromStation().equals(fromStation) && t.getToStation().equals(toStation) && t.getDoj().equals(doj) && t.getSeatsAvailable() > numofSeats) {
			searchTrainList.add(t);
		}
	
	}
	if(searchTrainList.size()==0) {
		System.out.println("Sorry, no matching train available for the search criteria !");
	}
	
	else {
		System.out.println("Tr.No\tTrain Name\tFrom Station\tTo Station\tDoj\tSeats Available\tFare");
		System.out.println();
		for(Train t: searchTrainList) {
		System.out.printf("%4d%20s%15s%15s%12s%4d%5d\n", t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj(),t.getSeatsAvailable(),t.getFare());
		
		//System.out.println("%4d%20s%15s%15s%12s%4d%5d", t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj,t.getSeatsAvailable(),t.getFare());
	}}
}

	public static void bookTickets(int trainNumber,List<Passenger> passengerList) {
		
		//step-1 we need to subtract the train fare for all paSSENGER together from the bank account object
		int numofSeats= passengerList.size();
		
		/*Passenger tempPassenger=passengerList.get(0);
		BankAccount account=tempPassenger.getBankAccount();*/
		
		BankAccount account=passengerList.get(0).getBankAccount();
		
		Train tempTrain=findTrain(trainNumber);
		int fare=tempTrain.getFare();
		int totalFare=fare* numofSeats;
		//step-2 we need to subtract the number of tickets that are being booked, from the actual available no of ticket 
		tempTrain.setSeatsAvailable(tempTrain.getSeatsAvailable()-numofSeats);
		
		
		 //step-3 we need to add one entry(one record) into ticket collection.
		TicketService.addNewTicket(trainNumber,passengerList);
		
	} 




}


