package 프로그래머스.레벨2.교점에_별_만들기;

import java.util.Arrays;
import java.util.HashSet;

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private HashSet<Point> set = new HashSet<>();
    long minY = Long.MAX_VALUE;
    long maxY = Long.MIN_VALUE;
    long minX = Long.MAX_VALUE;
    long maxX = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        for(int i=0; i<line.length-1; i++) {
            for(int j=i+1; j<line.length; j++)
                getIntersection(line[i], line[j]);
        }

        long rowSize = maxY - minY + 1;
        long colSize = maxX - minX + 1;
        String[] answer = new String[(int)rowSize];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<colSize; i++)
            sb.append('.');
        Arrays.fill(answer, sb.toString());

        for(Point p: set) {
            int col = (int)(p.x - minX);
            int row = (int)(maxY - p.y);

            answer[row] = answer[row].substring(0, col) + "*" + answer[row].substring(col+1);
        }

        return answer;
    }

    private void getIntersection(int[] exp1, int[] exp2) {
        long a = exp1[0];
        long b = exp1[1];
        long c = exp1[2];
        long d = exp2[0];
        long e = exp2[1];
        long f = exp2[2];

        long bfce = b*f - c*e;
        long aedb = a*e - b*d;
        long cdaf = c*d - a*f;

        if(bfce%aedb!=0 || cdaf%aedb!=0)
            return;

        long x = bfce / aedb;
        long y = cdaf / aedb;

        set.add(new Point(x, y));
        minY = Math.min(minY, y);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        maxX = Math.max(maxX, x);
    }
}