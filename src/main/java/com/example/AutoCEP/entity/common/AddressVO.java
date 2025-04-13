package com.example.AutoCEP.entity.common;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class AddressVO {
    @NotBlank
    @NotNull
    private String streetAddres;

    @NotBlank
    @NotNull
    private String number;

    private String complement;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^\\d{8}$")
    private String cep;

    @NotBlank
    @NotNull
    private String neighborhood;

    @NotBlank
    @NotNull
    private String city;

    @NotBlank
    @NotNull
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
