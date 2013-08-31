package train.station;

public class Deajeon extends TrainStation {
	private static Deajeon stationInstance;
	
	private Deajeon() {
		super(TrainStation.StationName.Deajeon);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Deajeon();
	}
}
