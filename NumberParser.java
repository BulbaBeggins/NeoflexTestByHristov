import java.util.Scanner;

public class NumberParser {
    static final String DIGITS = "0123456789ABCDEF";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 0 до 10000");
        int number = scanner.nextInt();
        System.out.println("Введите систему счисления");
        int numSys = scanner.nextInt();
        System.out.println(convertFromDecToNumSys(number, numSys));
        System.out.println("Введите двоичное число");
        int numBin = scanner.nextInt();
        System.out.println(convertBinToDec(numBin));
    }

    public static String convertFromDecToNumSys(int number, int numSys) {

        int fromDec = number;
        StringBuilder answerToHex = new StringBuilder();
        do {
            answerToHex.append(DIGITS.charAt(fromDec % numSys));
            fromDec = fromDec / numSys;
        } while (fromDec / numSys != 0 || fromDec % numSys != 0);
        return answerToHex.reverse().toString();
    }

    public static int convertBinToDec(int number) {
        String numBin = Integer.toString(number);
        int answerDec = 0;
        for (int i = numBin.length() - 1, j = 1; i >= 0; i--, j = j * 2) {
            answerDec = answerDec + (numBin.charAt(i) - '0') * j;
        }
        return answerDec;
    }
}
