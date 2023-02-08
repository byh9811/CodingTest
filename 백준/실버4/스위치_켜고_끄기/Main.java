package 백준.실버4.스위치_켜고_끄기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * 스위치 켜고 끄기
 * https://www.acmicpc.net/problem/1244
 *
 * 1. 각각 어떤 성별의 학생이 어떤 스위치를 받았는지 분류한다.
 * 2. 각 성별에 따라 다르게 동작하도록 구현한다.
 * 3. 배열의 인덱스와 입력으로 주어지는 인덱스가 같지 않음에 유의한다.
 *
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		int[] switches = new int[n];		// 스위치의 상태를 저장할 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {		// 스위치 상태 입력
			switches[i] = parseInt(st.nextToken());
		}

		int m = parseInt(br.readLine());
		for(int i=0; i<m; i++) {		// 학생 수만큼 반복
			st = new StringTokenizer(br.readLine());
			int gender = parseInt(st.nextToken());		// 학생의 성별
			int no = parseInt(st.nextToken());		// 학생이 받은 수
			if(gender==1) {		// 남학생
				for(int j=no; j<=n; j+=no) {		// 받은 수부터 그만큼 더하면서 반복
					switches[j-1] ^= 1;		// 실제로 저장된 인덱스는 -1 해줘야함
				}
			} else {		// 여학생
				switches[--no] ^= 1;		// 자기 자신은 반드시 바뀌고, 인덱스도 바꿔주어도 됨
				for(int j=1; no+j<n && no-j>=0; j++) {		// 양 옆 크기 하나씩 늘려가며 비교
					if(switches[no+j]!=switches[no-j])		// 스위치 상태가 다르면 탈출
						break;

					switches[no+j] ^= 1;		// 오른쪽 스위치 변화
					switches[no-j] ^= 1;		// 왼쪽 스위치 변화
				}
			}
		}

		for(int i=0; i<switches.length; i++) {		// 스위치 반복하며 출력
			if(i!=0 && i%20==0)		// 20번째 줄마다 한줄 띄어쓰기
				System.out.println();
			System.out.print(switches[i] + " ");		// 공백으로 구분하여 출력
		}
	}

}
