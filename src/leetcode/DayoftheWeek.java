package leetcode;

import java.time.LocalDateTime;

public class DayoftheWeek {

    public static void main(String[] args) {
        int day = 31, month = 8, year = 2019;
        System.out.println(dayOfTheWeek(day,month,year));
    }
    public static String dayOfTheWeek(int day, int month, int year) {


        LocalDateTime time = LocalDateTime.of(year,month,day,0,0);
        String temp = String.valueOf(time.getDayOfWeek());
        return temp.substring(0,1)+temp.substring(1).toLowerCase();
    }
}
