java 5주차 레포트
=================

1. 음 프로그램에 대해 물음에 답하라.

<pre>
  int sum=0, i=1;
while (i < 100) {
	sum = sum + i;
	i+=2;
}
system.out.println(sum);
</pre>

1) 무엇을 계산하는 코드이며 실행 결과 출력되는 내용은?
2) 위의 코드를 main() 메소드로 만들고 whileTest 클래스로 완성하라.
3) for문을 이용하여 동일하게 실행되는 ForTest 클래스를 작성하라.
4) do-while 문을 이용하여 동일하게 실행되는 DoWhileTest 클래스를 작성하라.

<pre> 1) 무엇을 계산하는 코드이며 실행 결과 출력되는 내용은?
  주어진 코드는 1부터 99까지 홀수들의 합을 계산하는 코드이다. 따라서 결과로는 2500이 출력된다.
</pre>

<pre> 2) 위의 코드를 main() 메소드로 만들고 whileTest 클래스로 완성하라.
  public class whileTest {
    public static void main(String[] args) {
        int sum=0, i=1;
        while (i < 100) {
            sum = sum + i;
            i+=2;
        }
        System.out.println(sum);
    }
}
</pre>

<pre> 3) for문을 이용하여 동일하게 실행되는 ForTest 클래스를 작성하라.
  public class ForTest {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
    }
}
</pre>

<pre> 4) do-while 문을 이용하여 동일하게 실행되는 DoWhileTest 클래스를 작성하라.
  public class DoWhileTest {
    public static void main(String[] args) {
        int sum = 0, i = 1;
        do {
            sum += i;
            i += 2;
        } while (i < 100);
        System.out.println(sum);
    }
}
</pre>
