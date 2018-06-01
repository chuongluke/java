package appsdeveloperblog.com;

public class CreateArray {

    public static void main(String[] args) {
        String[] names = new String[5];
        names[0] = "Chuong";
        names[1] = "Linh";
        names[2] = "trinh";
        names[3] = "Hue";
        names[4] = "Love";

        System.out.println("Array contains " + names.length + " elements.");
        System.out.println("First element of an array is " + names[0]);
    }
}
