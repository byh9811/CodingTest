package 프로그래머스.레벨2.멀쩡한_사각형;

public class Solution {
    public long solution(int w, int h) {
        if(w==h)
            return (long)w*(long)h-(long)w;

        long gcd = gcd(w, h);
        long pw = w / gcd;
        long ph = h / gcd;
        return (long)w*(long)h-(gcd*(pw+ph-1));
    }

    private int gcd(int a, int b) {
        if(a%b==0)
            return b;
        return gcd(b, a%b);
    }
}