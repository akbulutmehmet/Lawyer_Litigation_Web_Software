package com.mehmet.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "dava")
public class Dava implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="dava_id", nullable = false)
    private Long davaId;

    @Column(name="dava_ad", nullable = false)
    private String davaAd;

    @Column(name = "davaTipi", nullable = false)
    private String davaTipi;

    @Column(name = "dava_numarasi", nullable = false )
    private Long davaNumarasi;


    @ManyToOne
    @JoinColumn(name = "davali_id",referencedColumnName = "davali_id")
    private Davali davali;


    @ManyToOne
    @JoinColumn(name = "musteki_id",referencedColumnName = "musteki_id")
    private Musteki musteki;

    public void setDavali(Davali davali) {
        this.davali = davali;
    }

    public Davali getDavali() {
        return davali;
    }

    public void setMusteki(Musteki musteki) {
        this.musteki = musteki;
    }

    public Musteki getMusteki() {
        return musteki;
    }



    public Long getDavaId() {
        return davaId;
    }

    public Long getDavaNumarasi() {
        return davaNumarasi;
    }



    public String getDavaAd() {
        return davaAd;
    }

    public void setDavaAd(String davaAd) {
        this.davaAd = davaAd;
    }

    public String getDavaTipi() {
        return davaTipi;
    }

    public void setDavaId(Long davaId) {
        this.davaId = davaId;
    }


    public void setDavaNumarasi(Long davaNumarasi) {
        this.davaNumarasi = davaNumarasi;
    }

    public void setDavaTipi(String davaTipi) {
        this.davaTipi = davaTipi;
    }


}
