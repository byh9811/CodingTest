package 프로그래머스.레벨2.호텔_대실;

import java.util.*;

/*
1. 예약을 시작 시간순으로 정렬한다.
2. 예약을 순회하며 끝나는 시간을 PQ에 넣는다.
3. 다음 예약의 시작 시간보다 작은 예약을 종료하고 새로운 예약을 받는다.
    - 청소시간 10분에 유의한다.
    - 시간은 항상 "HH:MM"으로 유지되어야 한다.
4. 예약을 종료할 때는 사용중인 객실 수를 +1, 예약을 시작할 때는 -1하여 최댓값을 저장한다.

풀이 시간: 43분 10초
*/
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        int using = 0;
        int answer = Integer.MIN_VALUE;
        PriorityQueue<String> endTimeQ = new PriorityQueue<>();
        
        for(int i=0; i<book_time.length; i++) {
            String curTime = book_time[i][0];
            endTimeQ.add(addCleaningTime(book_time[i][1]));
            using++;
            
            while(!endTimeQ.isEmpty() && endTimeQ.peek().compareTo(curTime)<=0) {
                endTimeQ.poll();
                using--;
            }
            
            answer = Math.max(answer, using);
        }
        
        return answer;
    }
    
    private String addCleaningTime(String time) {
        String hour = time.substring(0, 2);
        String minute = time.substring(3);
        int hourInt = Integer.parseInt(hour);
        int minuteInt = Integer.parseInt(minute) + 10;
        if(minuteInt>=60) {
            hourInt++;
            minuteInt -= 60;
        }
        
        StringBuilder sb = new StringBuilder();
        if(hourInt<10) {
            sb.append(0);
        }
        sb.append(hourInt).append(':');
        
        if(minuteInt<10) {
            sb.append(0);
        }
        sb.append(minuteInt);
        
        return sb.toString();
    }
}