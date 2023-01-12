package 백준.골드5.소트;
import java.util.*;
import java.io.*;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int S = Integer.parseInt(br.readLine());

        for(int curIdx=0; curIdx<arr.length && S>0; curIdx++) {
            int maxIdx = find(arr, curIdx, S);
            move(arr, maxIdx, curIdx);
            S -= maxIdx - curIdx;
        }

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private void move(int[] arr, int src, int tar) {
        int temp = arr[src];
        for(int i=src-1; i>=tar; i--) {
            arr[i+1] = arr[i];
        }
        arr[tar] = temp;
    }

    private int find(int[] arr, int start, int range) {
        int end = start + range;
        if(end>=arr.length)
            end = arr.length-1;
        int idx = 0;
        int max = 0;

        for(int i=start; i<=end; i++) {
            if(max<arr[i]) {
                max = arr[i];
                idx = i;
            }
        }

        return idx;
    }

}
