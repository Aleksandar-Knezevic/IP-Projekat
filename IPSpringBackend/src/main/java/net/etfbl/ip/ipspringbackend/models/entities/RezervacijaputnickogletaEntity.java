package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rezervacijaputnickogleta")
@IdClass(RezervacijaputnickogletaEntityPK.class)
public class RezervacijaputnickogletaEntity {
    private Integer korisnikId;
    private Integer putnickiLetId;
    private String status;
    private Date datumKreiranja;
    private String razlogPonistavanja;
    private Integer brojMjesta;
    private KorisnikEntity korisnikByKorisnikId;
    private PutnickiletEntity putnickiletByPutnickiLetId;

    @Id
    @Column(name = "korisnik_id", nullable = false, insertable = false, updatable = false)
    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Id
    @Column(name = "putnickiLet_id", nullable = false, insertable = false, updatable = false)
    public Integer getPutnickiLetId() {
        return putnickiLetId;
    }

    public void setPutnickiLetId(Integer putnickiLetId) {
        this.putnickiLetId = putnickiLetId;
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

    @Basic
    @Column(name = "brojMjesta", nullable = false)
    public Integer getBrojMjesta() {
        return brojMjesta;
    }

    public void setBrojMjesta(Integer brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervacijaputnickogletaEntity that = (RezervacijaputnickogletaEntity) o;
        return Objects.equals(korisnikId, that.korisnikId) && Objects.equals(putnickiLetId, that.putnickiLetId) && Objects.equals(status, that.status) && Objects.equals(datumKreiranja, that.datumKreiranja) && Objects.equals(razlogPonistavanja, that.razlogPonistavanja) && Objects.equals(brojMjesta, that.brojMjesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnikId, putnickiLetId, status, datumKreiranja, razlogPonistavanja, brojMjesta);
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
    @JoinColumn(name = "putnickiLet_id", referencedColumnName = "id", nullable = false)
    public PutnickiletEntity getPutnickiletByPutnickiLetId() {
        return putnickiletByPutnickiLetId;
    }

    public void setPutnickiletByPutnickiLetId(PutnickiletEntity putnickiletByPutnickiLetId) {
        this.putnickiletByPutnickiLetId = putnickiletByPutnickiLetId;
    }
}
