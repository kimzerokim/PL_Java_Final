package train.station;

public class Gwangju extends TrainStation {
	private static Gwangju stationInstance;
	
	private Gwangju() {
		super(TrainStation.StationName.Gwangju);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Gwangju();
	}
}
