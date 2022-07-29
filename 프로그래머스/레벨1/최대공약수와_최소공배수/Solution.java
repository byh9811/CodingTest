package 프로그래머스.레벨1.최대공약수와_최소공배수;

public class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(Math.max(n, m), Math.min(n, m));
        int lcm = getLCM(n, m, gcd);
        return new int[]{gcd, lcm};
    }

    private int getLCM(int n, int m, int lcm) {
        return n*m/lcm;
    }

    private int getGCD(int max, int min) {
        return min==0 ? max : getGCD(Math.max(max%min, min), Math.min(max%min, min));
    }
}