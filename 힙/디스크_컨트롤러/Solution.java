package 힙.디스크_컨트롤러;

import java.util.Comparator;
import java.util.PriorityQueue;

class Job {
    int reqTime;
    int workTime;

    public Job(int reqTime, int workTime) {
        this.reqTime = reqTime;
        this.workTime = workTime;
    }
}

public class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> reqHeap = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job1.reqTime - job2.reqTime;
            }
        });
        PriorityQueue<Job> waitHeap = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.workTime - o2.workTime;
            }
        });
        int sum = 0;
        int time = 0;
        for(int[] job: jobs)
            reqHeap.add(new Job(job[0], job[1]));

        do {
            while(!reqHeap.isEmpty() && reqHeap.peek().reqTime<=time) {
                waitHeap.add(reqHeap.poll());
            }
            if(waitHeap.isEmpty()) {
                time = reqHeap.peek().reqTime;
                continue;
            }

            Job job = waitHeap.poll();
            time += job.workTime;
            sum += time - job.reqTime;
        } while(!reqHeap.isEmpty() || !waitHeap.isEmpty());

        return sum / jobs.length;
    }
}