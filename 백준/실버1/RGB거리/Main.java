package 백준.실버1.RGB거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * RGB거리
 * https://www.acmicpc.net/problem/1149
 * 
 * 1. 3개의 조건 중 1, 2번 조건은 3번 조건을 지키기위한 조건이므로 사실상 붙어있는 두 집의 색깔이 다르면 된다.
 * 2. 따라서 현재 칠할 색깔을 선택하면 이전에 동일한 색을 칠하지 않은 경우 중 최소를 골라나가는 DP 문제다.
 * 3. Nx3 크기의 DP배열을 만들어 누적합을 계산해나간다. (0: 빨강, 1: 초록, 2: 파랑)
 * 4. 마지막 행의 누적합 중 가장 작은 값을 출력한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];		// 원본 배열
		int[][] dp = new int[N][3];			// 누적합 배열

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dp[0] = Arrays.copyOf(map[0], 3);		// 첫 행은 원본 배열 그대로

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++)
				dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + map[i][j];		// 1, 2를 더해서 3으로 나눈 나머지로 접근하면 자신을 제외한 원소에 접근 가능
		}

		System.out.print(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}
}