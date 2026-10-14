import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SigninForm extends JFrame implements MouseListener{
    Container cp;
    JLabel user, pass, confirmpass;
    JTextField u1, u2;
    JPasswordField p1;
    JButton Sg, Lg;
    public SigninForm() {
        Initial();
        signinFrame();
        Finally();
    }

    public JLabel CreateLable(JLabel Label, String text, int fontSize, Color Textcolor) {
        Label = new JLabel(text);
        Label.setFont(new Font("", Font.BOLD, fontSize));
        Label.setForeground(Textcolor);
        return Label;
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new GridBagLayout());
        cp.setBackground(new Color(39,76,67));
    }

    public void signinFrame(){
        user = CreateLable(user, "User :",16,Color.WHITE);
        pass = CreateLable(pass,"Create Password :", 16,Color.WHITE);
        confirmpass = CreateLable(confirmpass,"Confirm Password :", 16,Color.WHITE);

        u1 = new JTextField();
        u2 = new JTextField();
        p1 = new JPasswordField();
        Dimension fieldSize = new Dimension(220,30);
        u1.setPreferredSize(fieldSize);
        p1.setPreferredSize(fieldSize);
        u2.setPreferredSize(fieldSize);

        addFormComponent(user, 0, 0, 0, GridBagConstraints.NONE);
        addFormComponent(u1, 1, 0, 1, GridBagConstraints.HORIZONTAL);
        addFormComponent(pass, 0, 1, 0, GridBagConstraints.NONE);
        addFormComponent(p1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
        addFormComponent(confirmpass, 0, 2, 0, GridBagConstraints.NONE);
        addFormComponent(u2, 1, 2, 1, GridBagConstraints.HORIZONTAL);

        Sg = new JButton("Sign in");
        Sg.addMouseListener(this);
        Lg = new JButton("Login");
        Lg.addMouseListener(this);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        buttons.setOpaque(false);
        buttons.add(Sg);
        buttons.add(Lg);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 3;
        buttonConstraints.gridwidth = 2;
        buttonConstraints.weightx = 1;
        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        buttonConstraints.insets = new Insets(6, 8, 6, 8);
        cp.add(buttons, buttonConstraints);
    }

    private void addFormComponent(Component component, int gridx, int gridy, double weightx, int fill) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.weightx = weightx;
        constraints.fill = fill;
        constraints.insets = new Insets(6, 8, 6, 8);
        constraints.anchor = fill == GridBagConstraints.NONE ? GridBagConstraints.LINE_END : GridBagConstraints.CENTER;
        cp.add(component, constraints);
    }

    public void openGamepanel(){
        MainGui form = new MainGui();
        form.setVisible(true);
    }

    public void openLogin(){
        LoginForm form = new LoginForm();
        form.setVisible(true);
    }


    public void Finally() {
        this.setTitle("Sign in");
        this.pack();
        this.setMinimumSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == Sg){
        openGamepanel();
        this.dispose();
       }

        if(e.getSource() == Lg){
        openLogin();
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
