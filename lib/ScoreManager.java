package lib;

import javax.swing.*;

public class ScoreManager {
    public static boolean checkScore(String result, JLabel score) {
        try {
            double value = Double.parseDouble(result);
            int currentScore = Integer.parseInt(score.getText().trim()); 
            
            // เช็คว่าผลลัพธ์เท่ากับ 24 หรือไม่ (รองรับทั้งทศนิยมและจำนวนเต็ม)
            if (value == 24.0){
                score.setText(String.valueOf(currentScore + 3));
                return true;

            }else if(value == 23.0 || value == 25.0){
                score.setText(String.valueOf(currentScore + 2));

            }else if(value == 22.0 || value == 21.0 || value == 20.0 || value == 26.0 || value == 27.0 || value == 28.0){
                score.setText(String.valueOf(currentScore + 1));
            }else{
                 score.setText(String.valueOf(currentScore + 0));

            }
            
        } catch (NumberFormatException e) { }
        return false;
    }
    
}
