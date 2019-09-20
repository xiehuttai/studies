package calendar;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Function:  Calendar
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/9/20 11:30
 */
public class Main {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println("timeInMillis: "+timeInMillis);

        TimeZone timeZone = calendar.getTimeZone();
        System.out.println("timeZone: "+timeZone);

        int weeksInWeekYear = calendar.getWeeksInWeekYear();
        System.out.println("weeksInWeekYear: "+weeksInWeekYear);

        int weekYear = calendar.getWeekYear();
        System.out.println("weekYear: "+weekYear);

        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        System.out.println("firstDayOfWeek: " + firstDayOfWeek);

        int minimalDaysInFirstWeek = calendar.getMinimalDaysInFirstWeek();
        System.out.println("minimalDaysInFirstWeek: " + minimalDaysInFirstWeek);

        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("weekOfYear: "+weekOfYear);

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("dayOfYear: "+dayOfYear);



    }

}
