package 백준.브론즈2.백설공주와_일곱난쟁이;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백설 공주와 일곱 난쟁이
 * https://www.acmicpc.net/problem/3040
 * 
 * 1. 아홉 난쟁이 중 일곱 난쟁이를 뽑는 조합을 구한다. (원본이 아닌 두 난쟁이를 구하는게 더 빠를듯)
 * 2. 선택된 난쟁이의 모자의 합이 100이면 난쟁이들을 리턴한다.
 * 3. 조합은 O(2^N)이고 모자의 합을 구할때 O(N)인데 N의 최대값이 9이므로 충분히 구현 가능하다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		visited = new boolean[9];
		Arrays.fill(visited, true);		// 7명이 아닌 2명을 뽑기 위해 true로 초기화
		for(int i=0; i<9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int depth, int start) {		// 일곱 난쟁이가 아닌 두 명의 난쟁이를 뽑는다.
		if(depth==2) {
			int sum = 0;
			
			for(int i=0; i<9; i++) {
				if(!visited[i])		// 가짜 난쟁이로 뽑혔으면 패스
					continue;
				
				sum += arr[i];		// 일곱 난쟁이의 모자의 합을 구한다.
			}
			
			if(sum==100) {		// 합이 정확히 100이면
				for(int i=0; i<9; i++) {
					if(!visited[i])		// 가짜 난쟁이 제외하고
						continue;
					
					sb.append(arr[i]).append('\n');		// 모두 출력
				}
			}
			
			return;
		}
		
		for(int i=start; i<9; i++) {
			visited[i] = false;
			combination(depth+1, i+1);
			visited[i] = true;
		}
	}
}