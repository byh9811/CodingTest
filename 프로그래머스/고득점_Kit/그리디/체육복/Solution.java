package 프로그래머스.고득점_Kit.그리디.체육복;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        byte[] students = new byte[n+1];        // -1: 잃어버림, 0: 여유없음, 1: 여유있음
        Arrays.sort(reserve);
        for(int elem: lost)
            students[elem]--;
        for(int elem: reserve)
            students[elem]++;

        for(int elem: reserve) {
            if(students[elem]>0) {
                if(students[elem-1]<0)
                    students[elem-1]++;
                else if(elem!=n && students[elem+1]<0)
                    students[elem+1]++;
            }
        }

        int answer = 0;
        for(byte student: students) {
            if(student>=0)
                answer++;
        }

        return answer-1;
    }
}