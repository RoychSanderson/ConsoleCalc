public enum Roman {
    One("I", 1), Two("II", 2), Three("III", 3),
    Four("IV", 4), Five("V", 5), Six("VI", 6),
    Seven("VII", 7), Eight("VIII", 8), Nine("IX", 9), Ten("X", 10);

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
        return "";
    }
}
