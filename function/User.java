package lib.function;

/**
    * ADT สำหรับจัดการข้อมูลผู้ใช้งาน และคะแนนสูงสุดในโหมดการเล่นเกมต่างๆ
    * 
    */

public class User {
    private String username;
    private String password;
    private int highScore;
    private int scoreFive;
    private int scoreSS;
    private int scoreRush;

    
    /**
     * สร้างอ็อบเจกต์ User ด้วยข้อมูลผู้ใช้และคะแนนเริ่มต้นในแต่ละโหมด
     * 
     * @param username ชื่อผู้ใช้งาน
     * @param password รหัสผ่านผู้ใช้งาน
     * @param highScore คะแนนสูงสุดในโหมด "Four"
     * @param scoreFive คะแนนสูงสุดในโหมด "Five"
     * @param scoreSS คะแนนสูงสุดในโหมด "SS"
     * @param scoreRush คะแนนสูงสุดในโหมด "Rush"
     */

    public User(String username, String password, int highScore,int scoreFive,int scoreSS,int scoreRush) {
        this.username = username;
        this.password = password;
        this.highScore = highScore;
        this.scoreFive = scoreFive;
        this.scoreSS = scoreSS;
        this.scoreRush = scoreRush;
    }

    /**
     * ดึงค่าชื่อผู้ใช้งาน
     * 
     * @return ชื่อผู้ใช้งาน
     */

    public String getUsername() {
        return username;
    }

    /**
     * ดึงค่ารหัสผ่านของผู้ใช้งาน
     * 
     * @return รหัสผ่าน
     */
    public String getPassword() {
        return password;
    }

     /**
     * ดึงค่าคะแนนตามโหมดเกมที่ระบุ
     * 
     * @param mode ชื่อโหมดเกมที่ต้องการตรวจสอบคะแนน
     * @return คะแนนสูงสุดของโหมดนั้นๆ หากไม่พบโหมดจะคืนค่าเป็น 0
     */

    public int getScore(String mode) {
        switch(mode){
            case "Four" : return highScore;
            case "Five" : return scoreFive;
            case "SS" : return scoreSS;
            case "Rush" : return scoreRush;
            default : return 0;
        }
    }

    /**
     * กำหนดคะแนนสูงสุดตามโหมดเกมที่ระบุ
     * 
     * @param mode ชื่อโหมดเกมที่ต้องการฏฎฆฯโคะแนน
     * @param highScore คะแนนใหม่ที่ต้องการบันทึก
     */

    public void setHighScore(String mode ,int highScore) {
        switch (mode) {
            case "Four": this.highScore = highScore; break;
            case "Five": this.scoreFive = highScore; break;
            case "SS": this.scoreSS = highScore; break;
            case "Rush": this.scoreRush = highScore; break;                            
        }
    }

    /**
     * แปลงข้อมูลของผู้ใช้ทั้งหมดให้อยู่ในรูปแบบสตริง CSV บรรทัดเดียว
     * 
     * @return สตริงที่คั่นข้อมูลด้วยเครื่องหมายจุลภาค
     *         ตามลำดับ username, password, highScore, scoreFive, scoreSS, scoreRush
     */
    public String toCsvRow() {
        return username + "," + password + "," + highScore + "," + scoreFive + "," + scoreSS + "," + scoreRush;
    }
}