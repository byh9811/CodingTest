package 백준.실버5.이차원_배열의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            for(int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(input2[j]);
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++) {
            String[] input3 = br.readLine().split(" ");
            int y1 = Integer.parseInt(input3[0]);
            int x1 = Integer.parseInt(input3[1]);
            int y2 = Integer.parseInt(input3[2]);
            int x2 = Integer.parseInt(input3[3]);
            int sum = 0;

            for(int j=y1-1; j<y2; j++) {
                for(int k=x1-1; k<x2; k++)
                    sum += arr[j][k];
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}