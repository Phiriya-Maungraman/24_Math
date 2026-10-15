package lib.function;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * ตัวนับเวลาถอยหลังแบบ Swing แสดงผลในรูปแบบ mm:ss บน JLabel
 */

public class CountdownTimer {
    private Timer timer;
    private int initialSeconds;
    private int seconds;
    private JLabel targetLabel;
    private Runnable onTimeUp; 

    /**
     * สร้างตัวนับเวลาเปล่า (เวลา 0 วินาที, ไม่มี label และ callback)
     */

    public CountdownTimer() {
        this.initialSeconds = 0;
        this.seconds = 0;
        this.targetLabel = null;
        this.onTimeUp = null;
    }

    /**
     * สร้างตัวนับเวลาโดยไม่มี callback เมื่อหมดเวลา
     *
     * @param seconds     เวลาตั้งต้นของการนับถอยหลัง (วินาที)
     * @param targetLabel JLabel ที่จะแสดงเวลา
     */

    public CountdownTimer(int seconds, JLabel targetLabel) {
        this(seconds, targetLabel, null);
    }

    /**
     * @param seconds     เวลาตั้งต้นของการนับถอยหลัง (วินาที)
     * @param targetLabel JLabel ที่จะแสดงเวลา
     * @param onTimeUp    callback ที่จะทำงานเมื่อหมดเวลา (เป็น null ได้)
     */
    public CountdownTimer(int seconds, JLabel targetLabel, Runnable onTimeUp) {
        this.initialSeconds = seconds;
        this.seconds = seconds;
        this.targetLabel = targetLabel;
        this.onTimeUp = onTimeUp;
        this.timer = new Timer(1000, e -> {
            if (this.seconds > 0) {
                this.seconds--;
                updateTimeLabel();
            } else {
                stop();
                if (this.onTimeUp != null) {
                    this.onTimeUp.run();
                }
            }
        });
    }

     /** อัปเดตข้อความบน JLabel ให้เป็นรูปแบบ mm:ss */
    private void updateTimeLabel() {
        if (targetLabel != null) {
            int m = seconds / 60;
            int s = seconds % 60;
            targetLabel.setText(String.format("%02d:%02d", m, s));
        }
    }

    /**
     * เริ่มนับถอยหลังใหม่จากเวลาตั้งต้น
     *
     * @param delay  initial delay ก่อน tick แรก (มิลลิวินาที)
     * @param period ไม่ถูกใช้งานในโค้ดปัจจุบัน (Timer ใช้ช่วง 1000 ms คงที่)
     */
    public void start(int delay, int period) {
        stop();
        this.seconds = initialSeconds;
        updateTimeLabel(); // อัปเดตแสดงผลทันทีตั้งแต่เริ่ม

        // สำหรับ Swing Timer ให้กำหนด Initial Delay ได้
        timer.setInitialDelay(delay);
        timer.start();
    }

    /** หยุดการนับถอยหลังทันที */
    public void stop() {
        if (timer != null && timer.isRunning()) {
            timer.stop(); // <--- หยุดทันทีแบบ Real-time ไม่มีดีเลย์
        }
    }
}