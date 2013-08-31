package train.station;

import passenger.Passenger;
import system.Main;

public class TicketBox {
	private Passenger mPassenger;
	private int mArriveTime;
	private int mFinishTime;

	public void receivePassenger(Passenger passenger) {
		mPassenger = passenger;
		mArriveTime = Main.getCurTime();
		mFinishTime = mArriveTime + mPassenger.getTicketingRequireTime();
	}

	public boolean isEmpty() {
		if (mPassenger == null)	return true;
		return false;
	}

	public Passenger handle() {
		if (isEmpty())
			return null;
		
		if (Main.getCurTime() == mFinishTime) {
			mPassenger.setTicketingFinishTime(mFinishTime);
			
			Passenger tmp = mPassenger;
			mPassenger = null;
			return tmp;
		}
		else
			return null;
	}
}
