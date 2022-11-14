package 백준.골드5.로봇_청소기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean[][] isFloor = new boolean[N][M];
        boolean[][] isClean = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                switch(input.charAt(j*2)) {
                    case '1': isFloor[i][j] = false; break;
                    default: isFloor[i][j] = true;
                }
            }
        }

        while(true) {
            isClean[r][c] = true;
            boolean moved = false;

            for(int i=0; i<4; i++) {
                d = (d+3) % 4;
                int nextR = r + dy[d];
                int nextC = c + dx[d];
                if(isFloor[nextR][nextC] && !isClean[nextR][nextC]) {
                    r = nextR;
                    c = nextC;
                    moved = true;
                    break;
                }
            }

            if(moved)
                continue;

            int prev = d>1 ? d-2 : d+2;
            int nextR = r + dy[prev];
            int nextC = c + dx[prev];
            if(isFloor[nextR][nextC]) {
                r = nextR;
                c = nextC;
            }
            else
                break;
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(isClean[i][j])
                    answer++;
            }
        }

        System.out.println(answer);
    }
}