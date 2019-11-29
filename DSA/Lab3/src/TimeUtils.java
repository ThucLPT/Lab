import java.util.*;

public class TimeUtils {
	public static long now() {
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		return currentDate.getTime();
	}
}
