import lib.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame implements ActionListener, KeyListener, MouseListener {
    Container cp;
    JButton N1, N2, N3, N4, re, ra, st, ht, ldr, plus, minus, multi, divide, op, cl, ent;
    JTextField ip;
    JPanel gamePanel;
    JLabel eq, sum, mid, scr, scr_num, mt, htp;
    RandomNumber randomizer;
    boolean isFirstRandom = true;
    boolean hasRandomized = false;
    CountdownTimer midTimer, mainTimer;

    public MainGui() {
        Initial();
        RandomNumber();
        randomizer = new RandomNumber(new JButton[] { N1, N2, N3, N4 });
        RandomButton();
        ResetButton();
        InputNum();
        Symbols();
        Sum();
        SettingButton();
        HowtoButton();
        MidTimer();
        MainTimer();
        ShowScore();
        RankingBoard();
        Finally();
        event();
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
        gamePanel = new JPanel(null);
        gamePanel.setPreferredSize(new Dimension(850, 650));
        cp.add(gamePanel);
    }

    public JButton CreateButton(JButton button, String text, int fontSize, Color bgColor) {
        button = new JButton(text);
        button.setFont(new Font("", Font.PLAIN, fontSize));
        button.setBackground(bgColor);
        button.setFocusable(false);
        gamePanel.add(button);
        return button;
    }

    public void RandomNumber() {
        N1 = CreateButton(N1, "0", 100, Color.WHITE);
        N1.setBounds(100, 80, 100, 100);
        // N1 = new JButton("0");
        // N1.setBounds(100, 80, 50, 25);
        // N1.setSize(100, 100);
        // N1.setFont(new Font("", Font.PLAIN, 100));
        // N1.setBackground(Color.WHITE);
        // N1.setFocusable(false);

        N2 = CreateButton(N2, "0", 100, Color.WHITE);
        N2.setBounds(250, 80, 100, 100);

        N3 = CreateButton(N3, "0", 100, Color.WHITE);
        N3.setBounds(400, 80, 100, 100);

        N4 = CreateButton(N4, "0", 100, Color.WHITE);
        N4.setBounds(550, 80, 100, 100);

    }

    public void RandomButton() {
        ImageIcon raic = new ImageIcon("./Icon/RandomIcon.png");
        ra = new JButton("Random", raic);
        ra.setBounds(200, 220, 50, 25);
        ra.setSize(350, 100);
        ra.setFont(new Font("", Font.PLAIN, 50));
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
        ImageIcon reic = new ImageIcon("./Icon/ResetIcon.png");
        re = new JButton("Reset", reic);
        re.setBounds(30, 250, 50, 25);
        re.setSize(150, 50);
        re.setFont(new Font("", Font.PLAIN, 20));
        re.setBackground(Color.WHITE);
        re.setHorizontalTextPosition(JButton.RIGHT);
        re.setVerticalTextPosition(JButton.CENTER);
        re.setIconTextGap(20);
        re.setFocusable(false);
        gamePanel.add(re);
    }

    public void InputNum() {
        ip = new JTextField();
        ip.setBounds(30, 400, 50, 25);
        ip.setSize(600, 100);
        ip.setFont(new Font("", Font.BOLD, 50));
        ip.setHorizontalAlignment(JTextField.CENTER);
        gamePanel.add(ip);

    }

    public void Symbols() {
        ImageIcon entic = new ImageIcon("./Icon/EnterIcon.png");
        minus = new JButton("-");
        multi = new JButton("*");
        divide = new JButton("/");
        op = new JButton("(");
        cl = new JButton(")");
        ent = new JButton("Enter", entic);

        plus = CreateButton(plus, "+", 50, Color.WHITE);
        plus.setBounds(30, 550, 75,75);

        minus = CreateButton(minus, "-", 50, Color.WHITE);
        minus.setBounds(130, 550, 75,75);

        multi = CreateButton(multi, "*", 50, Color.WHITE);
        multi.setBounds(230, 550, 75,75);

        divide = CreateButton(divide, "/", 50, Color.WHITE);
        divide.setBounds(330, 550, 75,75);

        op = CreateButton(op, "(", 50, Color.WHITE);
        op.setBounds(430, 550, 75,75);

        cl = CreateButton(cl, ")", 50, Color.WHITE);
        cl.setBounds(530, 550, 75,75);
        
        ent.setBounds(630, 550, 150, 75);
        ent.setFont(new Font("", Font.BOLD, 23));
        ent.setBackground(Color.WHITE);
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
        eq.setBounds(650, 400, 630,100);
        eq.setFont(new Font("", Font.PLAIN, 70));

        sum = new JLabel("?");
        sum.setBounds(725, 400, 630,100);
        sum.setFont(new Font("", Font.PLAIN, 35));

        gamePanel.add(eq);
        gamePanel.add(sum);
    }

    public void SettingButton() {
        ImageIcon setic = new ImageIcon("./Icon/SettingIcon.png");
        st = new JButton("Setting", setic);
        st.setBounds(700, 10, 50, 30);
        st.setSize(125, 30);
        st.setFont(new Font("", Font.BOLD, 17));
        st.setBackground(Color.WHITE);
        st.setHorizontalAlignment(JButton.LEFT);
        st.setFocusable(false);
        gamePanel.add(st);
    }

    private void openSetting() {
        SettingForm form = new SettingForm(this);
        form.setVisible(true);
    }

    public void HowtoButton() {
        ht = new JButton("#How2Play");
        ht.setBounds(550, 10, 50, 30);
        ht.setSize(125, 30);
        ht.setFont(new Font("", Font.BOLD, 17));
        ht.setBackground(Color.WHITE);
        ht.setFocusable(false);
        gamePanel.add(ht);

    }

    /** เปิดหน้าต่างวิธีการเล่น (How2Play) */
    private void openHow2Play() {
        How2PlayForm form = new How2PlayForm(this);
        form.setVisible(true);
    }

    public void MidTimer() {
        mid = new JLabel("00:30");
        mid.setBounds(300, 5, 50, 30);
        mid.setSize(200, 60);
        mid.setFont(new Font("", Font.PLAIN, 60));
        mid.setForeground(new Color(225, 0, 0));
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
        mt.setBackground(Color.WHITE);
        gamePanel.add(mt);

        mainTimer = new CountdownTimer(5*60, mt, () -> {
            resetGame();
        });
        mt.setFocusable(false);
    }

    public void ShowScore() {
        scr = new JLabel("Score:");
        scr.setBounds(600, 250, 50, 25);
        scr.setSize(150, 50);
        scr.setFont(new Font("", Font.PLAIN, 35));
        scr_num = new JLabel("0");
        scr_num.setBounds(720, 250, 50, 25);
        scr_num.setSize(150, 50);
        scr_num.setFont(new Font("", Font.PLAIN, 40));
        gamePanel.add(scr);
        gamePanel.add(scr_num);
    }

    public void RankingBoard() {
        ImageIcon ldric = new ImageIcon("./Icon/PointIcon.png");
        ldr = new JButton("Ranking", ldric);
        ldr.setBounds(120, 10, 50, 30);
        ldr.setSize(125, 30);
        ldr.setFont(new Font("", Font.BOLD, 15));
        ldr.setFocusable(false);
        ldr.setBackground(Color.WHITE);
        ldr.setHorizontalTextPosition(JButton.RIGHT);
        ldr.setVerticalTextPosition(JButton.CENTER);
        gamePanel.add(ldr);
    }

    private void openRanking() {
        RankingForm form = new RankingForm(this);
        form.setVisible(true);
    }

    public void Finally() {
        this.setTitle("24Math");
        this.setSize(850, 750);
        this.setLocationRelativeTo(null);
        gamePanel.setPreferredSize(new Dimension(850, 650));
        gamePanel.setMinimumSize(new Dimension(850, 650));
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!hasRandomized) {
            return;
        }
        if (e.getSource() == ent || e.getSource() == ip) {
            boolean isAllNumbersUsed = !N1.isEnabled() && !N2.isEnabled() && !N3.isEnabled() && !N4.isEnabled();
            
            if (!isAllNumbersUsed) {
                return; // ออกจากการทำงานทันที ไม่คำนวณผลลัพธ์
            }
            
            String input = ip.getText().trim();
            JButton[] numButtons = { N1, N2, N3, N4 };
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
                if (adjacentNumbers) break;
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

                    ScoreManager.checkScore(result, scr_num);

                    // สร้าง JLabel เปล่าขึ้นมาเพื่อรับตัวเลขเวลานับถอยหลังไม่ให้กระทบ sum
                    JLabel dummyLabel = new JLabel();

                    CountdownTimer sumResetTimer = new CountdownTimer(3, dummyLabel, () -> {
                        sum.setText("?");
                    });
                    sumResetTimer.start(0, 1000);

                    randomizer.randomizeAll();
                    midTimer.start(0, 1000);
                } 
                catch (Exception ex) {
                    sum.setText("can't process");
                    JLabel dummyLabel = new JLabel();
                    CountdownTimer sumResetTimer = new CountdownTimer(3, dummyLabel, () -> {
                        sum.setText("?");});
                        sumResetTimer.start(0, 1000);

                    randomizer.randomizeAll();  // สุ่มเลขชุดใหม่
                    midTimer.start(0, 1000);
                }
            }
            ip.setText("");
            setNumberButtonsEnabled(true);
 
            
        }

        // เมื่อมีการคลิกปุ่ม N1, N2, N3, N4
        else if (e.getSource() == N1 || e.getSource() == N2 || e.getSource() == N3 || e.getSource() == N4) {


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
        if (e.getSource() == ip) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                String text = ip.getText();

                // ต้องมีข้อความอยู่ในช่องก่อนถึงจะทำการลบได้
                if (!text.isEmpty()) {
                    // คลุมดำข้อความบางส่วนไว้เพื่อลบ
                    if (ip.getSelectedText() != null) {
                        String selected = ip.getSelectedText();
                        if (selected.contains(N1.getText())) N1.setEnabled(true);
                        if (selected.contains(N2.getText())) N2.setEnabled(true);
                        if (selected.contains(N3.getText())) N3.setEnabled(true);
                        if (selected.contains(N4.getText())) N4.setEnabled(true);
                    } 
                    // ลบถอยหลังทีละตัว
                    else {
                        char lastChar = text.charAt(text.length() - 1);
                        String lastStr = String.valueOf(lastChar);

                        JButton[] num = { N1, N2, N3, N4 };
                        for (JButton btn : num) {
                            // เช็คเฉพาะปุ่มที่ปิดการใช้งานอยู่ และมีตัวเลขตรงกับตัวที่ถูกลบ
                            if (!btn.isEnabled() && btn.getText().equals(lastStr)) {
                                btn.setEnabled(true);
                                break; // ปลดล็อกแค่ปุ่มเดียวแล้วออกจากลูปทันที
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

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
