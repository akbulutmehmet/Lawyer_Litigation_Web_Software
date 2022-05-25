package com.mehmet.dao;

import com.mehmet.model.Musteki;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MustekiDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession () {
        return sessionFactory.getCurrentSession();
    }


    public List<Musteki> mustekiListele() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Musteki> criteriaQuery = criteriaBuilder.createQuery(Musteki.class);
        Root<Musteki> root = criteriaQuery.from(Musteki.class);

        criteriaQuery.select(root);
        Query<Musteki> query = currentSession.createQuery(criteriaQuery);
        List<Musteki> mustekiList = query.getResultList();
        return mustekiList;
    }
}
