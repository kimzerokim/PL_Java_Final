package passenger;

import java.util.List;

import util.ExcelReader;

public class PassengerData {
	private List<Passenger> mPassengers;
	
	public void readAllPassengers() {
		ExcelReader reader = new ExcelReader();
		mPassengers = reader.getAllPassengers();
	}
	
	public Passenger getPassenger(int idx) {
		return mPassengers.get(idx);
	}
	
	public List<Passenger> getPassengerList() {
		return mPassengers;
	}
}
