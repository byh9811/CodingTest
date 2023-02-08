package 백준.실버1.구간_합_구하기_5;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 * 
 * 1. 열 기준 누적합을 계산한 뒤 행을 반복하며 구하면 누적합 계산 O(N^2), 부분합 계산 O(NM)이므로 100,000,000번 이상의 연산으로 통과 못할것 같다.
 * 2. 각 칸을 기준으로 이전의 행과 열을 모두 누적한 누적합을 구한다.
 * 3. 누적합을 기준으로 중복되는 부분을 빼주고, 2번 빠진 부분을 더해주면 주어진 구간의 누적합을 구할 수 있다.
 * 4. 모든 칸의 값이 1,000이어도 약 1,000,000,000으로 int형의 범위를 벗어나지 않으므로 사용할 수 있다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());		// N 입력
		int M = parseInt(st.nextToken());		// M 입력
		int[][] map = new int[N+1][N+1];		// 입력받은 값을 저장할 배열
		int[][] sum = new int[N+1][N+1];		// 누적합을 저장할 배열
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());		// 입력받고
			for(int j=1; j<=N; j++) {
				map[i][j] = parseInt(st.nextToken());		// 각 칸 초기화
				sum[i][j] = map[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];			// 누적합 계산
			}
		}

		StringBuilder sb = new StringBuilder();		// 효율을 위해 StringBuilder 사용
		for(int a=0; a<M; a++) {		// 명령 개수만큼 반복
			st = new StringTokenizer(br.readLine());
			int i1 = parseInt(st.nextToken());		// i1 입력
			int j1 = parseInt(st.nextToken());		// j1 입력
			int i2 = parseInt(st.nextToken());		// i2 입력
			int j2 = parseInt(st.nextToken());		// j2 입력
			
			sb.append(sum[i2][j2] - sum[i2][j1-1] - sum[i1-1][j2] + sum[i1-1][j1-1]).append('\n');		// 구간 누적합 계산하여 출력 문자열 추가
		}
		
		System.out.println(sb);		// 출력
	}
}
