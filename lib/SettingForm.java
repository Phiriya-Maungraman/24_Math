package lib;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class SettingForm extends JDialog implements MouseListener{
    Container cp;
    JButton four,five,ss,rush,lg;
    JLabel logo,nm,mode,st;
    JFrame owner;
    String currentMode;
    String currentUser;

    public SettingForm(JFrame owner, String currentMode,String currentUser){
        super(owner,"Setting",true);
        this.owner = owner;
        this.currentMode = currentMode;
        this.currentUser = currentUser;
        Initial();
        settingMenu();
        Finally();
    }

     public JButton CreateButtonIcon(JButton button, String text, ImageIcon Icon, int fontSize, Color lnColor,
            Color bgColor) {
        button = new JButton(text, Icon);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(new Color(60, 74, 106));
        button.setBorder(new LineBorder(lnColor, 2));
        button.setForeground(bgColor);
        button.setHorizontalTextPosition(JButton.CENTER); 
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFocusable(false);
        cp.add(button);
        return button;
    } 

    public JLabel CreateJLable(JLabel lable, String text, int fontSize, Color bgColor){
        lable = new JLabel(text);
        lable.setFont(new Font("", Font.PLAIN, fontSize));
        lable.setForeground(bgColor);
        cp.add(lable);
        return lable;
    }



    public void settingMenu(){
        four = CreateButtonIcon(four, "4-digit number",new ImageIcon("./Icon/Fouric.png"), 20, new Color(77, 92, 128),Color.WHITE);
        four.setBounds(25,150,200,100);
        four.addMouseListener(this);
        five = CreateButtonIcon(five, "5-digit number",new ImageIcon("./Icon/Fiveic.png"), 20, new Color(77, 92, 128),Color.WHITE);
        five.setBounds(250,150,200,100);
        five.addMouseListener(this);
        ss = CreateButtonIcon(ss, "67 Mode",new ImageIcon("./Icon/SSic.png"), 20, new Color(77, 92, 128),Color.WHITE);
        ss.setBounds(25,275,200,100);
        ss.addMouseListener(this);
        rush = CreateButtonIcon(rush, "Rush Mode",new ImageIcon("./Icon/Rushic.png"), 20, new Color(77, 92, 128),Color.WHITE);
        rush.setBounds(250, 275,200,100);
        rush.addMouseListener(this);
        //lg = CreateButtonIcon(lg, "Log out",new ImageIcon(""), 20, Color.RED,Color.RED );
        ImageIcon lgic = new ImageIcon("./Icon/LogOutic.png");
        lg = new JButton("Log out",lgic);
        lg.setBounds(50,500,400,50);
        lg.setFont(new Font("",Font.BOLD,25));
        lg.setBackground(new Color(30, 42, 68));
        lg.setBorder(new LineBorder(Color.RED, 2));
        lg.setHorizontalTextPosition(JButton.RIGHT);
        lg.setVerticalTextPosition(JButton.CENTER);
        lg.setIconTextGap(10);
        lg.setForeground(Color.RED);    
        lg.setFocusable(false);
        cp.add(lg);
        lg.addMouseListener(this);

        ImageIcon tflg = new ImageIcon("./Icon/24Logo.png");
        logo = new JLabel(tflg);
        logo.setBounds(25,20,70,70);
        cp.add(logo);

        nm = CreateJLable(nm, "24Math", 25, Color.WHITE);
        nm.setBounds(105,0,100,70);

        st = CreateJLable(st, "Setting", 20, new Color(174, 185, 214));
        st.setBounds(105,30,100,70);

        mode = CreateJLable(mode, "Game Mode", 30, new Color(174, 185, 214));
        mode.setBounds(150,85,200,70);

        if (currentMode.equals("Four")) {
        four.setEnabled(false); }
        else if (currentMode.equals("Five")) {
        five.setEnabled(false); }
        if (currentMode.equals("SS")) {
        ss.setEnabled(false); }
        if (currentMode.equals("Rush")) {
        rush.setEnabled(false); }

    }
    public void Initial() {
    cp = this.getContentPane();
    cp.setBackground(new Color(30, 42, 68));
    cp.setLayout(null); }

    public void Finally() {
        this.setSize(490, 650);
        this.setLocation(1400,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    

    private void openFour(){
        MainGui form = new MainGui(currentUser);
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openFive(){
        FiveMode form = new FiveMode(currentUser);
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openSS(){
        SixSevenMode form = new SixSevenMode(currentUser);
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openRush() {
        RushMode form = new RushMode(currentUser);
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openLogin() {
        LoginForm form = new LoginForm();
        form.setVisible(true);
        this.dispose();
        if (owner != null) {
        owner.dispose(); // ปิดหน้าต่างเกมหลักที่ค้างอยู่ด้วย
    }
}
    




    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == four && !currentMode.equals("Four")){
            openFour();}
        
        if(e.getSource() == five && !currentMode.equals("Five")){
            openFive();}

        if(e.getSource() == ss && !currentMode.equals("SS")){
            openSS();}

        if(e.getSource() == rush && !currentMode.equals("Rush")){
            openRush();}
        
        if(e.getSource() == lg){
            openLogin();}

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
