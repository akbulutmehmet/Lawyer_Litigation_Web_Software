package com.mehmet.service;

import com.mehmet.dao.DavaDAO;
import com.mehmet.dao.MainDAO;
import com.mehmet.model.Dava;
import com.mehmet.model.Davali;
import com.mehmet.model.Musteki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly =true,rollbackFor = Exception.class)
public class DavaService {
    @Autowired
    private DavaDAO davaDAO;

    @Autowired
    private MustekiService mustekiService;

    @Autowired
    private DavaliService davaliService;

    @Autowired
    private MainDAO mainDAO;

    public List<Dava> davaListele() {
        List<Dava> davaList = davaDAO.davaListele();
        return davaList;
    }
    @Transactional(readOnly = false)
    public Boolean davaKaydet(Long davaId,String davaAd, String davaTipi,Long davaNumarasi,Long davaliId,Long mustekiId) {
        Dava dava;
        if(davaId != null) {
            dava = davaLoad(davaId);
        }
        else {
            dava = new Dava();
        }
        Davali davali = davaliService.davaliLoad(davaliId);
        Musteki musteki = mustekiService.mustekiLoad(mustekiId);
        dava.setDavaAd(davaAd);
        dava.setDavali(davali);
        dava.setMusteki(musteki);
        dava.setDavaNumarasi(davaNumarasi);
        dava.setDavaTipi(davaTipi);
        Boolean exist = mainDAO.saveOrUpdateObject(dava);
        return exist;
    }

    public Dava davaLoad(long id) {
        Dava dava = (Dava) mainDAO.loadObject(Dava.class,id);
        return dava;
    }
    @Transactional(readOnly = false)
    public Boolean davaSil(long id) {
        Dava dava = davaLoad(id);
        Boolean exist = mainDAO.removeObject(dava);
        return exist;
    }
}
