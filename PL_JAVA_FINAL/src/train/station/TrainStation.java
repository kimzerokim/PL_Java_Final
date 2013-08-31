package train.station;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import passenger.Passenger;
import system.Main;
import train.*;

public class TrainStation {
	public enum StationName {
		Seoul, Wonju, Chuncheon, Asan, Deajeon, Kyungju, Gwangju;
	}

	protected StationName mStationName;
	private Queue<Passenger> mTicketReservationLine = new LinkedList<Passenger>();
	private Queue<Passenger> mTicketWaitingLine = new LinkedList<Passenger>();
	private List<TicketBox> mEmptyTicketBox = new ArrayList<TicketBox>();
	private TicketBox mBox1 = TicketBox.createTicketBox();
	private TicketBox mBox2 = TicketBox.createTicketBox();
	private TicketBox mBox3 = TicketBox.createTicketBox();
	private TrainWaitingLine mTrainWaitingLine = TrainWaitingLine.createTrainWaitingLine();

	protected TrainStation(StationName name) {
		mStationName = name;
	}

	public static TrainStation getTrainStation(String startStation) {
		switch (startStation) {
		case "Asan":
			return Asan.getInstance();
		case "Chuncheon":
			return Chuncheon.getInstance();
		case "Deajeon":
			return Deajeon.getInstance();
		case "Gwangju":
			return Gwangju.getInstance();
		case "Kyungju":
			return Kyungju.getInstance();
		case "Seoul":
			return Seoul.getInstance();
		case "Wonju":
			return Wonju.getInstance();

		default:
			return null;
		}
	}

	private void pushPassenger(Queue<Passenger> curQueue, Passenger passenger) {
		curQueue.add(passenger);
	}

	private Passenger pullPassenger(Queue<Passenger> curQueue) {
		if (!curQueue.isEmpty())
			return curQueue.poll();
		else {
			System.out.println("waitingQueue is Empty");
			return null;
		}
	}

	public void setPassengerToTicketReservationLine(Passenger passenger) {
		pushPassenger(mTicketReservationLine, passenger);
	}

	public Passenger getPassengerFromTicketReservationLine() {
		return pullPassenger(mTicketReservationLine);
	}

	public void setPassengerToTicketWaitingLine() {
		Passenger handlePassenger = mTicketReservationLine.peek();
		if (handlePassenger.getArriveTime() == Main.getCurTime()) {
			handlePassenger = getPassengerFromTicketReservationLine();
			pushPassenger(mTicketWaitingLine, handlePassenger);
		} else
			return;
	}

	public void checkReservationLine() { // for Test
		while (mTicketReservationLine.peek() != null) {
			System.out.println(mTicketReservationLine.poll());
		}
	}

	public void checkTicketWaitingLine() { // for Test
		int LineLength = mTicketWaitingLine.size();
		for (int i = 0; i < LineLength; i++) {
			Passenger curPassenger = mTicketWaitingLine.poll();
			System.out.println(curPassenger.toString());
			pushPassenger(mTicketWaitingLine, curPassenger);
		}
	}

	public List<TicketBox> checkEmptyTicketBox() {
		if (mBox1.isEmpty())
			mEmptyTicketBox.add(mBox1);
		if (mBox2.isEmpty())
			mEmptyTicketBox.add(mBox2);
		if (mBox3.isEmpty())
			mEmptyTicketBox.add(mBox3);
		return mEmptyTicketBox;
	}
	
	public TicketBox setPassengerToTicketBox() {  // 한번에 같은 출발지의 사람이 같은 시간에 오지 않는다.(데이터에서)
		TicketBox curBox;
		checkEmptyTicketBox();
		if (!mEmptyTicketBox.isEmpty()) {
			curBox = mEmptyTicketBox.get(0);
			curBox.receivePassenger(mTicketWaitingLine.poll());
			return curBox;
		}
		else {
			mTicketWaitingLine.peek().setTicketWaitingTime();
			return null;
		}			
	}
	
	


}
