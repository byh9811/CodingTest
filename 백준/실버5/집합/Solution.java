package 백준.실버5.집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] set = new boolean[21];
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];

            switch (order) {
                case "add": set[Integer.parseInt(input[1])] = true; break;
                case "remove": set[Integer.parseInt(input[1])] = false; break;
                case "check": sb.append((set[Integer.parseInt(input[1])] ? 1 : 0) + "\n"); break;
                case "toggle": set[Integer.parseInt(input[1])] = set[Integer.parseInt(input[1])] ? false : true; break;
                case "all": Arrays.fill(set, true); break;
                case "empty": Arrays.fill(set, false); break;
            }
        }

        System.out.print(sb);
    }
}