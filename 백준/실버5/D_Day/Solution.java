package 백준.실버5.D_Day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(" ");
        String[] end = br.readLine().split(" ");
        int sy = Integer.parseInt(start[0]);
        int sm = Integer.parseInt(start[1]);
        int sd = Integer.parseInt(start[2]);
        int ey = Integer.parseInt(end[0]);
        int em = Integer.parseInt(end[1]);
        int ed = Integer.parseInt(end[2]);
        int day = 0;

        if(ey-sy>1000 || (ey-sy==1000 && em-sm>0) || (ey-sy==1000 && em-sm==0 && ed-sd>=0)) {
            System.out.println("gg");
            return;
        }

        for(int i=sy; i<ey; i++)
            day += isLeapYear(i) ? 366 : 365;
        for(int i=sm; i<em; i++)
            day += getDays(ey, i);
        day += ed-sd;

        System.out.println("D-" + day);
    }

    private boolean isLeapYear(int year) {
        if(year%400==0)
            return true;
        else if(year%100==0)
            return false;
        else if(year%4==0)
            return true;
        else
            return false;
    }

    private int getDays(int year, int month) {
        switch (month) {
            case 2: return isLeapYear(year) ? 29 : 28;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            default: return 30;
        }
    }
}