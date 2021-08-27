package net.etfbl.ip.ipspringbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grad")
public class GradEntity {
    private Integer id;
    private String nazivGrada;
    private DrzavaEntity drzavaByDrzavaId;
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
    @Column(name = "nazivGrada", nullable = false, length = 45)
    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradEntity that = (GradEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nazivGrada, that.nazivGrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazivGrada);
    }

    @ManyToOne
    @JoinColumn(name = "drzava_id", referencedColumnName = "id", nullable = false)
    public DrzavaEntity getDrzavaByDrzavaId() {
        return drzavaByDrzavaId;
    }

    public void setDrzavaByDrzavaId(DrzavaEntity drzavaByDrzavaId) {
        this.drzavaByDrzavaId = drzavaByDrzavaId;
    }

    @OneToMany(mappedBy = "gradByPolazniGrad")
    @JsonIgnore
    public List<PutnickiletEntity> getPutnickiletsById() {
        return putnickiletsById;
    }

    public void setPutnickiletsById(List<PutnickiletEntity> putnickiletsById) {
        this.putnickiletsById = putnickiletsById;
    }

    @OneToMany(mappedBy = "gradByOdredisniGrad")
    @JsonIgnore
    public List<PutnickiletEntity> getPutnickiletsById_0() {
        return putnickiletsById_0;
    }

    public void setPutnickiletsById_0(List<PutnickiletEntity> putnickiletsById_0) {
        this.putnickiletsById_0 = putnickiletsById_0;
    }

    @OneToMany(mappedBy = "gradByPolazniGrad")
    @JsonIgnore
    public List<TeretniletEntity> getTeretniletsById() {
        return teretniletsById;
    }

    public void setTeretniletsById(List<TeretniletEntity> teretniletsById) {
        this.teretniletsById = teretniletsById;
    }

    @OneToMany(mappedBy = "gradByOdredisniGrad")
    @JsonIgnore
    public List<TeretniletEntity> getTeretniletsById_0() {
        return teretniletsById_0;
    }

    public void setTeretniletsById_0(List<TeretniletEntity> teretniletsById_0) {
        this.teretniletsById_0 = teretniletsById_0;
    }
}
