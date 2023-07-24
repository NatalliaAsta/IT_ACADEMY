package lessonMap.cars;

public enum Brand {

    AUDI("Germany", "TT"),
    GEELY("China", "Monjaro"),
    PEUGEOT("France", "5008"),
    KIA("Korea", "Karnival"),
    TESLA("USA", "Model X")

    ;

    Brand(String country, String model) {
        this.country = country;
        this.model = model;
    }

    private String country;

    private String model;

    public String getCountry() {
        return country;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "{ " + this.name() +
                ", country=" + country +
                ", model=" + model;
    }
}
