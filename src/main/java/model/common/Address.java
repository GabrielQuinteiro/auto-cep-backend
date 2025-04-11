package model.common;

public class Address {
    private final String streetAddres;
    private final String number;
    private final String complement;
    private final String cep;
    private final String neighborhood;
    private final String city;
    private final String state;

    public Address(String streetAddres, String number, String complement, String cep, String neighborhood, String city, String state) throws Exception {

        if (streetAddres == null || streetAddres.isBlank()) throw new Exception("Street cannot be null or empty.");
        if (number == null || number.isBlank()) throw new Exception("Number cannot be null or empty.");
        if (neighborhood == null || neighborhood.isBlank()) throw new Exception("Neighborhood cannot be null or empty.");
        if (city == null || city.isBlank()) throw new Exception("City cannot be null or empty.");
        if (state == null || state.isBlank()) throw new Exception("State cannot be null or empty.");
        if (cep == null || !cep.matches("^\\d{8}$")) throw new Exception("Postal code must have 8 digits.");

        this.streetAddres = streetAddres.trim();
        this.number = number.trim();
        this.complement = (complement == null) ? "" : complement.trim();
        this.cep = cep.trim();
        this.neighborhood = neighborhood.trim();
        this.city = city.trim();
        this.state = state.trim();
    }

    public String getStreetAddres() {
        return streetAddres;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getCep() {
        return cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
