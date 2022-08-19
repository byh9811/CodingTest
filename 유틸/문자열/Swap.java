package 유틸.문자열;

public class Swap {
    /**
     * <li>String의 인덱스를 swap하여 반환하는 메서드</li>
     * <li>i와 j는 순서대로 들어오지 않아도 된다.</li>
     *
     * @param str 문자열 소스
     * @param i 옮길 인덱스 1
     * @param j 옮길 인덱스 2
     * @return 변화된 문자열
     */
    private String swap(String str, int i, int j) {
        int front = Math.min(i, j);
        int back = Math.max(i, j);

        return str.substring(0, front) + str.charAt(back) + str.substring(front+1, back) + str.charAt(front) + str.substring(back+1);
    }
}
