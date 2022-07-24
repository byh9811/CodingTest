package 프로그래머스.레벨1.정수_내림차순으로_배치하기;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] arr = new int[10];
        int cnt = -1;

        while(n>0) {
            arr[(int)(n%10)]++;
            cnt++;
            n /= 10;
        }

        for(int i=9; i>0; i--) {
            for(int j=0; j<arr[i]; j++, cnt--)
                answer += i*Math.pow(10, cnt);
        }

        return answer;
    }
}