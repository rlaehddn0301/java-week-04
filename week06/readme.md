java 6주차 레포트
=================

1. 다음 프로그램에 대해 물음에 답하라.

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

2. 다음 2차원 배열 n을 출력하는 프로그램을 작성하라.
<pre>
public class ArrayPrint {
    public static void main(String[] args) {
        int n[][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }
}
</pre>

3. Scanner를 이용하여 정수를 입력받고 다음과 같이 *를 출력하는 프로그램을 작성하라. 다음은 5를 입력받았을 경우이다.
<pre>
import java.util.Scanner;

public class PrintStarsReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = scanner.nextInt();

        for (int i = num; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
</pre>

4. Scanner를 이용하여 소문자 알파벳을 하나 입력받고 다음과 같이 출력하는 프로그램을 작성하라. 다음은 e를 입력받았을 경우이다.
<pre>
import java.util.Scanner;

public class AlphabetPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("소문자 알파벳을 입력하세요: ");
        char input = scanner.next().charAt(0);

        int n = input - 'a' + 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char)('a' + j));
            }
            System.out.println();
        }
        scanner.close();
    }
}
</pre>

5. 양의 정수를 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라.
<pre>
import java.util.Scanner;

public class MultipleOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("양의 정수 10개를 입력하세요:");
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("입력된 배열에서 3의 배수는 다음과 같습니다:");
        for (int i = 0; i < 10; i++) {
            if (array[i] % 3 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        scanner.close();
    }
}
</pre>

6. 배열과 반복문을 이용하여 프로그램을 작성해보자. 키보드에서 정수로 된 돈의 액수를 입력받아 오만 원권, 만 원권, 천 원권, 500원짜리 동전, 100원짜리 동전, 50원짜리 동전, 10원짜리 동전, 1원짜리 동전이 각 몇 개로 변환되는지 예시와 같이 출력하라. 이때 반드시 다음 배열을 이용하고 반복문으로 작성하라.
<pre>
import java.util.Scanner;

public class MoneyConversion {
    public static void main(String[] args) {
        int[] units = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        String[] unitNames = {"오만 원권", "만 원권", "천 원권", "500원짜리 동전", "100원짜리 동전", "50원짜리 동전", "10원짜리 동전", "1원짜리 동전"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("정수로 된 돈의 액수를 입력하세요: ");
        int money = scanner.nextInt();

        System.out.println("입력한 액수를 화폐로 변환하면 다음과 같습니다:");
        for (int i = 0; i < units.length; i++) {
            int count = money / units[i];
            if (count > 0) {
                System.out.println(unitNames[i] + " : " + count + "개");
                money %= units[i];
            }
        }
        scanner.close();
    }
}
</pre>

7. 정수 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.
<pre>
import java.util.Random;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        // 배열에 1에서 10까지의 랜덤 정수 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        // 배열에 든 숫자들 출력
        System.out.print("배열에 든 숫자들: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // 평균 계산
        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = sum / array.length;
        System.out.println("\n평균: " + average);
    }
}
</pre>

8. 정수를 몇 개 저장할지 키보드로부터 개수를 입력받아(100보다 작은 개수) 정수 배열을 생성하고, 이곳에 1에서 100까지 범위의 정수를 랜덤하게 삽입해라. 배열에는 같은 수가 없도록 하고 배열을 출력하라.
<pre>
import java.util.Scanner;
import java.util.Random;

public class UniqueRandomArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열에 저장할 정수의 개수(100보다 작은 수)를 입력하세요: ");
        int count = scanner.nextInt();

        if (count >= 100) {
            System.out.println("100보다 작은 수를 입력해주세요.");
            return;
        }

        int[] array = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int num;
            do {
                num = random.nextInt(100) + 1;
            } while (isDuplicate(array, num, i));
            array[i] = num;
        }

        System.out.print("배열에 든 숫자들: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // 배열 내 중복 여부 확인
    private static boolean isDuplicate(int[] array, int num, int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }
}
</pre>

9. 4*4의 2차원 배열을 만들고 이곳에 1에서 10까지 범위의 정수를 랜덤하게 생성하여 정수 16개를 배열에 저장하고,  2차원 배열을 화면에 출력하라.
<pre>
import java.util.Random;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Random random = new Random();

        // 배열에 1에서 10까지의 랜덤 정수 저장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = random.nextInt(10) + 1;
            }
        }

        // 2차원 배열 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
</pre>

10. 4*4의 2차원 배열을 만들고 1에서 10까지 범위의 정수를 10개만 랜덤하게 생성하여 임의의 위치에 삽입하라. 동일한 정수가 있어도 상관없다. 나머지 6개의 숫자는 모두 0이다. 만들어진 2차원 배열을 화면에 출력하라.
<pre>
import java.util.Random;

public class PartiallyFilledArray {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Random random = new Random();

        // 10개의 랜덤 정수를 임의 위치에 삽입
        for (int k = 0; k < 10; k++) {
            int i = random.nextInt(4);
            int j = random.nextInt(4);
            int num = random.nextInt(10) + 1;
            array[i][j] = num;
        }

        // 나머지 6개의 숫자는 모두 0
        for (int k = 0; k < 6; k++) {
            int i = random.nextInt(4);
            int j = random.nextInt(4);
            array[i][j] = 0;
        }

        // 2차원 배열 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
</pre>

11. 다음과 같이 작동하는 Avergage.java를 작성하라. 명령행 인자는 모두 정수만 사용하며 정수들은 평균을 출력한다. 다음 화면은 컴파일된 Average.class 파일을 c:\Temp 디렉터리에 복사한 뒤 실행한 경우이다. 원본 Average.class 파일은 이클립스 프로젝트 폴더 bin 폴더에 있다.
<pre>
public class Average {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("인자가 제공되지 않았습니다.");
            return;
        }

        double sum = 0;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
        }
        double average = sum / args.length;

        System.out.println("평균: " + average);
    }
}
</pre>

12. 다음과 같이 작동하는 Add.java를 작성하라. 명령행 인자 중에서 정수 만을 골라 합을 구하라. 다음 화면은 Add.class 파일을 c:|Temp 디렉터리에 복사한 뒤 실행한 경우이다. 원본 Add,class 파일은 이클립스 프로젝트 폴더 밑에 bin 폴더에 있다.
<pre>
public class Add {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("인자가 제공되지 않았습니다.");
            return;
        }

        int sum = 0;
        for (String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                // 정수로 변환할 수 없는 경우 무시
            }
        }
        System.out.println("합: " + sum);
    }
}
</pre>

13. 반복문을 이용하여 369게임엣허 박수를 쳐야 하는 경우를 순서대로 화면에 출력해보자. 1부터 시작하며 99까지만 한다. 실행 사례는 다음과 같다.
<pre>
public class Game369 {
    public static void main(String[] args) {
        for (int i = 1; i <= 99; i++) {
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                System.out.println("박수");
            } else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
                System.out.println("박수");
            } else {
                System.out.println(i);
            }
        }
    }
}
</pre>

14. 다음 코드와 같이 과목과 점수가 짝을 이루도록 2개의 배열을 작성하라.
<pre>
public class SubjectScore {
    public static void main(String[] args) {
        String[] subjects = {"국어", "영어", "수학", "과학", "역사"};
        int[] scores = {95, 88, 76, 62, 55};

        // 배열 출력
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + scores[i]);
        }
    }
}
</pre>

15. 다음은 2개의 정수를 입력 받아 곱을 구하는 Multiply 클래스이다.
    <pre>
	    import java.util.Scanner;
	    public class Multiply {
	    	public static void main(String[] args) {
	    		Scanner scanner = new Scanner(System.in);
	    		System.out.print("곱하고자 하는 두 수 입력 : ");
	    		int n = scanner.nextInt();
	   		int m = scanner.nextInt();
	    		System.out.print(n + "x" + m + "=" + n * m);
	    		scanner.close();
	    }
	}
    </pre>

    1) 다음과 같이 실행 할 때 프로그램은 10과 5를 곱해 50을 잘 출력한다.
       <pre>
	       곱하고자 하는 두 수 입력 : 10 5
	       10*5=50
       </pre>
       
    2) 하지만, 다음과 같이 실수를 입력하였을 때, 예외가 발생한다.
       <pre>
	       곱하고자 하는 두 수 입력 : 2.5 4
	       >> 애러발생!!
       </pre>
    3) 다음과 같이 실수가 입력되면 정수를 다시 입력하도록 하여 예외 없이 정상적으로 처리되도록 예외 처리 코드를 삽입하여 Multiply  클래스를 수정하라.

<pre>
	       import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print("곱하고자 하는 두 수 입력 : ");
                n = scanner.nextInt();
                m = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요. 다시 시도하세요.");
                scanner.nextLine(); // 버퍼를 비워줌
            }
        }

        System.out.print(n + "x" + m + "=" + n * m);
        scanner.close();
    }
}
</pre>
