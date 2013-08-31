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

		for (int i = 0; i < 50; i++) {
			Passenger passenger = passengerData.getPassenger(i);
			TrainStation station = TrainStation.getTrainStation(passenger.getStartStation());
			station.setPassengerToTicketReservationLine(passenger);
		}
		
		for (passedTime = 0; passedTime < 100; passedTime++) {
			Asan.getInstance().handle();
//			Chuncheon.getInstance().handle();
//			Deajeon.getInstance().handle();
//			Gwangju.getInstance().handle();
//			Kyungju.getInstance().handle();
//			Seoul.getInstance().handle();
//			Wonju.getInstance().handle();
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
