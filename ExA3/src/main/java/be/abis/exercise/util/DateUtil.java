package be.abis.exercise.util;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private static final String DATEFORMAT = "dd/MM/yyyy";
	private static DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern(DATEFORMAT);
	
	public static LocalDate parseDate(String value) {
		return LocalDate.parse(value,dateFormat);
	}
}
