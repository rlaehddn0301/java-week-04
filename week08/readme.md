java 8주차 레포트
=============

1. 다음 main() 메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV 클래스를 작성하라
<pre>
package Report_8;

class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

public class ColorTV extends TV {
    private int colorCount;

    public ColorTV(int size, int colorCount) {
        super(size);
        this.colorCount = colorCount;
    }

    public void printProperty() {
        System.out.println("Size: " + getSize() + " inches, Color Count: " + colorCount);
    }

    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
}
</pre>

2. 다음 main() 메소드와 실행 결과를 참고하여 문제 1의 ColorTV를 상속받은 IPTV 클래스를 작성하라.
<pre>
package Report_8;

class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int colorCount;

    public ColorTV(int size, int colorCount) {
        super(size);
        this.colorCount = colorCount;
    }

    public void printProperty() {
        System.out.println("Size: " + getSize() + " inches, Color Count: " + colorCount);
    }
}

public class IPTV extends ColorTV {
    private String ipAddress;

    public IPTV(String ipAddress, int size, int colorCount) {
        super(size, colorCount);
        this.ipAddress = ipAddress;
    }

    @Override
    public void printProperty() {
        System.out.println("IP Address: " + ipAddress + ", " + "Size: " + getSize() + " inches, Color Count: " + colorCount);
    }

    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}
</pre>

3. Converter 클래스를 상속받아 원화를 달러로 변환하는 wonDollar 클래스를 작성하라 main() 메소드와 실행결과는 다음과 같다.
   <pre>
     원을 달러로 바꿉니다
     원을 입력하세요 >> 24000
     변환 결과 : 20.0달러입니다.
   </pre>
   
<pre>
 package Report_8;

import java.util.Scanner;

class Converter {
    public static void main(String[] args) {
        WonDollar toDollar = new WonDollar(1200); // 1달러는 1200원
        toDollar.run();
    }
}

class WonDollar extends Converter {
    private double ratio;

    public WonDollar(double ratio) {
        this.ratio = ratio;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원을 달러로 바꿉니다");
        System.out.print("원을 입력하세요 >> ");

        double won = scanner.nextDouble();
        double result = convert(won);

        System.out.println("변환 결과 : " + result + "달러입니다.");
        scanner.close();
    }

    private double convert(double won) {
        return won / ratio;
    }
}

</pre>

4. Converter 클래스를 상속받아 km을 mile(마일)로 변화하는 km2Mile 클래슬르 작성하라. main() 메소드 실행 결과는 다음과 같다.
    <pre>
      km을 mile로 바꿉니다.
      km을 입력하세요 >> 30
      변환 결과 : 18.75mile 입니다.
    </pre>

<pre>
package Report_8;

import java.util.Scanner;

class Mile {
    public static void main(String[] args) {
        Km2Mile toMile = new Km2Mile(1.6); // 1마일은 1.6km
        toMile.run();
    }
}

class Km2Mile extends Converter {
    private double ratio;

    public Km2Mile(double ratio) {
        this.ratio = ratio;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("km을 mile로 바꿉니다.");
        System.out.print("km을 입력하세요 >> ");

        double km = scanner.nextDouble();
        double result = convert(km);

        System.out.println("변환 결과 : " + result + "mile 입니다.");
        scanner.close();
    }

    private double convert(double km) {
        return km / ratio;
    }
}

</pre>

5. Point를 상속받아 책을 가진 점을 나타내는 ColorPoint 클래스를 작성하라. 다음 main() 메소드를 포함하고 실행결과와 같이 출력되게 하라.
   <pre>
     package Report_8;

public class ColorPoint {

	public static void main(String[] args) {
		ColorPoint = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		String str = cp.toString();
		System.out.println(str + "입니다");

	}
}
   </pre>
   
<pre>
  package Report_8;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", color: " + color;
    }

    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
        cp.setXY(10, 20);
        cp.setColor("RED");
        String str = cp.toString();
        System.out.println(str + "입니다");
    }
}
</pre>

6. Point를 상속받아 책을 가진 점을 나타내는 ColorPoint 클래스를 작성하라. 다음 main() 메소드를 포함하고 실행결과와 같이 출력되게 하라.

<pre>
package Report_8;

public class RedBlack {

	public static void main(String[] args) {
		ColorPoint zeroPoint = new ColorPoint(); //(0, 0) 위치의 black 색 점
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint cp = new colorPoint(10, 10); //(10, 10) 위치의 black 색 점
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");
		}
}

  <pre>
    package Report_8;

class Point {
    protected int x, y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint() {
        super(); // Call the default constructor of the superclass
        this.color = "black";
    }

    public ColorPoint(int x, int y) {
        super(x, y); // Call the parameterized constructor of the superclass
        this.color = "black";
    }

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " " + color;
    }
}

public class RedBlack {
    public static void main(String[] args) {
        ColorPoint zeroPoint = new ColorPoint(); // (0, 0) 위치의 black 색 점
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPoint cp = new ColorPoint(10, 10); // (10, 10) 위치의 black 색 점
        cp.setXY(5, 5);
        cp.setColor("RED");
        System.out.println(cp.toString() + "입니다.");
    }
}

  </pre>

</pre>

7. Point를 상속받아 3차원의 점을 나타내는 Point3D 클래스를 작성하라. 다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
<pre>
  package Report_8;

public class Point3D {

	public static void main(String[] args) {
		Point3D p = new Point3D(1, 2, 3); // 1, 2, 3은 각각 x, y, z축의 값.
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(); // z 축으로 이동
		System.out.println(p.toString() + "입니다.");
		
		p.moveDown(); // z 축으로 아래쪽 이동
		p.move(10, 10); // x, y 축으로 이동
		System.out.println(p.toString() + "입니다.");
		
		p.move(100, 200, 300); // x, y, z 축으로 이동
		System.out.println(p.toString() + "입니다.");
}
</pre>
package Report_8_7;

class Point {
    protected int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp() {
        z++;
    }

    public void moveDown() {
        z--;
    }

    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    public static void main(String[] args) {
        Point3D p = new Point3D(1, 2, 3);
        System.out.println(p.toString() + "입니다.");

        p.moveUp();
        System.out.println(p.toString() + "입니다.");

        p.moveDown();
        p.move(10, 10, 0);
        System.out.println(p.toString() + "입니다.");

        p.move(100, 200, 300);
        System.out.println(p.toString() + "입니다.");
    }
}

<pre>
  

8. Point 를 상속받아 양수의 공간에서만 점을 나타내는 PositivePoint 클래스를 작성하라. main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
<pre>
  package Report_8_8;

public class PositivePoint {

	public static void main(String[] args) {
		PositivePoint = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString() + "입니다.");
		
		p.move(-5, 5); // 객체 p는 음수 공간으로 이동되지 않음
		System.out.println(p.toString() + "입니다.");
		
		PositivePoint p2 = new PositivePoint(-10, -10);
		System.out.println(p.toString() + "입니다.");
	}

}
</pre>

<pre>
  package Report_8_8;

class Point {
    protected int x, y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class PositivePoint extends Point {

    public PositivePoint() {
        super();
        ensurePositive();
    }

    public PositivePoint(int x, int y) {
        super(x, y);
        ensurePositive();
    }

    private void ensurePositive() {
        if (x < 0 || y < 0) {
            x = 0;
            y = 0;
        }
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        ensurePositive();
    }

    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(10, 10);
        System.out.println(p.toString() + "입니다.");

        p.move(-5, 5); // 객체 p는 음수 공간으로 이동되지 않음
        System.out.println(p.toString() + "입니다.");

        PositivePoint p2 = new PositivePoint(-10, -10);
        System.out.println(p2.toString() + "입니다.");
    }
}

</pre>

9. 다음 Stack 인터페이스를 상속받아 실수를 저장하는 StringStack 클래스를 구현하라. 그리고 다음 실행 사례와 같이 작동하도록 StackApp 클래스에 main() 메소드를 작성하라.

<pre>
  총 스택 저장공간의 크기 입력 >> 3
  문자열 입력 >> hello
  문자열 입력 >> smile
  문자열 입력 >> sunny
  문자열 입력 >> happy
  스택이 꽉 차서 푸시 불가!
  문자열 입력 >> 그만
  스택에 저장된 모든 문자열 팝 : smile sunny hello
</pre>

<pre>
  package Report_8_9;

class StringStack implements Stack {
    private int size;
    private int capacity;
    private String[] stackArray;

    public StringStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.stackArray = new String[capacity];
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public String pop() {
        if (size > 0) {
            String poppedValue = stackArray[--size];
            stackArray[size] = null; // Optional: dereference to help with garbage collection
            return poppedValue;
        } else {
            return null; // Stack is empty
        }
    }

    @Override
    public boolean push(String val) {
        if (size < capacity) {
            stackArray[size++] = val;
            return true;
        } else {
            return false; // Stack is full
        }
    }
}

public class StackApp {
    public static void main(String[] args) {
        StringStack stack = new StringStack(5);

        System.out.println("Length: " + stack.length());
        System.out.println("Capacity: " + stack.capacity());

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        System.out.println("Length: " + stack.length());
        System.out.println("Capacity: " + stack.capacity());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Length: " + stack.length());
        System.out.println("Capacity: " + stack.capacity());

        stack.push("Grapes");
        stack.push("Orange");

        System.out.println("Length: " + stack.length());
        System.out.println("Capacity: " + stack.capacity());
    }
}

</pre>

