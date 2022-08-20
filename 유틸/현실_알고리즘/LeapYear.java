package 유틸.현실_알고리즘;

public class LeapYear {
    /**
     * <li>현재 연도를 입력받아 윤년인지 확인하는 함수</li>
     * <li>윤년은 2월이 29일로 하루가 더 많은 해이다.</li>
     * <li>현재 연도가 4의 배수면 윤년이지만, 100의 배수이면 아니고, 400의 배수이면 윤년이다.</li>
     *
     * @param year 현재 연도
     * @return 윤년 여부
     */
    private boolean isLeapYear(int year) {
        if(year%400==0)
            return true;
        else if(year%100==0)
            return false;
        else if(year%4==0)
            return true;
        else
            return false;
    }
}
