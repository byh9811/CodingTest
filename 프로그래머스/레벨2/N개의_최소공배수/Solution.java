package 프로그래머스.레벨2.N개의_최소공배수;

public class Solution {
    public int solution(int[] arr) {
        int lcm = 1;

        for(int elem: arr)
            lcm = lcm * elem / getGCD(Math.max(lcm, elem), Math.min(lcm, elem));

        return lcm;
    }

    private int getGCD(int max, int min) {
        return max%min==0 ? min : getGCD(min, max%min);
    }
}