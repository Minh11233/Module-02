package com.codegym;

import java.util.Scanner;

public class NextDayCalculatorTest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Mời nhập ngày: ");
        int day = sc.nextInt();
        System.out.println("Mời nhập tháng: ");
        int month =sc.nextInt();
        System.out.println("Mời nhập năm: ");
        int year = sc.nextInt();
        NextDayCalculator nextDayCalculator=new NextDayCalculator(day,month,year);
        System.out.println(nextDayCalculator.checkDay());
    }
}
