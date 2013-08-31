package train;

import passenger.Passenger;
import system.Main;

public class TicketBox {
	private static TicketBox boxInstance;
	private Passenger mCurTicketingPassenger;
	private int mCurTime;
	private int mCurPassengerArriveTime;
	private int mCurPassengerTicketingFinishTime;

	public static TicketBox createTicketBox() {
		if (boxInstance != null) {
			return boxInstance;
		}
		return boxInstance = new TicketBox();
	}

	public void receivePassenger(Passenger passenger) {
		mCurTicketingPassenger = passenger;
	}

	public void setPassengerInfo() {
		setCurPassengerArriveTime();
		mCurTicketingPassenger.setTicketingStartTime(mCurPassengerArriveTime);
	}
	
	public Passenger completeTicketing() {
		return mCurTicketingPassenger;
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
	
	public Passenger TicketingDependCurTime(Passenger passenger) {
		receivePassenger(passenger);
		setPassengerInfo();
		if (isTicketingFinish()) {
			return completeTicketing();
		}
		else
			return null;
	}
}
