package com.mehmet.service;


import com.mehmet.dao.AvukatDAO;
import com.mehmet.dao.MainDAO;
import com.mehmet.model.Avukat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly =true,rollbackFor = Exception.class)
public class AvukatService {
    @Autowired
    private AvukatDAO avukatDAO;
    @Autowired
    private MainDAO mainDAO;
    public Avukat loginKontrol(String email, String sifre){
        Avukat avukat = avukatDAO.loginKontrol(email,sifre);
        return  avukat;
    }

    public List<Avukat> avukatListele() {
        List<Avukat> avukatList = avukatDAO.avukatListele();
        return avukatList;
    }
    @Transactional(readOnly = false)
    public Boolean avukatKaydet(String isim, String soyIsim, String email, String password) {
        Avukat avukat = new Avukat();
        avukat.setAvukatAd(isim);
        avukat.setAvukatSoyad(soyIsim);
        avukat.setAvukatEposta(email);
        avukat.setAvukatSifre(password);
       Boolean exist = mainDAO.saveOrUpdateObject(avukat);

       return exist;
    }
    @Transactional(readOnly = false)
    public Boolean avukatSil(long id) {
        Avukat avukat = (Avukat) mainDAO.loadObject(Avukat.class,id);
        return mainDAO.removeObject(avukat);
    }

    public Avukat avukatLoad(long id) {
        Avukat avukat = (Avukat) mainDAO.loadObject(Avukat.class,id);
        return avukat;
    }
    @Transactional(readOnly = false)
    public Boolean avukatUpdate(long id, String isim, String soyisim, String email, String password) {
        Avukat avukat = avukatLoad(id);
        avukat.setAvukatAd(isim);
        avukat.setAvukatSoyad(soyisim);
        avukat.setAvukatEposta(email);
        avukat.setAvukatSifre(password);
        Boolean exist = mainDAO.saveOrUpdateObject(avukat);
        return exist;
    }
}
