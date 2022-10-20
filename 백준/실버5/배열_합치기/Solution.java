package 백준.실버5.배열_합치기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        ArrayList<Integer> arr = new ArrayList<>();
        String[] input2 = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            arr.add(Integer.parseInt(input2[i]));
        String[] input3 = br.readLine().split(" ");
        for(int i=0; i<M; i++)
            arr.add(Integer.parseInt(input3[i]));

        arr.sort(null);
        StringBuilder sb = new StringBuilder();
        for(int elem: arr)
            sb.append(elem).append(' ');
        System.out.print(sb);
    }
}