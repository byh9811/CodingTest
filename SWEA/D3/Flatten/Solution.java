package SWEA.D3.Flatten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Flatten
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
 * 
 * 1. 최고점과 최저점을 스캔할 때 가로의 길이 100만큼 연산한다.
 * 2. 최고점에서 최저점으로 옮기는 연산은 인덱스를 통해 이루어지므로 2이고, 덤프횟수는 최대 1000이다.
 * 3. 브루트포스를 이용해도 최대 연산은 약 100,000이므로 사용할 수 있다.
 * 
 * @author 배용현
 *
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++) {		// test case 10개 고정
			int dump = parseInt(br.readLine());		// 연산의 개수
			int[] height = new int[100];		// 가로는 100, 각 높이를 기록하는 배열
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<height.length; i++) {		// 높이 입력받음
				height[i] = parseInt(st.nextToken());
			}
			
			for(int i=0; i<dump; i++) {		// 브루트포스 수행
				int[] infos = getInfos(height);		// 최고점, 최저점 정보 계산
				if(infos[0]==infos[1])		// 평평해서 더이상 덤프를 수행할 수 없으면
					break;			// 탈출

				height[infos[2]]--;		// 가장 높은 곳의 상자를
				height[infos[3]]++;		// 가장 낮은 곳으로 옮김
			}
			
			int[] infos = getInfos(height);
			System.out.printf("#%d %d\n", test_case, infos[0]-infos[1]);		// 형식에 맞게 출력
		}
	}
	
	private static int[] getInfos(int[] height) {		// 최고점과 최저점의 정보를 리턴하는 메서드
		int max = 0;		// 높이가 최소 1이므로 초기값 0
		int min = 101;		// 높이가 최대 100이므로 초기값 101
		int maxIdx = -1;		// 초기 인덱스 -1로 설정
		int minIdx = -1;		// 초기 인덱스 -1로 설정
		
		for(int j=0; j<height.length; j++) {		// 각 부분을 순회하며 최고점과 최저점 기록
			if(height[j]>max) {		// 최고점보다 크면 갱신
				max = height[j];		// 높이 갱신
				maxIdx = j;			// 인덱스 갱신
			}
			if(height[j]<min) {		// 최저점보다 낮으면 갱신
				min = height[j];		// 높이 갱신
				minIdx = j;			// 인덱스 갱신
			}
		}
		
		return new int[] {max, min, maxIdx, minIdx};		// 최댓값, 최솟값, 최고점, 최저점 리턴
	}
}