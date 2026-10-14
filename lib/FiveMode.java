package lib;
import lib.function.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class FiveMode extends JFrame implements ActionListener, KeyListener, MouseListener {
    Container cp;
    JButton N1, N2, N3, N4, N5, re, ra, st, ht, ldr, plus, minus, multi, divide, op, cl, ent;
    JTextField ip;
    JPanel gamePanel;
    JLabel eq, sum, mid, scr, scr_num, mt, htp, ft;
    RandomNumber randomizer;
    boolean isFirstRandom = true;
    boolean hasRandomized = false;
    CountdownTimer midTimer, mainTimer;
    private String currentUser = "Guest";
    JLabel userLabel;

    public FiveMode() {

    }

    public FiveMode(String username) {
        this.currentUser = username;
        Initial();
        RandomNumber();
        randomizer = new RandomNumber(new JButton[] { N1, N2, N3, N4, N5 });
        RandomButton();
        ResetButton();
        InputNum();
        FunctionText();
        Symbols();
        Sum();
        SettingButton();
        HowtoButton();
        MidTimer();
        MainTimer();
        ShowScore();
        RankingBoard();
        ShowCurrentUser();
        Finally();
        event();
    }

    public void ShowCurrentUser() {
        userLabel = new JLabel("Player : " + currentUser);
        userLabel.setBounds(570, 45, 250, 30);
        userLabel.setFont(new Font("", Font.BOLD, 18));
        userLabel.setForeground(new Color(255, 165, 0));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gamePanel.add(userLabel);
    }

    public void event() {
        ip.addActionListener(this);
        ip.addKeyListener(this);
        re.addMouseListener(this);
        st.addMouseListener(this);
        ht.addMouseListener(this);
        ldr.addMouseListener(this);

        N1.addActionListener(this);
        N2.addActionListener(this);
        N3.addActionListener(this);
        N4.addActionListener(this);
        N5.addActionListener(this);

        plus.addActionListener(this);
        minus.addActionListener(this);
        multi.addActionListener(this);
        divide.addActionListener(this);
        op.addActionListener(this);
        cl.addActionListener(this);
        ent.addActionListener(this);

    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new GridBagLayout());
        cp.setBackground(new Color(30, 42, 68));
        gamePanel = new JPanel(null);
        gamePanel.setPreferredSize(new Dimension(850, 650));
        gamePanel.setBackground(new Color(30, 42, 68));
        cp.add(gamePanel);
    }

    public JButton CreateButton(JButton button, String text, int fontSize, Color bgColor) {
        button = new JButton(text);
        button.setFont(new Font("", Font.PLAIN, fontSize));
        button.setBackground(bgColor);
        button.setForeground(new Color(30, 42, 68));
        button.setFocusable(false);
        gamePanel.add(button);
        return button;
    }

    /*
     * public JButton CreateButton2(JButton button, String text, int fontSize, Color
     * bgColor){
     * button = new JButton(text);
     * button.setFont(new Font("", Font.BOLD, fontSize));
     * button.setBackground(new Color(30,42,68));
     * button.setBorder(new LineBorder(new Color(60, 74, 106),2));
     * button.setForeground(bgColor);
     * button.setFocusable(false);
     * gamePanel.add(button);
     * return button;
     * }
     */

    public JButton CreateButtonIcon(JButton button, String text, ImageIcon Icon, int fontSize, Color lnColor,
            Color bgColor) {
        button = new JButton(text, Icon);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(new Color(30, 42, 68));
        button.setBorder(new LineBorder(lnColor, 2));
        button.setForeground(bgColor);
        button.setFocusable(false);
        gamePanel.add(button);
        return button;
    }

    public JButton CreateButtonSymbols(JButton button, String text, int fontSize, Color bgColor) {
        button = new JButton(text);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(new Color(58, 74, 112));
        button.setForeground(bgColor);
        button.setFocusable(false);
        gamePanel.add(button);
        return button;
    }

    /*
     * ht = new JButton("#How2Play");
     * ht.setBounds(550, 10, 50, 30);
     * ht.setSize(125, 30);
     * ht.setFont(new Font("", Font.BOLD, 17));
     * ht.setForeground(Color.WHITE);
     * ht.setBackground(new Color(30,42,68));
     * ht.setBorder(new LineBorder(new Color(60, 74, 106),2));
     * ht.setFocusable(false);
     * gamePanel.add(ht);
     */

    public void RandomNumber() {
        N1 = CreateButton(N1, "0", 100, Color.WHITE);
        N1.setBounds(50, 80, 100, 100);
        // N1 = new JButton("0");
        // N1.setBounds(100, 80, 50, 25);
        // N1.setSize(100, 100);
        // N1.setFont(new Font("", Font.PLAIN, 100));
        // N1.setBackground(Color.WHITE);
        // N1.setFocusable(false);

        N2 = CreateButton(N2, "0", 100, Color.WHITE);
        N2.setBounds(200, 80, 100, 100);

        N3 = CreateButton(N3, "0", 100, Color.WHITE);
        N3.setBounds(350, 80, 100, 100);

        N4 = CreateButton(N4, "0", 100, Color.WHITE);
        N4.setBounds(500, 80, 100, 100);

        N5 = CreateButton(N4, "0", 100, Color.WHITE);
        N5.setBounds(650, 80, 100, 100);

    }

    public void RandomButton() {
        ImageIcon raic = new ImageIcon("./Icon/RandomIcon.png");
        ra = new JButton("Random", raic);
        ra.setBounds(200, 220, 50, 25);
        ra.setSize(350, 100);
        ra.setFont(new Font("", Font.PLAIN, 50));
        ra.setBackground(new Color(255, 138, 61));
        ra.setForeground(new Color(30, 42, 68));
        ra.setHorizontalTextPosition(JButton.RIGHT);
        ra.setVerticalTextPosition(JButton.CENTER);
        ra.setIconTextGap(20);
        ra.setFocusable(false);
        gamePanel.add(ra);

        ra.addActionListener(e -> {
            setNumberButtonsEnabled(true);
            ip.setText("");
        });

        // ตั้งค่าการทำงานเมื่อคลิกปุ่ม Random
        ra.addActionListener(e -> {
            randomizer.randomizeAll(); // สุ่มเลขตามปกติ
            midTimer.start(0, 1000); // เริ่มนับเวลาถอยหลัง

            hasRandomized = true;

            // เช็คว่าเป็นกดสุ่มครั้งแรกของเกมหรือไม่
            if (isFirstRandom) {
                mainTimer.start(0, 1000); // เริ่มนับเวลาถอยหลัง
                isFirstRandom = false; // เปลี่ยนค่าเป็น false เพื่อไม่ให้มันสั่ง start ซ้ำอีกเวลาคลิกครั้งถัดไป
            }
        });

    }

    public void ResetButton() {
        re = CreateButtonIcon(re, "Reset", new ImageIcon("./Icon/ResetIcon.png"), 20, Color.RED, Color.RED);
        re.setBounds(30, 250, 150, 50);
        re.setHorizontalTextPosition(JButton.RIGHT);
        re.setVerticalTextPosition(JButton.CENTER);
        re.setIconTextGap(10);
    }

    public void InputNum() {
        ip = new JTextField();
        ip.setBounds(30, 400, 50, 25);
        ip.setSize(600, 100);
        ip.setFont(new Font("", Font.BOLD, 50));
        ip.setForeground(new Color(30, 42, 68));
        ip.setHorizontalAlignment(JTextField.CENTER);
        gamePanel.add(ip);

    }

    public void FunctionText() {
        ft = new JLabel("function text");
        ft.setBounds(275, 360, 200, 25);
        ft.setFont(new Font("", Font.BOLD, 20));
        gamePanel.add(ft);
    }

    public void Symbols() {
        ImageIcon entic = new ImageIcon("./Icon/EnterIcon.png");
        ent = new JButton("Enter", entic);

        // plus = CreateButton(plus, "+", 50, Color.WHITE);
        plus = CreateButtonSymbols(plus, "+", 50, Color.WHITE);
        plus.setBounds(30, 550, 75, 75);

        minus = CreateButtonSymbols(minus, "-", 50, Color.WHITE);
        minus.setBounds(130, 550, 75, 75);

        multi = CreateButtonSymbols(multi, "*", 50, Color.WHITE);
        multi.setBounds(230, 550, 75, 75);

        divide = CreateButtonSymbols(divide, "/", 50, Color.WHITE);
        divide.setBounds(330, 550, 75, 75);

        op = CreateButtonSymbols(op, "(", 50, Color.WHITE);
        op.setBounds(430, 550, 75, 75);

        cl = CreateButtonSymbols(cl, ")", 50, Color.WHITE);
        cl.setBounds(530, 550, 75, 75);

        ent.setBounds(630, 550, 150, 75);
        ent.setFont(new Font("", Font.BOLD, 23));
        ent.setForeground(new Color(15, 61, 42));
        ent.setBackground(new Color(61, 220, 151));
        ent.setIconTextGap(10);
        ent.setFocusable(false);

        gamePanel.add(plus);
        gamePanel.add(minus);
        gamePanel.add(multi);
        gamePanel.add(divide);
        gamePanel.add(op);
        gamePanel.add(cl);
        gamePanel.add(ent);

    }

    public void Sum() {
        eq = new JLabel("=");
        eq.setBounds(650, 400, 630, 100);
        eq.setFont(new Font("", Font.PLAIN, 70));
        eq.setForeground(Color.WHITE);

        sum = new JLabel("?");
        sum.setBounds(725, 400, 630, 100);
        sum.setFont(new Font("", Font.PLAIN, 50));
        sum.setForeground(new Color(61, 220, 151));

        gamePanel.add(eq);
        gamePanel.add(sum);
    }

    public void SettingButton() {
        st = CreateButtonIcon(st, "Setting", new ImageIcon("./Icon/SettingIcon.png"), 17, new Color(60, 74, 106),
                Color.WHITE);
        st.setBounds(700, 10, 125, 30);
        /*
         * ImageIcon setic = new ImageIcon("./Icon/SettingIcon.png");
         * st = new JButton("Setting", setic);
         * st.setBounds(700, 10, 50, 30);
         * st.setSize(125, 30);
         * st.setFont(new Font("", Font.BOLD, 17));
         * st.setBackground(Color.WHITE);
         * st.setHorizontalAlignment(JButton.LEFT);
         * st.setFocusable(false);
         * gamePanel.add(st);
         */
    }

    private void openSetting() {
        SettingForm form = new SettingForm(this, "Five", currentUser);
        form.setVisible(true);
    }

    public void HowtoButton() {
        ht = CreateButtonIcon(ht, "#How2Play", new ImageIcon(""), 17, new Color(60, 74, 106), Color.WHITE);
        ht.setBounds(550, 10, 125, 30);

    }

    /** เปิดหน้าต่างวิธีการเล่น (How2Play) */
    private void openHow2Play() {
        How2PlayForm form = new How2PlayForm(this);
        form.setVisible(true);
    }

    private void openTimesup() {
        TimeupForm form = new TimeupForm(this, currentUser,currentUser);
        form.setVisible(true);
    }

    

    public void MidTimer() {
        mid = new JLabel("00:30");
        mid.setBounds(300, 5, 50, 30);
        mid.setSize(200, 60);
        mid.setFont(new Font("", Font.PLAIN, 60));
        mid.setForeground(new Color(255, 209, 102));
        mid.setBackground(Color.WHITE);
        gamePanel.add(mid);

        // "ถ้าเวลาหมด ให้สั่ง randomizer.randomizeAll()"
        midTimer = new CountdownTimer(30, mid, () -> {
            randomizer.randomizeAll();
            midTimer.start(0, 1000);
            ip.setText("");
            setNumberButtonsEnabled(true);

        });
    }

    public void MainTimer() {
        mt = new JLabel("05:00");
        mt.setBounds(25, 10, 50, 30);
        mt.setSize(100, 30);
        mt.setFont(new Font("", Font.BOLD, 25));
        mt.setForeground(Color.WHITE);
        gamePanel.add(mt);

        mainTimer = new CountdownTimer(5 * 60, mt, () -> {
            midTimer.stop();
            int finalScore = 0;
            try {
                finalScore = Integer.parseInt(scr_num.getText().trim());
            } catch (NumberFormatException e) {
                finalScore = 0;
            }
            UserManager.updateScore(currentUser, "Five", finalScore);
            /*JOptionPane.showMessageDialog(this,
                    "Time's Up!\nผู้เล่น: " + currentUser + "\nYour Score is: " + finalScore,
                    "หมดเวลา",
                    JOptionPane.INFORMATION_MESSAGE);

            // JOptionPane.showMessageDialog(this, "หมดเวลา! คะแนนของคุณคือ: " +
            // finalScore);*/
            openTimesup();
            resetGame();
        });
        mt.setFocusable(false);
    }

    public void ShowScore() {
        scr = new JLabel("Score:");
        scr.setBounds(600, 250, 50, 25);
        scr.setSize(150, 50);
        scr.setFont(new Font("", Font.PLAIN, 35));
        scr.setForeground(Color.WHITE);
        scr_num = new JLabel("0");
        scr_num.setBounds(720, 250, 50, 25);
        scr_num.setSize(150, 50);
        scr_num.setFont(new Font("", Font.PLAIN, 40));
        scr_num.setForeground(new Color(255, 209, 102));
        gamePanel.add(scr);
        gamePanel.add(scr_num);
    }

    public void RankingBoard() {
        ldr = CreateButtonIcon(ldr, "Ranking", new ImageIcon("./Icon/PointIcon.png"), 15, new Color(60, 74, 106),
                Color.WHITE);
        ldr.setBounds(120, 10, 125, 30);

    }

    private void openRanking() {
        RankingForm form = new RankingForm(this, "Five");
        form.setVisible(true);
    }

    public void Finally() {
        this.setTitle("24Math 5-digit");
        this.setSize(850, 750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        gamePanel.setPreferredSize(new Dimension(850, 750));
        gamePanel.setMinimumSize(new Dimension(850, 750));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("./Icon/24Logo.png");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
    }

    // reset ค่า
    public void resetGame() {

        if (mainTimer != null) {
            midTimer.stop();
            mainTimer.stop();
        }
        ip.setText("");
        mid.setText("00:30");
        mt.setText("05:00");

        N1.setText("0");
        N2.setText("0");
        N3.setText("0");
        N4.setText("0");
        N5.setText("0");

        scr_num.setText("0");

        isFirstRandom = true;
        hasRandomized = false;
        setNumberButtonsEnabled(true);
    }

    public void setNumberButtonsEnabled(boolean enabled) {
        N1.setEnabled(enabled);
        N2.setEnabled(enabled);
        N3.setEnabled(enabled);
        N4.setEnabled(enabled);
        N5.setEnabled(enabled);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!hasRandomized) {
            return;
        }
        if (e.getSource() == ent || e.getSource() == ip) {
            boolean isAllNumbersUsed = !N1.isEnabled() && !N2.isEnabled() && !N3.isEnabled() && !N4.isEnabled()
                    && !N5.isEnabled();

            if (!isAllNumbersUsed) {
                return; // ออกจากการทำงานทันที ไม่คำนวณผลลัพธ์
            }

            String input = ip.getText().trim();
            JButton[] numButtons = { N1, N2, N3, N4, N5 };
            boolean adjacentNumbers = false;

            // เช็กคู่ปุ่มทั้งหมด
            for (int i = 0; i < numButtons.length; i++) {
                for (int j = i + 1; j < numButtons.length; j++) {
                    String v1 = numButtons[i].getText();
                    String v2 = numButtons[j].getText();

                    // เช็กทั้ง v1 ต่อด้วย v2 และ v2 ต่อด้วย v1
                    if (input.contains(v1 + v2) || input.contains(v2 + v1)) {
                        adjacentNumbers = true;
                        break;
                    }
                }
                if (adjacentNumbers)
                    break;
            }

            // ถ้ามีตัวเลขอยู่ติดกันจะไม่ส่งคำตอบ
            if (adjacentNumbers) {
                return;
            }
            if (!input.isEmpty()) {
                try {
                    ReicveNum process = new ReicveNum(input);
                    String result = process.getresult();
                    if (result.endsWith(".0")) {
                        result = result.substring(0, result.length() - 2);
                    }

                    sum.setText(result);

                    ScoreManager.checkScore(result, scr_num, "Five");

                    // สร้าง JLabel เปล่าขึ้นมาเพื่อรับตัวเลขเวลานับถอยหลังไม่ให้กระทบ sum
                    JLabel dummyLabel = new JLabel();

                    CountdownTimer sumResetTimer = new CountdownTimer(3, dummyLabel, () -> {
                        sum.setText("?");
                    });
                    sumResetTimer.start(0, 1000);

                    randomizer.randomizeAll();
                    midTimer.start(0, 1000);
                } catch (Exception ex) {
                    sum.setText("can't process");
                    sum.setBounds(700, 400, 630, 100);
                    sum.setFont(new Font("", Font.PLAIN, 20));
                    JLabel dummyLabel = new JLabel();
                    CountdownTimer sumResetTimer = new CountdownTimer(3, dummyLabel, () -> {
                        sum.setText("?");
                        sum.setBounds(725, 400, 630, 100);
                        sum.setFont(new Font("", Font.PLAIN, 50));
                    });
                    sumResetTimer.start(0, 1000);

                    randomizer.randomizeAll(); // สุ่มเลขชุดใหม่
                    midTimer.start(0, 1000);
                }
            }
            ip.setText("");
            setNumberButtonsEnabled(true);

        }

        // เมื่อมีการคลิกปุ่ม N1, N2, N3, N4
        else if (e.getSource() == N1 || e.getSource() == N2 || e.getSource() == N3 || e.getSource() == N4
                || e.getSource() == N5) {

            JButton sourceButton = (JButton) e.getSource();
            String btnText = sourceButton.getText();
            ip.replaceSelection(btnText);
            ip.requestFocusInWindow();

            sourceButton.setEnabled(false);
        } else if (e.getSource() == plus || e.getSource() == minus || e.getSource() == multi ||
                e.getSource() == divide || e.getSource() == plus || e.getSource() == op || e.getSource() == cl) {

            JButton sourceButton = (JButton) e.getSource();
            String btnText = sourceButton.getText();
            ip.replaceSelection(btnText);
            ip.requestFocusInWindow();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ip) {
            char c = e.getKeyChar();

            if (!Character.isDigit(c)) {
                e.consume();
            } else if (!Character.isAlphabetic(c)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == ip) {
            // ดึงข้อความปัจจุบันหลังจากการลบเสร็จสิ้นแล้ว
            String currentText = ip.getText();
            JButton[] numButtons = { N1, N2, N3, N4 };

            // วนเช็คปุ่มตัวเลขทุกปุ่ม
            for (JButton btn : numButtons) {
                if (btn != null) {
                    String btnText = btn.getText();

                    if (!btn.isEnabled() && !currentText.contains(btnText)) {
                        btn.setEnabled(true);
                    }
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == re) {
            resetGame();
        }
        if (e.getSource() == ht) {
            openHow2Play();

        }
        if (e.getSource() == st) {
            openSetting();
        }
        if (e.getSource() == ldr) {
            openRanking();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public JButton[] getButtons() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getButtons'");
    }
}
