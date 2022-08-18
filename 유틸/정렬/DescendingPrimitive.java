package 유틸.정렬;

import java.util.Arrays;
import java.util.Collections;

public class DescendingPrimitive {
    /**
     * <li>Object 타입이 아닌 기본 타입 배열을 stream을 이용해 내림차순으로 정렬하는 함수</li>
     * <li>arr을 Stream으로 만들고 boxing하여 내림차순 정렬한다.</li>
     * <li>이후 mapToInt 메서드를 이용하여 unboxing하고 배열로 변환한다.</li>
     *
     * @param arr 정렬되지 않은 기본타입 배열
     * @return 정렬된 기본타입 배열
     */
    private int[] descendingPrimitive(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }
}
