package SWEA.D3.저수지의_물의_총_깊이_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * 저수지의 물의 총 깊이 구하기
 * https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWlTKTUqCN8DFAVS
 *
 * 1. 인덱스 1부터 N-1까지 행과 열을 순회하며 구획의 물 깊이를 구한다.
 * 2. 가장 깊은 물 깊이를 저장해놓고 이를 출력한다.
 * 3. O(N^2)의 시간복잡도가 형성되는데 N이 최대 100이므로 통과 가능하다.
 *
 * @author 배용현
 */
public class Solution {
    static final int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static boolean[][] map;     // true: 물, false: 땅

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            int N = parseInt(br.readLine());
            map = new boolean[N+2][N+2];        // 기본값은 false
            for(int i=1; i<N+1; i++) {
                String input = br.readLine();
                for(int j=1; j<N+1; j++) {
                    map[i][j] = input.charAt((j-1)*2)=='W';       // 입력이 물이면 true로 저장
                }
            }

            int answer = 0;     // 저수지의 물 깊이
            for(int i=0; i<N; i++) {      // 행
                for(int j=0; j<N; j++) {      // 열
                    if(!map[i][j])      // 땅이면 패스
                        continue;

                    int depth = 0;      // 구획의 물 깊이
                    for(int k=0; k<8; k++) {        // 팔방 탐색
                        if(map[i+dy[k]][j+dx[k]])       // 해당 방향에 물이 있으면
                            depth++;        // 물 깊이 1 증가
                    }
                    answer = Math.max(answer, depth==0 ? 1 : depth);        // 저수지의 물 깊이 업데이트. depth는 최소 1
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
