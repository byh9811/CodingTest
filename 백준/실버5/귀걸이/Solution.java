package 백준.실버5.귀걸이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answer = new ArrayList<>();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;
            String[] names = new String[n+1];
            boolean[] lost = new boolean[n+1];
            for(int i=1; i<n+1; i++)
                names[i] = br.readLine();

            for(int i=1; i<2*n; i++) {
                int idx = Integer.parseInt(br.readLine().split(" ")[0]);
                lost[idx] = lost[idx] ? false : true;
            }

            for(int i=1; i<n+1; i++) {
                if(lost[i])
                    answer.add(names[i]);
            }
        }

        for(int i=0; i<answer.size(); i++)
            System.out.println(i+1 + " " + answer.get(i));
    }
}