package lib;

import lib.function.UserManager;
import lib.function.Validator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpForm extends JFrame implements MouseListener {
    Container cp;
    JLabel user, pass, confirmpass;
    JTextField u1, p2;
    JPasswordField p1;
    JButton Sg, Lg;

    public SignUpForm() {
        Initial();
        signUpFrame();
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
        cp.setBackground(new Color(39, 76, 67));
    }

    public void signUpFrame() {
        user = CreateLable(user, "User :", 16, Color.WHITE);
        pass = CreateLable(pass, "Create Password :", 16, Color.WHITE);
        confirmpass = CreateLable(confirmpass, "Confirm Password :", 16, Color.WHITE);

        u1 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        Dimension fieldSize = new Dimension(220, 30);
        u1.setPreferredSize(fieldSize);
        p1.setPreferredSize(fieldSize);
        p2.setPreferredSize(fieldSize);

        addFormComponent(user, 0, 0, 0, GridBagConstraints.NONE);
        addFormComponent(u1, 1, 0, 1, GridBagConstraints.HORIZONTAL);
        addFormComponent(pass, 0, 1, 0, GridBagConstraints.NONE);
        addFormComponent(p1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
        addFormComponent(confirmpass, 0, 2, 0, GridBagConstraints.NONE);
        addFormComponent(p2, 1, 2, 1, GridBagConstraints.HORIZONTAL);

        Sg = new JButton("Sign Up");
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

    public void openGamepanel(String username) {
        GameFourDigitMode form = new GameFourDigitMode(username);
        form.setVisible(true);
    }

    public void openLogin() {
        LogInForm form = new LogInForm();
        form.setVisible(true);
    }

    public void Finally() {
        this.setTitle("Sign Up");
        this.pack();
        this.setMinimumSize(this.getSize());
        ImageIcon logo = new ImageIcon("./Icon/24Logo.png");
        this.setIconImage(logo.getImage());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String username = u1.getText().trim();
        String password = new String(p1.getPassword()).trim();
        String confirmPass = p2.getText().trim();

        if (e.getSource() == Sg) {
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please input Username and Password for Register", "แจ้งเตือน",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!Validator.isAlphaNume(username)) {
                JOptionPane.showMessageDialog(this, "Username must contain only letters and numbers.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (username.length() < 3) {
                JOptionPane.showMessageDialog(this, "Username must be at least 3 characters long.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (password.length() < 8) {
                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!Validator.isValidUserName(password)) {
                JOptionPane.showMessageDialog(this, "Password must contain at least one letter.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!Validator.isValidPassword(password)) {
                JOptionPane.showMessageDialog(this, "Password must contain at least one letter, one number, and one special character.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            

            if (!Validator.isPasswordMatch(password, confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isRegistered = UserManager.register(username, password);
            if (isRegistered) {
                JOptionPane.showMessageDialog(this, "Register success you can Login to play right now", "สำเร็จ",
                        JOptionPane.INFORMATION_MESSAGE);
                u1.setText("");
                p1.setText("");
                p2.setText("");
                openGamepanel(username);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "This name already used", "เกิดข้อผิดพลาด",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == Lg) {
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
