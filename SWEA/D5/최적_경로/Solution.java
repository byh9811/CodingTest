package SWEA.D5.최적_경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 1. N의 범위가 2~10이므로 완전탐색(순열)을 사용하면 될 것 같다.
* 2. 각 고객을 방문할 때 Math.abs()를 이용하여 맨하탄 거리를 구하고 더한다.
* 3. 각 거리들 중 최단 거리를 출력한다.
* */
public class Solution {
    int N, answer;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            int[][] arr = new int[N+2][2];      // arr[0] => 회사, arr[1] => 집, arr[n][0] => x좌표, arr[n][0] => y좌표
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<arr.length; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            int[] order = new int[N];
            boolean[] visited = new boolean[N+2];
            recur(arr, order, visited, 0);

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private void recur(int[][] arr, int[] order, boolean[] visited, int depth) {
        if(depth==N) {
            answer = Math.min(answer, calManDis(arr, order));
            return;
        }

        for(int i=2; i<arr.length; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            order[depth] = i;
            recur(arr, order, visited, depth+1);
            visited[i] = false;
        }
    }

    private int calManDis(int[][] arr, int[] order) {
        int distance = 0;
        int curX = arr[0][0];
        int curY = arr[0][1];

        for(int i=0; i<order.length; i++) {
            distance += Math.abs(arr[order[i]][0]-curX);
            distance += Math.abs(arr[order[i]][1]-curY);
            curX = arr[order[i]][0];
            curY = arr[order[i]][1];
        }

        distance += Math.abs(arr[1][0]-curX);
        distance += Math.abs(arr[1][1]-curY);

        return distance;
    }
}