package 백준.브론즈1.색종이;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이
 * https://www.acmicpc.net/problem/10163
 * 
 * 1. 색종이를 배열에 하나씩 붙인다.
 * 2. 나중에 붙인 색종이는 기존의 색종이를 덮기 때문에 값을 색종이 인덱스로 갱신하는 방법을 사용한다.
 * 3. 인덱스는 배열의 초기값 0과 헷갈리지 않기 위해 1부터 시작한다.
 * 4. 좌표와 길이가 주어진다는 점에 유의하여 반복문을 설정한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[1001][1001];
		
		int N = parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] point = new int[4];		// 0: x좌표, 1: y좌표, 2: 너비, 3: 높이
			for(int j=0; j<4; j++)
				point[j] = parseInt(st.nextToken());
			
			for(int j=point[0]; j<point[2]+point[0]; j++) {
				for(int k=point[1]; k<point[3]+point[1]; k++)
					map[j][k] = i;		// 새로운 색종이로 영역을 덮음
			}
		}
		
		int[] score = new int[N+1];		// 각 색종이가 차지하는 영역의 넓이
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++)
				score[map[i][j]]++;		// 넓이 계산
		}
		
		for(int i=1; i<=N; i++)		// 각 색종이의 넓이 출력
			sb.append(score[i]).append('\n');
		
		System.out.print(sb);
	}
}