import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum Roman {
    One("I", 1), Two("II", 2), Three("III", 3),
    Four("IV", 4), Five("V", 5), Six("VI", 6),
    Seven("VII", 7), Eight("VIII", 8), Nine("IX", 9), Ten("X", 10),
    Twenty("XX", 20), Thirty("XXX", 30), Forty("XL", 40), Fifty("L", 50),
    Sixty("LX", 60), Seventy("LXX", 70), Eighty("XXC", 80), Ninety("XC", 90),
    Hundred("C", 100);
    private final String rimv;
    private final int value;

    Roman(String rimv, int value) {
        this.rimv = rimv;
        this.value = value;
    }
    public String getRimv() {
        return rimv;
    }
    public int getValue() {
        return value;
    }

    static int toInt(String key) {
        for (Roman i : Roman.values())
            if (i.getRimv().equals(key))
                return i.getValue();
        return -1;
    }

    static String toRoman(int value){
            for (Roman i: Roman.values()){
                if (i.getValue() == value)
                    return i.getRimv();
            }
            List<Integer> list = new ArrayList<>();
            String s = "";
            while (value >= 1){
                int tmp = value % 10;
                value /= 10;
                list.add(tmp);
            }
            for (int i = 0; i < list.size(); i++){
                int tmp = list.get(i);
                tmp *= Math.pow(10, i);
                for (Roman iu: Roman.values()){
                    if (iu.getValue() == tmp)
                        s = iu.getRimv() + s;
                }
            }
        return s;
    }
}
