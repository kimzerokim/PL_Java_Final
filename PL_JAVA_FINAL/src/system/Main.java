package system;

import map.MapInfo;
import passenger.Passenger;
import passenger.PassengerData;
import train.station.*;
import util.ResultReporter;

public class Main {
	private static int passedTime = 0;

	public static int getCurTime() {
		return passedTime;
	}

	public static void main(String[] args) {
		PassengerData passengerData = new PassengerData();
		passengerData.readAllPassengers();

		int waitCount = 0;
		TrainStation station = TrainStation.getInstance();
		for (passedTime = 0; passedTime < 200; passedTime++) {
			// put passenger to Ticket Waiting Queue
			for (int i = waitCount; i < 50; i++) {
				Passenger passenger = passengerData.getPassenger(i);
				if (passedTime == passenger.getArriveTime())
					station.inputPassengerToTicketWaitingLine(passenger);
				else {
					waitCount = i;
					break;
				}
			}
			// put passenger to Empty ticketbox
			station.handleTicketWaitingQueue();
			station.handleTicketBox();
			station.handleTrainWaitingLine();
		}

		// for (int i=0; i<50; i++) {
		// Passenger passenger = passengerData.getPassenger(i);
		// String startLocation = passenger.getStartStation();
		// String arriveLocation = passenger.getArriveStation();
		// System.out.println(startLocation);
		// System.out.println(arriveLocation);
		// int time = passenger.getTrainStartTime() + new
		// MapInfo().getTime(startLocation, arriveLocation);
		// passenger.setTrainArriveTime(time);
		// }

		for (int i = 0; i < 50; i++) {
			Passenger passenger = passengerData.getPassenger(i);
			String startLocation = passenger.getStartStation();
			String arriveLocation = passenger.getArriveStation();
			
			int time = passenger.getTrainStartTime()
					+ new MapInfo().getTime(startLocation, arriveLocation);
			passenger.setTrainArriveTime(time);
		}
		
		ResultReporter.makeResultFile(passengerData.getPassengerList());
	}
}
