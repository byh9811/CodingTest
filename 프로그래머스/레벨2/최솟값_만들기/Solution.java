package 프로그래머스.레벨2.최솟값_만들기;

import java.util.Arrays;

public class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<n; i++)
            answer += A[i] * B[n-i-1];

        return answer;
    }
}