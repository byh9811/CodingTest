package DP.정수_삼각형;

public class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] max = new int[triangle.length][];
        max[0] = new int[1];
        max[0][0] = triangle[0][0];
        for(int i=1; i< triangle.length; i++) {
            max[i] = new int[i+1];
            max[i][0] = max[i-1][0] + triangle[i][0];
            for(int j=1; j<triangle[i].length-1; j++) {
                max[i][j] = Math.max(max[i-1][j-1], max[i-1][j]) + triangle[i][j];
            }
            max[i][triangle[i].length-1] = max[i-1][triangle[i].length-2] + triangle[i][triangle[i].length-1];
        }

        for(int i=0; i<max[max.length-1].length; i++) {
            answer = Math.max(answer, max[max.length-1][i]);
        }

        return answer;
    }
}