package 백준.골드5.신기한_소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 신기한 소수
 * https://www.acmicpc.net/problem/2023
 * 
 * 1. 에라토스테네스의 체로 8자리 숫자까지 계산할 수는 없다.
 * 2. 현재 인덱스가 소수인지 확인하고 소수라면 다음 인덱스를 붙여 반복확인한다.
 * 3. 한자리씩 끊는데 O(2^N), 검사하는데 O(logN)이므로 O(2^N*logN)이 되는데, N이 최대 8이므로 통과 가능하다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static StringBuilder sb;
	static int N;		// 자리수 N
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for(int i=2; i<=9; i++) {		// 2~9까지 수 중에
			if(isPrime(i))		// 소수만 재귀 시작
				recur(1, i);		// 이미 한자리 했으니까 depth는 1부터
		}
		
		System.out.println(sb);
	}
	
	private static void recur(int depth, int num) {		// 소수만 재귀를 호출하도록하여 경우의 수 줄이기
		if(depth==N) {		// N자리 숫자 되었으면
			sb.append(num).append('\n');		// 출력하고
			return;		// 리턴
		}
		
		for(int i=0; i<=9; i++) {		// 두 번째 자리부터는 0과 1도 올 수 있음
			if(isPrime(num*10+i))		// 기존 수는 오른쪽으로 한칸 밀고 왼쪽에 새로운 수 넣음
				recur(depth+1, num*10+i);		// depth 1올리고 바뀐 수로 재귀 호출
		}
	}

	private static boolean isPrime(int num) {		// 소수 판별 메서드
		double sqrt = Math.sqrt(num);		
		for(int i=2; i<=sqrt; i++) {		// 제곱근까지만 돌면 판별 가능 
			if(num%i==0)		 // 나누어 떨어지면
				return false;		// 합성수
		}
		
		return true;		// 나누어 떨어지지 않으면 소수
	}
}
