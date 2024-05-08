import java.util.Scanner;

public class Ejercicio37 {
    public static void main(String[] args) {
        int EnteroText = new Scanner(System.in).nextInt();
        System.out.println(Integer.toBinaryString(EnteroText));
        System.out.println(Integer.toHexString(EnteroText));
    }
}
