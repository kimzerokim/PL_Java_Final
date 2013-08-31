package train.station;

public class Kyungju extends TrainStation {
	private static Kyungju stationInstance;
	
	private Kyungju() {
		super(TrainStation.StationName.Kyungju);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Kyungju();
	}
}
