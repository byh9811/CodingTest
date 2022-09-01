package 유틸;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareExample implements Comparable<CompareExample> {
    /**
     * 1순위 정렬 방식
     */
    int first;

    /**
     * 2순위 정렬 방식
     */
    int second;

    /**
     * 3순위 정렬 방식
     */
    String third;

    public CompareExample(int first, int second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Comparable 인터페이스를 구현하기 위한 메서드
     * first기준으로 오름차순 정렬, second기준으로 내림차순 정렬, third기준으로 오름차순 정렬
     * 리턴값을 연산할 때 overflow나 underflow가 발생할 여지가 있다면 조건문으로 따로 분기해주어야 한다.
     *
     * @param o 비교할 객체
     * @return (오름차순 기준)이 객체의 필드가 매개변수의 필드보다 크면 양수, 작으면 음수, 같으면 0
     */
    public int compareTo(CompareExample o) {
        if(first!=o.first)
            return first-o.first;
        else if(second!=o.second)
            return o.second-second;
        else
            return third.compareTo(o.third);
    }

    /**
     * Comparator 인터페이스를 익명 클래스로 사용하는 예시
     * Integer 클래스를 내림차순으로 정렬하는 코드이다.
     * 람다로 변환할 수 있지만, 이해를 위해 원형을 유지했다.
     * 계산 과정에서 overflow나 underflow가 발생할 여지가 있으면 이 메서드처럼 분기한다.
     *
     * @param arr 정렬할 배열
     * @return 정렬된 배열을 변환한 List
     */
    public List<Integer> compare(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1==o2)
                    return 0;
                else if(o1>o2)
                    return 1;
                else
                    return -1;
            }
        });

        return List.of(arr);
    }
}