package 프로그래머스.고득점_Kit.DP.등굣길;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] puddle: puddles)
            map[puddle[1]-1][puddle[0]-1] = -1;
        map[0][0] = 1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==1 || map[i][j]==-1)
                    continue;

                int sum = 0;
                if(i!=0 && map[i-1][j]!=-1)
                    sum += map[i-1][j];
                if(j!=0 && map[i][j-1]!=-1)
                    sum += map[i][j-1];
                map[i][j] = sum % 1000000007;
            }
        }

        return map[n-1][m-1];
    }
}