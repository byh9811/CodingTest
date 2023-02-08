package SWEA.D3.농작물_수확하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * 농작물 수확하기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
 * 
 * 1. 이중 반복문을 돌면서 절반행 까지는 각 행의 N/2-i부터 N/2+i까지 농작물의 가치를 더한다.
 * 2. 나머지 절반행은 각 행의 i-N/2부터 3*N/2-i까지 농작물의 가치를 더한다.
 * 2. N이 최대 49이므로 충분히 통과할 수 있다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());		// test case 입력
		for(int test_case=1; test_case<=T; test_case++) {
			int N = parseInt(br.readLine());		// 농장의 크기
			int[][] map = new int[N][N];		// 농작물의 가치를 저장할 배열
			for(int i=0; i<N; i++) {		// map 입력처리
				String input = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			int sum = 0;		// 농작물의 가치 합
			for(int i=0; i<=N/2; i++) {		// 위쪽 농작물의 가치 덧셈
				for(int j=N/2-i; j<=N/2+i; j++) {
					sum += map[i][j];
				}
			}
			
			for(int i=N/2+1; i<N; i++) {		// 아래쪽 농작물의 가치 덧셈
				for(int j=i-N/2; j<3*N/2-i; j++) {
					sum += map[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", test_case, sum);		// 형식에 맞게 출력
		}
	}
}
