package 프로그래머스.레벨2.n제곱_배열_자르기;

public class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)(right-left)+1];

        for(long i=left; i<=right; i++) {
            int idx = (int)(i-left);
            answer[idx] = i%n + 1;
            if(i/n>i%n)
                answer[idx] += i/n - i%n;
        }

        return answer;
    }
}