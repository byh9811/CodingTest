package 프로그래머스.레벨2.하노이의_탑;

import java.util.ArrayList;

public class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> answer = new ArrayList<>();

        hanoi(1, 2, 3, n, answer);

        int[][] ret = new int[answer.size()][2];
        for(int i=0; i<answer.size(); i++)
            ret[i] = answer.get(i);

        return ret;
    }

    private void hanoi(int origin, int stopover, int destination, int n, ArrayList<int[]> answer) {
        if(n==1)
            answer.add(new int[]{origin, destination});
        else {
            hanoi(origin, destination, stopover, n-1, answer);
            answer.add(new int[]{origin, destination});
            hanoi(stopover, origin, destination, n-1, answer);
        }
    }
}