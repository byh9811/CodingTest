package 백준.실버5.생일;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Date implements Comparable<Date> {
    String name;
    int year;
    int month;
    int day;

    public Date(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(Date o) {
        if(year!=o.year)
            return year-o.year;
        else if(month!=o.month)
            return month-o.month;
        else
            return day-o.day;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Date old = new Date("", 2011, 0, 0);
        Date young = new Date("", 1989, 0, 0);
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            Date cur = new Date(input[0], Integer.parseInt(input[3]), Integer.parseInt(input[2]),Integer.parseInt(input[1]));
            if(cur.compareTo(old)<0)
                old = cur;
            if(cur.compareTo(young)>0)
                young = cur;
        }

        System.out.print(young + "\n" + old);
    }
}