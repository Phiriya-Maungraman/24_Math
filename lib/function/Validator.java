package lib.function;

/**
 * รวมเมธอดตรวจสอบความถูกต้องของข้อมูล เช่น ชื่อผู้ใช้และรหัสผ่าน
 */
public class Validator {

        /**
     * เช็กว่าข้อความมีแต่ตัวอักษรหรือตัวเลขเท่านั้น ไม่ว่าง ไม่มีช่องว่างหรือสัญลักษณ์
     *
     * @param str ข้อความที่ต้องการตรวจสอบ
     * @return true ถ้าเป็นตัวอักษรหรือตัวเลขล้วนและไม่ว่าง, false ถ้าเป็น null ว่าง
     *         หรือมีอักขระอื่นปน
     */
    public static boolean isAlphaNume(String str) {

        if (str == null || str.isEmpty())
            return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
    /**
     * เช็กว่าชื่อผู้ใช้มีตัวอักษรอย่างน้อย 1 ตัว
     *
     * @param name ชื่อผู้ใช้ที่ต้องการตรวจสอบ
     * @return true ถ้ามีตัวอักษรอย่างน้อย 1 ตัว, false ถ้าไม่มี
     */
    public static boolean isValidUserName(String name) {
        
        boolean hasLetter = false;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isLetter(c))
                hasLetter = true;
        }
        return hasLetter;
    }

    /**
     * เช็กว่ารหัสผ่านมีครบทั้ง 3 ประเภท คือ ตัวอักษร ตัวเลข และอักขระพิเศษ
     *
     * @param password รหัสผ่านที่ต้องการตรวจสอบ
     * @return true ถ้ามีครบทั้ง 3 ประเภท, false ถ้าขาดประเภทใดประเภทหนึ่ง
     */
    public static boolean isValidPassword(String password) {

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isWhitespace(c)) {
                hasSpecial = true;
            }
        }

        // ต้องมีครบทั้ง 3 ประเภท
        return hasLetter && hasDigit && hasSpecial;
    }

    /**
     * เช็กว่ารหัสผ่านที่พิมพ์ 2 ช่อง (รหัสผ่านกับยืนยันรหัสผ่าน) ตรงกันทุกตัว
     *
     * @param p1 รหัสผ่านที่พิมพ์ในช่องแรก
     * @param p2 รหัสผ่านที่พิมพ์ในช่องยืนยัน
     * @return true ถ้าตรงกันทุกตัว, false ถ้าไม่ตรงกันหรือเป็น null
     */
    public static boolean isPasswordMatch(String p1, String p2) {
        if (p1 == null || p2 == null)
            return false;
        if (p1.length() != p2.length())
            return false;

        for (int i = 0; i < p1.length(); i++) {
            if (p1.charAt(i) != p2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}