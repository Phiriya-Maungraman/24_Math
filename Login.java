
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Container cp;
    JTextField Username;
    JPasswordField passwordField;
    JButton Login;
    JLabel label;
    JPanel panel;

    public Login() {
        setTitle("Login");
        //*ตรงนี้ */

        Login.addActionListener(e -> login());
    }

        private void login() {
        String username = Username.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login สำเร็จ!");
            // เปิดหน้า Main ตรงนี้
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Username or Password incorrect",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE
            );
        }

    }
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}