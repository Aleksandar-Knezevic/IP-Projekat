package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "zaposleni")
public class ZaposleniEntity {
    private Integer id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ime", nullable = false, length = 20)
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "prezime", nullable = false, length = 20)
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "korisnickoIme", nullable = false, length = 20)
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Basic
    @Column(name = "lozinka", nullable = false, length = 20)
    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZaposleniEntity that = (ZaposleniEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(korisnickoIme, that.korisnickoIme) && Objects.equals(lozinka, that.lozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, korisnickoIme, lozinka);
    }
}
