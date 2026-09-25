import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    private Timer timer = new Timer();
    private int seconds;
    private JLabel targetLabel;

    // รับค่าจำนวนวินาที และ JLabel ที่ต้องการให้แสดงผล
    public CountdownTimer(int seconds, JLabel targetLabel) {
        this.seconds = seconds;
        this.targetLabel = targetLabel;
    }

    public void start(int delay, int period) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds >= 0) {
                    // แปลงวินาทีเป็น นาที:วินาที (เช่น 00:30)
                    int m = seconds / 60;
                    int s = seconds % 60;
                    String timeFormatted = String.format("%02d:%02d", m, s);

                    // ทำงานผ่านจุดนี้เพื่อเช็คค่าที่รับมามีค่าไหม
                    SwingUtilities.invokeLater(() -> {
                        if (targetLabel != null) {
                            targetLabel.setText(timeFormatted);
                        }
                    });
                    seconds--;
                } else {
                    timer.cancel(); // หยุด Timer เมื่อหมดเวลา
                }
            }
        }, delay, period);
    }
}
