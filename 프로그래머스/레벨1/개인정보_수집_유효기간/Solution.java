package 프로그래머스.레벨1.개인정보_수집_유효기간;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/150370
1. 날짜는 비교하기 쉽게 일수로 모두 변경한다.
2. 조건은 키, 값 형태이므로 해시로 저장한다.
3. 개인정보 유효기간은 해시를 이용해 만료기간을 일수로 변환한다.
4. 만료기간이 오늘미만인 정보의 인덱스를 +1하여 리턴한다.
5. 2022년 마지막 날을 일수로 바꿔도 int의 범위를 넘지 않으므로 int형으로 사용한다.
 */
public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character, Integer> map = new HashMap<>();
        int todayInt = convertDay(today);
        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0].charAt(0), Integer.parseInt(term[1])*28);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int expireDay = convertDay(privacy[0]) + map.get(privacy[1].charAt(0));
            System.out.println(todayInt);
            System.out.println(expireDay);
            if(expireDay<=todayInt)
                answer.add(i+1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int convertDay(String date) {
        int[] dateArr = Arrays.stream(date.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int day = dateArr[0] * 28 * 12;
        day += dateArr[1] * 28;
        day += dateArr[2];
        return day;
    }
}