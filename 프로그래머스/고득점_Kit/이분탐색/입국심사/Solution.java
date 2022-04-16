package 프로그래머스.고득점_Kit.이분탐색.입국심사;

import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long left = 1;
        long right = (long)times[times.length-1] * n;

        while(left<=right) {
            long mid = (left+right) / 2;
            long checkableNum = 0;

            for(int time: times)
                checkableNum += mid / time;

            if(checkableNum<n)
                left = mid+1;
            else {
                right = mid-1;
                answer = mid;
            }
        }

        return answer;
    }
}