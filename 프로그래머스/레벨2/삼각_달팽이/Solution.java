package 프로그래머스.레벨2.삼각_달팽이;

public class Solution {
    int cnt = 1;

    public int[] solution(int n) {
        int[][] arr = new int[n][];
        for(int i=0; i<n; i++)
            arr[i] = new int[i+1];

        while(left(0, n, arr) || bottom() || right()) {}

        int num = 0;
        for(int i=1; i<=n; i++)
            num += i;
        int[] answer = new int[num];

        int idx = 0;
        for(int[] elem1: arr) {
            for(int elem: elem1)
                answer[idx++] = elem;
        }

        return answer;
    }

    private boolean left(int idx, int n, int[][] arr) {
        if(arr[idx*2][idx]!=0)
            return false;

        for(int col=idx*2; col<n-idx; col++)
            arr[col][idx] = cnt++;

        return true;
    }
}