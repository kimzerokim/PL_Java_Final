package train.station;

public class Wonju extends TrainStation {
	private static Wonju stationInstance;
	
	private Wonju() {
		super(TrainStation.StationName.Wonju);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Wonju();
	}
} 
