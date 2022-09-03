import java.io.IOException;
import java.util.Objects;

public class Calculating {

    private static boolean flagRim = false;

//    //функция высчитывания выражения
//    private static int calc (int a, int b, String znak) throws IOException{
//        switch (znak){
//            case ("-"):
//                int answer = a - b;
//                if (flagRim) {
//                    if (answer < 0){
//                        throw new IOException("//т.к. в римской системе нет отрицательных чисел");
//                    }
//                }
//                return answer;
//            case ("+"):
//                return a + b;
//            case ("/"):
//                return a / b;
//            case ("*"):
//                return a * b;
//            default:
//                throw new IOException("Что-то пошло не так");
//        }
//    }

    //парсинг строки для её дальнейшей обратботки и подсчета
    public static String[] parse(String tmp) throws IOException {
        String[] array = tmp.split(" ");
        if (array.length < 3) {
            throw new IOException("//т.к. строка не является математической операцией");
        }

        int a = check(array[0]);
        int b = check(array[2]);

        if (checkForActions(array[1])) {
            throw new IOException("//т.к. строка не является математической операцией");
        }
        if (array.length > 3) {
            if (checkForActions(array[4])) {
                throw new IOException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else throw new IOException("//т.к. строка не является математической операцией");
        }
        return array;
    }

    //проверка на числа, римские и арабские
    private static int check(String str) throws NumberFormatException, IOException{
        switch (str) {
            case ("I") -> {
                flagRim = true;
                return 1;
            }
            case ("II") -> {
                flagRim = true;
                return 2;
            }
            case ("III") -> {
                flagRim = true;
                return 3;
            }
            case ("IV") -> {
                flagRim = true;
                return 4;
            }
            case ("V") -> {
                flagRim = true;
                return 5;
            }
            case ("VI") -> {
                flagRim = true;
                return 6;
            }
            case ("VII") -> {
                flagRim = true;
                return 7;
            }
            case ("VIII") -> {
                flagRim = true;
                return 8;
            }
            case ("IX") -> {
                flagRim = true;
                return 9;
            }
            case ("X") -> {
                flagRim = true;
                return 10;
            }
            default -> {
                try {
                    if ((flagRim) && (str.matches("[-+]?\\d+"))){
                        throw new IOException("//т.к. используются одновременно разные системы счисления");
                    }
                    int answer = Integer.parseInt(str);
                    if (answer > 10 || answer < 1){
                        throw new IOException("//недопустимые значения чисел");
                    }
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("//т.к. строка не является математической операцией");
                }
            }
            }

    }

    //проверка, является ли переданный символ арифметической операцией
    private static boolean checkForActions(String str){
        return !Objects.equals(str, "+") && !Objects.equals(str, "-") && !Objects.equals(str, "/") && !Objects.equals(str, "*");
    }

    public static boolean getRoman(){
        return flagRim;
    }
}
