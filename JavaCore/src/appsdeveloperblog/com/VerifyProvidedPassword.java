package appsdeveloperblog.com;

public class VerifyProvidedPassword {

    public static void main(String[] args) {
        String providedPassword = "myPassword123";

        String securePassword = "YTB1X4zuKCrcGBG2E11QMohuAR3LXr88Es1z6tQpZhk=";

        String salt = "FxVKH6FfNkkeHO86iBRCjhqZEimWsd";

        boolean passwordMacth = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);

        if (passwordMacth) {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        }else{
            System.out.println("Provided user password is incorrect.");
        }
    }
}
