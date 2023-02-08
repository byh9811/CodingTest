package 백준.실버3.N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (2)
 * https://www.acmicpc.net/problem/15650
 *
 * 1. N개 중 M개를 뽑은 조합을 구하면 된다.
 * 2. 중복을 허용하지 않는다.
 * 3. N개중 하나를 뽑는 과정을 M번 반복하므로 O(N^M)의 시간복잡도를 가진다.
 *
 * @author 배용현
 *
 */
public class Main {
	static int N, M;		// 사용하기 편하도록 멤버변수로 선언
	static StringBuilder sb = new StringBuilder();		// 출력 성능을 위해 StringBuilder 사용
	static int[] isSelected;		// 선택된 원소 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		// N 입력 처리
		M = Integer.parseInt(st.nextToken());		// M 입력 처리
		isSelected = new int[M];		// 배열 초기화
		
		permutation(0, 0);		// 조합 재귀 호출
		System.out.print(sb);		// 출력
	}

	private static void permutation(int depth, int start) {		// 재귀로 구현한 중복이 없는 조합
		if(depth==M) {		// M개 뽑았으면
			for(int i=0; i<M; i++) {		// 선택된거 StringBuilder에 저장하고
				sb.append(isSelected[i]).append(' ');
			}
			sb.append('\n');
			
			return;		// 종료
		}
		
		for(int i=start; i<N; i++) {		// start 이전의 원소가 뽑히는 경우는 이미 처리 했으므로 start부터 처리
			isSelected[depth] = i + 1;		// 뽑은 숫자 저장
			permutation(depth + 1, i + 1);		// 다음 재귀 호출
		}
	}
}
