package SWEA.D2.달팽이_숫자;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 달팽이 숫자
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
 *
 * 1. 구현을 쉽게 하기 위해서 배열을 n+2로 생성하고 모서리를 벽을 의미하는 -1로 초기화한다.
 * 2. 진행하다가 벽을 만나면 시계방향으로 회전한다.
 * 3. 더이상 진행할 공간이 없다면 배열을 출력한다.
 *
 * @author 배용현
 *
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        int[] dx = {1, 0, -1, 0};       // 이동방향을 설정해주는 배열 초기화
        int[] dy = {0, 1, 0, -1};       // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        // 테스트케이스 개수 입력

        for(int test_case=1; test_case<=T; test_case++) {       // 테스트케이스 반복
            int N = Integer.parseInt(br.readLine());        // 달팽이 크기 N
            int[][] map = new int[N+2][N+2];        // 계산하기 편하도록 (N+2)*(N+2)로 생성
            for(int i=0; i<N+2; i++) {
                map[i][0] = map[i][N+1] = map[0][i] = map[N+1][i] = -1;     // 모서리를 벽으로 초기화
            }

            int x = 1;      // 초기 x값
            int y = 1;      // 초기 y값
            int d = 0;      // 방향 d
            int cnt = 1;        // 현재 숫자 cnt
            while(true) {       // 지도에 값을 찍기 시작
                map[y][x] = cnt++;      // 현재 위치에 찍고 cnt+1
                if(map[y+dy[d]][x+dx[d]]!=0) {      // 다음칸으로 전진할 수 없으면
                    d = ++d % 4;        // 방향을 변경
                    if(map[y+dy[d]][x+dx[d]]!=0)        // 다음 방향도 변경할 수 없으면
                        break;      // 더이상 진행 불가능
                }

                x += dx[d];     // 다음 칸으로 전진
                y += dy[d];     // 다음 칸으로 전진
            }

            StringBuilder sb = new StringBuilder();     // 출력 속도를 위해 StringBuilder 사용
            sb.append("#").append(test_case).append('\n');      // 테스트케이스 정보 추가
            for(int i=1; i<N+1; i++) {      // 외곽을 제외한 안쪽만 접근
                for(int j=1; j<N+1; j++) {
                    sb.append(map[i][j]).append(' ');       // 달팽이 정보 추가
                }
                sb.append('\n');
            }
            System.out.print(sb);       // 달팽이 출력
        }
    }
}
