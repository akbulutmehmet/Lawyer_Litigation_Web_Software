package com.mehmet.service;

import com.mehmet.dao.MainDAO;
import com.mehmet.dao.MustekiDAO;
import com.mehmet.model.Musteki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly =true,rollbackFor = Exception.class)
public class MustekiService {
    @Autowired
    private MustekiDAO mustekiDAO;

    @Autowired
    private MainDAO mainDAO;

    public List<Musteki> mustekiListele() {
        List<Musteki> mustekiList = mustekiDAO.mustekiListele();
        return mustekiList;
    }
    @Transactional(readOnly = false)
    public Boolean mustekiKaydet(Long mustekiId,String mustekiAd, String mustekiSoyad, String mustekiEposta, Long mustekiTelefon) {
        Musteki musteki;
        if(mustekiId != null) {
            musteki = mustekiLoad(mustekiId);
        }
        else {
            musteki = new Musteki();
        }
        musteki.setMustekiAd(mustekiAd);
        musteki.setMustekiSoyad(mustekiSoyad);
        musteki.setMustekiEposta(mustekiEposta);
        musteki.setMustekiTelefon(mustekiTelefon);
        Boolean exist = mainDAO.saveOrUpdateObject(musteki);
        return exist;
    }

    public Musteki mustekiLoad(long id) {
        Musteki musteki = (Musteki) mainDAO.loadObject(Musteki.class,id);
        return musteki;
    }
    @Transactional(readOnly = false)
    public Boolean mustekiSil(long id) {
        Musteki musteki = mustekiLoad(id);
        Boolean exist = mainDAO.removeObject(musteki);
        return exist;
    }
}
