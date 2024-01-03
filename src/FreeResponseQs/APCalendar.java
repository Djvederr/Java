package FreeResponseQs;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class APCalendar
{

/**
     * Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year. Precondition: The
     * date represented by month, day, year is a valid date.
     */
    
private static int dayOfYear(int month, int day, int year)
    {
        int n=0;
        int months[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<month;i++){
            if (isLeapYear(year) && i==2) {
                n += months[i] + 1;
            }
            else{
                n += months[i];
            }
        }
        n+=day;
        return n;
    }

/**
     * Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ..., and 6
     * denotes Saturday. Precondition: The date represented by month, day, year is
     * a valid date.
     */
   
 public static int dayOfWeek(int month, int day, int year)
    {
        int days=dayOfYear(month,day,year)+firstDayOfYear(year)-1;
        return days%7;
    }

    

    public static void main(String[] args)
    {
        int answer = APCalendar.dayOfWeek(10, 2, 2023);
        System.out.println("Your answer should be 2: " + answer);
	System.out.println("Your answer should be 6: " + dayOfWeek(1, 5, 2019));
    }


    /**
     * Returns the value representing the day of the week for the first day of
     * year, where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year)
    {
        GregorianCalendar gc = new GregorianCalendar(year, Calendar.JANUARY, 1);
        return gc.get(Calendar.DAY_OF_WEEK) - 1;
    }

 /** Returns true if year is a leap year and false otherwise. */

 private static boolean isLeapYear(int year)
    {
        return new GregorianCalendar().isLeapYear(year);
    }

    
}

