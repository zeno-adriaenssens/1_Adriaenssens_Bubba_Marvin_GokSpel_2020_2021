package model;

import java.util.Objects;

public class Speler {
    private String familienaam;
    private String voornaam;
    private String spelernaam;
    private double goksaldo;

    public Speler(String familienaam, String voornaam, String spelernaam, double goksaldo) {
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.spelernaam = spelernaam;
        this.goksaldo = goksaldo;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    private void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    private void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getSpelernaam() {
        return spelernaam;
    }

    private void setSpelernaam(String spelernaam) {
        this.spelernaam = spelernaam;
    }

    public double getGoksaldo() {
        return goksaldo;
    }

    private void setGoksaldo(double goksaldo) {
        this.goksaldo = goksaldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speler speler = (Speler) o;
        return Double.compare(speler.goksaldo, goksaldo) == 0 &&
                familienaam.equals(speler.familienaam) &&
                voornaam.equals(speler.voornaam) &&
                spelernaam.equals(speler.spelernaam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familienaam, voornaam, spelernaam, goksaldo);
    }

    @Override
    public String toString() {
        return familienaam + ',' + voornaam + ',' + spelernaam + ',' + goksaldo;
    }
}
