/*
    1. 조건은 2022년 10월 5일에 이뤄진 거래만 출력하는 것
    2. status를 한글로 변환해서 출력
    3. board_id 기준 내림차순 정렬
*/
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
       (CASE
            WHEN `STATUS`='SALE' THEN '판매중'
            WHEN `STATUS`='RESERVED' THEN '예약중'
            ELSE '거래완료'
           END) AS `STATUS`
FROM USED_GOODS_BOARD
where DATE_FORMAT(CREATED_DATE,'%Y-%m-%d') = '2022-10-05'
ORDER BY BOARD_ID DESC;