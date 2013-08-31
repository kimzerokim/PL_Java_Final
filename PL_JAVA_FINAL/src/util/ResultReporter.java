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
			int passengerNum = 2001+i;
			String passengerName = "Passenger"+passengerNum;
			String passengerInfo = passengerName + resultList.get(i).writePassengerInfo();			
			result.write(StringUtil.appendNewLine(passengerInfo));
		}
		result.close();
	}
}
