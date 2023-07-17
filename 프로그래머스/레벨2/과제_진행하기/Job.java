package 프로그래머스.레벨2.과제_진행하기;

import java.util.*;

/*
1. 완료하지 못한 작업은 Stack에 넣으면 될 것 같다.
2. 순서대로 과제를 시작하므로 시작 시간을 기준으로 정렬해야할 것 같다.
3. 과제의 시작 시간이 최근 과제의 종료 시간보다 빠를 경우, 진행중인 과제를 스택에 넣고 다음 과제를 수행해야 한다.
4. 시간을 비교하기 위해서 분 단위로 통일하면 편리할 것 같다.

풀이 실패
1. class 생성을 주저함
2. sort 조건 람다식이 미숙함
*/
class Job {
    String name;
    int remainTime;
    
    public Job(String name, int remainTime) {
        this.name = name;
        this.remainTime = remainTime;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        for(int i=0; i<plans.length; i++) {
            plans[i][1] = convert(plans[i][1]);
            System.out.println(Arrays.toString(plans[i]));
        }
        
        Stack<Job> stack = new Stack<>();      // 0: 이름, 1: 남은 시간
        ArrayList<String> answer = new ArrayList<>();
        int prevTime = Integer.parseInt(plans[0][1]);
        stack.add(new Job(plans[0][0], Integer.parseInt(plans[0][2])));
        
        for(int i=1; i<plans.length; i++) {
            int startTime = Integer.parseInt(plans[i][1]);
            int needTime = Integer.parseInt(plans[i][2]);
            int workTime = startTime - prevTime;
            prevTime = startTime;
            
            while(!stack.isEmpty()) {
                Job job = stack.pop();
                if(workTime>job.remainTime) {     // 이전 과제를 완료할 수 있음
                    workTime -= job.remainTime;
                    answer.add(job.name);
                } else if(workTime==job.remainTime) {
                    answer.add(job.name);
                    break;
                } else {        // 이전 과제를 완료할 수 없음
                    job.remainTime -= workTime;
                    stack.push(job);
                    break;
                }
            }
            
            stack.push(new Job(plans[i][0], needTime));
        }
        
        while(!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private String convert(String origin) {
        int hour = Integer.parseInt(origin.substring(0, 2));
        int minute = Integer.parseInt(origin.substring(3));
        
        return Integer.toString(hour*60+minute);
    }
}