# 캐시

### 문제 설명

지도개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 읽어 보여주는 서비스를 개발하고 있다.
이 프로그램의 테스팅 업무를 담당하고 있는 어피치는 서비스를 오픈하기 전 각 로직에 대한 성능 측정을 수행하였는데, 제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다는 것을 알게 되었다.
어피치는 제이지에게 해당 로직을 개선하라고 닦달하기 시작하였고, 제이지는 DB 캐시를 적용하여 성능 개선을 시도하고 있지만 캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.

어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.

-----------
### 입력 형식

- 캐시 크기(`cacheSize`)와 도시이름 배열(`cities`)을 입력받는다.
- `cacheSize`는 정수이며, 범위는 0 ≦ `cacheSize` ≦ 30 이다.
- `cities`는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
- 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 도시 이름은 최대 20자로 이루어져 있다.

-----------
### 출력 형식

- 입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.

-----------
### 조건

- 캐시 교체 알고리즘은 `LRU`(Least Recently Used)를 사용한다.
- `cache hit`일 경우 실행시간은 `1`이다.
- `cache miss`일 경우 실행시간은 `5`이다.

-----------
### 입출력 예

| cacheSize | cities                                                                                                            | result |
|-----------|-------------------------------------------------------------------------------------------------------------------|--------|
| 3         | ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]                          | 50     |
| 3         | ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]                                 | 21     |
| 2         | ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"] | 60     |
| 5         | ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"] | 52     |
| 2         | ["Jeju", "Pangyo", "NewYork", "newyork"]                                                                          | 16     |
| 0         | 	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]                                                                     | 25     |


-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/17680

-----------
## 풀이
1. 대소문자를 구분하지 않으므로 전부 대문자로 바꿔 다룬다.
2. `cacheSize`가 0이면 도시 하나당 무조건 5의 실행시간을 가지므로 cache.length * 5를 리턴한다.
3. `Queue<String> cache`를 생성한다.
4. 총 실행시간을 기록할 `answer`를 0으로 초기화한다.
5. `cities`를 순회하면서 다음을 수행한다.
   1. `city`가 `cache`에 존재할 경우 다음을 수행한다.
      1. `answer`에 1을 더한다.
      2. `cache`의 크기가 `cacheSize`인 경우, `tempQ`를 생성하고 `city`를 제외한 원소를 `cache`에서 `poll()`하여 `tempQ`에 `add()`한다.
      3. `tempQ`의 모든 원소를 `poll()`하여 `cache`에 `add()`한다.
      4. `city`를 `cache`에 `add()`한다.
   2. `city`가 `cache`에 존재하지 않을 경우 다음을 수행한다.
      1. `answer`에 5를 더한다.
      2. `cache`의 크기가 `cacheSize`인 경우, `cache`에서 `poll()`한다.
      3. `city`를 `add()`한다.
6. 순회가 끝나면 `answer`를 리턴한다.