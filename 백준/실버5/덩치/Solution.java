package 백준.실버5.덩치;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][N];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(input[0]);
            info[i][1] = Integer.parseInt(input[1]);
        }

        for(int i=0; i<N; i++) {
            int rank = 1;
            for(int j=0; j<N; j++) {
                if(i==j)
                    continue;

                if(info[i][0]<info[j][0] && info[i][1]<info[j][1])
                    rank++;
            }
            sb.append(rank);
            sb.append(' ');
        }

        System.out.println(sb);
    }
}