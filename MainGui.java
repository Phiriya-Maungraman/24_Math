import lib.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame implements ActionListener, KeyListener, MouseListener {
    Container cp;
    JButton N1, N2, N3, N4, re, ra, st, ht, ldr, plus, minus, multi, divide, del, ac, ent;
    JTextField ip;
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
        ShowScore();
        RankingBoard();

        MidTimer();
        MainTimer();
       
        setupDynamicLayout();
        Finally();

        event();
    }

    public void event() {
        ip.addActionListener(this);
        ip.addKeyListener(this);
        re.addMouseListener(this);
        st.addMouseListener(this);
        ht.addMouseListener(this);
        N1.addActionListener(this);
        N2.addActionListener(this);
        N3.addActionListener(this);
        N4.addActionListener(this);
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public JButton CreateButton(JButton button, String text, int fontSize, Color bgColor) {
        button = new JButton(text);
        button.setFont(new Font("", Font.PLAIN, fontSize));
        button.setBackground(bgColor);
        button.setFocusable(false);
        cp.add(button);
        return button;
    }

    public void RandomNumber() {

        N1 = CreateButton(N1, "0", 100, Color.WHITE);
        N2 = CreateButton(N2, "0", 100, Color.WHITE);
        N3 = CreateButton(N3, "0", 100, Color.WHITE);
        N4 = CreateButton(N4, "0", 100, Color.WHITE);

    }

    public void RandomButton() {
        ImageIcon raic = new ImageIcon("./Icon/RandomIcon.png");
        ra = new JButton("Random", raic);
        ra.setFont(new Font("", Font.PLAIN, 50));
        ra.setHorizontalTextPosition(JButton.RIGHT);
        ra.setVerticalTextPosition(JButton.CENTER);
        ra.setIconTextGap(20);
        ra.setFocusable(false);
        cp.add(ra);

        ra.addActionListener(e -> ip.setText(""));

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
        re = new JButton(reic);
        // re.setFont(new Font("", Font.PLAIN, 20));
        // re.setBackground(Color.GREEN);
        re.setHorizontalTextPosition(JButton.RIGHT);
        re.setVerticalTextPosition(JButton.CENTER);
        re.setIconTextGap(20);
        re.setFocusable(false);
        cp.add(re);
    }

    public void InputNum() {
        ip = new JTextField();
        ip.setSize(600, 100);
        ip.setFont(new Font("", Font.BOLD, 50));
        ip.setHorizontalAlignment(JTextField.CENTER);
        cp.add(ip);

    }

    public void Symbols(){
        ImageIcon delic = new ImageIcon("./Icon/DeleteIcon.png");
        ImageIcon entic = new ImageIcon("./Icon/EnterIcon.png");
        plus = new JButton("+");
        minus = new JButton("-");
        multi = new JButton("*");
        divide = new JButton("/");
        del = new JButton(delic);
        ac = new JButton("AC");
        ent = new JButton("Enter",entic);
        plus.setBounds(30, 550, 50, 25);
        plus.setSize(75, 75);
        plus.setFont(new Font("", Font.BOLD, 50));
        plus.setBackground(Color.WHITE);
        plus.setFocusable(false);
        cp.add(plus);
        minus.setBounds(130, 550, 50, 25);
        minus.setSize(75, 75);
        minus.setFont(new Font("", Font.BOLD, 50));
        minus.setBackground(Color.WHITE);
        minus.setFocusable(false);
        cp.add(minus);
        multi.setBounds(230, 550, 50, 25);
        multi.setSize(75, 75);
        multi.setFont(new Font("", Font.BOLD, 50));
        multi.setBackground(Color.WHITE);
        multi.setFocusable(false);
        cp.add(multi);
        divide.setBounds(330, 550, 50, 25);
        divide.setSize(75, 75);
        divide.setFont(new Font("", Font.BOLD, 50));
        divide.setBackground(Color.WHITE);
        divide.setFocusable(false);
        cp.add(divide);
        del.setBounds(430, 550, 50, 25);
        del.setSize(75, 75);
        del.setFont(new Font("", Font.BOLD, 50));
        del.setBackground(Color.WHITE);
        del.setFocusable(false);
        cp.add(del);
        ac.setBounds(530, 550, 50, 25);
        ac.setSize(75, 75);
        ac.setFont(new Font("", Font.BOLD, 27));
        ac.setBackground(Color.WHITE);
        ac.setFocusable(false);
        cp.add(ac);
        ent.setBounds(630, 550, 50, 25);
        ent.setSize(150, 75);
        ent.setFont(new Font("", Font.BOLD, 23));
        ent.setBackground(Color.WHITE);
        ent.setIconTextGap(10);
        ent.setFocusable(false);
        cp.add(ent);
    }

    public void Sum() {
        eq = new JLabel("=");
        // eq.setSize(630, 100);
        eq.setFont(new Font("", Font.PLAIN, 70));
        sum = new JLabel("???");
        sum.setSize(630, 100);
        sum.setFont(new Font("", Font.PLAIN, 70));
        cp.add(eq);
        cp.add(sum);
    }

    public void SettingButton() {
        ImageIcon setic = new ImageIcon("./Icon/SettingIcon.png");
        st = new JButton(setic);
        // st.setBounds(700, 10, 50, 30);
        // st.setSize(125, 30);
        // st.setFont(new Font("", Font.BOLD, 17));
        // st.setBackground(Color.WHITE);
        //st.setHorizontalAlignment(JButton.LEFT);
        st.setFocusable(false);
        cp.add(st);
    }

    public void HowtoButton() {
        ht = new JButton("#How2Play");
        ht.setFont(new Font("", Font.BOLD, 14));
        ht.setBackground(Color.WHITE);
        ht.setFocusable(false);
        cp.add(ht);

    }


    public void MidTimer() {
        mid = new JLabel("00:30");
        mid.setFont(new Font("", Font.PLAIN, 60));
        mid.setForeground(new Color(225, 0, 0));
        mid.setBackground(Color.WHITE);
        cp.add(mid);

        // "ถ้าเวลาหมด ให้สั่ง randomizer.randomizeAll()"
        midTimer = new CountdownTimer(30, mid, () -> {
            randomizer.randomizeAll(); // สุ่มเลขใหม่เมื่อเวลาหมด
            midTimer.start(0, 1000); // และให้นับเวลาถอยหลังใหม่วนไปเรื่อยๆ (ถ้าต้องการให้วนลูป)
        });
    }

    public void MainTimer() {
        mt = new JLabel("05:00");
        mt.setBounds(25, 10, 100, 30);
        mt.setFont(new Font("", Font.BOLD, 25));
        mt.setBackground(Color.WHITE);
        cp.add(mt);

        mainTimer = new CountdownTimer(5 * 60, mt, () -> {
            resetGame();
        });
        mt.setFocusable(false);
    }

    public void ShowScore() {
        scr = new JLabel("Score:");
        scr.setFont(new Font("", Font.PLAIN, 35));
        scr_num = new JLabel("0");
        scr_num.setFont(new Font("", Font.PLAIN, 40));

        cp.add(scr);
        cp.add(scr_num);
    }

    public void RankingBoard() {
        ImageIcon ldric = new ImageIcon("./Icon/PointIcon.png");
        ldr = new JButton("Ranking", ldric);
        ldr.setFont(new Font("", Font.BOLD, 14));
        ldr.setFocusable(false);
        ldr.setBackground(Color.WHITE);
        ldr.setHorizontalTextPosition(JButton.RIGHT);
        ldr.setVerticalTextPosition(JButton.CENTER);
        cp.add(ldr);
    }

    public void Finally() {
        this.setTitle("24Math");
        this.setSize(850, 770);
        this.setMinimumSize(new Dimension(850, 750));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("./Icon/24Logo.png");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
    }

    public void setupDynamicLayout() {
        // ดักฟังเหตุการณ์เมื่อหน้าต่างมีการเปลี่ยนแปลงขนาด (Resize)
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int panelWidth = cp.getWidth(); // ความกว้างหน้าจอปัจจุบัน
                int panelHeight = cp.getHeight(); // ความสูงหน้าจอปัจจุบัน

                // 1. สูตรจัดวางปุ่มตัวเลขทั้ง 4 (N1 - N4)
                // ให้อยู่ตรงกลางหน้าจอแนวนอนและกระจายช่องไฟเท่าๆ กัน
                int btnWidth = 100;
                int btnHeight = 100;
                int gap = 100; // ระยะห่างระหว่างปุ่ม
                int totalButtonsWidth = (btnWidth * 4) + (3 * 20); // ขนาดปุ่ม 4 ปุ่ม + ระยะห่าง 20px จำนวน 3 ช่วง
                int startX = (panelWidth - totalButtonsWidth) / 2; // สูตรหากึ่งกลางหน้าจอ
                int fixedY = (int) (panelHeight * 0.15); // อยู่ที่ 15% จากขอบบน

                N1.setBounds(startX, fixedY, btnWidth, btnHeight);
                N2.setBounds(startX + btnWidth + 20, fixedY, btnWidth, btnHeight);
                N3.setBounds(startX + (btnWidth * 2) + 40, fixedY, btnWidth, btnHeight);
                N4.setBounds(startX + (btnWidth * 3) + 60, fixedY, btnWidth, btnHeight);

                // 2. สูตรปุ่ม Random ให้อยู่ตรงกลางด้านล่างของกลุ่มปุ่มตัวเลข
                int raWidth = 350;
                int raHeight = 100;
                int raX = (panelWidth - raWidth) / 2;
                int raY = fixedY + btnHeight + 30; // อยู่ใต้ปุ่มตัวเลขลงมา 30 พิกเซล
                ra.setBounds(raX, raY, raWidth, raHeight);

                // 3. สูตรช่องกรอกข้อความ (TextField: ip) อยู่ตรงกลางหน้าจอ
                int ipWidth = (int) (panelWidth * 0.5); // กว้าง 50% ของหน้าจอ
                int ipHeight = 100;
                int ipX = (panelWidth - ipWidth) / 2;
                int ipY = (int) (panelHeight * 0.55); // อยู่ที่ 55% จากขอบบน
                ip.setBounds(ipX-gap, ipY, ipWidth, ipHeight);

                // 4. สูตรเครื่องหมายเท่ากับ (=) และผลลัพธ์ (sum) อยู่ถัดจากช่องกรอกข้อความ
                int eqX = ipX + ipWidth + 20;
                int eqY = ipY;
                eq.setBounds(eqX-gap, eqY, 60, ipHeight);

                int sumX = eqX + 85;
                int sumY = ipY;
                sum.setBounds(sumX-gap, sumY, 100, ipHeight);

                // 5. สูตรปุ่ม Reset อยู่มุมซ้ายล่างของโซนกรอกข้อมูล
                re.setBounds(raX - 80, raY, 50, 50);

                // 6. สูตรคะแนน (Score) อยู่ขวาบนหรือขวาของจอ
                scr.setBounds(panelWidth - 230, raY, 120, 50);
                scr_num.setBounds(panelWidth - 110, raY, 100, 50);

                // 7. สูตรปุ่ม Setting อยู่มุมขวาบนของหน้าจอ
                st.setBounds(panelWidth - 100, 10, 40, 35);
                // 8. สูตรปุ่ม How2Play อยู่ซ้ายของปุ่ม Setting
                ht.setBounds(panelWidth - 250, 10, 125, 30);
                // 9. ตัวจับเวลา 00:30 (mid) อยู่ตรงกลางด้านบนของหน้าจอ
                mid.setBounds((panelWidth / 2) - 100, 10, 200, 60);
                // 10. ตัวจับเวลา 05:00 (mt) อยู่มุมซ้ายบนของหน้าจอ
                mt.setBounds(25, 10, 80, 30);
                // 11. ปุ่ม Ranking อยู่ขวาของปุ่ม How2Play
                ldr.setBounds(110, 10, 130, 30);

            }
        });
    }

    // reset ค่า
    public void resetGame() {
        // ล้างช่องกรอกข้อความ
        ip.setText("");

        // หยุดเวลาถอยหลังทั้งหมด
        if (midTimer != null)
            midTimer.stop();
        if (mainTimer != null)
            mainTimer.stop();

        // รีเซ็ตข้อความเวลาถอยหลังบนหน้าจอ
        mid.setText("00:30");
        mt.setText("05:00");

        // คืนค่าตัวเลขสุ่มบนปุ่มทั้ง 4 ให้กลับเป็น "0"
        N1.setText("0");
        N2.setText("0");
        N3.setText("0");
        N4.setText("0");

        // รีเซ็ตคะแนนเป็น 0
        scr_num.setText("0");

        // รีเซ็ตสถานะการสุ่มครั้งแรก
        isFirstRandom = true;
        hasRandomized = false;
    }

     /** เปิดหน้าต่างชำระเงิน (How2Play) */
    private void openHow2Play() {
        How2PlayForm form = new How2PlayForm();
        form.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ip) {

        }
        // เมื่อมีการคลิกปุ่ม N1, N2, N3, N4
        else if (e.getSource() == N1 || e.getSource() == N2 || e.getSource() == N3 || e.getSource() == N4) {
            if (!hasRandomized) {
                return;
            }
            JButton sourceButton = (JButton) e.getSource();
            String btnText = sourceButton.getText();
            ip.setText(ip.getText() + btnText);
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

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == re) {
            resetGame();
        }
        if (e.getSource() == ht) {
            openHow2Play();
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
