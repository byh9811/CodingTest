package SWEA.D2.스도쿠_검증;

import java.io.*;
import java.util.Arrays;

/*
* 1. 대각선으로 한 점씩 잡아서 가로와 세로가 만족하는지 확인한다.
* 2. 9분면의 한 점씩 잡아서 각 부분이 만족하는지 확인한다.
* 3. 모두 만족한다면 1, 하나라도 불만족한다면 0을 리턴한다.
* */
public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String input = br.readLine();
                map[i] = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            System.out.printf("#%d %d\n", test_case, isOkay(map) ? 1 : 0);
        }
    }

    private boolean isOkay(int[][] map) {
        for(int i=0; i<9; i++) {
            if(!isOkayStraight(map, i))
                return false;
        }

        for(int i=1; i<9; i+=3) {
            for(int j=1; j<9; j+=3) {
                if(!isOkaySquare(map, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean isOkayStraight(int[][] map, int idx) {
        boolean[] rowCheck = new boolean[9];
        boolean[] colCheck = new boolean[9];
        for (int k = 0; k < 9; k++) {
            colCheck[map[idx][k]-1] = true;
            rowCheck[map[k][idx]-1] = true;
        }

        // 가로 세로 체크
        for (int k = 0; k < 9; k++) {
            if (!rowCheck[k] || !colCheck[k])
                return false;
        }

        return true;
    }

    private boolean isOkaySquare(int[][] map, int row, int col) {
        boolean[] check = new boolean[9];
        for(int i=row-1; i<=row+1; i++) {
            for(int j=col-1; j<=col+1; j++)
                check[map[i][j]-1] = true;
        }

        for (int k = 0; k < 9; k++) {
            if (!check[k])
                return false;
        }

        return true;
    }

}