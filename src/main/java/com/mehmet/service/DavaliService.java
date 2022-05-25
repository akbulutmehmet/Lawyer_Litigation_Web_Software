package com.mehmet.service;

import com.mehmet.dao.DavaliDAO;
import com.mehmet.dao.MainDAO;
import com.mehmet.model.Davali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly =true,rollbackFor = Exception.class)
public class DavaliService {
    @Autowired
    private DavaliDAO davaliDAO;

    @Autowired
    private MainDAO mainDAO;

    public List<Davali> davaliListele() {
        List<Davali> davaliList = davaliDAO.davaliListele();
        return davaliList;
    }
    @Transactional(readOnly = false)
    public Boolean davaliKaydet(Long davaliId,String davaliAd, String davaliSoyad, String davaliEposta, Long davaliTelefon) {
        Davali davali;
        if(davaliId != null) {
            davali = davaliLoad(davaliId);
        }
        else {
            davali = new Davali();
        }
        davali.setDavaliAd(davaliAd);
        davali.setDavaliSoyad(davaliSoyad);
        davali.setDavaliEposta(davaliEposta);
        davali.setDavaliTelefon(davaliTelefon);
        Boolean exist = mainDAO.saveOrUpdateObject(davali);
        return exist;
    }

    public Davali davaliLoad(long id) {
        Davali davali = (Davali) mainDAO.loadObject(Davali.class,id);
        return davali;
    }
    @Transactional(readOnly = false)
    public Boolean davaliSil(long id) {
        Davali davali = davaliLoad(id);
        Boolean exist = mainDAO.removeObject(davali);
        return exist;
    }
}
