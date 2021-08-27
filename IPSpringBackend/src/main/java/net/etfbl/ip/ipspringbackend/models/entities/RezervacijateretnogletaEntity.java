package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rezervacijateretnogleta")
@IdClass(RezervacijateretnogletaEntityPK.class)
public class RezervacijateretnogletaEntity {
    private Integer korisnikId;
    private Integer teretniLetId;
    private String status;
    private Date datumKreiranja;
    private String razlogPonistavanja;
    private KorisnikEntity korisnikByKorisnikId;
    private TeretniletEntity teretniletByTeretniLetId;

    @Id
    @Column(name = "korisnik_id", nullable = false, insertable = false, updatable = false)
    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Id
    @Column(name = "teretniLet_id", nullable = false, insertable = false, updatable = false)
    public Integer getTeretniLetId() {
        return teretniLetId;
    }

    public void setTeretniLetId(Integer teretniLetId) {
        this.teretniLetId = teretniLetId;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "datumKreiranja", nullable = false)
    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    @Basic
    @Column(name = "razlogPonistavanja", nullable = true, length = 45)
    public String getRazlogPonistavanja() {
        return razlogPonistavanja;
    }

    public void setRazlogPonistavanja(String razlogPonistavanja) {
        this.razlogPonistavanja = razlogPonistavanja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervacijateretnogletaEntity that = (RezervacijateretnogletaEntity) o;
        return Objects.equals(korisnikId, that.korisnikId) && Objects.equals(teretniLetId, that.teretniLetId) && Objects.equals(status, that.status) && Objects.equals(datumKreiranja, that.datumKreiranja) && Objects.equals(razlogPonistavanja, that.razlogPonistavanja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnikId, teretniLetId, status, datumKreiranja, razlogPonistavanja);
    }

    @ManyToOne
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id", nullable = false)
    public KorisnikEntity getKorisnikByKorisnikId() {
        return korisnikByKorisnikId;
    }

    public void setKorisnikByKorisnikId(KorisnikEntity korisnikByKorisnikId) {
        this.korisnikByKorisnikId = korisnikByKorisnikId;
    }

    @ManyToOne
    @JoinColumn(name = "teretniLet_id", referencedColumnName = "id", nullable = false)
    public TeretniletEntity getTeretniletByTeretniLetId() {
        return teretniletByTeretniLetId;
    }

    public void setTeretniletByTeretniLetId(TeretniletEntity teretniletByTeretniLetId) {
        this.teretniletByTeretniLetId = teretniletByTeretniLetId;
    }
}
