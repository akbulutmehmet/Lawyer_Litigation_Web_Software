package com.mehmet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "davali")
public class Davali implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="davali_id", nullable = false)
    private Long davaliId;

    @Column(name="davali_ad", nullable = false)
    private String davaliAd;

    @Column(name = "davali_soyad", nullable = false)
    private String davaliSoyad;
    @Transient
    private String davaliAdSoyad;

    @Column(name = "davali_telefon", nullable = false ,unique = true )
    private Long davaliTelefon;

    @Column(name = "davali_eposta", nullable = false ,unique = true)
    private String davaliEposta;

    @OneToMany(mappedBy = "davali",fetch = FetchType.LAZY,cascade = CascadeType.MERGE,orphanRemoval = true)
    private List<Dava> davaList;

    public List<Dava> getDavaList() {
        return davaList;
    }

    public void setDavaList(List<Dava> davaList) {
        this.davaList = davaList;
    }

    public String getDavaliAdSoyad() {
        return davaliAd + " " + davaliSoyad;
    }

    public void setDavaliAdSoyad(String davaliAdSoyad) {
        this.davaliAdSoyad = davaliAd + " " + davaliSoyad;
    }

    public Long getDavaliId() {
        return davaliId;
    }

    public String getDavaliEposta() {
        return davaliEposta;
    }

    public String getDavaliAd() {
        return davaliAd;
    }

    public Long getDavaliTelefon() {
        return davaliTelefon;
    }

    public void setDavaliAd(String davaliAd) {
        this.davaliAd = davaliAd;
    }

    public String getDavaliSoyad() {
        return davaliSoyad;
    }

    public void setDavaliId(Long davaliId) {
        this.davaliId = davaliId;
    }

    public void setDavaliEposta(String davaliEposta) {
        this.davaliEposta = davaliEposta;
    }

    public void setDavaliSoyad(String davaliSoyad) {
        this.davaliSoyad = davaliSoyad;
    }

    public void setDavaliTelefon(Long davaliTelefon) {
        this.davaliTelefon = davaliTelefon;
    }
}