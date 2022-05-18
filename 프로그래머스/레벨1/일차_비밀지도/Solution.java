package 프로그래머스.레벨1.일차_비밀지도;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] map1 = new boolean[n][n];
        boolean[][] map2 = new boolean[n][n];

        for(int i=0; i<n; i++) {
            int deci1 = arr1[i];
            int deci2 = arr2[i];
            for(int j=0; j<n; j++) {
                int value = (int)Math.pow(2, n-j-1);
                if(deci1==0 || deci1<value) {
                    map1[i][j] = false;
                } else {
                    map1[i][j] = true;
                    deci1 -= value;
                }
                if(deci2==0 || deci2<value) {
                    map2[i][j] = false;
                } else {
                    map2[i][j] = true;
                    deci2 -= value;
                }
            }
        }

        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++)
                sb.append(map1[i][j]||map2[i][j] ? "#" : " ");
            answer[i] = sb.toString();
        }
        return answer;
    }
}