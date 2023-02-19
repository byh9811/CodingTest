package 백준.실버5.스네이크버드;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스네이크 버드
 * https://www.acmicpc.net/problem/16435
 * 
 * 1. 배열을 오름차순 정렬한다.
 * 2. 먹을 수 있는지 확인하고 먹을 수 있다면 길이를 늘린뒤 배열을 반복한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int L = parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();		// 한 줄을 입력받아 정렬된 int배열로 변경
		
		for(int cur: arr) {		// 값이 작은 순서대로 접근
			if(cur<=L)		// 먹을 수 있으면
				L++;		// 크기 증가
			else			// 먹을 수 없으면
				break;		// 탈출
		}
		
		System.out.println(L);
	}
}