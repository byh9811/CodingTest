package 프로그래머스.레벨2.삼각_달팽이;

public class Solution {
    int cnt = 1;

    public int[] solution(int n) {
        int[][] arr = new int[n][];
        for(int i=0; i<n; i++)
            arr[i] = new int[i+1];

        int lotate = 0;
        while(left(lotate, n, arr) && bottom(lotate, n, arr) && right(lotate, n, arr)) {
            lotate++;
        }

        int[] answer = new int[cnt-1];

        int idx = 0;
        for(int[] elem1: arr) {
            for(int elem: elem1)
                answer[idx++] = elem;
        }

        return answer;
    }

    private boolean left(int idx, int n, int[][] arr) {
        boolean changed = false;

        for(int col=idx*2; col<n-idx; col++) {
            arr[col][idx] = cnt++;
            changed = true;
        }

        return changed;
    }

    private boolean bottom(int idx, int n, int[][] arr) {
        boolean changed = false;

        for(int row=idx+1, col=n-idx-1; row<=col-idx; row++) {
            arr[col][row] = cnt++;
            changed = true;
        }

        return changed;
    }

    private boolean right(int idx, int n, int[][] arr) {
        boolean changed = false;

        for(int col=n-idx-2, row=col-idx; col>idx*2; col--, row--) {
            arr[col][row] = cnt++;
            changed = true;
        }

        return changed;
    }

}