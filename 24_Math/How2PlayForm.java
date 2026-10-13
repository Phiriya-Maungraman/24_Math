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
        htp.setBounds(-10, -20, 1000, 450);
        cp.add(htp);
    }

    public void Initial() {
    cp = this.getContentPane();
    cp.setLayout(null); }

    public void Finally() {
        this.setSize(1000, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
