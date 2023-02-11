package 백준.실버4.카드2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카드2
 * https://www.acmicpc.net/problem/2164
 * 
 * 1. 한장이 남을 때까지 한방을 버리고 한장을 밑으로 내리는 동작을 반복한다.
 * 2. 한장이 버려지므로 반복 조건을 검사하는 시점에는 카드가 2개가 남아있어야 함에 유의한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++)		// 1부터 N까지 넣어야 한다.
			q.add(i);

		for(int i=0; i<N-1; i++) {		// 마지막 수행 때 카드가 2장 남아 있어야 하므로 N-1번 반복한다.
			q.poll();
			q.add(q.poll());
		}

		System.out.println(q.peek());		// 큐에 남은 값을 출력한다.
	}
}
