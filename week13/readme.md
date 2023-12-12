java 13주차 레포트
=============

1. JLabel 컴포넌트는 Mouse 이벤트를 받을 수 있다. JLabel 컴포넌트에 마우스를 올리면 "Love Java"가. 내리면 "사랑해"가 출력되도록 스윙 응용프로그램을 작성하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventsExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Mouse Events Example");

        // 프레임 크기 설정
        frame.setSize(300, 200);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel 생성
        JLabel label = new JLabel();

        // JLabel에 MouseListener 추가
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭 이벤트 처리 (미사용)
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // 마우스 눌림 이벤트 처리 (미사용)
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // 마우스 떼어짐 이벤트 처리 (미사용)
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // 마우스가 컴포넌트에 들어왔을 때의 이벤트 처리
                label.setText("Love Java");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 마우스가 컴포넌트에서 나갔을 때의 이벤트 처리
                label.setText("사랑해");
            }
        });

        // 프레임에 JLabel 추가
        frame.add(label);

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

2. 컨텐트팬의 배경색은 초록색으로 하고 마우스를 드래깅하는 동안만 노란색으로 유지하는 스윙 응용프로그램을 작성하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DraggingColorChangeExample {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Dragging Color Change Example");

        // 프레임 크기 설정
        frame.setSize(300, 200);

        // 프레임을 화면 가운데에 위치
        frame.setLocationRelativeTo(null);

        // 프레임 종료 시 프로그램 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 생성
        Container contentPane = frame.getContentPane();

        // 컨텐트팬의 배경색을 초록색으로 설정
        contentPane.setBackground(Color.GREEN);

        // 마우스 이동 이벤트를 처리하는 MouseMotionListener 추가
        contentPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 마우스를 드래깅하는 동안의 이벤트 처리
                contentPane.setBackground(Color.YELLOW);
            }
        });

        // 마우스 이벤트를 처리하는 MouseAdapter 추가 (드래깅 외의 마우스 이벤트 처리)
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // 마우스를 뗐을 때의 이벤트 처리
                contentPane.setBackground(Color.GREEN);
            }
        });

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
</pre>

3. JLabel을 활용하여 "Love Java"를 출력하고 왼쪽 화살표 키(<Left> 키)를 입력할 때마다 "avaJ evoL"와 "Love Java"를 번갈아 출력하는 스윙 프로그램을 작성하라.

<pre>
  import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoveJavaSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 프레임 생성
            JFrame frame = new JFrame("Love Java Swing App");

            // 레이블 생성
            JLabel label = new JLabel("Love Java");

            // 레이블의 텍스트를 가운데 정렬
            label.setHorizontalAlignment(SwingConstants.CENTER);

            // 키 이벤트 처리를 위한 키 리스너 추가
            label.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    // 사용하지 않음
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    // 왼쪽 화살표 키가 눌렸을 때 처리
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        String currentText = label.getText();
                        // 현재 텍스트가 "Love Java"이면 "avaJ evoL"로, 그 반대의 경우로 변경
                        label.setText(currentText.equals("Love Java") ? "avaJ evoL" : "Love Java");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // 사용하지 않음
                }
            });

            // 레이블에 포커스 설정을 가능하게 함
            label.setFocusable(true);

            // 레이블에 액션 리스너 추가 (포커스를 받아야 키 이벤트를 받을 수 있도록 함)
            label.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 사용하지 않음
                }
            });

            // 컨텐트팬에 레이블 추가
            frame.getContentPane().add(label);

            // 프레임 설정
            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // 화면 중앙에 표시
            frame.setVisible(true);
        });
    }
}
</pre>

4. JLabel을 활용하여 "Love Java"를 출력하고 왼쪽 화살표 키(<Left> 키)를 입력할 때마다 "ove JavaL", "ve JavaLo", "e JavaLov"와 같이 한 문자씩 왼쪽으로 회전하는 프로그램을 작성하라.

<pre>
  import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RotateTextSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 프레임 생성
            JFrame frame = new JFrame("Rotate Text Swing App");

            // 레이블 생성
            JLabel label = new JLabel("Love Java");

            // 레이블의 텍스트를 가운데 정렬
            label.setHorizontalAlignment(SwingConstants.CENTER);

            // 키 이벤트 처리를 위한 키 리스너 추가
            label.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    // 사용하지 않음
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    // 왼쪽 화살표 키가 눌렸을 때 처리
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        String currentText = label.getText();
                        // 텍스트를 한 문자씩 왼쪽으로 회전
                        label.setText(rotateTextLeft(currentText));
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // 사용하지 않음
                }
            });

            // 레이블에 포커스 설정을 가능하게 함
            label.setFocusable(true);

            // 컨텐트팬에 레이블 추가
            frame.getContentPane().add(label);

            // 프레임 설정
            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // 화면 중앙에 표시
            frame.setVisible(true);
        });
    }

    // 문자열을 한 문자씩 왼쪽으로 회전하는 메소드
    private static String rotateTextLeft(String text) {
        char[] charArray = text.toCharArray();
        char firstChar = charArray[0];
        System.arraycopy(charArray, 1, charArray, 0, charArray.length - 1);
        charArray[charArray.length - 1] = firstChar;
        return new String(charArray);
    }
}
</pre>

5. JLabel 컴포넌트로 "Love Java"를 출력하고, 키 리스너를 작성하여 + 키를 치면 폰트 크기를 5픽셀씩 키우고, - 키를 치면 폰트 크기를 5픽셀씩 줄이는 스윙 응용프로그램을 작성하라. 5픽셀 이하로 작아지지 않도록 하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FontSizeChangeApp {
    private static final String INITIAL_TEXT = "Love Java";
    private static final int MIN_FONT_SIZE = 5;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 프레임 생성
            JFrame frame = new JFrame("Font Size Change App");

            // 레이블 생성
            JLabel label = new JLabel(INITIAL_TEXT);

            // 레이블의 텍스트를 가운데 정렬
            label.setHorizontalAlignment(SwingConstants.CENTER);

            // 키 이벤트 처리를 위한 키 리스너 추가
            label.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    // 사용하지 않음
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    // + 키가 눌렸을 때 처리
                    if (e.getKeyChar() == '+') {
                        increaseFontSize(label);
                    }
                    // - 키가 눌렸을 때 처리
                    else if (e.getKeyChar() == '-') {
                        decreaseFontSize(label);
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // 사용하지 않음
                }
            });

            // 레이블에 포커스 설정을 가능하게 함
            label.setFocusable(true);

            // 컨텐트팬에 레이블 추가
            frame.getContentPane().add(label);

            // 프레임 설정
            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // 화면 중앙에 표시
            frame.setVisible(true);
        });
    }

    // 폰트 크기를 키우는 메소드
    private static void increaseFontSize(JLabel label) {
        Font currentFont = label.getFont();
        int currentSize = currentFont.getSize();
        int newSize = currentSize + 5;
        label.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), newSize));
    }

    // 폰트 크기를 줄이는 메소드 (5픽셀 이하로 작아지지 않도록 처리)
    private static void decreaseFontSize(JLabel label) {
        Font currentFont = label.getFont();
        int currentSize = currentFont.getSize();
        int newSize = Math.max(currentSize - 5, MIN_FONT_SIZE);
        label.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), newSize));
    }
}
</pre>

6. 클릭 연습용 스윙 응용프로그램을 작성하라. "C"를 출력하는 JLabel을 하나 만들고 초기 위치를 (100, 100)으로 하고, "C"를 클릭할 때마다 컨텐트팬 내에 랜덤한 위치로 움직이게 하라.\

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ClickPracticeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 프레임 생성
            JFrame frame = new JFrame("Click Practice App");

            // 레이블 생성
            JLabel label = new JLabel("C");
            label.setFont(new Font("Arial", Font.PLAIN, 30));

            // 레이블의 위치 초기화
            label.setBounds(100, 100, 30, 30);

            // 마우스 클릭 이벤트 처리를 위한 마우스 어댑터 추가
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    moveLabelRandomly(label, frame.getContentPane());
                }
            });

            // 컨텐트팬에 레이블 추가
            frame.getContentPane().add(label);

            // 프레임 설정
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null); // 레이아웃 매니저 사용 안 함
            frame.setLocationRelativeTo(null); // 화면 중앙에 표시
            frame.setVisible(true);
        });
    }

    // 레이블을 랜덤한 위치로 이동시키는 메소드
    private static void moveLabelRandomly(JLabel label, Container container) {
        Random random = new Random();

        // 컨텐트팬의 크기
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();

        // 레이블의 크기
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();

        // 레이블을 랜덤한 위치로 이동
        int newX = random.nextInt(containerWidth - labelWidth);
        int newY = random.nextInt(containerHeight - labelHeight);
        label.setLocation(newX, newY);
    }
}
</pre>

7. JLabel을 활용하여 "Love Java"를 출력하고, "Love Java" 글자 위에 마우스를 올려 마우스 휠을 위로 굴리면 글자가 작아지고, 아래로 굴리면 글자가 커지도록 프로그램을 작성하라. 폰트 크기는 한 번에 5픽셀씩 작아지거나 커지도록 하고, 5픽셀 이하로 작아지지 않도록 하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class FontSizeAdjustApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 프레임 생성
            JFrame frame = new JFrame("Font Size Adjust App");

            // 레이블 생성
            JLabel label = new JLabel("Love Java");
            label.setFont(new Font("Arial", Font.PLAIN, 30));

            // 마우스 휠 이벤트 처리를 위한 마우스 휠 리스너 추가
            label.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    adjustFontSize(label, e);
                }
            });

            // 컨텐트팬에 레이블 추가
            frame.getContentPane().add(label);

            // 프레임 설정
            frame.setSize(400, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout()); // 플로우 레이아웃 사용
            frame.setLocationRelativeTo(null); // 화면 중앙에 표시
            frame.setVisible(true);
        });
    }

    // 폰트 크기를 조절하는 메소드
    private static void adjustFontSize(JLabel label, MouseWheelEvent e) {
        Font currentFont = label.getFont();
        int newSize = currentFont.getSize() - e.getWheelRotation() * 5;

        // 최소 폰트 크기를 5로 제한
        newSize = Math.max(5, newSize);

        Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), newSize);
        label.setFont(newFont);
    }
}
</pre>
