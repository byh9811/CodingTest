package 백준.실버1.쿼드트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * 쿼드트리
 * https://www.acmicpc.net/problem/1992
 * 
 * 1. Divide and Conquer를 사용하여 각 사분면이 0과 1로 이루어져있는지 확인한다.
 * 2. 모든 값이 0이나 1로 이루어져 있으면 압축하고, 아니라면 사이즈를 줄여 재귀를 호출한다.
 * 3. 재귀 호출시 '('를, 리턴시 ')'를 붙인다.
 * 4. 문자열이 계속 붙으므로 StringBuilder를 사용하는 것이 좋을 것 같다.
 *
 * @author 배용현
 *
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		recur(0, 0, N);

		System.out.println(sb);
	}

	private static void recur(int x, int y, int size) {		// 분할정복 재귀 메서드
		if(size==1) {		// 최소 단위이면
			sb.append(map[y][x]);		// 값 추가하고
			return;		// 리턴
		}

		int sum0 = 0;		// 0의 개수
		for(int i=y; i<y+size; i++) {		// 현재 사분면 순회하면서
			for(int j=x; j<x+size; j++) {
				if(map[i][j]=='0')		// 0개수 셈
					sum0++;
			}
		}

		if(sum0==0) {		// 1로 가득하면
			sb.append(1);		// 1로 압축
		} else if(sum0==size*size) {		// 0으로 가득하면
			sb.append(0);		// 0으로 압축
		} else {		// 섞여있으면
			sb.append('(');		// 여는 괄호 추가하고
			int half = size/2;		// 사이즈 반으로 줄여서
			recur(x, y, half);		// 사분면 재귀호출
			recur(x+half, y, half);
			recur(x, y+half, half);
			recur(x+half, y+half, half);
			sb.append(')');		// 끝나면 닫는 괄호 추가
		}
	}
}