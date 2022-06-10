package 프로그래머스.레벨2.배달;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                if(i==j)
                    continue;
                map[i][j] = 500001;
            }
        }

        for(int[] elem: road) {
            int node1 = elem[0];
            int node2 = elem[1];
            int dist = elem[2];

            if(map[node1][node2]<dist)
                continue;

            map[node1][node2] = dist;
            map[node2][node1] = dist;
        }

        for(int k=1; k<N+1; k++) {
            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    if(map[i][j]>map[i][k]+map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        for(int i=1; i<N+1; i++) {
            if(map[1][i]>K)
                continue;
            answer++;
        }

        return answer;
    }
}