# 로또
## 1단계 : 학습 테스트 실습
* String 테스트
  * split test
    * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
  * substring test
    * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
  * charAt test
    * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
* Set Collection 테스트
  * size test
    * Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
  * contains test
    * Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.
\
## 2단계 : 문자열 덧셈 계산기
* 구분자를 기준으로 분리한 각 숫자의 합을 반환
  * 기본 구분자 : ',', ':'
  * 예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6
* 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
\
## 3단계 : 로또(자동)
[클래스 구현]
* LottoGames
  * LottoInput/LottoOutput을 이용해 사용자로부터 값을 입력받고, 결과를 출력할 수 있다.
    * LottoInput: 사용자의 입력받기를 담당하는 클래스
    * LottoOutput: 결과의 출력을 담당하는 클래스
  * 사용자가 원하는 개수만큼 로또를 구입할 수 있다.
    * Order: 사용자의 로또 주문 정보를 관리하는 클래스(구매 수량/총 금액)
      * 구매 금액이 1000원 미만이면 IllegalArgumentException이 발생한다.
      * 구매 수량이 음수 혹은 0이면 IllegalArgumentException이 발생한다.
* Store
  * 로또 숫자의 범위(1-45)에 해당하는 랜덤한 숫자 6개를 사용자가 원하는 개수만큼 구입할 수 있다.
  * 현재 로또의 가격을 가진다. 
* Lottos
  * 사용자가 구매한 로또의 목록을 가진다.
  * 로또의 추첨을 요청한다(Lottos -> WinningLotto).
* Lotto 
  * 로또 1개를 의미하며, 1-45 범위 안의 랜덤한 숫자 6개를 가진다.
  * 지난 주 당첨 번호를 입력받아 당첨 상태(LottoStatus, 1-4등/낙첨)를 가진다.
* WinningLotto
  * 지난 주 당첨 번호를 입력받을 수 있다.
    * 중복된 값이 있으면 IllegalArgumentException이 발생한다.
    * 지난 주 당첨 번호에 음수 혹은 0이 포함되어 있으면 IllegalArgumentException이 발생한다.
    * 지난 주 당첨 번호의 개수가 6개가 아니라면 IllegalArgumentException이 발생한다.
  * 각 Lotto 객체에 지난 주 당첨 번호를 넘겨주며 추첨을 요청한다.
* WinStats: 아래와 같은 클래스들과 연관관계를 맺고 있는 클래스
  * ProfitRate: 누적 당첨 금액/구매 수량을 입력받아 수익률을 계산하는 클래스
  * AmountByLottoStatus: 누적 당첨 금액과 총 당첨 금액, 각 등수별 당첨 개수를 계산하는 클래스

[입출력 예시]\
구입금액을 입력해 주세요.\
14000\
14개를 구매했습니다.\
[8, 21, 23, 41, 42, 43]\
[3, 5, 11, 16, 32, 38]\
[7, 11, 16, 35, 36, 44]\
[1, 8, 11, 31, 41, 42]\
[13, 14, 16, 38, 42, 45]\
[7, 11, 30, 40, 42, 43]\
[2, 13, 22, 32, 38, 45]\
[23, 25, 33, 36, 39, 41]\
[1, 3, 5, 14, 22, 45]\
[5, 9, 38, 41, 43, 44]\
[2, 8, 9, 18, 19, 21]\
[13, 14, 18, 21, 23, 35]\
[17, 21, 29, 37, 42, 45]\
[3, 8, 27, 30, 35, 44]\
\
지난 주 당첨 번호를 입력해 주세요.\
1, 2, 3, 4, 5, 6\
\
당첨 통계\
---------\
3개 일치 (5000원)- 1개\
4개 일치 (50000원)- 0개\
5개 일치 (1500000원)- 0개\
6개 일치 (2000000000원)- 0개\
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

## 4단계 : 로또(2등)
[클래스 구현]
* LottoGames
  * 보너스 번호를 추가로 입력받을 수 있다.
  * 1-5등 당첨 결과와 수익률을 출력한다.
* Lotto
  * 지난 주 당첨 번호를 입력받아 당첨 상태(1-5등/낙첨)를 가진다.
  * LottoStatus: 당첨 상태 클래스
    * 1등: 6개 숫자 일치
    * 2등: 5개 숫자 일치 + 보너스볼 일치
    * 3등: 5개 숫자 일치
    * 4등: 4개 숫자 일치
    * 5등: 3개 숫자 일치
* WinningLotto
  * 보너스 번호를 가진다.
    * 지난 주 당첨번호에 포함된 번호가 보너스 번호로 입력되면 IllegalArgumentException 발생
    * 보너스 번호가 사용자가 구매한 로또에 포함되었는지 확인한다.

[입출력 예시]\
지난 주 당첨 번호를 입력해 주세요.\
1, 2, 3, 4, 5, 6\
보너스 볼을 입력해 주세요.\
7\
\
당첨 통계\
---------\
3개 일치 (5000원)- 1개\
4개 일치 (50000원)- 0개\
5개 일치 (1500000원)- 0개\
5개 일치, 보너스 볼 일치(30000000원) - 0개\
6개 일치 (2000000000원)- 0개\
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\