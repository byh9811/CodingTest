package 힙.이중우선순위큐;

import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(String operation: operations) {
            String[] split = operation.split(" ");
            String action = split[0];
            int num = Integer.parseInt(split[1]);

            if(action.equals("I")) {
                maxHeap.add(num);
                minHeap.add(num);
            } else {
                if(num<0)
                    maxHeap.remove(minHeap.poll());
                else
                    minHeap.remove(maxHeap.poll());
            }
        }
        int[] answer = new int[2];
        answer[0] = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        answer[1] = minHeap.isEmpty() ? 0 : minHeap.poll();

        return answer;
    }
}