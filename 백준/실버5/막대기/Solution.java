package 백준.실버5.막대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(64);
        int sum = 64;
        int X = Integer.parseInt(br.readLine());

        while(X!=sum) {
            int cur = heap.poll()/2;
            if(sum-cur>=X) {
                heap.add(cur);
                sum -= cur;
            } else {
                heap.add(cur);
                heap.add(cur);
            }
        }

        System.out.println(heap.size());
    }
}