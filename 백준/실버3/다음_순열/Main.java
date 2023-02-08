package 백준.실버3.다음_순열;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다음 순열
 * https://www.acmicpc.net/problem/10972
 * 
 * 1. 순열은 조합을 구한 뒤 순서를 조정하는 방식으로 구할 수 있다.
 * 2. 입력으로 조합을 주기때문에 이 순서를 잘 조정하여 다음 순열을 구할 수 있다.
 * 3. 다음 순열이기 위해서는 마지막에 내림차순으로 정렬되는 구간을 찾아야 한다.
 * 4. 내림차순으로 정렬되는 구간은 순열을 사전순으로 나열했을 때 가장 늦게 등장하는 순열이므로 올림이 필요하다.
 * 5. 구간 내에서 올림할만한 가장 작은 수를 선택하여 올림처리하고, 이제 사전순으로 가장 앞서는 순열이 필요하므로 구간을 뒤집어준다.
 * 6. 전체 순열을 출력한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());		// 순열의 크기 N
		StringTokenizer st = new StringTokenizer(br.readLine());		// 문자열을 끊어 처리하기 위한 StirngTokenizer
		arr = new int[N];		// 순열을 저장할 배열
		
		for(int i=0; i<N; i++)
			arr[i] = parseInt(st.nextToken());		// 순열 입력
		
		StringBuilder sb = new StringBuilder();		// 출력 성능을 위해 String Builder 사용
		if(existNextPermutation()) {		// 다음 순열이 존재한다면
			for(int elem: arr)		// 배열의 원소를 StringBuilder에 추가
				sb.append(elem).append(' ');
		} else {		// 마지막 순열이라면
			sb.append(-1);		// -1을 StringBuilder에 추가
		}
		
		System.out.println(sb);		// 출력
	}

	private static boolean existNextPermutation() {		// 다음 순열이 존재하는지 확인하는 메서드
		int head = N-1;		// 감소 구간의 첫 인덱스
		
		while(head>0 && arr[head]>arr[head-1])		// 뒤에서부터 탐색하여 확인할 때 내 앞의 원소가 나보다 작으면 감소구간의 시작 인덱스임
			head--;
		
		if(head==0)		// 감소 구간이 배열 전체라면
			return false;		// 다음 순열은 없으므로 false 리턴
		
		int tail = N-1;		// 감소 구간의 마지막 인덱스
		
		while(tail>=head && arr[tail]>arr[head-1]) {		// 뒤에서부터 탐색하여 감소 구간의 앞 원소와 변경할 원소 선택
			tail--;
		}
		
		swap(head-1, tail);		// swap하여 올림과 같은 기능 수행
		
		tail = N-1;		// 올림 이후 감소 구간을 증가 구간으로 바꿔야하므로 tail을 맨 끝으로 변경
		while(head<tail) {		// 감소 구간이 모두 변경될 때까지
			swap(head++, tail--);		// head와 tail을 스왑하여 변경
		}
		
		return true;		// 다음 순열을 구하는 과정이 성공적으로 수행되었으므로 true 리턴
	}

	private static void swap(int head, int tail) {		// 배열의 원소를 바꾸는 메서드
		int temp = arr[head];
		arr[head] = arr[tail];
		arr[tail] = temp;		
	}
}
