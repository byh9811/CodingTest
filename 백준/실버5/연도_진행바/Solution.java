package 백준.실버5.연도_진행바;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);

        StringTokenizer st = new StringTokenizer(br.readLine(), ",: ");
        int month = map.get(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int totalMinute = isLeapYear(year) ? 366*24*60 : 365*24*60;
        minute += hour * 60;
        minute += (day-1) * 24 * 60;
        minute += monthToMinute(year, month);

        System.out.print((double)minute*100/totalMinute);
    }

    private int monthToMinute(int year, int month) {
        int minute = 0;

        for(int i=1; i<13; i++) {
            if(i==month)
                break;

            minute += getDays(year, i) * 1440;
        }

        return minute;
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
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2: return isLeapYear(year) ? 29 : 28;
            default: return -1;
        }
    }
}