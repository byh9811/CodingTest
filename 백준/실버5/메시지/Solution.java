package 백준.실버5.메시지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;
            idx++;
            String[][] arr = new String[n][n];
            for(int i=0; i<n; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0; j<n; j++)
                    arr[i][j] = input[j];
            }
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++) {
                for(int j=1; j<n; j++) {
                    if(arr[i][j].equals("P"))
                        continue;

                    sb.append(arr[i>=j ? i-j : i-j+n][0] + " was nasty about " + arr[i][0] + "\n");
                }
            }

            System.out.println("Group " + idx);
            if(sb.length()!=0)
                System.out.println(sb);
            else
                System.out.println("Nobody was nasty\n");
        }
    }
}