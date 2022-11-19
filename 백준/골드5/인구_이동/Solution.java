package 백준.골드5.인구_이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    int N, L, R;
    int[][] map;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int answer = 0;
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            int[][] union = new int[N][N];
            int[] average = new int[N*N+1];
            int idx = 1;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(union[i][j]!=0)
                        continue;

                    average[idx] = getAverage(i, j, idx, union);
                    idx++;
                }
            }

            if(idx==N*N+1)
                break;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++)
                    map[i][j] = average[union[i][j]];
            }
            answer++;
        }

        System.out.println(answer);
    }

    private Integer getAverage(int i, int j, int idx, int[][] union) {
        int sum = 0;
        int cnt = 0;
        union[i][j] = idx;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        xq.add(j);
        yq.add(i);

        while(!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();

            if(x!=0 && union[y][x-1]==0 && L<=Math.abs(map[y][x-1]-map[y][x]) && Math.abs(map[y][x-1]-map[y][x])<=R) {
                union[y][x-1] = idx;
                xq.add(x-1);
                yq.add(y);
            }
            if(x!=N-1 && union[y][x+1]==0 && L<=Math.abs(map[y][x+1]-map[y][x]) && Math.abs(map[y][x+1]-map[y][x])<=R) {
                union[y][x+1] = idx;
                xq.add(x+1);
                yq.add(y);
            }
            if(y!=0 && union[y-1][x]==0 && L<=Math.abs(map[y-1][x]-map[y][x]) && Math.abs(map[y-1][x]-map[y][x])<=R) {
                union[y-1][x] = idx;
                xq.add(x);
                yq.add(y-1);
            }
            if(y!=N-1 && union[y+1][x]==0 && L<=Math.abs(map[y+1][x]-map[y][x]) && Math.abs(map[y+1][x]-map[y][x])<=R) {
                union[y+1][x] = idx;
                xq.add(x);
                yq.add(y+1);
            }

            sum += map[y][x];
            cnt++;
        }

        return sum/cnt;
    }
}