package SWEA.D5.최적_경로;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최적 경로
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
 *
 * 1. 기사의 좌표를 dfs의 매개변수로 넘기면서 진행한다.
 * 2. 각 집의 좌표를 미리 저장해두고 dfs로 모든 경우의 수를 탐색한다.
 * 3. 진행하면서 누적 거리를 계산하고, 가장 짧은 누적 거리를 저장하여 출력한다.
 *
 * @author 배용현
 *
 */
public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, x, y, homeX, homeY, answer;
    static boolean[] visited;		// 해당 고객을 방문했는지 확인하는 방문 배열
    static int[][] customer;		// 고객의 위치 정보 (0: x, 1: y)

    public static void main(String[] args) throws Exception {
        int T = parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x = parseInt(st.nextToken());
            y = parseInt(st.nextToken());
            homeX = parseInt(st.nextToken());
            homeY = parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            customer = new int[N][2];
            visited = new boolean[N];

            for(int i=0; i<N; i++) {
                customer[i][0] = parseInt(st.nextToken());
                customer[i][1] = parseInt(st.nextToken());
            }

            dfs(x, y, 0, 0);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y, int depth, int sum) {		// 고객 집에 찾아가는 순열을 구하는 재귀 메서드
        if(depth==N) {		// 전부 방문했으면
            sum += Math.abs(x-homeX) + Math.abs(y-homeY);		// 마지막 집으로 돌아가는 거리까지 더해서
            answer = Math.min(answer, sum);		// 정답에 최솟값 저장

            return;
        }

        for(int i=0; i<N; i++) {		// 고객 N명 순서 뽑기
            if(visited[i])		// 이미 방문 했으면 패스
                continue;

            visited[i] = true;
            dfs(customer[i][0], customer[i][1], depth+1, sum + Math.abs(x-customer[i][0]) + Math.abs(y-customer[i][1]));		// 위치와 누적 거리 갱신해서 재귀 호출
            visited[i] = false;
        }
    }
}