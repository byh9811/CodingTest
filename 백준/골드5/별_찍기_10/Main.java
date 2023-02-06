package 백준.골드5.별_찍기_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
 *
 * 1. 큰 정사각형은 작은정사각형으로 이루어지는데 가운데 부분만 출력하지 않으면 된다.
 * 2. 가운데 부분은 cnt 변수를 통해 판별한다.
 * 3. 각 구간별로 쪼개가며 재귀를 호출하되, 빈 구간이라면 빈칸을 출력하고 아니라면 재귀 함수를 호출한다.
 * 4. 가장 작은 구간(1)이면서 빈 구간이 아니라면 별을 출력한다.
 *
 * @author 배용현
 */
public class Main {
	static char[][] map;		// 재귀함수에서 편하게 사용할 수 있도록 멤버 변수로 지정
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];		// N * N 2차원 배열 초기화
		recur(0, 0, N, false);		// 1, 1부터 재귀 함수 호출
		for(int i=0; i<N; i++) {		// 출력문
			for(int j=0; j<N; j++) {
				bw.write(map[i][j]);
			}
			bw.write('\n');
		}
		bw.flush();
		br.close();
		bw.close();
	}

	private static void recur(int x, int y, int size, boolean empty) {
		if(empty) {		// 빈 구간이면
			for(int i=x; i<x+size; i++) {		// x부터 넘어온 사이즈 만큼 한 구간을
				for(int j=y; j<y+size; j++)		// y부터 넘어온 사이즈 만큼 한 구간을
					map[i][j] = ' ';		// 빈칸으로 채움
			}
			return;		// 이미 빈칸으로 구간이 채워졌으므로 리턴
		}
		
		if(size==1) {		// 빈칸이 아닌 구간으로 가장 작은 사이즈까지 왔으면
			map[x][y] = '*';		// *을 출력
			return;		// *을 출력하여 가장 작은 구간인 1만큼 채웠으므로 리턴
		}
		
		int cursize = size / 3;		// 한 구간의 크기
		int count = 0;		// 빈 구간을 찾기 위한 변수
		for(int i=x; i<x+size; i+=cursize) {		// 현재 좌표부터 세 구간을 반복
			for(int j=y; j<y+size; j+=cursize) {		// 현재 좌표부터 세 구간을 반복
				count++;		// 빈 구간을 찾기 위한 변수 갱신
				if(count==5)		// 가운데 구간이면
					recur(i, j, cursize, true);		// 빈 칸을 출력
				else		// 가운데를 제외한 구간은
					recur(i, j, cursize, false);		// 별 출력
			}
		}
	}

}