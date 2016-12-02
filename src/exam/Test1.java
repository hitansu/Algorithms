package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// write your code in Java SE 8
		solution("", "");

	}

	public static int solution(String E, String L) {
		String E_format[] = E.split(":");

		String L_format[] = L.split(":");

		int E_time = Integer.parseInt(E_format[0]) * 60 + Integer.parseInt(E_format[1]);

		int L_time = Integer.parseInt(L_format[0]) * 60 + Integer.parseInt(L_format[1]);

		int amount = 2, factor = 0;

		if ((L_time - E_time) % 60 == 0)

			factor = (L_time - E_time) / 60;

		else
			factor = ((L_time - E_time) / 60) + 1;

		if (factor >= 1) {

			amount += 3;

			factor -= 1;

		}

		amount = amount + factor * 4;

		return amount;
	}
	
    public long solution1(String E, String L) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date d1 = null;
        Date d2 = null;
        try {
               d1 = format.parse(E);
               d2 = format.parse(L);
        } catch (ParseException e) {
               e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        long totalHour = diffHours + (diffMinutes > 0 ? 1 : 0);
        long firstHour = totalHour > 1 ? 1 : 0;
        long totalCost = 2 + 3 * firstHour + (totalHour - firstHour) * 4;
        return totalCost;
  }


}
