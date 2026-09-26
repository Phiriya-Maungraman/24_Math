import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame implements ActionListener, KeyListener, MouseListener {
    Container cp;
    JButton N1, N2, N3, N4, re, ra, st, ht;
    JTextField ip;
    JLabel eq, sum, mid, scr, scr_num, mt, htp;
    RandomNumber randomizer;
    boolean isFirstRandom = true;
    CountdownTimer midTimer, mainTimer;

    public MainGui() {
        Initial();
        RandomNumber();
        randomizer = new RandomNumber(new JButton[] { N1, N2, N3, N4 });
        RandomButton();
        ResetButton();
        InputNum();
        Sum();
        SettingButton();
        HowtoButton();
        MidTimer();
        MainTimer();
        ShowScore();
        Finally();
        event();
    }

    public void event() {
        ip.addKeyListener(this);
        re.addMouseListener(this);
        st.addMouseListener(this);

    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void RandomNumber() {
        N1 = new JButton("0");
        N1.setBounds(100, 80, 50, 25);
        N1.setSize(100, 100);
        N1.setFont(new Font("", Font.PLAIN, 100));
        N1.setBackground(Color.WHITE);
        N1.setFocusable(false);

        N2 = new JButton("0");
        N2.setBounds(250, 80, 50, 25);
        N2.setSize(100, 100);
        N2.setFont(new Font("", Font.PLAIN, 100));
        N2.setBackground(Color.WHITE);
        N2.setFocusable(false);

        N3 = new JButton("0");
        N3.setBounds(400, 80, 50, 25);
        N3.setSize(100, 100);
        N3.setFont(new Font("", Font.PLAIN, 100));
        N3.setBackground(Color.WHITE);
        N3.setFocusable(false);

        N4 = new JButton("0");
        N4.setBounds(550, 80, 50, 25);
        N4.setSize(100, 100);
        N4.setFont(new Font("", Font.PLAIN, 100));
        N4.setBackground(Color.WHITE);
        N4.setFocusable(false);
        cp.add(N1);
        cp.add(N2);
        cp.add(N3);
        cp.add(N4);
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
        cp.add(ra);

        // ตั้งค่าการทำงานเมื่อคลิกปุ่ม Random
        ra.addActionListener(e -> {
            randomizer.randomizeAll(); // สุ่มเลขตามปกติ
            midTimer.start(0, 1000); // เริ่มนับเวลาถอยหลัง

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
        cp.add(re);
    }

    public void InputNum() {
        ip = new JTextField();
        ip.setBounds(30, 400, 50, 25);
        ip.setSize(600, 100);
        ip.setFont(new Font("", Font.BOLD, 50));
        ip.setHorizontalAlignment(JTextField.CENTER);
        cp.add(ip);

    }

    public void Sum() {
        eq = new JLabel("=");
        eq.setBounds(650, 400, 50, 25);
        eq.setSize(630, 100);
        eq.setFont(new Font("", Font.PLAIN, 70));
        sum = new JLabel("24");
        sum.setBounds(725, 400, 50, 25);
        sum.setSize(630, 100);
        sum.setFont(new Font("", Font.PLAIN, 70));
        cp.add(eq);
        cp.add(sum);
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
        cp.add(st);
    }

    public void HowtoButton() {
        ht = new JButton("#How2Play");
        ht.setBounds(550, 10, 50, 30);
        ht.setSize(125, 30);
        ht.setFont(new Font("", Font.BOLD, 17));
        ht.setBackground(Color.WHITE);
        ht.setFocusable(false);
        cp.add(ht);

    }

    public void HowtoPlay() {
        JFrame how = new JFrame();
        ImageIcon htscreen = new ImageIcon("./Icon/HowToPlay.png");
        htp = new JLabel(htscreen);
        htp.setBounds(-5, -290, 1000, 1000);
        htp.setSize(1000, 1000);
        how.add(htp);
        how.setTitle("#How2Play");
        how.setSize(1000, 500);
        how.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        how.setLocationRelativeTo(null);
        how.setLayout(null);
        how.setVisible(true);
    }

    public void MidTimer() {
        mid = new JLabel("00:30");
        mid.setBounds(300, 5, 50, 30);
        mid.setSize(200, 60);
        mid.setFont(new Font("", Font.PLAIN, 60));
        mid.setForeground(new Color(225,0,0 ));
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
        mt.setBounds(25, 10, 50, 30);
        mt.setSize(100, 30);
        mt.setFont(new Font("", Font.BOLD, 25));
        mt.setBackground(Color.WHITE);
        cp.add(mt);

        mainTimer = new CountdownTimer(5 * 60, mt);

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
        cp.add(scr);
        cp.add(scr_num);
    }

    public void Finally() {
        this.setTitle("24Math");
        this.setSize(850, 750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("./Icon/24Logo.png");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ip) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c) && c != '+' && c != '*' && c != '/' && c != '-') {
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
            ip.setText("");
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
