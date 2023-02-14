package 백준.실버1.배열_돌리기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기
 * https://www.acmicpc.net/problem/16926
 *
 * 1. N, M중 작은 수의 절반만큼 항상 회전한다.
 * 2. 각 모서리마다 회전을 하는 방식이 다르므로 경곗값에 주의해서 회전한다.
 * 3. 처음 덮어씌워지는 원소는 삭제되므로 따로 저장해두어야한다.
 * 
 * @author 배용현
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());		// 행 크기 N
		int M = Integer.parseInt(st.nextToken());		// 열 크기 M
		int R = Integer.parseInt(st.nextToken());		// 회전 횟수 R
		
		int[][] arr = new int[N][M];		// 초기 배열
		for(int i=0; i<N; i++) {		// 입력 처리
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int count = Math.min(N, M) / 2;		// 회전 줄 수
		for(int i=0; i<R; i++) {		// 회전 횟수만큼 반복
			for(int j=0; j<count; j++) {		// 라인들 전부 돌리기
				int temp = arr[j][j];		// 처음 접근되는 원소는 전부 묻히므로 따로 저장
				
				for(int k=j+1; k<M-j; k++)		// 왼쪽으로 이동
					arr[j][k-1] = arr[j][k];
				
				for(int k=j+1; k<N-j; k++)		// 아래쪽으로 이동
					arr[k-1][M-1-j] = arr[k][M-1-j];
				
				for(int k=M-2-j; k>=j; k--)		// 오른쪽으로 이동
					arr[N-1-j][k+1] = arr[N-1-j][k];
				
				for(int k=N-2-j; k>=j; k--)		// 위쪽으로 이동
					arr[k+1][j] = arr[k][j];
				
				arr[j+1][j] = temp;		// 첫 원소가 움직일 위치에 따로 저장된 값 삽입
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<N; j++) {		// 출력
			for(int k=0; k<M; k++)
				sb.append(arr[j][k]).append(' ');
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}