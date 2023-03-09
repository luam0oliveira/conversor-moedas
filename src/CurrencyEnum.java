public enum CurrencyEnum {
    REAL("Real"),
    EURO("Euro"),
    DOLAR("Dolar"),
    LIBRA("Libra"),
    YEN("Yen"),
    WON_COREANO("Won Coreano");

    private String currency;
    CurrencyEnum(String currency) {
        this.currency = currency;
    }

    public String getCurrency(){
        return this.currency;
    }

    @Override
    public String toString() {
        return this.currency;
    }
}
