import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;

public class MainGui extends JFrame{
    Container cp;
    JButton N1,N2,N3,N4,re,ra;
    JTextField ip;
    JLabel eq,sum;
    public  MainGui(){
        Initial();
        RandomNumber();
        RandomButton();
        ResetButton();
        InputNum();
        Sum();
        Finally();
    }

    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
    }
    public void RandomNumber(){
        N1 = new JButton("0");
        N1.setBounds(100,70,50,25);
        N1.setSize(100,100);
        N1.setFont(new Font("",Font.PLAIN,100));
        N1.setBackground(Color.WHITE);
        N1.setFocusable(false);
        N2 = new JButton("0");
        N2.setBounds(250,70,50,25);
        N2.setSize(100,100);
        N2.setFont(new Font("",Font.PLAIN,100));
        N2.setBackground(Color.WHITE);
        N2.setFocusable(false);
        N3 = new JButton("0");
        N3.setBounds(400,70,50,25);
        N3.setSize(100,100);
        N3.setFont(new Font("",Font.PLAIN,100));
        N3.setBackground(Color.WHITE);
        N3.setFocusable(false);
        N4 = new JButton("0");
        N4.setBounds(550,70,50,25);
        N4.setSize(100,100);
        N4.setFont(new Font("",Font.PLAIN,100));
        N4.setBackground(Color.WHITE);
        N4.setFocusable(false);
        cp.add(N1); cp.add(N2); cp.add(N3); cp.add(N4);
    }
    public void RandomButton(){
        ImageIcon rlg = new ImageIcon("./Icon/RandomIcon.png");
        ra = new JButton("Random",rlg);
        ra.setBounds(200,220,50,25);
        ra.setSize(350,100);
        ra.setFont(new Font("",Font.PLAIN,50));
        ra.setHorizontalTextPosition(JButton.RIGHT);
        ra.setVerticalTextPosition(JButton.CENTER);
        ra.setIconTextGap(20);
        ra.setFocusable(false);
        cp.add(ra);
    }
    public void ResetButton(){
        ImageIcon relg = new ImageIcon("./Icon/ResetIcon.png");
        re = new JButton("Reset",relg);
        re.setBounds(30,250,50,25);
        re.setSize(150,50);
        re.setFont(new Font("",Font.PLAIN,20));
        re.setBackground(Color.WHITE);
        ra.setHorizontalTextPosition(JButton.RIGHT);
        ra.setVerticalTextPosition(JButton.CENTER);
        ra.setIconTextGap(20);
        re.setFocusable(false);
        cp.add(re);
    }
    public void InputNum(){
        ip = new JTextField();
        ip.setBounds(30,400,50,25);
        ip.setSize(600,100);
        ip.setFont(new Font("",Font.BOLD,50));
        ip.setHorizontalAlignment(JTextField.CENTER);
        cp.add(ip);

    }
    public void Sum(){
        eq = new JLabel("=");
        eq.setBounds(650,400,50,25);
        eq.setSize(630,100);
        eq.setFont(new Font("",Font.PLAIN,70));
        sum = new JLabel("24");
        sum.setBounds(725,400,50,25);
        sum.setSize(630,100);
        sum.setFont(new Font("",Font.PLAIN,70));
        cp.add(eq); cp.add(sum);
    }
    public void Finally(){
        this.setTitle("24Math");
        this.setSize(850,750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("./Icon/24Logo.png");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
    }
}
