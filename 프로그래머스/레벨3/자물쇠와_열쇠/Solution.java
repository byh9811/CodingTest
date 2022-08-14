package 프로그래머스.레벨3.자물쇠와_열쇠;

public class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int[][] newLock = new int[lock.length + key.length*2 - 2][lock.length + key.length*2 - 2];
        setLock(lock, newLock, key.length-1);

        for(int i=0; i<newLock.length; i++) {       // newLock row
            for(int j=0; j<newLock.length; j++) {       //newLock col
                for(int k=0; k<4; k++) {        // rotation
                    key = rotate(key, k);
                    if(check(i, j, key, newLock))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean check(int i, int j, int[][] key, int[][] newLock) {
        for(int r=0; r<key.length; r++) {
            for(int c=0; c<key.length; c++)
                newLock[r+i][c+j] = newLock[r+i][c+j]^key[r][c];
        }

        for(int r=key.length-1; r<newLock.length-key.length; r++) {
            for(int c=key.length-1; c<newLock.length-key.length; c++) {
                if(newLock[r][c]!=1)
                    return false;
            }
        }

        return true;
    }

    private int[][] rotate(int[][] key, int k) {
        int n = key.length;
        int[][] ret = new int[n][n];

        if(k==1) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    ret[i][j] = key[j][n-i-1];
            }
        } else if(k==2) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    ret[i][j] = key[n-j-1][n-i-1];
            }
        } else if(k==3) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    ret[i][j] = key[n-j-1][i];
            }
        }

        return ret;
    }

    private void setLock(int[][] lock, int[][] newLock, int center) {
        for(int i=0; i<lock.length; i++) {
            for(int j=0; j<lock.length; j++)
                newLock[center+i][center+j] = lock[i][j];
        }
    }
}