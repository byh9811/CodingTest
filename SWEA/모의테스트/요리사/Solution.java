package SWEA.모의테스트.요리사;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 요리사
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
 * 
 * 1. 식재료를 반으로 나누는 조합을 구한다.
 * 2. 시너지 배열을 순회하며 시너지를 계산한다.
 * 3. 시너지 차이가 가장 적은 경우를 저장한다.
 *
 * @author 배용현
 *
 */
public class Solution {
	static int N, answer;		// 식재료의 수 N, 최소 시너지 차이 answer
	static int[][] map;		// 시너지 정보
	static int[] selected;		// 선택된 식재료

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());		// 테스트케이스 개수

		for(int test_case=1; test_case<=T; test_case++) {
			answer = Integer.MAX_VALUE;		// 최솟값 저장할 필드니까 최대로 초기화
			N = parseInt(br.readLine());		// N 입력
			map = new int[N][N];		// 시너지 정보 배열 초기화
			selected = new int[N/2];		// 선택된 식재료 배열 초기화
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = parseInt(st.nextToken());		// 배열 초기화
				}
			}

			combination(0, 0);		// 조합 구성
			System.out.printf("#%d %d\n", test_case, answer);		// 형식에 맞게 출력
		}
	}

	private static void combination(int depth, int start) {		// 조합을 이용해 식재료 선택
		if(depth==N/2) {		// 한 요리를 만들 식재료가 모두 선택되면
			answer = Math.min(answer, calDif());		// 시너지 차이를 계산하여 작은 쪽을 저장하고 종료
			return;
		}

		for(int i=start; i<N; i++) {		// 중복이 없는 조합
			selected[depth] = i;		// 식재료 선택하고
			combination(depth+1, i+1);		// 재귀 호출
		}
	}

	private static int calDif() {		// 두 음식의 맛 차이 계산
		int[] notSelected = new int[N/2];		// 선택되지 않은 식재료를 저장할 배열

		for(int i=0, cnt=0; i<N; i++) {		// 선택되지 않은 식재료 계산
			if(Arrays.binarySearch(selected, i)<0)		// 이진 탐색을 이용해 selected 안에 i가 존재하는지 확인
				notSelected[cnt++] = i;		// 존재하지 않으면 notSelected에 저장
		}

		return Math.abs(getTotalSynergy(selected)-getTotalSynergy(notSelected));		// 두 음식의 맛을 계산한 뒤 차이를 리턴
	}

	private static int getTotalSynergy(int[] arr) {		// 음식 맛 계산
		int synergy = 0;		// 맛을 저장할 필드

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				synergy += map[arr[i]][arr[j]];		// 음식에 들어가는 식재료간 시너지를 모두 더함
			}
		}

		return synergy;		// 음식 맛 리턴
	}
}
