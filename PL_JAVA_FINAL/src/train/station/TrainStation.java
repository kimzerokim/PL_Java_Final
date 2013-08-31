package train.station;

import java.util.LinkedList;
import java.util.Queue;

import passenger.Passenger;
import train.TrainWaitingLine;

public class TrainStation {
	private static TrainStation _instance;
	private Queue<Passenger> mTicketWaitingLine = new LinkedList<Passenger>();
	private TicketBox mBox1 = new TicketBox();
	private TicketBox mBox2 = new TicketBox();
	private TicketBox mBox3 = new TicketBox();
	private TrainWaitingLine mTrainWaitingLine = new TrainWaitingLine();

	private TrainStation() {
	}

	public static TrainStation getInstance() {
		if (_instance != null) {
			return _instance;
		}
		return _instance = new TrainStation();
	}

	private void pushPassenger(Queue<Passenger> curQueue, Passenger passenger) {
		curQueue.add(passenger);
	}

	public void inputPassengerToTicketWaitingLine(Passenger passenger) {
		pushPassenger(mTicketWaitingLine, passenger);
	}

	public void checkTicketWaitingLine() { // for Test
		int LineLength = mTicketWaitingLine.size();
		for (int i = 0; i < LineLength; i++) {
			Passenger curPassenger = mTicketWaitingLine.poll();
			System.out.println(curPassenger.toString());
			pushPassenger(mTicketWaitingLine, curPassenger);
		}
	}

	public void handleTicketWaitingQueue() {
		if (mBox1.isEmpty() && mTicketWaitingLine.peek() != null)
			mBox1.receivePassenger(mTicketWaitingLine.poll());
		if (mBox2.isEmpty() && mTicketWaitingLine.peek() != null)
			mBox2.receivePassenger(mTicketWaitingLine.poll());
		if (mBox3.isEmpty() && mTicketWaitingLine.peek() != null)
			mBox3.receivePassenger(mTicketWaitingLine.poll());
	}

	public void handleTicketBox() {
		Passenger passenger;
		if ((passenger = mBox1.handle()) != null)
			mTrainWaitingLine.inputPassenger(passenger);
		if ((passenger = mBox2.handle()) != null)
			mTrainWaitingLine.inputPassenger(passenger);
		if ((passenger = mBox3.handle()) != null)
			mTrainWaitingLine.inputPassenger(passenger);
	}

	public void handleTrainWaitingLine() {
		mTrainWaitingLine.handle();		
	}
}
