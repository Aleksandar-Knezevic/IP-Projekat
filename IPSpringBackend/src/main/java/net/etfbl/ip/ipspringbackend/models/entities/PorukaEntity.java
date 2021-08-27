package net.etfbl.ip.ipspringbackend.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "poruka")
public class PorukaEntity {
    private Integer id;
    private String email;
    private String naslov;
    private String sadrzaj;
    private String status;

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
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "naslov", nullable = false, length = 45)
    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    @Basic
    @Column(name = "sadrzaj", nullable = false, length = 45)
    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
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
        PorukaEntity that = (PorukaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(naslov, that.naslov) && Objects.equals(sadrzaj, that.sadrzaj) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, naslov, sadrzaj, status);
    }
}
