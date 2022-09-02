package 유틸;

import java.util.*;

public final class Utils {
    /**
     * <h1>확인하고 싶은 정수를 입력받아 소수인지 판별하는 함수</h1>
     * <li>소수는 약수가 1과 자기자신뿐인 자연수를 의미한다.</li>
     * <li>2부터 입력받은 수의 제곱근까지 반복하며 나누어 떨어지면 합성수다.</li>
     * <li>제곱근 이후부터는 확인하지 않은 수와 곱해질 수 없으므로 제곱근까지만 검사한다.</li>
     * <li>1이하이면 소수가 아니며, 2와 3은 소수지만 제곱근이 2미만이므로 따로 처리한다.</li>
     *
     * @param num 확인하고 싶은 수
     * @return num의 소수 여부
     */
    public static boolean isPrime(int num) {
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
     * <h1>확인하고 싶은 범위를 입력받아 그 이하의 소수를 모두 구하는 함수</h1>
     * <li>소수는 약수가 1과 자기자신뿐인 자연수를 의미한다.</li>
     * <li>에라토스테네스의 체를 이용하여 성능을 최적화한다.</li>
     * <li>i를 순회하면서 이전까지의 수는 이미 소수인지 구해놨으므로 j=i*2보단 j=i*i를 사용한다.</li>
     * <li>0과 1은 소수가 아니지만 사용하지 않는 영역이므로 따로 처리하지 않는다.</li>
     *
     * @param max 구하고 싶은 범위
     * @return max까지의 소수 List
     */
    public static List<Integer> isPrimeWithEratos(int max) {
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

    /**
     * <h1>현재 연도를 입력받아 윤년인지 확인하는 함수</h1>
     * <li>윤년은 2월이 29일로 하루가 더 많은 해이다.</li>
     * <li>현재 연도가 4의 배수면 윤년이지만, 100의 배수이면 아니고, 400의 배수이면 윤년이다.</li>
     *
     * @param year 현재 연도
     * @return 윤년 여부
     */
    public static boolean isLeapYear(int year) {
        if(year%400==0)
            return true;
        else if(year%100==0)
            return false;
        else if(year%4==0)
            return true;
        else
            return false;
    }

    /**
     * <h1>두 수의 최대공약수를 구하는 함수</h1>
     * <li>유클리드 호제법을 이용해 구현한다.</li>
     * <li>3개 이상의 수에 대해 구할 경우 임의의 두 수에 대해 함수를 호출하고 리턴값과 다른 수에 대해 호출을 반복하면 된다.</li>
     *
     * @param big 최대공약수를 구하려하는 두 수 중에 큰 값
     * @param small 최대공약수를 구하려하는 두 수 중에 작은 값
     * @return 최대공약수
     */
    public static int getGCD(int big, int small) {
        return big%small==0 ? small : getGCD(small, big%small);
    }

    /**
     * <h1>두 수의 최소공배수를 구하는 함수</h1>
     * <li>두 수를 곱하고 최대공약수로 나누면 최소공배수가 된다.</li>
     * <li>3개 이상의 수에 대해 구할 경우 임의의 두 수에 대해 함수를 호출하고 리턴값과 다른 수에 대해 호출을 반복하면 된다.</li>
     *
     * @param big 최소공배수를 구하려하는 두 수 중에 큰 값
     * @param small 최소공배수를 구하려하는 두 수 중에 작은 값
     * @return 최소공배수
     */
    public static int getLCM(int big, int small) { return big * small / getGCD(big, small); }

    /**
     * <h1>Object 타입이 아닌 기본 타입 배열을 stream을 이용해 내림차순으로 정렬하는 함수</h1>
     * <li>arr을 Stream으로 만들고 boxing하여 내림차순 정렬한다.</li>
     * <li>이후 mapToInt 메서드를 이용하여 unboxing하고 배열로 변환한다.</li>
     *
     * @param arr 정렬되지 않은 기본타입 배열
     * @return 정렬된 기본타입 배열
     */
    public static int[] descendingPrimitive(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }

    /**
     * <h1>이차원 배열을 시계방향으로 90도 단위로 회전하여 반환하는 함수</h1>
     * <li>반시계방향으로 회전하려면 degree를 음수로 입력한다.</li>
     * <li>degree*90도를 회전하며 360도가 넘어도 처리한다.</li>
     *
     * @param arr 회전시킬 배열
     * @param degree 회전시킬 각도
     * @return 회전시킨 배열
     */
    public static int[][] rotate(int[][] arr, int degree) {
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

    /**
     * <h1>String의 특정 인덱스 문자를 swap하여 반환하는 메서드</h1>
     * <li>i와 j는 순서대로 들어오지 않아도 된다.</li>
     *
     * @param str 문자열 소스
     * @param i 옮길 인덱스 1
     * @param j 옮길 인덱스 2
     * @return 변화된 문자열
     */
    public static String swap(String str, int i, int j) {
        int front = Math.min(i, j);
        int back = Math.max(i, j);

        return str.substring(0, front) + str.charAt(back) + str.substring(front+1, back) + str.charAt(front) + str.substring(back+1);
    }

    /**
     * <h1>배열의 특정 인덱스 원소를 swap하는 메서드</h1>
     * <li>i와 j는 순서대로 들어오지 않아도 된다.</li>
     *
     * @param arr 변환활 배열
     * @param i 옮길 인덱스 1
     * @param j 옮길 인덱스 2
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * <h1>재귀를 이용하여 팩토리얼을 구하는 함수</h1>
     *
     * @param num 변환활 배열
     * @return num!
     */
    public static int factorial(int num) {
        if(num==0)
            return 1;

        return num * factorial(num-1);
    }

    /**
     * <h1>기본타입 배열을 박싱된 기본 타입 배열로 변환하는 함수</h1>
     *
     * @param arr 변환활 기본 타입 배열
     * @return 박싱된 기본 타입 배열
     */
    public static Integer[] boxing(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }

    /**
     * <h1>박싱된 기본 타입 배열을 기본타입 배열로 변환하는 함수</h1>
     *
     * @param arr 박싱된 기본 타입 배열
     * @return 기본 타입 배열
     */
    public static int[] unboxing(Integer[] arr) {
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }

}