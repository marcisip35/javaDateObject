import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {
    public int year = (int)Math.floor((Math.random() * 200) + 1900);
    public int month = (int)Math.floor((Math.random() * 12) + 1);
    public int day = 0;

    Date(){
        //check for february
        if(checkFebruary()){
            System.out.println("February");
            if (checkLeapYear()){
                this.day = (int)Math.floor((Math.random() * 29) + 1);
            } else {
                this.day = (int)Math.floor((Math.random() * 28) + 1);
            }
        } else {
            this.day = (int)Math.floor((Math.random() * 31) + 1);
        }
    }

    public boolean checkLeapYear(){
        if(year%4 == 0){ // leap years are divisible by 4
            if(year%100 == 0){ // is the year the end of a century e.g. 1700 1800 1900 2000 2100
                if(year%400 == 0){ // if the year is the end of century, it must be divisibly by 400 to be a leap year
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean checkFebruary(){
        return month == 2;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String getDate(){
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

    public int[] getActualDate(){
        int[] actualDate = new int[3];
        actualDate[0] = year;
        actualDate[1] = month;
        actualDate[2] = day;
        return actualDate;
    }

    public String getAlphabeticalDate(){
        String str = "";
        String[] monthArray = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};

        str += getYear() + "-" + monthArray[month - 1] + "-" + getDayofWeek(getDate(),"yyyy-MM-dd");
        return str;
    }

    public String getDayofWeek(String date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(date, formatter);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        return dayOfWeek.name();
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }

    public int howManyDaysFrom(String input){

        return -1;
    }

    public String toString(){
        String str = "Date : " + getDate();
        if(checkLeapYear()){
            str += " (Leap Year)";
        }
        return str;
    }
}
