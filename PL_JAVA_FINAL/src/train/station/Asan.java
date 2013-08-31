package train.station;

public class Asan extends TrainStation {
	private static Asan stationInstance;
	
	private Asan() {
		super(TrainStation.StationName.Asan);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Asan();
	}
}
