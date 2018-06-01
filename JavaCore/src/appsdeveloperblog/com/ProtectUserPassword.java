package appsdeveloperblog.com;

public class ProtectUserPassword {

    public static void main(String[] args) {
        String myPassword = "myPassword123";

        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
    }
}
