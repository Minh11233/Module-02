package com.codegym;

public class NextDayCalculator {
    int year;
    int month;
    int day;
    public NextDayCalculator(int day,int month,int year) {
        this.day=day;
        this.month=month;
        this.year=year;
        isLeapYear(year);
        is31DaysInMonth(month);
        is30DaysInMonth(month);
        isFeb29Days(month);

    }

    private boolean isLeapYear(int year) {
        this.year = year;
        boolean isDivisibleBy4 = year % 4 == 0;
        if(isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                return true;
            }
        }
        return false;
    }

    private boolean is31DaysInMonth(int month){
        this.month=month;
        switch (month ) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
        } return false;
    }
    private boolean is30DaysInMonth(int month) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return true;
        } return false;
    }
    private boolean isFeb29Days(int month) {
        if (month == 2) {
            if (isLeapYear(year)){
                return true;
            }
        } return false;
    }
//    private void is31Days(int day){
//        if (is31DaysInMonth(month) && day == 31) {
//            day = 1;
//            month++;
//        } else day++;
//    }
//    private void is30Days(int day) {
//        if (is30DaysInMonth(month) && day == 30) {
//            day = 1;
//            month++;
//        } else day++;
//    }
//    private void is29Days(int day) {
//        if (isFeb29Days(month) && day == 29) {
//            day = 1;
//            month++;
//        } else if (day == 28) {
//            day = 1;
//            month++;
//        } else day++;
//    }
//    private void isNewYear(int day,int month,int year) {
//        if (month == 12 && day == 31) {
//            day=1;
//            month=1;
//            year++;
//        }
//    }
    public String checkDay(){
        if( month == 12 && day == 31)  {
            day = 1;
            month=1;
            year++;
        } else if (is30DaysInMonth(month) && day == 30) {
            day = 1;
            month++;
        } else if (isFeb29Days(month) && day == 29) {
            day = 1;
            month++;
        } else if (!isFeb29Days(month) && day == 28) {
            day = 1;
            month++;
        } else if (is31DaysInMonth(month) && day == 31) {
            day=1;
            month++;
        } else day++;
        return "Ngày tiếp theo là ngày "+day +" tháng "+month+" năm "+year;
    }
}

