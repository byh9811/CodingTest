package 그리디.단속카메라;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int last = -30001;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int[] route: routes) {
            int in = route[0];
            int out = route[1];

            if(in<=last)
                continue;
            last = out;
            answer++;
        }

        return answer;
    }
}