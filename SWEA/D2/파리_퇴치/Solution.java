package SWEA.D2.파리_퇴치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 파리 퇴치
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
 *
 * 1. 입력을 받으면서 오른쪽 아래를 기준으로 누적합을 기록한다.
 * 2. map[i][j] - map[i][j-M] - map[i-M][j] + map[i-M][j-M]으로 구간합을 계산한다.
 * 3. (M, M)에서부터 (N, N)까지 순회하며 구간합의 최댓값을 출력한다.
 *
 * @author 배용현
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());

            int[][] map = new int[N+2][N+2];        // 양 옆 패딩
            for(int i=1; i<N+1; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<N+1; j++) {
                    map[i][j] = parseInt(st.nextToken());       // 입력 처리
                    map[i][j] += map[i-1][j] + map[i][j-1] - map[i-1][j-1];     // 누적합 기록
                }
            }

            int answer = 0;
            for(int i=M; i<=N; i++) {       // 우측하단이 기준이므로 M~N까지의 범위가 된다.
                for(int j=M; j<=N; j++) {       // 우측하단이 기준이므로 M~N까지의 범위가 된다.
                    answer = Math.max(answer, map[i][j]-map[i][j-M]-map[i-M][j]+map[i-M][j-M]);     // 큰 구간합을 저장
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
