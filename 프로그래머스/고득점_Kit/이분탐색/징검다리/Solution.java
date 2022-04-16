package 프로그래머스.고득점_Kit.이분탐색.징검다리;

import java.util.Arrays;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);

        while(left<=right) {
            int mid = (left+right) / 2;
            int prev = 0;
            int remove = 0;

            for(int rock: rocks) {
                if(rock-prev<mid)
                    remove++;
                else
                    prev = rock;
            }
            if(distance-prev<mid)
                remove++;

            if(remove<=n) {
                left = mid + 1;
                answer = mid;
            }
            else
                right = mid - 1;
        }

        return answer;
    }
}