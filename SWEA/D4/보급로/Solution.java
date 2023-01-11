package SWEA.D4.보급로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 1. 그래프가 양수 가중치로 구성되어 있으므로 다익스트라 알고리즘을 이용한다.
* 2. 모든 노드에 대한 최단거리를 초기화하고 갱신해나가는 알고리즘이다.
* 3. 2중 for문 대신 PriorityQueue를 사용하면 시간복잡도를 단축시킬 수 있다.
* */
class Point implements Comparable<Point> {
    int x;
    int y;
    int w;

    public Point(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Point p) {
        return w - p.w;
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
                String input = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }
            int[][] d = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
            d[0][0] = 0;

            System.out.printf("#%d %d\n", test_case, dijkstra(map, d));
        }
    }

    private int dijkstra(int[][] map, int[][] d) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            int x = p.x;
            int y = p.y;
            int w = p.w;

            if(x==map.length-1 && y==map.length-1)
                return w;

            if(x!=0 && w+map[y][x-1]<d[y][x-1]) {
                d[y][x-1] = w + map[y][x-1];
                pq.add(new Point(x-1, y, d[y][x-1]));
            }

            if(y!=0 && w+map[y-1][x]<d[y-1][x]) {
                d[y-1][x] = w + map[y-1][x];
                pq.add(new Point(x, y-1, d[y-1][x]));
            }

            if(x!=map.length-1 && w+map[y][x+1]<d[y][x+1]) {
                d[y][x+1] = w + map[y][x+1];
                pq.add(new Point(x+1, y, d[y][x+1]));
            }

            if(y!=map.length-1 && w+map[y+1][x]<d[y+1][x]) {
                d[y+1][x] = w + map[y+1][x];
                pq.add(new Point(x, y+1, d[y+1][x]));
            }
        }

        return 0;
    }
}