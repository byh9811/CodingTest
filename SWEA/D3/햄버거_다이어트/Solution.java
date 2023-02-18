package SWEA.D3.햄버거_다이어트;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 햄버거
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
 * 
 * 1. DP와 브루트포스 중 하나를 사용하면 될 것 같다.
 * 2. 비트마스킹을 이용해 방문체크하면서 부분집합을 구하면 좋을 것 같다.
 * 3. 비트마스킹을 이용했으나 사실 합을 누적하면 그만인 문제라 다시 삭제했다. 개별 원소의 정보가 필요할 때만 써야할 것 같다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	static int N, L, answer;
	static int[][] info;		// 0: 무게, 1: 가치
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			info = new int[N][2];
			answer = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][1] = Integer.parseInt(st.nextToken());		// 첫 입력이 가치
				info[i][0] = Integer.parseInt(st.nextToken());		// 다음 입력이 무게
			}
			
			subset(0, 0, 0);
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}

	private static void subset(int depth, int sumW, int sumV) {
		if(sumW>L) { return; }		// 끝까지 도달하기 전에 현재 무게가 이미 한게를 넘었으면 백트래킹
		else if(depth==N) {		// 끝까지 도달했을때
			if(sumW<=L)		// 무게가 허용 범위이면
				answer = Math.max(answer, sumV);		// 가치의 합 비교하고 갱신
			
			return;
		}
		
		subset(depth+1, sumW+info[depth][0], sumV+info[depth][1]);		// 현재 물건을 넣는 경우
		subset(depth+1, sumW, sumV);		// 현재 물건을 넣지 않는 경우
	}
	
	
}