package 유틸.현실_알고리즘;

public class GreatestCommonDivisor {
    /**
     * <li>두 수의 최대공약수를 구하는 함수</li>
     * <li>유클리드 호제법을 이용해 구현한다.</li>
     * <li>3개 이상의 수에 대해 구할 경우 임의의 두 수에 대해 함수를 호출하고 리턴값과 다른 수에 대해 호출을 반복하면 된다.</li>
     *
     * @param big 최대공약수를 구하려하는 두 수 중에 큰 값
     * @param small 최대공약수를 구하려하는 두 수 중에 작은 값
     * @return 최대공약수
     */
    private int getGCD(int big, int small) {
        return big%small==0 ? small : getGCD(small, big%small);
    }
}
