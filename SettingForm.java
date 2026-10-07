import javax.swing.*;
import java.awt.*;

public class SettingForm extends JDialog{
    Container cp;
    JButton four,five,ss,rush;
    public SettingForm(JFrame owner){
        super(owner,"Setting",true);
        Initial();
        settingMenu();
        Finally();
    }

     public JButton CreateButton(JButton button, String text, int fontSize, Color bgColor) {
        button = new JButton(text);
        button.setFont(new Font("", Font.PLAIN, fontSize));
        button.setBackground(bgColor);
        button.setFocusable(true);
        cp.add(button);
        return button;
    }

    public void settingMenu(){
        four = CreateButton(four, "4-digit number", 35, Color.WHITE);
        four.setBounds(50,50,100,35);
        four.setSize(300,50);
        five = CreateButton(five, "5-digit number", 35, Color.WHITE);
        five.setBounds(50,150,100,35);
        five.setSize(300,50);
        ss = CreateButton(ss, "67 Mode", 35, Color.WHITE);
        ss.setBounds(50,250,100,35);
        ss.setSize(300,50);
        rush = CreateButton(rush, "Rush Mode", 35, Color.WHITE);
        rush.setBounds(50,350,100,35);
        rush.setSize(300,50);
    }
    public void Initial() {
    cp = this.getContentPane();
    cp.setLayout(null); }

    public void Finally() {
        this.setSize(400, 550);
        this.setLocation(1400,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
