package 백준.실버3.구간_합_구하기_4;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 * 
 * 1. 단순히 생각하면 구간의 합을 더하면 될 것 같지만, O(NM)으로 약 10,000,000,000의 연산이 발생하기 때문에 시간이 초과된다.
 * 2. 구간은 떨어지지 않는다는 점을 이용하여 누적합을 저장해놓는다. (100,000칸까지 나오는데 한 칸에 최대 1,000이므로 int형으로 다룰 수 있다.)
 * 3. i 인덱스의 누적합에서 j 인덱스의 누적합을 빼면 정답이 나온다.
 * 4. 누적합을 구하는 로직이 O(N), 계산하는 로직이 O(1)이므로 통과 가능하다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());		// N 입력
		int M = parseInt(st.nextToken());		// M 입력
		int[] arr = new int[N+1];		// 계산하기 쉽게 하기위해 n+1개 생성
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = parseInt(st.nextToken());		// 입력받고
			arr[i] += arr[i-1];			// 누적합 계산
		}

		StringBuilder sb = new StringBuilder();		// 효율을 위해 StringBuilder 사용
		for(int a=0; a<M; a++) {		// 명령 개수만큼 반복
			st = new StringTokenizer(br.readLine());
			int i = parseInt(st.nextToken());		// i 입력
			int j = parseInt(st.nextToken());		// j 입력
			sb.append(arr[j]-arr[i-1]).append('\n');		// 출력 문자열 추가
		}
		
		System.out.println(sb);		// 출력
	}
}
