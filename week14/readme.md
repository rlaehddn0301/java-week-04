java 14주차 레포트
=============

1. 아래 그림과 같이 2개의 체크박스와 버튼을 하나 만들어라. "버튼 비활성화" 체크박스를 선택하면 버튼이 작동하지 못하게 하고, 해제하면 다시 작동하게 하라. "버튼 감추기" 체크박스를 선택하면 버튼이 보이지 않도록 하고 해제하면 버튼이 보이도록 하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonControlApp extends JFrame {
    private JButton button;
    private JCheckBox disableCheckBox;
    private JCheckBox hideCheckBox;

    public ButtonControlApp() {
        // 프레임 초기화
        setTitle("Button Control App");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 체크박스 및 버튼 초기화
        disableCheckBox = new JCheckBox("버튼 비활성화");
        hideCheckBox = new JCheckBox("버튼 감추기");
        button = new JButton("Click me!");

        // 체크박스 리스너 등록
        disableCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setEnabled(!disableCheckBox.isSelected());
            }
        });

        hideCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setVisible(!hideCheckBox.isSelected());
            }
        });

        // 버튼 리스너 등록
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ButtonControlApp.this, "버튼이 클릭되었습니다!");
            }
        });

        // 레이아웃 설정
        setLayout(new FlowLayout());
        add(disableCheckBox);
        add(hideCheckBox);
        add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonControlApp().setVisible(true);
            }
        });
    }
}
</pre>

2. 실행 예시와 같이 JComboBox로 빈 콤보박스를 만들고, JTextField 입력 창에 문자열을 입력하고 <Enter> 키를 입력하면 문자열을 콤보박스의 아이템으로 삽입하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ComboBoxExample extends JFrame {
    private JComboBox<String> comboBox;
    private JTextField textField;

    public ComboBoxExample() {
        // 프레임 초기화
        setTitle("ComboBox Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 콤보박스 및 텍스트 필드 초기화
        comboBox = new JComboBox<>();
        textField = new JTextField(15);

        // <Enter> 키 이벤트 처리
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addItem();
                }
            }
        });

        // 버튼 이벤트 처리
        JButton addButton = new JButton("추가");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        // 레이아웃 설정
        setLayout(new FlowLayout());
        add(comboBox);
        add(textField);
        add(addButton);
    }

    private void addItem() {
        String newItem = textField.getText().trim();
        if (!newItem.isEmpty() && !comboBoxContainsItem(newItem)) {
            comboBox.addItem(newItem);
            textField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "유효하지 않거나 중복된 아이템입니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean comboBoxContainsItem(String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComboBoxExample().setVisible(true);
            }
        });
    }
}
</pre>

3. 다음과 같은 화면을 구성하고 금액을 입력한 후 버튼을 클릭하면 오만원권, 만원권, 천원권, 500원짜리 동전, 100원짜리 동전, 50원짜리 동전, 10원짜리 동전, 1원짜리 동전이 각각 몇 개로 변환되는지 출력하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField amountField;
    private JTextArea resultArea;

    public CurrencyConverter() {
        // 프레임 초기화
        setTitle("화폐 변환기");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI 구성 요소 초기화
        amountField = new JTextField(10);
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);

        JButton convertButton = new JButton("변환");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // 레이아웃 설정
        setLayout(new FlowLayout());
        add(new JLabel("금액 입력:"));
        add(amountField);
        add(convertButton);
        add(new JScrollPane(resultArea));

        // 프레임 표시
        setVisible(true);
    }

    private void convertCurrency() {
        try {
            // 입력된 금액을 정수로 변환
            int amount = Integer.parseInt(amountField.getText());

            // 각 화폐 단위 계산
            int[] denominations = {50000, 10000, 1000, 500, 100, 50, 10, 1};
            int[] counts = new int[denominations.length];

            for (int i = 0; i < denominations.length; i++) {
                counts[i] = amount / denominations[i];
                amount %= denominations[i];
            }

            // 결과 출력
            resultArea.setText("");
            for (int i = 0; i < denominations.length; i++) {
                resultArea.append(denominations[i] + "원권/동전: " + counts[i] + "개\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "올바른 숫자를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter();
            }
        });
    }
}
</pre>

4. 실습문제 3번에서 체크박스를 추가하여, 사용자가 선택한 체크박스에 해당하는 돈으로만 바꿀 수 있도록 하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField amountField;
    private JTextArea resultArea;
    private JCheckBox fiftyThousandCheckBox;
    private JCheckBox tenThousandCheckBox;
    private JCheckBox thousandCheckBox;
    private JCheckBox fiveHundredCheckBox;
    private JCheckBox hundredCheckBox;
    private JCheckBox fiftyCheckBox;
    private JCheckBox tenCheckBox;
    private JCheckBox oneCheckBox;

    public CurrencyConverter() {
        // 프레임 초기화
        setTitle("화폐 변환기");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI 구성 요소 초기화
        amountField = new JTextField(10);
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);

        fiftyThousandCheckBox = new JCheckBox("5만원권");
        tenThousandCheckBox = new JCheckBox("1만원권");
        thousandCheckBox = new JCheckBox("1천원권");
        fiveHundredCheckBox = new JCheckBox("500원 동전");
        hundredCheckBox = new JCheckBox("100원 동전");
        fiftyCheckBox = new JCheckBox("50원 동전");
        tenCheckBox = new JCheckBox("10원 동전");
        oneCheckBox = new JCheckBox("1원 동전");

        JButton convertButton = new JButton("변환");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // 레이아웃 설정
        setLayout(new FlowLayout());
        add(new JLabel("금액 입력:"));
        add(amountField);
        add(fiftyThousandCheckBox);
        add(tenThousandCheckBox);
        add(thousandCheckBox);
        add(fiveHundredCheckBox);
        add(hundredCheckBox);
        add(fiftyCheckBox);
        add(tenCheckBox);
        add(oneCheckBox);
        add(convertButton);
        add(new JScrollPane(resultArea));

        // 프레임 표시
        setVisible(true);
    }

    private void convertCurrency() {
        try {
            // 입력된 금액을 정수로 변환
            int amount = Integer.parseInt(amountField.getText());

            // 체크박스 상태에 따라 변환할 화폐 단위 결정
            int[] denominations = {50000, 10000, 1000, 500, 100, 50, 10, 1};
            JCheckBox[] checkBoxes = {
                    fiftyThousandCheckBox, tenThousandCheckBox, thousandCheckBox,
                    fiveHundredCheckBox, hundredCheckBox, fiftyCheckBox, tenCheckBox, oneCheckBox
            };

            // 각 화폐 단위 계산
            int[] counts = new int[denominations.length];

            for (int i = 0; i < denominations.length; i++) {
                if (checkBoxes[i].isSelected()) {
                    counts[i] = amount / denominations[i];
                    amount %= denominations[i];
                }
            }

            // 결과 출력
            resultArea.setText("");
            for (int i = 0; i < denominations.length; i++) {
                if (checkBoxes[i].isSelected()) {
                    resultArea.append(denominations[i] + "원권/동전: " + counts[i] + "개\n");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "올바른 숫자를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter();
            }
        });
    }
}
</pre>

5. 100에서 200까지 조절할 수 있는 수평 슬라이더와 레이블을 하나 만들고 사용자가 슬라이더를 움직이면 레이블 컴포넌트에 수치로 보여주는 스윙 응용프로그램을 작성하라.

<pre>
  import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderExample extends JFrame {
    private JSlider slider;
    private JLabel label;

    public SliderExample() {
        // 프레임 초기화
        setTitle("수평 슬라이더 예제");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI 구성 요소 초기화
        slider = new JSlider(JSlider.HORIZONTAL, 100, 200, 100);
        label = new JLabel("100");

        // 슬라이더와 레이블 간격 설정
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // 슬라이더 리스너 등록
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText(Integer.toString(slider.getValue()));
            }
        });

        // 레이아웃 설정
        setLayout(new FlowLayout());
        add(slider);
        add(label);

        // 프레임 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SliderExample();
            }
        });
    }
}
</pre>

6. JLabel 컴포넌트와 JTextArea 컴포넌트를 하나 만들고 문자열을 입력할 때마다 입력된 글자 수에 맞게 슬라이더 바가 자동으로 움직이게 하고 100자 이상 입력할 수 없게 하라. 또한 사용자가 마우스로 슬라이더 손잡이를 움직이면 슬라이더 크기만큼 텍스트영역의 글자가 지워지도록 하라.

<pre>
  import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SliderWithTextArea extends JFrame {
    private JTextArea textArea;
    private JSlider slider;

    public SliderWithTextArea() {
        // 프레임 초기화
        setTitle("글자 수에 따른 슬라이더 예제");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI 구성 요소 초기화
        textArea = new JTextArea();
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);

        // 텍스트 영역 리스너 등록
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSlider();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSlider();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSlider();
            }
        });

        // 슬라이더 리스너 등록
        slider.addChangeListener(e -> updateTextArea());

        // 레이아웃 설정
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);

        // 프레임 표시
        setVisible(true);
    }

    private void updateSlider() {
        int charCount = textArea.getText().length();
        slider.setValue(charCount);
    }

    private void updateTextArea() {
        int limit = slider.getValue();
        String text = textArea.getText();

        if (text.length() > limit) {
            textArea.setText(text.substring(0, limit));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SliderWithTextArea::new);
    }
}
</pre>

7. 수평 슬라이더를 만들고, 슬라이더를 움직이면 문자열 레이블의 글자 크기를 조절할 수 있는 스윙 응용프로그램을 작성하라. 폰트 크기는 1픽셀에서 100픽셀까지이며, 큰 문자열은 CENTER에 부착하라.

<pre>
  import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderFontSizeApp extends JFrame {
    private JLabel label;
    private JSlider slider;

    public SliderFontSizeApp() {
        // 프레임 초기화
        setTitle("글자 크기 조절 프로그램");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI 구성 요소 초기화
        label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
        slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 12);

        // 슬라이더 리스너 등록
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateLabelFontSize();
            }
        });

        // 레이아웃 설정
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);

        // 프레임 표시
        setVisible(true);
    }

    private void updateLabelFontSize() {
        int fontSize = slider.getValue();
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        label.setFont(font);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SliderFontSizeApp::new);
    }
}
</pre>

8. 이미지 갤러리를 만들어보자. 다음과 같이 두 개의 라디오버튼과 이미지가 출력된다.
이미지를 클릭하면 다음 이미지를 보여준다. 이 행동은 프로젝트의 images 폴더에 있 는 모든 이미지에 대해 이루어진다. 그러므로 프로그램 실행 전 images 폴더를 만들 고 여러 개의 이미지를 저장해두어야 한다. left 버튼이 선택되어 있으면 왼쪽으로 넘기는 순서로 이미지를 보여주고, right 라디오버튼이 선택되어 있으면 그 반대로 진행된다.

<pre>
  import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageGalleryApp extends JFrame {
    private List<String> imageFiles;
    private int currentIndex;
    private JLabel imageLabel;

    public ImageGalleryApp() {
        // 이미지 파일 목록 초기화
        File imageFolder = new File("images");
        File[] imageFilesArray = imageFolder.listFiles();
        if (imageFilesArray != null) {
            imageFiles = new ArrayList<>(Arrays.asList(imageFilesArray));
        } else {
            imageFiles = new ArrayList<>();
        }
        currentIndex = 0;

        // 프레임 초기화
        setTitle("Image Gallery");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI 구성 요소 초기화
        imageLabel = new JLabel();
        updateImage();

        JRadioButton leftButton = new JRadioButton("Left");
        JRadioButton rightButton = new JRadioButton("Right");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(leftButton);
        buttonGroup.add(rightButton);

        // 라디오버튼 리스너 등록
        leftButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (leftButton.isSelected()) {
                    currentIndex = (currentIndex - 1 + imageFiles.size()) % imageFiles.size();
                    updateImage();
                }
            }
        });

        rightButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (rightButton.isSelected()) {
                    currentIndex = (currentIndex + 1) % imageFiles.size();
                    updateImage();
                }
            }
        });

        // 레이아웃 설정
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 프레임 표시
        setVisible(true);
    }

    private void updateImage() {
        if (!imageFiles.isEmpty()) {
            ImageIcon icon = new ImageIcon(imageFiles.get(currentIndex).getPath());
            imageLabel.setIcon(icon);
        } else {
            imageLabel.setIcon(null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageGalleryApp::new);
    }
}
</pre>

9. "Computer !!!"를, 둘이 같으면 "Same !!!"를 출력한다.
겼는지 결과가 레이블에 출력된다. 사용자가 이기면 "Ne !!!”를, 컴퓨터가 이기면
고 두 사람이 선택한 가위, 바위, 보 이미지가 각각 레이블에 출력된다. 또한 누가 이 자가 버튼을 선택하는 순간 컴퓨터는 랜덤하게 가위, 바위, 보 중에서 하나를 선택하 가 선택한 결과 화면이다. 왼쪽은 사용자의 손이며 오른쪽은 컴퓨터의 손이다. 사용 각각가위, 바위, 보를 선택하는 버튼이며, 노란색 배경에는 나(me)와 컴퓨터(com) 바위, 보에 해당하는 이미지 버튼을 만들어라. 회색 배경에 그러진 3개의 이미지는 9. 사용자(me)와 컴퓨터(com)가 가위바위보를 하는 스윙 프로그램을 작성해보자.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame {
    private JLabel userLabel;
    private JLabel computerLabel;
    private JLabel resultLabel;

    public RockPaperScissorsGame() {
        setTitle("Rock Paper Scissors Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new GridLayout(2, 3));

        // UI 구성 요소 초기화
        userLabel = new JLabel();
        computerLabel = new JLabel();
        resultLabel = new JLabel();

        JButton rockButton = new JButton(new ImageIcon("rock.png"));
        JButton paperButton = new JButton(new ImageIcon("paper.png"));
        JButton scissorsButton = new JButton(new ImageIcon("scissors.png"));

        // 가위 바위 보 이미지 버튼 리스너 등록
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("scissors");
            }
        });

        // 레이블 및 버튼 추가
        add(userLabel);
        add(computerLabel);
        add(resultLabel);
        add(rockButton);
        add(paperButton);
        add(scissorsButton);

        setVisible(true);
    }

    private void playGame(String userChoice) {
        // 사용자의 선택을 레이블에 표시
        userLabel.setIcon(new ImageIcon(userChoice + ".png"));

        // 컴퓨터의 선택을 무작위로 생성
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        int randomIndex = random.nextInt(choices.length);
        String computerChoice = choices[randomIndex];

        // 컴퓨터의 선택을 레이블에 표시
        computerLabel.setIcon(new ImageIcon(computerChoice + ".png"));

        // 결과 계산 및 출력
        if (userChoice.equals(computerChoice)) {
            resultLabel.setText("Same !!!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            resultLabel.setText("You Win !!!");
        } else {
            resultLabel.setText("Computer Win !!!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissorsGame::new);
    }
}
</pre>

10. 10개의 레이블을 순서대로 클릭하는 간단한 게임을 만들어보자. 8에서 9까지 숫자를 가진 레이블 컴포넌트를 10개 만들고 이들을 프레임 내의 랜덤한 위지에 배치한다. 사 용자가 8부터 9까지 순서대로 클릭하여 10개를 모두 클릭하면 다시 18개의 레이블을 랜덤한 위치에 배치한다. 클릭된 레이블 컴포넌트는 화면에서 보이지 않게 하며 반드 시 번호 순서로 클릭되게 하라.

<pre>
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame {
    private JLabel userLabel;
    private JLabel computerLabel;
    private JLabel resultLabel;

    public RockPaperScissorsGame() {
        setTitle("Rock Paper Scissors Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new GridLayout(2, 3));

        // UI 구성 요소 초기화
        userLabel = new JLabel();
        computerLabel = new JLabel();
        resultLabel = new JLabel();

        JButton rockButton = new JButton(new ImageIcon("rock.png"));
        JButton paperButton = new JButton(new ImageIcon("paper.png"));
        JButton scissorsButton = new JButton(new ImageIcon("scissors.png"));

        // 가위 바위 보 이미지 버튼 리스너 등록
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("scissors");
            }
        });

        // 레이블 및 버튼 추가
        add(userLabel);
        add(computerLabel);
        add(resultLabel);
        add(rockButton);
        add(paperButton);
        add(scissorsButton);

        setVisible(true);
    }

    private void playGame(String userChoice) {
        // 사용자의 선택을 레이블에 표시
        userLabel.setIcon(new ImageIcon(userChoice + ".png"));

        // 컴퓨터의 선택을 무작위로 생성
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        int randomIndex = random.nextInt(choices.length);
        String computerChoice = choices[randomIndex];

        // 컴퓨터의 선택을 레이블에 표시
        computerLabel.setIcon(new ImageIcon(computerChoice + ".png"));

        // 결과 계산 및 출력
        if (userChoice.equals(computerChoice)) {
            resultLabel.setText("Same !!!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            resultLabel.setText("You Win !!!");
        } else {
            resultLabel.setText("Computer Win !!!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissorsGame::new);
    }
}
</pre>
