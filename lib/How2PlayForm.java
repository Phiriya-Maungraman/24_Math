import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class How2PlayForm extends JDialog{
    Container cp;
    JLabel htp;
    public How2PlayForm(JFrame owner){
        super(owner, "#How2Play",true);
      Initial();
      HowScreen();
      Finally();

    }

    public void HowScreen(){
        ImageIcon htscreen = new ImageIcon("./Icon/HowToPlay.png");
        htp = new JLabel(htscreen);
        htp.setBounds(-85, -100, 1000, 700);
        cp.setBackground(new Color(30, 42, 68));
        cp.add(htp);
    }

    public void Initial() {
    cp = this.getContentPane();
    cp.setLayout(null); }

    public void Finally() {
        this.setSize(850, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
