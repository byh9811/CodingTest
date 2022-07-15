package 프로그래머스.레벨2.최댓값과_최솟값;

import java.util.StringTokenizer;

public class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(s);

        while(st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }

        return min + " " + max;
    }
}