package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import passenger.Passenger;

public class ExcelReader {
	public List<Passenger> getAllPassengers() {
		Workbook workbook = getWorkbook("./resource/JavaFinal.xls");
		Sheet sheet = workbook.getSheet(1); // JavaFinal 2번째 sheet를 읽어온다.

		List<Passenger> passengers = new ArrayList<Passenger>();
		for (int i=1; i<=50; i++)
			passengers.add(readPassengerInfo(sheet, i));
		workbook.close();
		
		return passengers;
	}
	
	private Passenger readPassengerInfo(Sheet sheet, int idx) {
		Passenger passenger = Passenger.createPassenger();
		passenger.setArriveTime(readPassengerArriveTime(sheet, idx));
		passenger.setTicketingTime(readPassengerTicketingTime(sheet, idx));
		passenger.setStartStation(readPassengerStartStation(sheet, idx));
		passenger.setArriveStation(readPassengerArriveStation(sheet, idx));
		
		return passenger;
	}
	
	private Workbook getWorkbook(String filePath) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(filePath));
		} catch(Exception e) {
			System.out.println("ExcelFile open error");
		}
		return workbook;
	}
	
	private int readPassengerArriveTime(Sheet sheet, int passengerID) {
		return Integer.parseInt(sheet.getCell(2, passengerID).getContents());
	}
	
	private int readPassengerTicketingTime(Sheet sheet, int passengerID) {
		return Integer.parseInt(sheet.getCell(3, passengerID).getContents());
	}
	
	private String readPassengerStartStation(Sheet sheet, int passengerID) {
		return sheet.getCell(4, passengerID).getContents();
	}
	
	private String readPassengerArriveStation(Sheet sheet, int passengerID) {
		return sheet.getCell(5, passengerID).getContents();
	}
}
