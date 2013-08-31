package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import passenger.Passenger;

public class ResultReporter {
	public static void makeResultFile(List<Passenger> resultList) {
		PrintWriter result = null;
		try {
			result = new PrintWriter(new FileWriter("output.txt"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < resultList.size(); i++) {
			String passengerInfo = resultList.get(i).toString();
			result.write(passengerInfo);
		}
		result.close();
	}
}
