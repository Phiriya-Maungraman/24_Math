import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class How2PlayForm extends JDialog{
    JLabel htp;
    public How2PlayForm(){
        ImageIcon htscreen = new ImageIcon("./Icon/HowToPlay.png");
        htp = new JLabel(htscreen);
        this.add(htp);
        this.setTitle("#How2Play");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
