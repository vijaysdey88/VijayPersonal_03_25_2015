package hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {

	public String convertDirect(String input) {
		SimpleDateFormat format_ampm = new SimpleDateFormat("hh:mm:ssa");
		SimpleDateFormat format_24hr = new SimpleDateFormat("HH:mm:ss");
		Date ampm = null;
		try {
			ampm = format_ampm.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return format_24hr.format(ampm);
	}
	
	public String convert(String input) {
		validateInputPresent(input);
		Time time = parseIntoTime(input);
		validateInput(input, time);
		
		return time.to24HourFormat();
	}

	private Time parseIntoTime(String input) {
		Time time = new Time();
		time.hr = Integer.valueOf(input.substring(0, 2));
		time.min = Integer.valueOf(input.substring(3, 5));
		time.sec = Integer.valueOf(input.substring(6, 8));
		time.amOrPm = input.substring(8, input.length());
		return time;
	}

	private void validateInputPresent(String input) {
		if(input.isEmpty())
			throw new IllegalArgumentException("Should not be empty.");
	}

	private void validateInput(String input, Time time) {
		if(time.hr > 12 || time.min > 59 || time.sec > 59)
			throw new IllegalArgumentException("Invalid input.");
	}
	
	
	private static class Time {
		int hr;
		int min;
		int sec;
		String amOrPm = "AM";
		
		public String to24HourFormat() {
			int hrConverted = hr;
			if(amOrPm.equals("PM") && (hr >= 1 && hr <= 11)) {
				hrConverted = 12 + hr;
			}
			
			if(amOrPm.equals("AM") && hr == 12) {
				hrConverted = 0;
			}
			return formatted(hrConverted) + ":" + formatted(min) + ":" + formatted(sec);
		}
		
		String formatted(int unit) {
			String formatted = String.valueOf(unit);
			if(unit < 10) {
				formatted = "0" + formatted;
			} 
			return formatted;
		}
	}

	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//	}
}
