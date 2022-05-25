package com.mehmet.dao;

import com.mehmet.model.Dava;
import com.mehmet.model.Davali;
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
public class DavaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession () {
        return sessionFactory.getCurrentSession();
    }


    public List<Dava> davaListele() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Dava> criteriaQuery = criteriaBuilder.createQuery(Dava.class);
        Root<Dava> root = criteriaQuery.from(Dava.class);

        criteriaQuery.select(root);
        Query<Dava> query = currentSession.createQuery(criteriaQuery);
        List<Dava> davaList = query.getResultList();
        return davaList;
    }
}
