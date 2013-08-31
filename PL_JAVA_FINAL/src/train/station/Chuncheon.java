package train.station;

public class Chuncheon extends TrainStation {
	private static Chuncheon stationInstance;
	
	private Chuncheon() {
		super(TrainStation.StationName.Chuncheon);
	}
	
	public static TrainStation getInstance() {
		if (stationInstance != null)
			return stationInstance;
		return stationInstance = new Chuncheon();
	}
}
