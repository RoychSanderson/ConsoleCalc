import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Пожайлуста, введите выражение");
        String tmp = in.nextLine();
        System.out.println(calc(Calculating.parse(tmp)));
    }

    private static String calc(String[] array) throws IOException {
        int a, b, answer;
        if (Calculating.getRoman()) {
            a = Roman.toInt(array[0]);
            b = Roman.toInt(array[2]);
        } else {
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[2]);
        }
        switch (array[1]) {
            case ("-") -> {
                answer = a - b;
                if (Calculating.getRoman()) {
                    if (answer < 0) {
                        throw new IOException("//т.к. в римской системе нет отрицательных чисел");
                    }
                }
            }
            case ("+") -> answer = a + b;
            case ("/") -> answer = a / b;
            case ("*") -> answer = a * b;
            default -> throw new IOException(" Что-то пошло не так");
        }
        if (Calculating.getRoman()){
            return Roman.toRoman(answer);
        } else {
            return Integer.toString(answer);
        }
    }
}
