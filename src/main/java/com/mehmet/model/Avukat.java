package com.mehmet.model;


import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "avukat")
public class Avukat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "avukat_id", nullable = false)
    private Long avukatId;

    @Column(name = "avukat_ad", nullable = false)
    private String avukatAd;

    @Column(name = "avukat_soyad", nullable = false)
    private String avukatSoyad;

    @Transient
    private String adSoyad;

    @Column(name = "avukat_eposta", nullable = false,unique = true)
    private String avukatEposta;

    @Column(name = "avukat_sifre", nullable = false)
    private String avukatSifre;

    @OneToMany(mappedBy = "avukat",fetch = FetchType.LAZY,cascade = CascadeType.MERGE,orphanRemoval = true)
    private List<Ajanda> ajandaList;

    public List<Ajanda> getAjandaList() {
        return ajandaList;
    }

    public void setAjandaList(List<Ajanda> ajandaList) {
        this.ajandaList = ajandaList;
    }

    public void setAvukatAd(String avukatAd) {
        this.avukatAd = avukatAd;
    }

    public String getAdSoyad() {
        return avukatAd + " " + avukatSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public Long getAvukatId() {
        return avukatId;
    }

    public String getAvukatAd() {
        return avukatAd;
    }

    public String getAvukatEposta() {
        return avukatEposta;
    }

    public String getAvukatSifre() {
        return avukatSifre;
    }

    public String getAvukatSoyad() {
        return avukatSoyad;
    }

    public void setAvukatId(Long avukatId) {
        this.avukatId = avukatId;
    }

    public void setAvukatEposta(String avukatEposta) {
        this.avukatEposta = avukatEposta;
    }

    public void setAvukatSifre(String avukatSifre) {
        this.avukatSifre = avukatSifre;
    }

    public void setAvukatSoyad(String avukatSoyad) {
        this.avukatSoyad = avukatSoyad;
    }
}