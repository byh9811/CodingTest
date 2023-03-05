package 백준.실버2.가장_긴_증가하는_부분순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 가장 긴 증가하는 부분 순열
 * https://www.acmicpc.net/problem/11053
 * 
 * 1. 현재 칸을 선택했을때의 최대 수열 길이를 dp에 저장하며 순회한다.
 * 2. 이 때, 자신을 포함하는 최대 수열 길이를 구하기 위해서 이전까지의 원소를 모두 탐색해야 하므로 O(N^2)의 시간복잡도가 존재한다.
 * 3. 하지만 N이 최대 1,000이기 때문에 충분히 통과 가능하다.
 * 4. 항상 마지막 원소를 포함한다는 보장이 없으므로 반복문을 통해 가장 긴 수열의 길이를 찾는다.
 * 
 * @author 배용현
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = 0; j <= i - 1; j++) {
				if(dp[j]>max && arr[i]>arr[j])
					max = dp[j];
			}
			dp[i] = max + 1;
		}

		int answer = 0;
		for(int i=0; i<N; i++)
			answer = Math.max(dp[i], answer);

		System.out.println(answer);
	}

}
