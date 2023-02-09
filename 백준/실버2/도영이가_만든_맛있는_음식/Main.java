package 백준.실버2.도영이가_만든_맛있는_음식;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 도영이가 만든 맛있는 음식
 * https://www.acmicpc.net/problem/2961
 * 
 * 1. 음식으로 만들 수 있는 모든 부분집합을 구해서 신맛과 쓴맛을 계산한다.
 * 2. 신맛과 쓴맛의 차 중 가장 작은 것을 저장하고 출력한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static int N;		// 재료의 개수 N
	static int answer = Integer.MAX_VALUE;		// 가장 작은 차이를 저장할 변수
	static int[] sour, bitter;		// 각 재료의 신맛, 쓴맛
	static boolean[] isSelected;		// 재료가 선택되었는지 확인할 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {		// N개의 재료 입력 처리
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = parseInt(st.nextToken());		// 신맛 입력
			bitter[i] = parseInt(st.nextToken());		// 쓴맛 입력
		}
		
		makeCuisine(0);		// 부분집합을 만드는 방식으로 요리에 사용될 식재료 선택
		System.out.println(answer);		// 가장 작은 차이 출력
	}

	private static void makeCuisine(int cnt) {		// 부분집합을 만드는 재귀 메서드
		if(cnt==N) {		// N가지 모두의 식재료를 고려한 경우
			boolean anySelected = false;		// 공집합을 처리할 변수
			int sourTotal = 1;		// 신맛은 곱해지므로 1로 초기화
			int bitterTotal = 0;		// 단맛은 더해지므로 0으로 초기화
			
			for(int i=0; i<N; i++) {		// 선택된 식재료에 대해 수행
				if(isSelected[i]) {
					sourTotal *= sour[i];		// 신맛은 곱하고
					bitterTotal += bitter[i];		// 단맛은 더하고
					anySelected = true;		// 공집합이 아님을 체크
				}
			}
			
			if(anySelected)		// 공집합이 아니면
				answer = Math.min(answer, Math.abs(sourTotal-bitterTotal));		// 차이를 계산하여 작은 쪽을 저장
			
			return;		// 리턴
		}

		isSelected[cnt] = true;		// 식재료가 선택된 경우
		makeCuisine(cnt+1);		// 의 케이스로 재귀 호출
		isSelected[cnt] = false;		// 식재료가 선택되지 않은 경우
		makeCuisine(cnt+1);		// 의 케이스로 재귀 호출
	}

}
