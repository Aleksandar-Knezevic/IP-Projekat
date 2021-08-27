package net.etfbl.ip.ipspringbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "drzava")
public class DrzavaEntity {
    private Integer id;
    private String nazivDrzave;
    private List<GradEntity> gradsById;
    private List<PutnickiletEntity> putnickiletsById;
    private List<PutnickiletEntity> putnickiletsById_0;
    private List<TeretniletEntity> teretniletsById;
    private List<TeretniletEntity> teretniletsById_0;

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
    @Column(name = "nazivDrzave", nullable = false, length = 45)
    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrzavaEntity that = (DrzavaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nazivDrzave, that.nazivDrzave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazivDrzave);
    }

    @OneToMany(mappedBy = "drzavaByDrzavaId")
    @JsonIgnore
    public List<GradEntity> getGradsById() {
        return gradsById;
    }

    public void setGradsById(List<GradEntity> gradsById) {
        this.gradsById = gradsById;
    }

    @OneToMany(mappedBy = "drzavaByPolaznaDrzava")
    @JsonIgnore
    public List<PutnickiletEntity> getPutnickiletsById() {
        return putnickiletsById;
    }

    public void setPutnickiletsById(List<PutnickiletEntity> putnickiletsById) {
        this.putnickiletsById = putnickiletsById;
    }

    @OneToMany(mappedBy = "drzavaByOdredisnaDrzava")
    @JsonIgnore
    public List<PutnickiletEntity> getPutnickiletsById_0() {
        return putnickiletsById_0;
    }

    public void setPutnickiletsById_0(List<PutnickiletEntity> putnickiletsById_0) {
        this.putnickiletsById_0 = putnickiletsById_0;
    }

    @OneToMany(mappedBy = "drzavaByPolaznaDrzava")
    @JsonIgnore
    public List<TeretniletEntity> getTeretniletsById() {
        return teretniletsById;
    }

    public void setTeretniletsById(List<TeretniletEntity> teretniletsById) {
        this.teretniletsById = teretniletsById;
    }

    @OneToMany(mappedBy = "drzavaByOdredisnaDrzava")
    @JsonIgnore
    public List<TeretniletEntity> getTeretniletsById_0() {
        return teretniletsById_0;
    }

    public void setTeretniletsById_0(List<TeretniletEntity> teretniletsById_0) {
        this.teretniletsById_0 = teretniletsById_0;
    }
}
