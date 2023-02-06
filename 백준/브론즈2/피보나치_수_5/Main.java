package 백준.브론즈2.피보나치_수_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수 5
 * https://www.acmicpc.net/problem/10870
 *
 * 1. 점화식을 그대로 재귀함수로 구현한다.
 * 2. n이 2이상인 경우에 성립하므로 0일때와 1일때를 모두 처리해 주어야 한다.
 *
 * @author 배용현
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(fibo(N));		// 피보나치 재귀함수 호출
	}

	private static int fibo(int n) {
		if(n==0)		// f(0) = 0
			return 0;
		else if(n==1)		// f(1) = 1
			return 1;
		return fibo(n-2) + fibo(n-1);		// 이외의 경우 f(n-2) + f(n-1)
	}

}