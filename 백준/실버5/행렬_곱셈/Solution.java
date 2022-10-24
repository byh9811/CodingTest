package 백준.실버5.행렬_곱셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] head = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            for(int j=0; j<M; j++)
                head[i][j] = Integer.parseInt(input2[j]);
        }
        String[] input3 = br.readLine().split(" ");
        int K = Integer.parseInt(input3[1]);
        int[][] tail = new int[M][K];
        for(int i=0; i<M; i++) {
            String[] input4 = br.readLine().split(" ");
            for(int j=0; j<K; j++)
                tail[i][j] = Integer.parseInt(input4[j]);
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                int sum = 0;
                for(int k=0; k<M; k++)
                    sum += head[i][k] * tail[k][j];
                sb.append(sum).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}