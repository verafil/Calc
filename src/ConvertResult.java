public enum ConvertResult {

    C("C", 100), XC("XC", 90), L("L", 50), XL("XL", 40), X("X", 10),
    IX("IX", 9), V("V", 5), IV("IV", 4), I("I", 1);

    private int value;
    private String key;

    ConvertResult(String key, int value) {
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return value;
    }
    public String getKey() {
        return key;
    }
    static String toRom(int value) {
        StringBuilder str = new StringBuilder();

        for (ConvertResult i: ConvertResult.values()) {
            while (value >= i.getValue()) {
                str.append(i.getKey());
                value -= i.getValue();
            }
    }
        return str.toString();
    }
}
