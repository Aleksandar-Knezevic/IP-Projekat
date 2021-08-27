package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pristupi")
public class PristupiEntity {
    private Date datum;
    private Integer brojPristupa;

    @Id
    @Column(name = "datum", nullable = false)
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "brojPristupa", nullable = false)
    public Integer getBrojPristupa() {
        return brojPristupa;
    }

    public void setBrojPristupa(Integer brojPristupa) {
        this.brojPristupa = brojPristupa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PristupiEntity that = (PristupiEntity) o;
        return Objects.equals(datum, that.datum) && Objects.equals(brojPristupa, that.brojPristupa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datum, brojPristupa);
    }
}
