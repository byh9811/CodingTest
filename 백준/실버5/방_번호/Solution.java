package 백준.실버5.방_번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        String input = br.readLine();

        for(char c: input.toCharArray()) {
            int i = c - '0';
            arr[i]++;
        }

        int max = 0;
        for(int i=0; i<9; i++) {
            int cur = 0;
            if(i==6) {
                int sum = arr[6]+arr[9];
                cur = sum%2==0 ? sum/2 : sum/2+1;
            } else {
                cur = arr[i];
            }

            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}