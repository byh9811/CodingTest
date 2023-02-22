package SWEA.D3.상호의_배틀필드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상호의 배틀필드
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5LyE7KD2ADFAXc&categoryId=AV5LyE7KD2ADFAXc&categoryType=CODE&problemTitle=1873&orderBy=RECOMMEND_COUNT&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1
 *
 * 1. 맵은 모서리를 강철 벽돌로 만들어 계산하기 편하게 한다.
 * 2. 전차의 위치와 방향은 따로 저장하여 관리한다.
 * 3. 이동하면 현재 칸은 .으로 바꾸고 이동 명령에 따라 위치와 맵을 갱신한다.
 *  - 물이나 벽이면 움직이지 못한다.
 * 4. 발사하면 현재 위치로부터 바라보는 방향으로 한칸씩 확인하며 맵을 갱신한다.
 *  - 물과 평지는 통과하며 벽돌 벽이면 파괴하고, 강철 벽이면 포탄이 사라진다.
 * 5. 모든 입력에 대한 처리가 끝나면 맵을 출력한다.
 * 6. 모든 방향은 숫자로 치환하여 다루며 마지막 출력시에만 꺽쇠로 변환하여 넣어준다.
 *
 * @author 배용현
 *
 */
public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int x, y, d;
    static char[][] map;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            map = new char[H+2][W+2];          // 모서리 패딩 1줄씩
            for(int i=1; i<=H; i++) {       // map 내부 초기화
                String input = br.readLine();
                for(int j=1; j<=W; j++) {
                    map[i][j] = input.charAt(j-1);
                    processTank(i, j);
                }
            }
            for(int i=0; i<H+2; i++)        // 모서리 초기화
                map[i][0] = map[i][W+1] = '#';
            for(int i=0; i<W+2; i++)
                map[0][i] = map[H+1][i] = '#';

            br.readLine();        // String의 charAt으로 접근하면 쓸일 없음
            String orders = br.readLine();      // 명령 입력

            for(int i=0; i<orders.length(); i++) {      // 명령 수행
                int direction = interpretOrder(orders.charAt(i));       // 명령을 방향을 의미하는 정수로 변환
                if(direction<0)     // 방향이 없는 발사명령인 -1 이면
                    shoot();        // 발사
                else        // 방향이 있으면
                    move(direction);         // 해당 방향으로 이동
            }

            setTank();      // 탱크 맵에 배치
            sb.append('#').append(tc).append(' ');      // 주어진 형식대로 출력
            for(int i=1; i<=H; i++) {
                for(int j=1; j<=W; j++)
                    sb.append(map[i][j]);
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void setTank() {     // 모든 로직이 끝나고 마지막에 출력용으로 탱크 배치
        switch (d) {
            case 0: map[y][x]='^'; return;
            case 1: map[y][x]='<'; return;
            case 2: map[y][x]='>'; return;
            case 3: map[y][x]='v';
        }
    }

    private static void shoot() {       // 탱크의 발사를 담당하는 메서드
        int nx = x;     // 포탄의 x좌표
        int ny = y;     // 포탄의 y좌표

        while(true) {
            nx += dx[d];
            ny += dy[d];

            if(map[ny][nx]=='#')     // 강철 벽을 만나면 탈출
                break;

            if(map[ny][nx]=='*') {       // 벽돌 벽을 만나면 벽을 부수고 탈출
                map[ny][nx] = '.';
                break;
            }       // 물, 평지일 경우는 다음 위치 확인
        }
    }

    private static void move(int direction) {       // 탱크의 이동을 담당하는 메서드
        d = direction;      // 방향은 무조건 바뀌고
        if(map[y + dy[direction]][x + dx[direction]]=='.') {        // 움직일 수 있으면 움직임
            y += dy[direction];
            x += dx[direction];
        }
    }

    private static int interpretOrder(char order) {     // 명령을 정수로 바꿔주는 메서드 (-1: S, 0: U, 1: L, 2: R, 3: D)
        switch (order) {        // dx, dy에 순서대로 정의
            case 'U': return 0;
            case 'L': return 1;
            case 'R': return 2;
            case 'D': return 3;
        }

        return -1;      // 발사 명령이면 -1
    }

    private static void processTank(int i, int j) {     // 입력받을 때 탱크 관련 정보를 초기화 해주는 메서드
        if(map[i][j]=='.' || map[i][j]=='#' || map[i][j]=='*' || map[i][j]=='-')        // 탱크가 아니면 패스
            return;

        x = j;      // x 좌표 설정
        y = i;      // y 좌표 설정
        switch (map[i][j]) {      // 방향 설정
            case '^': d = 0; break;
            case '<': d = 1; break;
            case '>': d = 2; break;
            case 'v': d = 3; break;
        }
        map[i][j] = '.';      // 맵 갱신
    }
}
