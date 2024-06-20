import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2;
    static char op;
    static int result;
    static String resultRoman;

    public static void main(String[] args) {
        System.out.println("Введите выражение и нажмите Enter");

        String input = sc.nextLine();

        char[] empty_char = new char[10];
        for (int i = 0; i < input.length(); i++) {
            empty_char[i] = input.charAt(i);

            if (empty_char[i] == '+') {
                op = '+';
            }
            if (empty_char[i] == '-') {
                op = '-';
            }
            if (empty_char[i] == '*') {
                op = '*';
            }
            if (empty_char[i] == '/') {
                op = '/';
            }
        }
        String empty_charString = String.valueOf(empty_char);
        String[] strings = empty_charString.split("[+-/*]");
        String str1 = strings[0];
        String str2 = strings[1];
        String str3 = str2.trim();

        num1 = romanToNum(str1);
        num2 = romanToNum(str3);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = oper(num1, num2, op);
            resultRoman = convertNumToRoman(result);
            System.out.println("Ответ для выражения " + input + " будет равен = " + resultRoman);
        }
        num1 = Integer.parseInt(str1);
        num2 = Integer.parseInt(str3);
        result = oper(num1, num2, op);
        calc(input);
    }

    static String convertNumToRoman ( int numArabian){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    static int romanToNum(String roman){
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    static int oper(int num1, int num2, char op){
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

    public static String calc(String input) {
        System.out.println("Ответ для выражения " + input + " будет равен = " + result);
        return input;
    }
}
