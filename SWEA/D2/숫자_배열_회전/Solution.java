package SWEA.D2.숫자_배열_회전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 1. 각 회전을 메서드로 정의한다.
* 2. 회전했을 때의 모양을 생각해서 반복문을 설계한다.
* 3. 출력 형식에 맞게 sb에 저장한다.
* */
public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for(int i=0; i<n; i++) {
                String input = br.readLine();
                map[i] = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            StringBuilder sb = new StringBuilder();
            sb.append('#').append(test_case).append('\n');
            for(int i=0; i<n; i++) {
                rotate90(map, sb, i);
                sb.append(' ');
                rotate180(map, sb, i);
                sb.append(' ');
                rotate270(map, sb, i);
                sb.append('\n');
            }

            System.out.print(sb);
        }
    }

    private void rotate270(int[][] map, StringBuilder sb, int idx) {
        for(int i=0; i<map.length; i++)
            sb.append(map[i][map.length-idx-1]);
    }

    private void rotate180(int[][] map, StringBuilder sb, int idx) {
        for(int i=map.length-1; i>=0; i--) {
            sb.append(map[map.length-idx-1][i]);
        }
    }

    private void rotate90(int[][] map, StringBuilder sb, int idx) {
        for(int i=map.length-1; i>=0; i--)
            sb.append(map[i][idx]);
    }
}