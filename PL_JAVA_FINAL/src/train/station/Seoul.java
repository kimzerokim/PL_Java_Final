package train.station;

public class Seoul extends TrainStation{
	private static Seoul stationInstance;
	
	private Seoul() {
		super(TrainStation.StationName.Seoul);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Seoul();
	}
}
