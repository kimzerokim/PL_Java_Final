package passenger;

public class Passenger {
	private static int mID = 1;

	private int mPassengerID;
	// private String mPassengerName;
	private int mArriveTime;
	private int mTicketingLineArriveTime;
	
	public int getTicketingLineArriveTime() {
		return mTicketingLineArriveTime;
	}

	public void setTicketingLineArriveTime(int mTicketingLineArriveTime) {
		this.mTicketingLineArriveTime = mTicketingLineArriveTime;
	}

	private int mTicketingRequireTime; // 티켓팅소요시간
	private String mStartStation;
	private String mArriveStation;
	private int mTicketWaitingTime;
	
	public void setTicketWaitingTime(int mTicketWaitingTime) {
		this.mTicketWaitingTime = mTicketWaitingTime;
	}

	private int mTicketingFinishTime;
	private int mWaitingTrainTime;
	private int mTrainStartTime;
	private int mTrainArriveTime;

	public static Passenger createPassenger() {
		return new Passenger(mID++);
	}

	private Passenger(int passengerID) {
		mPassengerID = passengerID;
	}

	public int getID() {
		return mPassengerID;
	}

	public void setArriveTime(int arriveTime) {
		mArriveTime = arriveTime;
	}

	public int getArriveTime() {
		return mArriveTime;
	}

	public void setTicketingTime(int ticketingTime) {
		mTicketingRequireTime = ticketingTime;
	}

	public int getTicketingRequireTime() {
		return mTicketingRequireTime;
	}

	public void setStartStation(String startStation) {
		mStartStation = startStation;
	}

	public String getStartStation() {
		return mStartStation;
	}

	public void setArriveStation(String arriveStation) {
		mArriveStation = arriveStation;
	}

	public String getArriveStation() {
		return mArriveStation;
	}

	public void increaseTicketWaitingTime() {
		mTicketWaitingTime++;
	}

	public int getTicketWaitingTime() {
		return mTicketWaitingTime;
	}
	
	public int getmTicketingFinishTime() {
		return mTicketingFinishTime;
	}

	public void setTicketingFinishTime(int finishTime) {
		this.mTicketingFinishTime = finishTime;
	}

	public void increaseWaitingTrainTime() {
		mWaitingTrainTime++;
	}

	public int getWaitingTrainTime() {
		return mWaitingTrainTime;
	}

	public void setTrainStartTime(int time) {
		mTrainStartTime = time;
	}

	public int getTrainStartTime() {
		return mTrainStartTime;
	}

	public void setTrainArriveTime(int time) {
		mTrainArriveTime = time;
	}

	public int getTrainArriveTime() {
		return mTrainArriveTime;
	}

	@Override
	public String toString() {
		return "Passenger [mPassengerID=" + mPassengerID + ", mArriveTime="
				+ mArriveTime + ", mTicketingRequireTime="
				+ mTicketingRequireTime + ", mStartStation=" + mStartStation
				+ ", mArriveStation=" + mArriveStation
				+ ", mTicketWaitingTime=" + mTicketWaitingTime
				+ ", mTicketingFinishTime=" + mTicketingFinishTime
				+ ", mWaitingTrainTime=" + mWaitingTrainTime
				+ ", mTrainStartTime=" + mTrainStartTime
				+ ", mTrainArriveTime=" + mTrainArriveTime + "]";
	}



}
