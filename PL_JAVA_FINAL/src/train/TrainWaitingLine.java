package train;

import java.util.ArrayList;
import java.util.List;

import passenger.Passenger;
import system.Main;

public class TrainWaitingLine {
	private static TrainWaitingLine waitingLineInstance;
	private List<Passenger> mWaitingTrainLine = new ArrayList<Passenger>();
	private int mCurTime;

	public static TrainWaitingLine createTrainWaitingLine() {
		if (waitingLineInstance != null)
			return waitingLineInstance;
		else
			return waitingLineInstance = new TrainWaitingLine();
	}

	public void getCurTime() {
		mCurTime = Main.getCurTime();
	}

	public boolean isTrainArrive() {
		getCurTime();
		if (mCurTime % 5 == 0)
			return true;
		else
			return false;
	}

	public void setPassengerToTrainWaitingLine(Passenger passenger) {
		mWaitingTrainLine.add(passenger);
	}

	public void setAllPassengerTrainWaitingTime() {
		int numberOfWaitingPeople = mWaitingTrainLine.size();
		if (!isTrainArrive()) {
			for (int i = 0; i < numberOfWaitingPeople; i++) {
				mWaitingTrainLine.get(i).increaseWaitingTrainTime();
				System.out.println(mWaitingTrainLine.get(i).toString());
			}
		} else {
			for (int i = 0; i < numberOfWaitingPeople; i++) {
				////////////승객을 빼주는데 이때 기록을 하자.
			}
		}
	}
	
	public void boardingPassengerToTrain() {
		
	}

}
