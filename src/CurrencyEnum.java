public enum CurrencyEnum {
    REAL("Real"),
    EURO("Euro"),
    DOLAR("Dolar"),
    LIBRA("Libra Esterlina"),
    PESO_ARGENTINO("Peso Argentino"),
    PESO_CHILENO("Peso Chileno");

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
