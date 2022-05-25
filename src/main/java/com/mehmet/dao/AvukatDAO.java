package com.mehmet.dao;

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
public class AvukatDAO {
    @Autowired
    private SessionFactory sessionFactory;

     private Session getCurrentSession () {
         return sessionFactory.getCurrentSession();
     }
    public Avukat loginKontrol(String email, String sifre)  {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Avukat> criteriaQuery = criteriaBuilder.createQuery(Avukat.class);
        Root<Avukat> root = criteriaQuery.from(Avukat.class);
        Predicate predicateAvukatEposta = criteriaBuilder.equal((root.get("avukatEposta")),email);
        Predicate predicateAvukatSifre = criteriaBuilder.equal((root.get("avukatSifre")),sifre);

        criteriaQuery.select(root).where(criteriaBuilder.and(predicateAvukatEposta,predicateAvukatSifre));

        Query<Avukat> query = currentSession.createQuery(criteriaQuery);
        Avukat avukat = null;
        try {
            avukat = query.getSingleResult();
        }
        catch (Exception e) {
            return avukat;
        }
        return avukat;
    }

    public List<Avukat> avukatListele() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Avukat> criteriaQuery = criteriaBuilder.createQuery(Avukat.class);
        Root<Avukat> root = criteriaQuery.from(Avukat.class);

        criteriaQuery.select(root);
        Query<Avukat> query = currentSession.createQuery(criteriaQuery);
        List<Avukat> avukatList = query.getResultList();
         return avukatList;
    }


}
