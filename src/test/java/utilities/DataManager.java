package utilities;

import static org.testng.Assert.*;

public class DataManager {

	private static int count;
	private static ThreadLocal<DataManager> localDataManager;
	private static String dayOfWeek;

	private DataManager() {
		count++;
	}

	public static int getCount() {
		return count;
	}

	public static DataManager getInstance() {
		if (localDataManager == null)
			localDataManager = new ThreadLocal<DataManager>();
		if (localDataManager.get() == null)
			localDataManager.set(new DataManager());
		return localDataManager.get();
	}

	public static void reset() {
		if (localDataManager != null && localDataManager.get() != null)
			localDataManager.set(null);
	}

	public String getDayOfWeek() {
		assertNotNull(dayOfWeek, "No day of week data is given.");
		return dayOfWeek;
	}

	public void setDayOfWeek(String name) {
		DataManager.dayOfWeek = name;
	}

}
