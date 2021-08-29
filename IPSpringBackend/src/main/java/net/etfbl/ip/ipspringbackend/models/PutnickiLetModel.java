package net.etfbl.ip.ipspringbackend.models;

import java.sql.Date;
import java.sql.Time;

public class PutnickiLetModel {
    private Date datumLeta;
    private int brojMjesta;
    private int polazniGrad;
    private int odredisniGrad;
    private int polaznaDrzava;
    private int odredisnaDrzava;
    private String status;
    private String vrijemePolaska;
    private String vrijemeDolaska;

    public Date getDatumLeta() {
        return datumLeta;
    }

    public void setDatumLeta(Date datumLeta) {
        this.datumLeta = datumLeta;
    }

    public int getBrojMjesta() {
        return brojMjesta;
    }

    public void setBrojMjesta(int brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    public int getPolazniGrad() {
        return polazniGrad;
    }

    public void setPolazniGrad(int polazniGrad) {
        this.polazniGrad = polazniGrad;
    }

    public int getOdredisniGrad() {
        return odredisniGrad;
    }

    public void setOdredisniGrad(int odredisniGrad) {
        this.odredisniGrad = odredisniGrad;
    }

    public int getPolaznaDrzava() {
        return polaznaDrzava;
    }

    public void setPolaznaDrzava(int polaznaDrzava) {
        this.polaznaDrzava = polaznaDrzava;
    }

    public int getOdredisnaDrzava() {
        return odredisnaDrzava;
    }

    public void setOdredisnaDrzava(int odredisnaDrzava) {
        this.odredisnaDrzava = odredisnaDrzava;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVrijemePolaska() {
        return vrijemePolaska;
    }

    public void setVrijemePolaska(String vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    public String getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(String vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public PutnickiLetModel(Date datumLeta, int brojMjesta, int polazniGrad, int odredisniGrad, int polaznaDrzava, int odredisnaDrzava, String status, String vrijemePolaska, String vrijemeDolaska) {
        this.datumLeta = datumLeta;
        this.brojMjesta = brojMjesta;
        this.polazniGrad = polazniGrad;
        this.odredisniGrad = odredisniGrad;
        this.polaznaDrzava = polaznaDrzava;
        this.odredisnaDrzava = odredisnaDrzava;
        this.status = status;
        this.vrijemePolaska = vrijemePolaska;
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public PutnickiLetModel() {
    }

    @Override
    public String toString() {
        return "PutnickiLetModel{" +
                "datumLeta=" + datumLeta +
                ", brojMjesta=" + brojMjesta +
                ", polazniGrad=" + polazniGrad +
                ", odredisniGrad=" + odredisniGrad +
                ", polaznaDrzava=" + polaznaDrzava +
                ", odredisnaDrzava=" + odredisnaDrzava +
                ", status='" + status + '\'' +
                ", vrijemePolaska='" + vrijemePolaska + '\'' +
                ", vrijemeDolaska='" + vrijemeDolaska + '\'' +
                '}';
    }
}
