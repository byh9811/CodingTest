package SWEA.D3.한빈이와_Spot_Mart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 한빈이와 Spot Mart
 * https://www.acmicpc.net/problem/1991
 * 
 * 1. 주어진 과자봉지를 두 개 조합으로 뽑는다.
 * 2. 과자봉지를 무게만큼 더해서 제한을 넘지 않는 최댓값을 구한다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	static int N, M, answer;
	static int[] weights, selected = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());		// 과자 개수
			M = Integer.parseInt(st.nextToken());		// 무게 합 제한
			answer = -1;		// 조합이 없으면 -1
			weights = new int[N];		// 과자 무게 정보
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)		// 과자 무게 정보 입력
				weights[i] = Integer.parseInt(st.nextToken());
			
			combination(0, 0);		// 조합 수행
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');		// 출력 저장
		}
		
		System.out.println(sb);
	}

	private static void combination(int depth, int start) {		// 과자 두 개 뽑아서 무게 비교
		if(depth==2) {		// 두 개 뽑았으면
			int sum = selected[0] + selected[1];		// 두 무게 더함
			if(sum<=M && sum>answer)		// 제한을 넘지 않고 현재 최댓값이면
				answer = sum;		// answer 갱신
			
			return;
		}
		
		for(int i=start; i<N; i++) {		// 조합을 뽑는 반복문
			selected[depth] = weights[i];
			combination(depth+1, i+1);
		}
	}
}