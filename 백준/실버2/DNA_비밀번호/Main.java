package 백준.실버2.DNA_비밀번호;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DNA 비밀번호
 * https://www.acmicpc.net/problem/12891
 * 
 * 1. 완전탐색으로 전체문자열에서 부분문자열을 뽑는다. O(P)
 * 2. 부분문자열이 조건을 만족하는지 완전탐색으로 확인한다. O(S)
 * 3. 부분문자열을 뽑아서 조건이 만족하는지 확인하려면 O(PS)로 시간이 초과된다.
 * ----------------------------------------------
 * 1. 조건을 만족하는 부분문자열을 HashSet에 저장한다. O(n^S)
 * 2. 완전탐색으로 전체문자열에서 부분문자열을 뽑는다. O(P)
 * 3. 뽑은 부분문자열이 HashSet에 있는지 확인한다. O(1)
 * -----------------------------------------------
 * 1. 완전탐색으로 전체문자열에서 부분문자열을 뽑는다.
 * 2. 해당 문자열에 각 문자가 몇개 들어가는지 계산한다.
 * 3. 조건에 만족하면 정답에 +1한다.
 * 4. 다음 문자열을 뽑으면서 새로들어올 문자와 사라질 문자를 이용해 2번을 다시 계산한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = parseInt(st.nextToken());
		int S = parseInt(st.nextToken());
		String str = br.readLine();
		int[] cond = new int[4];		// A, C, G, T 각각 몇개 요구하는지
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			cond[i] = parseInt(st.nextToken());
		}
		
		int head = 0;		// 첫 부분을 가리키는 인덱스
		int tail = S-1;		// 마지막 부분을 가리키는 인덱스
		int[] exist = new int[4];		// A, C, G, T 각각 부분 문자열에 몇개 있는지
		for(int i=head; i<=tail; i++) {		// head부터 tail까지 각 문자가 얼마나 등장했는지 체크
			exist[convertToIdx(str.charAt(i))]++;
		}
		int answer = 0;
		while(true) {		// 마지막 인덱스가 P를 넘어가지 않는 선에서 반복
			
			if(useable(exist, cond))		// 사용가능한 비밀번호면
				answer++;		// answer에 1추가

			if(tail==P-1)		// 마지막에 도달했으면 탈출
				break;
			
			exist[convertToIdx(str.charAt(head++))]--;		// head가 가리키던 문자 개수 줄임 
			exist[convertToIdx(str.charAt(++tail))]++;		// tail이 가리킬 문자 개수 늘림
		}
		
		System.out.println(answer);
	}

	private static boolean useable(int[] exist, int[] cond) {		// 비밀번호 조건을 만족하는지 체크하는 메서드
		for(int i=0; i<4; i++) {		// 각 문자열이
			if(exist[i]<cond[i])		// 요구하는 수량을 못넘었으면
				return false;		// 사용할 수 없는 비밀번호
		}
		return true;		// 모두 넘었으면 사용할 수 있는 비밀번호
	}

	private static int convertToIdx(char c) {		// 각 문자가 저장된 인덱스 반환
		switch(c) {		// A, C, G, T 순서로 저장되어 있음
		case 'A': return 0;
		case 'C': return 1;
		case 'G': return 2;
		default: return 3;
		}
	}

}
