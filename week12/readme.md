java 12주차 레포트
=============

1.다음 그림과 같이 "Let's stduy Java"라는 문자열을 타이틀로 가지고 프레임의 크기가 400x200인 스윙 프로그램을 작성하라.

<pre>
  import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Let's study Java");

        // 프레임 크기 설정
        frame.setSize(400, 200);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

2. BorderLayout을 사용하여 컴포넌트 사이의 수평 수직 간격이 각각 5픽셀, 7픽셀이 되도록 스윙 응용프로그램을 작성하라.

<pre>
  import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("BorderLayout Example");

        // 프레임 크기 설정
        frame.setSize(400, 300);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout 설정
        frame.setLayout(new BorderLayout(5, 7));

        // 각 방향에 컴포넌트 추가
        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("West"), BorderLayout.WEST);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("Center"), BorderLayout.CENTER);

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

3. GridLayout을 사용하여 다음 그림과 같이 한 줄에 10개의 버튼을 동일한 크기로 배치하는 스윙 프로그램을 작성하라.

<pre>
  import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("GridLayout Example");

        // 프레임 크기 설정
        frame.setSize(400, 100);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout 설정
        int rows = 1; // 한 줄에 10개의 버튼
        int cols = 10;
        frame.setLayout(new GridLayout(rows, cols));

        // 10개의 버튼 추가
        for (int i = 1; i <= cols; i++) {
            frame.add(new JButton("Button " + i));
        }

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

4. 문제 3을 수정하여 다음 결과 같이 각 버튼의 배경색을 서로 다르게 설정하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorfulGridLayoutExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Colorful GridLayout Example");

        // 프레임 크기 설정
        frame.setSize(400, 100);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout 설정
        int rows = 1; // 한 줄에 10개의 버튼
        int cols = 10;
        frame.setLayout(new GridLayout(rows, cols));

        // 랜덤 색상 생성을 위한 Random 객체 생성
        Random random = new Random();

        // 10개의 버튼 추가
        for (int i = 1; i <= cols; i++) {
            JButton button = new JButton("Button " + i);

            // 랜덤 RGB 값으로 배경색 설정
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            button.setBackground(randomColor);

            frame.add(button);
        }

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

5. GridLayout을 이용하여 다음 그림과 같이 Color.WHITE, Color.GRAY, Color.RED 등 16개의 색을 배경색으로 하는 4 x 4 바둑판을 구성하라.

<pre>
  import javax.swing.*;
import java.awt.*;

public class CheckboardGridLayoutExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Checkboard GridLayout Example");

        // 프레임 크기 설정
        frame.setSize(400, 400);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout 설정
        int rows = 4;
        int cols = 4;
        frame.setLayout(new GridLayout(rows, cols));

        // 색 배열 정의
        Color[] colors = {Color.WHITE, Color.GRAY, Color.RED, Color.BLUE, Color.YELLOW,
                Color.GREEN, Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA,
                Color.LIGHT_GRAY, Color.DARK_GRAY, Color.BLACK, Color.decode("#FFD700"), Color.decode("#00CED1"), Color.decode("#800080")};

        int colorIndex = 0;

        // 4x4 바둑판 구성
        for (int i = 0; i < rows * cols; i++) {
            JButton button = new JButton();
            button.setBackground(colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length;
            frame.add(button);
        }

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

6. 20의 10 x 10 크기으 JLabel 컴포넌트가 프레임 내에 (50, 50) 위치에서 (250, 250) 영역에서 랜덤한 위치에 출력되도록 스윙 프로그램을 작성하라. 프레임의 크기를 300 x 300으로 하고, JLabel의 배경색은 모두 파란색으로 하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomPositionLabelsExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Random Position Labels Example");

        // 프레임 크기 설정
        frame.setSize(300, 300);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 랜덤 위치에 JLabel을 추가할 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(null); // 레이아웃 매니저를 null로 설정하여 위치를 직접 지정

        // JLabel 생성 및 추가
        int labelSize = 20;
        int gridSize = 30;
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JLabel label = new JLabel();
                label.setSize(labelSize, labelSize);
                label.setOpaque(true); // 배경색 적용을 위해 불투명 설정
                label.setBackground(Color.BLUE);

                // 랜덤한 위치에 JLabel 추가
                int x = random.nextInt(250 - labelSize) + 50;
                int y = random.nextInt(250 - labelSize) + 50;
                label.setLocation(x, y);

                panel.add(label);
            }
        }

        frame.add(panel);

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

7. 다음과 같은 GUI 모양을 가진 스윙 프레임을 작성하라. Open Challenge의 힌트나 정답을 참고하라. 버튼은 JButton, 텍스트는 JLabel, 입력창은 JTextField를 사용하면 된다.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingGUIExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Simple Swing GUI Example");

        // 프레임 크기 설정
        frame.setSize(300, 150);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 버튼 생성
        JButton button = new JButton("확인");

        // 레이블 생성
        JLabel label = new JLabel("텍스트를 입력하세요:");

        // 입력창 생성
        JTextField textField = new JTextField();

        // 버튼에 ActionListener 추가
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                label.setText("입력한 텍스트: " + inputText);
            }
        });

        // 패널에 컴포넌트 추가
        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        // 프레임에 패널 추가
        frame.add(panel);

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

8. 다음과 같은 GUI 모양을 가진 스윙 프레임을 작성하라. Open Challenge의 힌트나 정답을 참고하라. 10개의 '*' 문자는 10개의 JLabel을 이용하여 랜덤한 위치에 출력하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomStarsGUIExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Random Stars GUI Example");

        // 프레임 크기 설정
        frame.setSize(300, 300);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(null); // 레이아웃 매니저를 null로 설정하여 위치를 직접 지정

        // '*' 문자를 랜덤한 위치에 출력하는 JLabel 생성
        int numStars = 10;
        Random random = new Random();

        for (int i = 0; i < numStars; i++) {
            JLabel starLabel = new JLabel("*");
            starLabel.setForeground(Color.BLUE); // '*' 문자의 색상을 파란색으로 설정

            // 랜덤한 위치에 JLabel 추가
            int x = random.nextInt(250);
            int y = random.nextInt(250);
            starLabel.setBounds(x, y, 20, 20); // '*' 문자의 크기를 20x20으로 설정

            panel.add(starLabel);
        }

        frame.add(panel);

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>
