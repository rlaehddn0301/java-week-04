java 5주차 레포트
=================

13. 다음 switch 문이 있을 때, (1)~(4)의 각 문항에 따라 출력되는 결과는?
<pre>
  int sum=0;
  switch(grade) {
  case 'A' : sum += 100;
  case 'B' : sum += 50;
  case 'C' : sum += 30;
  case 'D' : sum += 10;
  }
  System.out.print(sum);
</pre>

<pre>
  (1) grade가 'A' 일 때 : sum = 100 + 50 + 30 + 10 = 190
  (2) grade가 'B' 일 때 : sum = 50 + 30 + 10 = 90
  (3) grade가 'C' 일 때 : sum = 30 + 10 = 40
  (4) grade가 'F' 일 때 : sum = 10
</pre>

14. 다음 if 문을 switch 문으로 바꾸어라.
<pre>
  if(in.equals("가위"))
    System.out.println(1);
  else if(in.equals("바위"))
    System.out.println(2);
  else if(in.equals("보"))
    System.out.println(3);
  else
    System.out.println(0);
</pre>

<pre>
switch (in.hashCode()) {
    case "가위".hashCode():
        System.out.println(1);
        break;
    case "바위".hashCode():
        System.out.println(2);
        break;
    case "보".hashCode():
        System.out.println(3);
        break;
    default:
        System.out.println(0);
}
</pre>

15. java 별찍기 마름모
<pre>
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i; j--) {             //위쪽 삼각형
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 4; i > 0; i--) {                //아래쪽 삼각형
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

</pre>
