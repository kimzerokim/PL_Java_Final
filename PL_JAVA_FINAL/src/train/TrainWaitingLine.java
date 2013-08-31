package train;

import java.util.ArrayList;
import java.util.List;

import passenger.Passenger;
import system.Main;

public class TrainWaitingLine {
	private List<Passenger> mWaitingTrainLine = new ArrayList<Passenger>();

	public void inputPassenger(Passenger passenger) {
		mWaitingTrainLine.add(passenger);
	}

	public boolean isTrainArrive() {
		if (Main.getCurTime() % 5 == 0)
			return true;
		else
			return false;
	}

	public void clearWaitingList() {
		mWaitingTrainLine.clear();
	}

	public void handle() {
		int numberOfWaitingPeople = mWaitingTrainLine.size();
		if (isTrainArrive()) {
			clearWaitingList();
		} else {
			if (!mWaitingTrainLine.isEmpty()) {
				for (int i = 0; i < numberOfWaitingPeople; i++) {
					mWaitingTrainLine.get(i).increaseWaitingTrainTime();
				}
			}
		}
	}
}
