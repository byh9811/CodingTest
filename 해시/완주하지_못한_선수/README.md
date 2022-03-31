# 완주하지 못한 선수

### 문제 설명

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

-----------
### 제한 사항

- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.

-----------
### 입출력 예

| participant                                       | completion                               | return    |
|---------------------------------------------------|------------------------------------------|-----------|
| ["leo", "kiki", "eden"]                           | ["eden", "kiki"]                         | 	"leo"    |
| ["marina", "josipa", "nikola", "vinko", "filipa"] | ["josipa", "filipa", "marina", "nikola"] | 	"vinko"  |
| ["mislav", "stanko", "mislav", "ana"]             | ["stanko", "ana", "mislav"]              | 	"mislav" |
-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42576

-----------
## 풀이
1. participant와 completion 모두 정렬한다.
2. 같은 인덱스로 participant와 completion을 순회하면서 같은지 비교한다.
3. 만약 다르다면, 그 때의 participant는 완주하지 못한 선수이다.
4. 또한 완주하지 못한 선수는 반드시 1명 존재하기 때문에, 마지막까지 미완주 선수를 찾지 못한다면 마지막 선수가 미완주 선수이다.