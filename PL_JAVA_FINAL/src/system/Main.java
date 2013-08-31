package system;

import passenger.Passenger;
import passenger.PassengerData;
import train.station.*;

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
			for (int i=waitCount; i<50; i++) {
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

		// 50명의 승객을 각각 TrainStation의 mTicketReservationLine에 넣어준다.
		
//		Seoul.getInstance().checkReservationLine();
	
//		for (int i = 0; i<20; i++) {
//			System.out.println(getCurTime());
//			Seoul.getInstance().setPassengerToTicketWaitingLine();
//			Seoul.getInstance().checkTicketWaitingLine();
//			timeIncrease();
//			System.out.println("--------");
//		}
	}
}
