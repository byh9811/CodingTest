package 백준.실버5.종이자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        boolean[] col = new boolean[Integer.parseInt(input[0])+1];
        boolean[] row = new boolean[Integer.parseInt(input[1])+1];
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            int dir = Integer.parseInt(input2[0]);
            int val = Integer.parseInt(input2[1]);

            if(dir==0)
                row[val] = true;
            else
                col[val] = true;
        }

        row[row.length-1] = true;
        int rowMax = 0;
        int prev = 0;
        for(int i=1; i<row.length; i++) {
            if(!row[i])
                continue;

            rowMax = Math.max(rowMax, i-prev);
            prev = i;
        }

        col[col.length-1] = true;
        int colMax = 0;
        prev = 0;
        for(int i=1; i<col.length; i++) {
            if(!col[i])
                continue;

            colMax = Math.max(colMax, i-prev);
            prev = i;
        }

        System.out.print(colMax*rowMax);
    }
}