import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements MouseListener{
    Container cp;
    JLabel user, pass;
    JTextField u1;
    JPasswordField p1;
    JButton lg;
    public LoginForm() {
        Initial();
        loginFrame();
        Finally();
    }

     public JLabel CreateLable(JLabel Label, String text, int fontSize, Color Textcolor) {
        Label = new JLabel(text);
        Label.setFont(new Font("", Font.BOLD, fontSize));
        Label.setForeground(Textcolor);
        cp.add(Label);
        return Label;
    }

    public void Initial() {
    cp = this.getContentPane();
    cp.setLayout(null); 
    cp.setBackground(new Color(39,76,67));}

    public void loginFrame(){
        user = CreateLable(user, "User :",20,Color.WHITE);
        user.setBounds(65,10,100,25);
        pass = CreateLable(pass,"Password :", 20,Color.WHITE);
        pass.setBounds(15,40,200,25);
        u1 = new JTextField();
        u1.setBounds(150,10,100,25);
        u1.setSize(200,25);
        p1 = new JPasswordField();
        p1.setBounds(150,40,100,25);
        p1.setSize(200,25);
        lg = new JButton("Login");
        lg.setBounds(150,100,100,50);
        lg.setSize(100,25);
        lg.addMouseListener(this);
        cp.add(u1);
        cp.add(lg);
        cp.add(p1);
    }

    public void openGamepanel(){
        MainGui form = new MainGui();
        form.setVisible(true);
    }


    public void Finally() {
        this.setTitle("Login");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == lg){
        openGamepanel();
        this.dispose();
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

 
}
