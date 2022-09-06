import java.io.IOException;
import java.util.Objects;

public class Calculating {

    private static String flagRim = "";

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
        for (Roman i: Roman.values()){
            if (Objects.equals(i.getRimv(), str)) {
                if ((Objects.equals(flagRim, "Arab")))
                    throw new IOException("//т.к. используются одновременно разные системы счисления");
                flagRim = "Rim";
                if (i.getValue() > 10) throw new IOException("//недопустимые значения чисел");
                return i.getValue();
            }
        }
        try {
                    if ((Objects.equals(flagRim, "Rim")) && (str.matches("[-+]?\\d+"))){
                        throw new IOException("//т.к. используются одновременно разные системы счисления");
                    }
                    flagRim = "Arab";
                    int answer = Integer.parseInt(str);
                    if (answer > 10 || answer < 1){
                        throw new IOException("//недопустимые значения чисел");
                    }
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("//т.к. строка не является математической операцией");
                }
    }

    //проверка, является ли переданный символ арифметической операцией
    private static boolean checkForActions(String str){
        return !Objects.equals(str, "+") && !Objects.equals(str, "-") && !Objects.equals(str, "/") && !Objects.equals(str, "*");
    }

    public static String getRoman(){
        return flagRim;
    }
}
