package com.mehmet.dao;

import com.mehmet.model.Ajanda;
import com.mehmet.model.Avukat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AjandaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession () {
        return sessionFactory.getCurrentSession();
    }


    public List<Ajanda> ajandaListele(Long avukatId) {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Ajanda> criteriaQuery = criteriaBuilder.createQuery(Ajanda.class);
        Root<Ajanda> root = criteriaQuery.from(Ajanda.class);
        Predicate predicateAvukat = criteriaBuilder.equal(root.get("avukat").get("avukatId"),avukatId);
        criteriaQuery.select(root).where(predicateAvukat);
        Query<Ajanda> query = currentSession.createQuery(criteriaQuery);
        List<Ajanda> ajandaList = query.getResultList();
        return ajandaList;
    }


}
