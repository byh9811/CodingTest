package 유틸;

public class BinarySearch {
    /**
     * 탐색을 수행할 배열
     */
    private int[] arr;

    /**
     * 배열에서 찾을 값
     */
    private int key;

    /**
     * key가 등장할 수 있는 최솟값
     */
    private int low;

    /**
     * key가 등장할 수 있는 최댓값
     */
    private int high;

    public BinarySearch(int[] arr, int key) {
        this.arr = arr;
        this.key = key;
        this.low = 0;
        this.high = arr.length;
    }

    /**
     * <h1>key를 찾아내는 이분 탐색</h1>
     * <li>반복문을 이용해 반복할 때마다 탐색 범위를 반으로 줄인다.</li>
     * <li>시간복잡도는 O(logN)이다.</li>
     *
     * @return key의 인덱스(없을 경우 -1)
     */
    public int executeBinarySearch() {
        int mid;

        while(low<=high) {
            mid = (low + high) / 2;

            if(key==arr[mid])
                return mid;
            else if(key>arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
