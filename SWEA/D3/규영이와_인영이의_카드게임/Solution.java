package SWEA.D3.규영이와_인영이의_카드게임;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 규영이와 인영이의 카드 게임
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
 * 
 * 1. 인영이의 카드는 규영이의 카드를 제외한 카드를 받는다.
 * 2. 인영이가 낼 수 있는 순열을 구해서 규영이의 순서와 대결한다.
 * 3. 순열은 비트마스킹으로 구할 수 있을 것 같다.
 * 4. 모든 카드의 값을 -1하여 다루되 점수를 얻을 때만 +2하여 계산하면 배열로 다루기 쉽다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	static int[] ky, iy, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int flag = 0;		// 비트마스킹용 정수
			ky = new int[9];		// 규영의 카드 순서
			iy = new int[9];		// 인영의 카드 순서
			result = new int[2];		// 0: 규영이 이기는 경우의 수, 1: 인영이 이기는 경우의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {		// 규영의 카드 9개를 입력받음
				ky[i] = parseInt(st.nextToken()) - 1;		// 인덱스와 값을 맞추기 위해 1을 빼서 저장
				flag = (flag|(1<<ky[i]));		// 규영의 카드는 인영이 가질 수 없으므로 방문처리
			}
			
			permutation(0, flag);
			sb.append('#').append(tc).append(' ').append(result[0]).append(' ').append(result[1]).append('\n');
		}
		System.out.print(sb);
	}
	private static void permutation(int depth, int flag) {		// 카드 순열을 만드는 재귀 메서드
		if(depth==9) {		// 인영이 카드 9개의 순서를 모두 정하면
			int kyScore = 0;		// 규영의 점수
			int iyScore = 0;		// 인영의 점수
			for(int i=0; i<9; i++) {
				if(ky[i]>iy[i])		// 규영의 카드가 높으면
					kyScore += ky[i] + iy[i] + 2;		// 규영이 점수 획득
				else		// 인영의 카드가 높으면
					iyScore += ky[i] + iy[i] + 2;		// 인영이 점수 획득
			}
			
			if(kyScore>iyScore)		// 규영의 점수가 높으면
				result[0]++;		// 규영이 이기는 경우의 수 +1
			else if(kyScore<iyScore)		// 인영의 점수가 높으면
				result[1]++;		// 인영이 이기는 경우의 수 +1
			
			return;
		}
		
		for(int i=0; i<18; i++) {		// 카드는 총 18장
			if((flag&(1<<i))!=0)		// 규영의 카드거나 이미 선택한 카드라면 패스
				continue;
			
			iy[depth] = i;		// 인영은 현재 인덱스가 선택한 카드
			permutation(depth+1, (flag|(1<<i)));		// 순열 완성을 위해 다음 재귀 호출
		}
	}
	
}