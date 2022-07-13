package 프로그래머스.레벨2.줄_서는_방법;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> bucket = new ArrayList<>();
        for(int i=0; i<n; i++)
            bucket.add(i+1);

        long[] fac = new long[n+1];
        fac[0] = 1;

        for(int i=1; i<=n; i++)
            fac[i] = fac[i-1] * i;

        for(int i=0; i<n-1; i++) {
            long cnt = (k-1)/fac[n-i-1];
            k -= cnt * fac[n-i-1];
            answer[i] = bucket.remove((int)cnt);
        }
        answer[n-1] = bucket.get(0);

        return answer;
    }
}