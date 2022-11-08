package 백준.골드5.제곱수_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    int[][] map;
    int N, M;
    int answer = -1;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String input2 = br.readLine();
            for(int j=0; j<M; j++)
                map[i][j] = input2.charAt(j) - '0';
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                func(i, j);
            }
        }

        System.out.print(answer);
    }

    private void func(int startRow, int startCol) {
        for(int i=-N; i<N; i++) {
            for(int j=-M; j<M; j++) {
                if(i==0 && j==0)
                    continue;

                int row = startRow;
                int col = startCol;

                int num = 0;
                while(row>=0 && row<N && col>=0 && col<M) {
                    num *= 10;
                    num += map[row][col];

                    if(Math.sqrt(num)==(int)Math.sqrt(num))
                        answer = Math.max(answer, num);

                    row += i;
                    col += j;
                }
            }
        }
    }
}