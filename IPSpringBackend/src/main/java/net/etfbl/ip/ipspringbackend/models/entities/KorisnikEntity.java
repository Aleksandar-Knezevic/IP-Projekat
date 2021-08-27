package net.etfbl.ip.ipspringbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "korisnik")
public class KorisnikEntity {
    private Integer id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private String drzava;
    private String tipNaloga;
    private String adresa;
    private List<RezervacijaputnickogletaEntity> rezervacijaputnickogletasById;
    private List<RezervacijateretnogletaEntity> rezervacijateretnogletasById;

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
    @Column(name = "email", nullable = false, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "lozinka", nullable = false, length = 20)
    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Basic
    @Column(name = "drzava", nullable = false, length = 45)
    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Basic
    @Column(name = "tipNaloga", nullable = false, length = 20)
    public String getTipNaloga() {
        return tipNaloga;
    }

    public void setTipNaloga(String tipNaloga) {
        this.tipNaloga = tipNaloga;
    }

    @Basic
    @Column(name = "adresa", nullable = false, length = 45)
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KorisnikEntity that = (KorisnikEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(korisnickoIme, that.korisnickoIme) && Objects.equals(email, that.email) && Objects.equals(lozinka, that.lozinka) && Objects.equals(drzava, that.drzava) && Objects.equals(tipNaloga, that.tipNaloga) && Objects.equals(adresa, that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, korisnickoIme, email, lozinka, drzava, tipNaloga, adresa);
    }

    @OneToMany(mappedBy = "korisnikByKorisnikId")
    @JsonIgnore
    public List<RezervacijaputnickogletaEntity> getRezervacijaputnickogletasById() {
        return rezervacijaputnickogletasById;
    }

    public void setRezervacijaputnickogletasById(List<RezervacijaputnickogletaEntity> rezervacijaputnickogletasById) {
        this.rezervacijaputnickogletasById = rezervacijaputnickogletasById;
    }

    @OneToMany(mappedBy = "korisnikByKorisnikId")
    @JsonIgnore
    public List<RezervacijateretnogletaEntity> getRezervacijateretnogletasById() {
        return rezervacijateretnogletasById;
    }

    public void setRezervacijateretnogletasById(List<RezervacijateretnogletaEntity> rezervacijateretnogletasById) {
        this.rezervacijateretnogletasById = rezervacijateretnogletasById;
    }
}
