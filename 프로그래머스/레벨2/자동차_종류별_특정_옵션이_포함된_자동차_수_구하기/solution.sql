/*
1. Like와 OR로 세 옵션 중 하나가 존재하는지 확인한다.
2. CAR_TYPE으로 그룹핑해야한다.
3. CAR_TYPE으로 오름차순 정렬해야한다.
*/
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' OR
        OPTIONS LIKE '%열선시트%' OR
        OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE ASC;