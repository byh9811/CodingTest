package SWEA.모의테스트.무선충전;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 무선 충전
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
 *
 * 1. 각 사용자의 위치는 따로 저장하여 관리한다.
 * 2. bc의 정보를 저장하는 배열을 만들고, 별도의 맵은 사용하지 않는다.
 * 3. 사용자의 위치가 변할 때마다 충전기 정보를 순회하여 범위 안쪽에 있는지 확인한다.
 * 4. 이중 반복문을 이용해 각 충전기 조합을 통해 얻을 수 있는 충전량을 계산하고 최댓값을 저장한다.
 * 5. 이 때 사용할 수 있는 충전기가 없어 계산이 안되는 경우를 대비해 충전량이 0인 더미충전기를 만들어 함께 조합한다.
 * 
 * @author 배용현
 *
 */
public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] location = new int[2][2];		// 두 사용자의 위치 (x, y)
	static int[][] move, charger;		// 각 사용자의 움직임 정보(0: x, 1: y), A개의 충전기 정보 4가지 (0: x, 1: y, 2: 범위, 3: 충전량)
	static int[] dx = {0, 0, 1, 0, -1};		// 이동 안할 수도 있다네
	static int[] dy = {0, -1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception {
		int T = parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = parseInt(st.nextToken());
			int A = parseInt(st.nextToken());
			
			move = new int[2][M];
			charger = new int[A+1][4];		// 더미 충전기 정보까지 A+1개
			location = new int[][] {{1, 1}, {10, 10}};		// 각 사용자의 첫 위치 초기화
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++)
					move[i][j] = parseInt(st.nextToken());
			}

			charger[0] = new int[] {5, 5, 20, 0};		// 어디서든 잡히게 만든 더미 충전기
			for(int i=1; i<=A; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					charger[i][j] = parseInt(st.nextToken());
				}
			}
			
			int sum = charge();		// 처음 위치에서도 충전이 이루어진대
			for(int i=0; i<M; i++) {		// 움직임 입력된 만큼
				move(i);		// 움직이고
				sum += charge();		// 충전하고
			}
			
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int charge() {		// 충전 진행하는 메서드
		List<Integer>[] availableCharger = new List[2];		// 0: 사용자 A의 가용 충전기, 1: 사용자 B의 가용 충전기
		availableCharger[0] = getAvailableCharger(0);		// 가용 충전기 뽑는 조합 메서드는 따로 호출
		availableCharger[1] = getAvailableCharger(1);		// 이것이 SRP
		
		int max = 0;		// 각 움직임에서의 최대 충전량이 곧 전체의 최대 충전량
		for(int i=0; i<availableCharger[0].size(); i++) {		// 가용 충전기 리스트 순회
			for(int j=0; j<availableCharger[1].size(); j++) {
				if(availableCharger[0].get(i)==availableCharger[1].get(j)) {		// 같은 충전기의 범위면
					max = Math.max(max, charger[availableCharger[0].get(i)][3]);		// 나눠먹으므로 출력대로 먹음
				} else {		// 다른 충전기면
					int sum = charger[availableCharger[0].get(i)][3] + charger[availableCharger[1].get(j)][3];		// 각자 출력을 온전히 먹음
					max = Math.max(max, sum);
				}
			}
		}
		
		return max;		// 어떤 충전기를 선택했는지는 중요하지 않음. 충전된 양만 리턴하여 사용
	}

	private static List<Integer> getAvailableCharger(int idx) {		// 가용 충전기 리스트 확인하는 메서드
		List<Integer> availableCharger = new ArrayList<Integer>();		// 얼마나 가능할지 모르니까 가변배열
		
		for(int i=0; i<charger.length; i++) {
			if(Math.abs(location[idx][0]-charger[i][0])+Math.abs(location[idx][1]-charger[i][1])<=charger[i][2]) {		// 충전 범위 안쪽이면
				availableCharger.add(i);		// 가용 충전기에 추가
			}
		}
		
		return availableCharger;		// 가용 충전기 리스트 리턴
	}

	private static void move(int orderIdx) {		// 이동하는 메서드
		for(int i=0; i<2; i++) {		// 각 사용자의
			location[i][0] += dx[move[i][orderIdx]];		// x좌표 갱신
			location[i][1] += dy[move[i][orderIdx]];		// y좌표 갱신
		}
	}
}