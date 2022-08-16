package 유틸;

public class Rotate {
    /**
     * <li>이차원 배열을 시계방향으로 90도 단위로 회전하여 반환하는 함수</li>
     * <li>반시계방향으로 회전하려면 degree를 음수로 입력한다.</li>
     * <li>degree*90도를 회전하며 360도가 넘어도 처리한다.</li>
     *
     * @param arr 회전시킬 배열
     * @param degree 회전시킬 각도
     * @return 회전시킨 배열
     */
    private int[][] rotate(int[][] arr, int degree) {
        degree %= 360;
        if(degree<0)
            degree += 360;

        if(degree==0)
            return arr;

        int n = arr.length;
        int[][] ret = new int[n][n];

        if(degree==90) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    ret[i][j] = arr[n-j-1][i];
            }
        } else if(degree==180) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    ret[i][j] = arr[n-i-1][n-j-1];
            }
        } else if(degree==270) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    ret[i][j] = arr[j][n-i-1];
            }
        }

        return ret;
    }
}
