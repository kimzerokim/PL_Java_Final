package train.station;

import passenger.Passenger;
import system.Main;

public class TicketBox {
	private Passenger mCurTicketingPassenger;
	private int mCurTime;
	private int mCurPassengerArriveTime;
	private int mCurPassengerTicketingFinishTime;

	public void receivePassenger(Passenger passenger) {
		mCurTicketingPassenger = passenger;
	}

	public void setPassengerInfo() {
		setCurPassengerArriveTime();
		setCurPassengerTicketingFinishTime();
		mCurTicketingPassenger.setTicketingStartTime(mCurPassengerArriveTime);
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
		mCurPassengerTicketingFinishTime = mCurPassengerArriveTime + mCurTicketingPassenger.getTicketingTime();
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
	
	public Passenger ticketingDependCurTime(Passenger passenger) {
		receivePassenger(passenger);
		setPassengerInfo();
		if (isTicketingFinish()) {
			return completeTicketing();
		}
		else
			return null;
	}
}
