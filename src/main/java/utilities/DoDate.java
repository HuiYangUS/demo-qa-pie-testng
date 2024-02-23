package utilities;

import java.time.LocalDate;

public class DoDate {
	
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate result = now.minusYears(7);
		System.out.println(result);
	}

}
