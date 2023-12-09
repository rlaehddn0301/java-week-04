java 9주차 레포트
=============

1. 다음 main()이 실행되면 아래 예시와 같이 출력되도록 MyPoint 클래스를 작성하라 
<pre>
  package six;

public class MyPoint1 {

	public static void main(String[] args) {
		MyPoint  p = new MyPoint(3, 50);
		MyPoint q = new MyPoint(4, 50);
		System.out.println(p);
		if(p.equals(q))
			System.out.println("같은 점");
		else
			System.out.println("다른 점");
	}

}
</pre>

<pre>
  package six;

public class MyPoint1 {

    public static class MyPoint {
        private int x;
        private int y;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyPoint myPoint = (MyPoint) obj;
            return x == myPoint.x && y == myPoint.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        MyPoint p = new MyPoint(3, 50);
        MyPoint q = new MyPoint(4, 50);
        System.out.println(p);
        if (p.equals(q))
            System.out.println("같은 점");
        else
            System.out.println("다른 점");
    }
}
</pre>

2. 중심을 나타내는 정수 x, y와 반지름 radius 필드를 가지는 Circle 클래스를 작성하고자 한다. 생성자는 3개의 인자(x, y, Circle)를 받아 해당 필드를 초기화하고,
   equals() 메소드는 두개의 Circle 객체의 중심이 같으면 같은것으로 판별하도록 한다.

<pre>
  package six;

public class Circle {

	public static void main(String[] args) {
		Circle a = new Circle(2, 3, 5); // 중심 (2, 3)에 반지름 5인 원
		Circle ㅠ = new Circle(2, 3, 30); // 중심 (2, 3)에 반지름 30인 원
		System.out.println("원 a : " + a);
		System.out.println("원 b : " + b);
		if(a.equals(b))
			System.out.println("같은 원");
		else
			System.out.println("서로 다른 원");
	}

}
</pre>

<pre>
  package six;

public class Circle {

    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Circle circle = (Circle) obj;
        return x == circle.x && y == circle.y;
    }

    @Override
    public String toString() {
        return "중심: (" + x + ", " + y + "), 반지름: " + radius;
    }

    public static void main(String[] args) {
        Circle a = new Circle(2, 3, 5); // 중심 (2, 3)에 반지름 5인 원
        Circle b = new Circle(2, 3, 30); // 중심 (2, 3)에 반지름 30인 원
        System.out.println("원 a : " + a);
        System.out.println("원 b : " + b);
        if (a.equals(b))
            System.out.println("같은 원");
        else
            System.out.println("서로 다른 원");
    }
}
</pre>

3. 다음 코드를 수정하여, Calc 클래스는 etc 패키지에. MainApp 클래스는 main 패키지로 분리 작성하라.
  <pre>
    package six;

class Calc {
	private int x, y;
	public Calc(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int sum() {
		return x+y;
	}
}

public class MainApp {

	public static void main(String[] args) {
		Calc c = new Calc(10, 20);
		System.out.println(c.sum());

	}

}
  </pre>

  <pre>
    // etc 패키지에 위치한 Calc 클래스
package etc;

public class Calc {
    private int x, y;

    public Calc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int sum() {
        return x + y;
    }
}
  </pre>

  <pre>
    // main 패키지에 위치한 MainApp 클래스
package main;

import etc.Calc;

public class MainApp {

    public static void main(String[] args) {
        Calc c = new Calc(10, 20);
        System.out.println(c.sum());
    }
}
  </pre>

4. 
