package lib.function;
import java.io.*;
import java.util.*;

public class UserManager {
    private static final String FILE_PATH = "users.csv";
    private static List<User> users = new ArrayList<>();

    // โหลดข้อมูลจาก CSV เข้าสู่ Memory เมื่อเริ่มต้น
    static {
        loadUsers();
    }

    /** อ่านข้อมูลทั้งหมดจากไฟล์ users.csv */
    public static void loadUsers() {
        users.clear();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            createDefaultCsv(file);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // ข้ามบรรทัดหัวตาราง (header)
                    continue;
                }
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    int scoreFour = 0 , scoreFive = 0 , scoreSS = 0 , scoreRush = 0;
                    try {
                        scoreFour = Integer.parseInt(parts[2].trim());
                        scoreFive = Integer.parseInt(parts[3].trim());
                        scoreSS = Integer.parseInt(parts[4].trim());
                        scoreRush = Integer.parseInt(parts[5].trim());
                    } catch (NumberFormatException ignored) {
                    }
                    users.add(new User(username, password, scoreFour,scoreFive,scoreSS,scoreRush));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** บันทึกข้อมูลผู้ใช้ทั้งหมดกลับลงไฟล์ users.csv */
    public static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("username,password,scoreFour,scoreFive,scoreSS,scoreRush");
            writer.newLine();
            for (User u : users) {
                writer.write(u.toCsvRow());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** ตรวจสอบการ Login (คืนค่า true เมื่อ username และ password ถูกต้อง) */
    public static boolean authenticate(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /** สมัครสมาชิกใหม่ (ป้องกัน username ซ้ำ) */
    public static boolean register(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return false; // ชื่อผู้ใช้ซ้ำ
            }
        }
        users.add(new User(username, password, 0,0,0,0));
        saveUsers();
        return true;
    }

    /** อัปเดตคะแนนสูงสุดของผู้เล่น */
    public static void updateScore(String username,String mode, int newScore) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                if (newScore > u.getScore(mode)) {
                    u.setHighScore(mode,newScore);
                    saveUsers();
                }
                break;
            }
        }
    }

    /** ดึงรายชื่อผู้เล่นเรียงตามคะแนนสูงสุด (สำหรับ RankingForm) */
    public static List<User> getTopRankings(String mode,int limit) {
        // 1. ทำสำเนา List ขึ้นมาใหม่
        List<User> sortedList = new ArrayList<>();

        for (User u : users) {
            if (u.getScore(mode) > 0) {
                sortedList.add(u);
            }
        }

        // สั่งเรียงคะแนนจากมากไปน้อย
        Collections.sort(sortedList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                // เอาคะแนน u2 ตั้งลบด้วย u1 เพื่อให้เรียงจาก มาก -> น้อย
                return u2.getScore(mode) - u1.getScore(mode);
            }
        });

        //  ดึงเฉพาะ Top ตามจำนวนที่กำหนด 
        List<User> result = new ArrayList<>();
        for (int i = 0; i < limit && i < sortedList.size(); i++) {
            result.add(sortedList.get(i));
        }

        return result;
    }

    /** สร้างไฟล์เริ่มต้นกรณีที่ยังไม่มีไฟล์ users.csv */
    private static void createDefaultCsv(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("username,password,scoreFour,scoreFive,scoreSS,scoreRush\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}