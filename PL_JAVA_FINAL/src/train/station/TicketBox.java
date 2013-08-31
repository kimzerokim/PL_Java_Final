package train.station;

import passenger.Passenger;
import system.Main;

public class TicketBox {
	private Passenger mCurTicketingPassenger;
	private int mCurPassengerArriveTime;
	private int mCurPassengerTicketingFinishTime;

	public void receivePassenger(Passenger passenger) {
		mCurTicketingPassenger = passenger;
	}

	public void setPassengerInfo() {
		setCurPassengerTicketingFinishTime();
	}

	public Passenger getCurPassenger() {
		return mCurTicketingPassenger;
	}

	public Passenger completeTicketing() {
		Passenger tmp = mCurTicketingPassenger;
		mCurTicketingPassenger = null;
		return tmp;
	}

	public void setCurPassengerArriveTime() {
		mCurPassengerArriveTime = Main.getCurTime();
	}

	public void setCurPassengerTicketingFinishTime() {
		setCurPassengerArriveTime();
		mCurPassengerTicketingFinishTime = mCurPassengerArriveTime
				+ mCurTicketingPassenger.getTicketingTime();
	}

	public boolean isTicketingFinish() {
		if (Main.getCurTime() >= mCurPassengerTicketingFinishTime) {
			return true;
		} else
			return false;
	}

	public boolean isEmpty() {
		if (mCurTicketingPassenger == null) {
			return true;
		} else
			return false;
	}

	public Passenger handle() {
		if (!isEmpty()) {
			setPassengerInfo();
			if (isTicketingFinish()) {
				return completeTicketing();
			}
		}
		return null;
	}
}
