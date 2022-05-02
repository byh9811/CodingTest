package 프로그래머스.고득점_Kit.그래프.순위;

public class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] winBoard = new boolean[n+1][n+1];
        int answer = 0;

        for(int i=0; i<results.length; i++)
            winBoard[results[i][0]][results[i][1]] = true;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                for(int k=1; k<n+1; k++) {
                    if(winBoard[j][i] && winBoard[i][k])
                        winBoard[j][k] = true;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            int match = 0;
            for(int j=1; j<n+1; j++) {
                if(winBoard[i][j] || winBoard[j][i])
                    match++;
            }
            if(match==n-1)
                answer++;
        }

        return answer;
    }
}