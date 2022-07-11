package 프로그래머스.레벨2.숫자_블록;

public class Solution {
    final int MAX = 10000000;

    public int[] solution(long begin, long end) {
        int e = (int)end;
        int b = (int)begin;

        int[] answer = new int[e-b+1];

        for(int i=b; i<=e; i++)
            answer[i-b] = getBlockNum(i);

        return answer;
    }

    private int getBlockNum(int num) {
        if(num==1)
            return 0;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0 && (num/i)<=MAX)
                return num/i;
        }

        return 1;
    }
}