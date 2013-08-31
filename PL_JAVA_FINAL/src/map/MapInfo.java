package map;

public class MapInfo {
	int dstBetweenStation[][] = { { 0, 16, 22, 1000, 29, 1000, 20 },
			{ 16, 0, 28, 31, 1000, 1000, 1000 },
			{ 22, 28, 0, 32, 23, 1000, 1000 },
			{ 1000, 31, 32, 0, 15, 18, 1000 }, { 29, 1000, 23, 15, 0, 12, 35 },
			{ 1000, 1000, 1000, 18, 12, 0, 25 },
			{ 20, 1000, 1000, 1000, 35, 25, 0 } };

	private int convertToInt(String location) {
		if (location.equals("Seoul"))
			return 0;
		if (location.equals("Chuncheon"))
			return 1;
		if (location.equals("Wonju"))
			return 2;
		if (location.equals("Kyungju"))
			return 3;
		if (location.equals("Deajeon"))
			return 4;
		if (location.equals("Gwangju"))
			return 5;
		if (location.equals("Asan"))
			return 6;
		return -1;
	}

	public void floydAlgorithm(int[][] path) {
		for (int k = 0; k < path.length; k++) {
			for (int i = 0; i < path.length; i++) {
				for (int j = 0; j < path.length; j++) {
					path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
				}
			}
		}
	}

	public int getTime(String src, String dst) {
		floydAlgorithm(dstBetweenStation);
		return dstBetweenStation[convertToInt(src)][convertToInt(dst)];
	}
}
