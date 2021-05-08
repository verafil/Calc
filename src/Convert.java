public enum Convert {
    I("I", 1), IV("IV", 4), II("II", 2), V("V", 5), III("III", 3), VI("VI", 6),
    VII("VII", 7), VIII("VIII", 8), IX("IX", 9), X("X", 10);

    private int value;
    private String key;

    Convert(String key, int value) {
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return value;
    }
    public String getKey() {
        return key;
    }
    static int toInt(String key) {
            for (Convert i: Convert.values())
                if (i.getKey().equals(key))
                    return i.getValue();
                return 0;
    }

}
