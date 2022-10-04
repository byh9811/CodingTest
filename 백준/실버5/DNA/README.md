# DNA

### 문제 설명

DNA란 어떤 유전물질을 구성하는 분자이다. 이 DNA는 서로 다른 4가지의 뉴클레오티드로 이루어져 있다(Adenine, Thymine, Guanine, Cytosine). 우리는 어떤 DNA의 물질을 표현할 때, 이 DNA를 이루는 뉴클레오티드의 첫글자를 따서 표현한다. 만약에 Thymine-Adenine-Adenine-Cytosine-Thymine-Guanine-Cytosine-Cytosine-Guanine-Adenine-Thymine로 이루어진 DNA가 있다고 하면, “TAACTGCCGAT”로 표현할 수 있다. 그리고 Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다. 만약에 “AGCAT"와 ”GGAAT"는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.

우리가 할 일은 다음과 같다. N개의 길이 M인 DNA s1, s2, ..., sn가 주어져 있을 때 Hamming Distance의 합이 가장 작은 DNA s를 구하는 것이다. 즉, s와 s1의 Hamming Distance + s와 s2의 Hamming Distance + s와 s3의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.

-----------
### 입력

첫 줄에 DNA의 수 N과 문자열의 길이 M이 주어진다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 DNA가 주어진다. N은 1,000보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.

-----------
### 출력

첫째 줄에 Hamming Distance의 합이 가장 작은 DNA 를 출력하고, 둘째 줄에는 그 Hamming Distance의 합을 출력하시오. 그러한 DNA가 여러 개 있을 때에는 사전순으로 가장 앞서는 것을 출력한다.

-----------
### URL

https://www.acmicpc.net/problem/1969

-----------
## 풀이
1. N의 크기를 가지는 String형 배열을 생성하고 입력받아 초기화한다.
2. 정답 DNA를 기록할 StringBuilder를 생성한다.
3. Hamming Distance를 기록할 int형 변수를 0으로 초기화한다.
2. 0부터 M까지 순회하며 다음을 수행한다.
   3. ATCG가 나온 횟수를 기록하는 int형 배열을 생성한다.
   4. 0부터 N까지 순회하며 각 dna의 현재 인덱스의 문자가 등장한 횟수를 기록한다.
   3. 가장 많이 나온 문자를 StringBuilder에 저장한다.
   4. N에서 가장 많이 나온 횟수를 빼서 
4. StringBuilder와 Hamming Distance를 형식에 맞게 출력한다.