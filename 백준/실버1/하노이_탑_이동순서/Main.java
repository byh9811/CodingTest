package 백준.실버1.하노이_탑_이동순서;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 *
 * 1. A에서 C로 N개의 블럭을 옮기는 하노이 탑의 로직은 다음과 같다.
 *  a. A -> B로 N-1개의 블럭을 옮긴다.
 *  b. A -> C로 1개의 블럭을 옮긴다.
 *  c. B -> C로 N-1개의 블럭을 옮긴다.
 * 2. 위 로직의 a와 c는 1개의 블럭을 옮길 때까지 반복되므로 재귀를 사용한다.
 * 3. 1개의 블럭은 별도의 처리없이 옮길 수 있으므로 출력하면 된다.
 * 4. 조금 더 빠른 입출력을 위해 BufferedWriter를 사용했다.
 *
 * @author 배용현
 */
public class Main {
	static BufferedWriter bw;		// 빠른 출력용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		bw.write((int) (Math.pow(2, N) - 1) + "\n");		// 하노이탑의 개수를 구하는 공식: 2^N-1
		hanoi(N, 1, 2, 3);		// 하노이 탑 재귀 호출
		bw.flush();
		br.close();
		bw.close();
	}

	private static void hanoi(int N, int start, int mid, int end) throws IOException {
		if(N==1) {		// 블럭 1개는 바로 옮기면 됨
			bw.write(start + " " + end + "\n");
			return;
		}
		
		hanoi(N-1, start, end, mid);		// 블럭 N-1개를 mid로 옮김
		bw.write(start + " " + end + "\n");		// 가장 아래 블럭을 end로 옮김
		hanoi(N-1, mid, start, end);		// 블럭 N-1개를 end로 옮김
	}
}