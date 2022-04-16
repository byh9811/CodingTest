package 프로그래머스.코딩테스트_고득점_Kit.DFS_및_BFS.그리디.큰_수_만들기;

public class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int startIdx = 0;

        for(int i=0; i<number.length()-k; i++) {    // 6개의 문자를 선택해야 함
            int max = 0;
            for(int j=startIdx; j<=i+k; j++) {    // 이번에 선택할 수 있는 문자를 선형탐색
                if(max<number.charAt(j)-'0') {  // 가장 큰 수 찾는 로직
                    max = number.charAt(j)-'0'; // max 갱신하고
                    startIdx = j+1; // 다음 탐색 시작 인덱스는 현재 인덱스 다음부터
                }
            }
            sb.append(max); // 고를 수 있는 가장 큰 값 저장
        }

        return sb.toString();
    }
}