package 프로그래머스.고득점_Kit.정렬.K번째수;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int idx=0; idx<commands.length; idx++) {
            int i = commands[idx][0] - 1;
            int j = commands[idx][1] - 1;
            int k = commands[idx][2] - 1;
            int[] temp = new int[j-i+1];

            for(int n=i; n<=j; n++)
                temp[n-i] = array[n];
            Arrays.sort(temp);

            answer[idx] = temp[k];
        }

        return answer;
    }
}