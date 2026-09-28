import lib.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame implements ActionListener, KeyListener, MouseListener {
    Container cp;
    JButton N1, N2, N3, N4, re, ra, st, ht, ldr, plus, minus, multi, divide, del, ac, ent;
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

        N1.addActionListener(this);
        N2.addActionListener(this);
        N3.addActionListener(this);
        N4.addActionListener(this);
    }

    public void Initial() {
    cp = this.getContentPane();
    cp.setLayout(new GridBagLayout());
    gamePanel = new JPanel(null);
    gamePanel.setPreferredSize(new Dimension(850, 650));
    cp.add(gamePanel);
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
        gamePanel.add(N1);
        gamePanel.add(N2);
        gamePanel.add(N3);
        gamePanel.add(N4);
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

        ra.addActionListener(e ->ip.setText(""));

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
        gamePanel.add(plus);
        minus.setBounds(130, 550, 50, 25);
        minus.setSize(75, 75);
        minus.setFont(new Font("", Font.BOLD, 50));
        minus.setBackground(Color.WHITE);
        minus.setFocusable(false);
        gamePanel.add(minus);
        multi.setBounds(230, 550, 50, 25);
        multi.setSize(75, 75);
        multi.setFont(new Font("", Font.BOLD, 50));
        multi.setBackground(Color.WHITE);
        multi.setFocusable(false);
        gamePanel.add(multi);
        divide.setBounds(330, 550, 50, 25);
        divide.setSize(75, 75);
        divide.setFont(new Font("", Font.BOLD, 50));
        divide.setBackground(Color.WHITE);
        divide.setFocusable(false);
        gamePanel.add(divide);
        del.setBounds(430, 550, 50, 25);
        del.setSize(75, 75);
        del.setFont(new Font("", Font.BOLD, 50));
        del.setBackground(Color.WHITE);
        del.setFocusable(false);
        gamePanel.add(del);
        ac.setBounds(530, 550, 50, 25);
        ac.setSize(75, 75);
        ac.setFont(new Font("", Font.BOLD, 27));
        ac.setBackground(Color.WHITE);
        ac.setFocusable(false);
        gamePanel.add(ac);
        ent.setBounds(630, 550, 50, 25);
        ent.setSize(150, 75);
        ent.setFont(new Font("", Font.BOLD, 23));
        ent.setBackground(Color.WHITE);
        ent.setIconTextGap(10);
        ent.setFocusable(false);
        gamePanel.add(ent);
    }

    public void Sum() {
        eq = new JLabel("=");
        eq.setBounds(650, 400, 50, 25);
        eq.setSize(630, 100);
        eq.setFont(new Font("", Font.PLAIN, 70));
        sum = new JLabel("?");
        sum.setBounds(725, 400, 50, 25);
        sum.setSize(630, 100);
        sum.setFont(new Font("", Font.PLAIN, 70));
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
        How2PlayForm form = new How2PlayForm();
        form.setVisible(true);
    }

    public void MidTimer() {
        mid = new JLabel("00:30");
        mid.setBounds(300, 5, 50, 30);
        mid.setSize(200, 60);
        mid.setFont(new Font("", Font.PLAIN, 60));
        mid.setForeground(new Color(225,0,0 ));
        mid.setBackground(Color.WHITE);
        gamePanel.add(mid);

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
        gamePanel.add(mt);

        mainTimer = new CountdownTimer(5 * 60, mt,() -> {resetGame();});
        

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

    public void RankingBoard(){
        ImageIcon ldric = new ImageIcon("./Icon/PointIcon.png");
        ldr = new JButton("Ranking",ldric);
        ldr.setBounds(120, 10, 50, 30);
        ldr.setSize(125, 30);
        ldr.setFont(new Font("", Font.BOLD, 15));
        ldr.setFocusable(false);
        ldr.setBackground(Color.WHITE);
        ldr.setHorizontalTextPosition(JButton.RIGHT);
        ldr.setVerticalTextPosition(JButton.CENTER);
        gamePanel.add(ldr);
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
    
     //reset ค่า
        public void resetGame() {
        //ล้างช่องกรอกข้อความ
        ip.setText("");

        //หยุดเวลาถอยหลังทั้งหมด
        if (midTimer != null) midTimer.stop();
        if (mainTimer != null) mainTimer.stop();

        //รีเซ็ตข้อความเวลาถอยหลังบนหน้าจอ
        mid.setText("00:30");
        mt.setText("05:00");

        //คืนค่าตัวเลขสุ่มบนปุ่มทั้ง 4 ให้กลับเป็น "0"
        N1.setText("0");
        N2.setText("0");
        N3.setText("0");
        N4.setText("0");

        //รีเซ็ตคะแนนเป็น 0
        scr_num.setText("0");

        // รีเซ็ตสถานะการสุ่มครั้งแรก
        isFirstRandom = true;
        hasRandomized = false;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ip) {
            
    }
        // เมื่อมีการคลิกปุ่ม N1, N2, N3, N4
        else if(e.getSource() == N1 || e.getSource() == N2 || e.getSource() == N3 || e.getSource() == N4){
            if (!hasRandomized) {
                return;
            }
            JButton sourceButton = (JButton) e.getSource();
            String btnText = sourceButton.getText();
            ip.setText(ip.getText()+btnText);
        }
}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ip) {
            char c = e.getKeyChar();

            if(!Character.isDigit(c)){
                    e.consume();   
                }
            else if (!Character.isAlphabetic(c)){
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
        if (e.getSource() == ht){
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
