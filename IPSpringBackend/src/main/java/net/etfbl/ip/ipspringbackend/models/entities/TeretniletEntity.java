package net.etfbl.ip.ipspringbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teretnilet")
public class TeretniletEntity {
    private Integer id;
    private Date datumLeta;
    private String opisTereta;
    private Time vrijemePolaska;
    private Time vrijemeDolaska;
    private String status;
    private List<RezervacijateretnogletaEntity> rezervacijateretnogletasById;
    private DrzavaEntity drzavaByPolaznaDrzava;
    private DrzavaEntity drzavaByOdredisnaDrzava;
    private GradEntity gradByPolazniGrad;
    private GradEntity gradByOdredisniGrad;

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
    @Column(name = "datumLeta", nullable = false)
    public Date getDatumLeta() {
        return datumLeta;
    }

    public void setDatumLeta(Date datumLeta) {
        this.datumLeta = datumLeta;
    }

    @Basic
    @Column(name = "opisTereta", nullable = true, length = 45)
    public String getOpisTereta() {
        return opisTereta;
    }

    public void setOpisTereta(String opisTereta) {
        this.opisTereta = opisTereta;
    }

    @Basic
    @Column(name = "vrijemePolaska", nullable = false)
    public Time getVrijemePolaska() {
        return vrijemePolaska;
    }

    public void setVrijemePolaska(Time vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    @Basic
    @Column(name = "vrijemeDolaska", nullable = false)
    public Time getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(Time vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeretniletEntity that = (TeretniletEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(datumLeta, that.datumLeta) && Objects.equals(opisTereta, that.opisTereta) && Objects.equals(vrijemePolaska, that.vrijemePolaska) && Objects.equals(vrijemeDolaska, that.vrijemeDolaska) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datumLeta, opisTereta, vrijemePolaska, vrijemeDolaska, status);
    }

    @OneToMany(mappedBy = "teretniletByTeretniLetId")
    @JsonIgnore
    public List<RezervacijateretnogletaEntity> getRezervacijateretnogletasById() {
        return rezervacijateretnogletasById;
    }

    public void setRezervacijateretnogletasById(List<RezervacijateretnogletaEntity> rezervacijateretnogletasById) {
        this.rezervacijateretnogletasById = rezervacijateretnogletasById;
    }

    @ManyToOne
    @JoinColumn(name = "polaznaDrzava", referencedColumnName = "id", nullable = false)
    public DrzavaEntity getDrzavaByPolaznaDrzava() {
        return drzavaByPolaznaDrzava;
    }

    public void setDrzavaByPolaznaDrzava(DrzavaEntity drzavaByPolaznaDrzava) {
        this.drzavaByPolaznaDrzava = drzavaByPolaznaDrzava;
    }

    @ManyToOne
    @JoinColumn(name = "odredisnaDrzava", referencedColumnName = "id", nullable = false)
    public DrzavaEntity getDrzavaByOdredisnaDrzava() {
        return drzavaByOdredisnaDrzava;
    }

    public void setDrzavaByOdredisnaDrzava(DrzavaEntity drzavaByOdredisnaDrzava) {
        this.drzavaByOdredisnaDrzava = drzavaByOdredisnaDrzava;
    }

    @ManyToOne
    @JoinColumn(name = "polazniGrad", referencedColumnName = "id", nullable = false)
    public GradEntity getGradByPolazniGrad() {
        return gradByPolazniGrad;
    }

    public void setGradByPolazniGrad(GradEntity gradByPolazniGrad) {
        this.gradByPolazniGrad = gradByPolazniGrad;
    }

    @ManyToOne
    @JoinColumn(name = "odredisniGrad", referencedColumnName = "id", nullable = false)
    public GradEntity getGradByOdredisniGrad() {
        return gradByOdredisniGrad;
    }

    public void setGradByOdredisniGrad(GradEntity gradByOdredisniGrad) {
        this.gradByOdredisniGrad = gradByOdredisniGrad;
    }
}
