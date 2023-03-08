public enum TemperatureEnum {
    FAHRENHEIT("Fahrenheit"),
    CELSIUS("Celsius"),
    KELVIN("Kelvin");


    private String temperature;

    TemperatureEnum(String temperature){
        this.temperature = temperature;
    }

    public String getTemperature(){
        return this.temperature;
    }

    @Override
    public String toString() {
        return this.temperature;
    }


}
