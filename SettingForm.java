import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SettingForm extends JDialog implements MouseListener{
    Container cp;
    JButton four,five,ss,rush,lg;
    JFrame owner;
    String currentMode;
    public SettingForm(JFrame owner, String currentMode){
        super(owner,"Setting",true);
        this.owner = owner;
        this.currentMode = currentMode;
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
        four.addMouseListener(this);
        five = CreateButton(five, "5-digit number", 35, Color.WHITE);
        five.setBounds(50,150,100,35);
        five.setSize(300,50);
        five.addMouseListener(this);
        ss = CreateButton(ss, "67 Mode", 35, Color.WHITE);
        ss.setBounds(50,250,100,35);
        ss.setSize(300,50);
        ss.addMouseListener(this);
        rush = CreateButton(rush, "Rush Mode", 35, Color.WHITE);
        rush.setBounds(50,350,100,35);
        rush.setSize(300,50);
        rush.addMouseListener(this);
        lg = CreateButton(lg, "Log Out", 35, Color.WHITE);
        lg.setBounds(50,450,100,35);
        lg.setSize(300,50);

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
    cp.setLayout(null); }

    public void Finally() {
        this.setSize(400, 650);
        this.setLocation(1400,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    

    private void openFour(){
        MainGui form = new MainGui();
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openFive(){
        FiveMode form = new FiveMode();
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openSS(){
        SixSevenMode form = new SixSevenMode();
        form.setVisible(true);
        this.dispose();
        owner.dispose();
    }

    private void openRush() {
        RushMode form = new RushMode();
        form.setVisible(true);
        this.dispose();
        owner.dispose();
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
