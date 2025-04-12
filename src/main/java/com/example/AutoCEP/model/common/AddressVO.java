package com.example.AutoCEP.model.common;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressVO {
    private String streetAddres;
    private String number;
    private String complement;
    private String cep;
    private String neighborhood;
    private String city;
    private String state;

    public AddressVO() {
    }

    public AddressVO(String streetAddres, String number, String complement, String cep, String neighborhood, String city, String state) {
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
