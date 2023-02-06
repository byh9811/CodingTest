package 백준.브론즈5.팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼
 * https://www.acmicpc.net/problem/10872
 *
 * 1. 재귀 함수를 이용해서 factorial을 구현한다.
 * 2. 재귀 호출을 마지막에 하면 성능이 향상된다고 한다.
 *
 * @author 배용현
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(fac(N));
	}

	private static int fac(int n) {
		if(n==0)
			return 1;		// 0! => 종료
		return n * fac(n-1);		// fac() 호출을 나중에!
	}

}