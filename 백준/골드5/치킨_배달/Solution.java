package 백준.골드5.치킨_배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    int M;
    ArrayList<Point> stores = new ArrayList<>();
    ArrayList<Point> homes = new ArrayList<>();
    int[][] dist;
    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                switch (input.charAt(j*2)) {
                    case '1': homes.add(new Point(j, i)); break;
                    case '2': stores.add(new Point(j, i)); break;
                }
            }
        }

        dist = new int[stores.size()][homes.size()];
        visited = new boolean[stores.size()];

        for(int i=0; i<stores.size(); i++) {
            for(int j=0; j<homes.size(); j++)
                dist[i][j] = Math.abs(stores.get(i).x-homes.get(j).x) + Math.abs(stores.get(i).y-homes.get(j).y);
        }

        combination(0, 0);
        System.out.println(answer);
    }

    private void combination(int idx, int start) {
        if(idx==M) {
            int chDis = 0;
            for(int i=0; i<homes.size(); i++) {
                int minDis = Integer.MAX_VALUE;
                for(int j=0; j<stores.size(); j++) {
                    if(visited[j])
                        minDis = Math.min(minDis, dist[j][i]);
                }
                chDis += minDis;
            }
            answer = Math.min(answer, chDis);
            return;
        }

        for(int i=start; i<stores.size(); i++) {
            visited[i] = true;
            combination(idx+1, i+1);
            visited[i] = false;
        }
    }
}