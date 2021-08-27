package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RezervacijateretnogletaEntityPK implements Serializable {
    private Integer korisnikId;
    private Integer teretniLetId;

    @Column(name = "korisnik_id", nullable = false, insertable = false, updatable = false)
    @Id
    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Column(name = "teretniLet_id", nullable = false, insertable = false, updatable = false)
    @Id
    public Integer getTeretniLetId() {
        return teretniLetId;
    }

    public void setTeretniLetId(Integer teretniLetId) {
        this.teretniLetId = teretniLetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervacijateretnogletaEntityPK that = (RezervacijateretnogletaEntityPK) o;
        return Objects.equals(korisnikId, that.korisnikId) && Objects.equals(teretniLetId, that.teretniLetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnikId, teretniLetId);
    }

    public RezervacijateretnogletaEntityPK(Integer korisnikId, Integer teretniLetId) {
        this.korisnikId = korisnikId;
        this.teretniLetId = teretniLetId;
    }
}
