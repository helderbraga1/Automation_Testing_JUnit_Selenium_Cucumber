package browserTesting;

/**
 * Define package wide constants here,
 * helps to avoid code duplication
 */
public enum Statics {
    WEB_URL("https://qa-automation-challenge.github.io/sandbox/"),

    //Change chrome driver version here if needed
    CHROME_VERSION("87");

    private final String getRef;

    Statics(String ref) {
        this.getRef = ref;
    }
    public String getRef() {
        return this.getRef;
    }

}
