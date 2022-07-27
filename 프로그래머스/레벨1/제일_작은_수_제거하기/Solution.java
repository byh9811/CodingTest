package 프로그래머스.레벨1.제일_작은_수_제거하기;

public class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1)
            return new int[]{-1};

        int min = Integer.MAX_VALUE;
        int idx = 0;
        boolean flag = false;
        int[] answer = new int[arr.length-1];

        for(int i=0; i<arr.length; i++) {
            if(arr[i]<min) {
                min = arr[i];
                idx = i;
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(flag)
                answer[i-1] = arr[i];
            else {
                if(i==idx)
                    flag = true;
                else
                    answer[i] = arr[i];
            }
        }

        return answer;
    }
}