package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RezervacijaputnickogletaEntityPK implements Serializable {
    private Integer korisnikId;
    private Integer putnickiLetId;

    @Column(name = "korisnik_id", nullable = false, insertable = false, updatable = false)
    @Id
    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Column(name = "putnickiLet_id", nullable = false, insertable = false, updatable = false)
    @Id
    public Integer getPutnickiLetId() {
        return putnickiLetId;
    }

    public void setPutnickiLetId(Integer putnickiLetId) {
        this.putnickiLetId = putnickiLetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervacijaputnickogletaEntityPK that = (RezervacijaputnickogletaEntityPK) o;
        return Objects.equals(korisnikId, that.korisnikId) && Objects.equals(putnickiLetId, that.putnickiLetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnikId, putnickiLetId);
    }

    public RezervacijaputnickogletaEntityPK(Integer korisnikId, Integer putnickiLetId) {
        this.korisnikId = korisnikId;
        this.putnickiLetId = putnickiLetId;
    }
}
