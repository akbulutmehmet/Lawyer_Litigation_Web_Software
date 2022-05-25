package com.mehmet.service;

import com.mehmet.dao.AjandaDAO;
import com.mehmet.dao.DavaDAO;
import com.mehmet.dao.MainDAO;
import com.mehmet.model.*;
import com.mehmet.util.DateConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly =true,rollbackFor = Exception.class)
public class AjandaService {
    @Autowired
    private AjandaDAO ajandaDAO;


    @Autowired
    private MainDAO mainDAO;

    public List<Ajanda> ajandaListele(Long avukatId) {
        List<Ajanda> ajandaList = ajandaDAO.ajandaListele(avukatId);
        return ajandaList;
    }
    @Transactional(readOnly = false)
    public Boolean ajandaKaydet(Long ajandaId, String ajandaIsim, String baslangicTarihi, String bitisTarihi, Avukat avukat) {
        Ajanda ajanda;
        if(ajandaId != null) {
            ajanda = ajandaLoad(ajandaId);
        }
        else {
            ajanda = new Ajanda();
        }
        DateConvert dateConvert = new DateConvert();
        dateConvert.setDateString(baslangicTarihi);
        Date baslangicTarihiDate = dateConvert.getDate();
        dateConvert.setDateString(bitisTarihi);
        Date bitisTarihiDate = dateConvert.getDate();

        ajanda.setAjandaIsim(ajandaIsim);
        ajanda.setBaslangicTarihi(baslangicTarihiDate);
        ajanda.setBitisTarihi(bitisTarihiDate);
        ajanda.setAvukat(avukat);
        Boolean exist = mainDAO.saveOrUpdateObject(ajanda);
        return exist;
    }

    public Ajanda ajandaLoad(long id) {
        Ajanda ajanda = (Ajanda) mainDAO.loadObject(Ajanda.class,id);
        return ajanda;
    }
    @Transactional(readOnly = false)
    public Boolean ajandaSil(long id) {
        Ajanda ajanda = ajandaLoad(id);
        Boolean exist = mainDAO.removeObject(ajanda);
        return exist;
    }
}
