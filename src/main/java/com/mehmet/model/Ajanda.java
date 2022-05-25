package com.mehmet.model;


import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ajanda")
public class Ajanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ajanda_id", nullable = false)
    private Long ajandaId;

    @Column(name = "ajanda_isim", nullable = false)
    private String ajandaIsim;

    @Column(name = "baslangic_tarihi", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date baslangicTarihi;


    @Column(name = "bitis_tarihi", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bitisTarihi;

    @ManyToOne
    @JoinColumn(name = "avukat_id",referencedColumnName = "avukat_id")
    private Avukat avukat;

    public Avukat getAvukat() {
        return avukat;
    }

    public Long getAjandaId() {
        return ajandaId;
    }

    public Date getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public Date getBitisTarihi() {
        return bitisTarihi;
    }

    public String getAjandaIsim() {
        return ajandaIsim;
    }

    public void setAjandaId(Long ajandaId) {
        this.ajandaId = ajandaId;
    }

    public void setAjandaIsim(String ajandaIsim) {
        this.ajandaIsim = ajandaIsim;
    }

    public void setAvukat(Avukat avukat) {
        this.avukat = avukat;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }
}