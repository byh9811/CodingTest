package 유틸.현실_알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {
    /**
     * <li>확인하고 싶은 정수를 입력받아 소수인지 판별하는 함수</li>
     * <li>소수는 약수가 1과 자기자신뿐인 자연수를 의미한다.</li>
     * <li>2부터 입력받은 수의 제곱근까지 반복하며 나누어 떨어지면 합성수다.</li>
     * <li>제곱근 이후부터는 확인하지 않은 수와 곱해질 수 없으므로 제곱근까지만 검사한다.</li>
     * <li>1이하이면 소수가 아니며, 2와 3은 소수지만 제곱근이 2미만이므로 따로 처리한다.</li>
     *
     * @param num 확인하고 싶은 수
     * @return num의 소수 여부
     */
    private boolean isPrime(int num) {
        if(num<=1)
            return false;
        else if(num==2 || num==3)
            return true;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }

        return true;
    }

    /**
     * <li>확인하고 싶은 범위를 입력받아 그 이하의 소수를 모두 구하는 함수</li>
     * <li>소수는 약수가 1과 자기자신뿐인 자연수를 의미한다.</li>
     * <li>에라토스테네스의 체를 이용하여 성능을 최적화한다.</li>
     * <li>i를 순회하면서 이전까지의 수는 이미 소수인지 구해놨으므로 j=i*2보단 j=i*i를 사용한다.</li>
     * <li>0과 1은 소수가 아니지만 사용하지 않는 영역이므로 따로 처리하지 않는다.</li>
     *
     * @param max 구하고 싶은 범위
     * @return max까지의 소수 List
     */
    private List<Integer> isPrimeWithEratos(int max) {
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        List<Integer> ret = new ArrayList<>();

        for(int i=2; i<=max; i++) {
            if(isPrime[i]) {
                ret.add(i);
                for(int j=i*i; j<=max; j+=i)
                    isPrime[j] = false;
            }
        }

        return ret;
    }
}
