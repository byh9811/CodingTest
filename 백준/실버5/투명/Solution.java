package 백준.실버5.투명;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101];
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=0; i<N; i++) {
            String[] coordinates = br.readLine().split(" ");
            int startX = Integer.parseInt(coordinates[0]);
            int startY = Integer.parseInt(coordinates[1]);
            int endX = Integer.parseInt(coordinates[2]);
            int endY = Integer.parseInt(coordinates[3]);

            for(int j=startY; j<=endY; j++) {
                for(int k=startX; k<=endX; k++)
                    arr[j][k]++;
            }
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j]>M)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}