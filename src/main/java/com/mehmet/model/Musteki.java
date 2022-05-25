package com.mehmet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "musteki")
public class Musteki implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="musteki_id", nullable = false)
    private Long mustekiId;

    @Column(name="musteki_ad", nullable = false)
    private String mustekiAd;

    @Column(name = "musteki_soyad", nullable = false)
    private String mustekiSoyad;

    @Transient
    private String mustekiAdSoyad;

    @Column(name = "musteki_telefon", nullable = false ,unique = true)
    private Long mustekiTelefon;

    @Column(name = "musteki_eposta", nullable = false,unique = true )
    private String mustekiEposta;

    @OneToMany(mappedBy = "musteki",fetch = FetchType.LAZY,cascade = CascadeType.MERGE,orphanRemoval = true)
    private List<Dava> davaList;

    public void setMustekiAdSoyad(String mustekiAdSoyad) {
        this.mustekiAdSoyad = mustekiAd + " " + mustekiSoyad;
    }

    public String getMustekiAdSoyad() {
        return mustekiAd + " " + mustekiSoyad;
    }

    public List<Dava> getDavaList() {
        return davaList;
    }

    public void setDavaList(List<Dava> davaList) {
        this.davaList = davaList;
    }

    public void setMustekiEposta(String mustekiEposta) {
        this.mustekiEposta = mustekiEposta;
    }

    public String getMustekiEposta() {
        return mustekiEposta;
    }

    public Long getMustekiId() {
        return mustekiId;
    }

    public String getMustekiAd() {
        return mustekiAd;
    }

    public void setMustekiAd(String mustekiAd) {
        this.mustekiAd = mustekiAd;
    }

    public Long getMustekiTelefon() {
        return mustekiTelefon;
    }

    public void setMustekiId(Long mustekiId) {
        this.mustekiId = mustekiId;
    }

    public String getMustekiSoyad() {
        return mustekiSoyad;
    }



    public void setMustekiSoyad(String mustekiSoyad) {
        this.mustekiSoyad = mustekiSoyad;
    }

    public void setMustekiTelefon(Long mustekiTelefon) {
        this.mustekiTelefon = mustekiTelefon;
    }
}