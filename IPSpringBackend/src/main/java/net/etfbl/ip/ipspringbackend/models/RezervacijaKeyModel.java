package net.etfbl.ip.ipspringbackend.models;

import java.util.Objects;

public class RezervacijaKeyModel {

    private int letId;
    private int korisnikId;
    private String razlogPonistavanja;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervacijaKeyModel that = (RezervacijaKeyModel) o;
        return letId == that.letId && korisnikId == that.korisnikId && Objects.equals(razlogPonistavanja, that.razlogPonistavanja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letId, korisnikId, razlogPonistavanja);
    }

    public int getLetId() {
        return letId;
    }

    public void setLetId(int letId) {
        this.letId = letId;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getRazlogPonistavanja() {
        return razlogPonistavanja;
    }

    public void setRazlogPonistavanja(String razlogPonistavanja) {
        this.razlogPonistavanja = razlogPonistavanja;
    }

    public RezervacijaKeyModel() {
    }

    public RezervacijaKeyModel(int letId, int korisnikId, String razlogPonistavanja) {
        this.letId = letId;
        this.korisnikId = korisnikId;
        this.razlogPonistavanja = razlogPonistavanja;
    }
}
